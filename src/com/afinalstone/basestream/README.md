>[个人博客](http://blog.csdn.net/abc6368765?viewmode=contents)、[个人简书](http://www.jianshu.com/u/0e4907a8f36b)、[gitHub主页](https://github.com/AFinalStone?tab=repositories)


JavaIO 总结笔记<二> 基本字节字符输入输出流和文件复制

#### 一、IO体系

1.流主要分两大类：字节流     字符流

2.在硬盘上的文件，都是以二进制字节形式存储的，所以不管啥文件，读写时都应该用字节流

3.在java的早期版本中，的确只有字节流，没有字符流

4.一个数字或字母占1个字节，一个汉字占了2个字节，而字节流一次读写1个字节，很容易产生中文乱码问题

5.字符流专门用来读写文本类的文件，txt   doc

6.字节流适合用来读写非文本类的文件，mp3   mp4  avi  rm   rmvb  mkv   jpg  png  bmp

#### 二、常用类(管道类)

```markdown
1.字节流   FileInputStream   FileOutputStream
2.字符流   FileReader        FileWriter
```


#### 三、字节流的输出流   FileOutputStream

1.作用  把内存中的数据输出到（写到）硬盘的某个文件中

2.构造方法

```markdown
FileOutputStream(File file)     不存在会自动键
FileOutputStream(String name)   不存在会自动键
```


3.功能方法

```markdown
public void write(int b)     参数是ASCII表中的码值，不是普通数字
public void write(byte[] b)   String对象的getBytes方法有编码转换功能
public void write(byte[] b, int off, int len)
```

4.使用字节流怎么输出一个换行？可以使用System.getProperty("line.separator")来获得当前系统的换行符。

5.如何追加和覆盖？ 默认就是覆盖

- 代码举例:

```markdown

    public static void writeFile() throws IOException {
        //演示FileOutputStream类
        //1.建管道
        FileOutputStream fos1 = new FileOutputStream(new File("A03_FileOutputStreamTest.txt"));
        //FileOutputStream   fos2=new FileOutputStream("A03_FileOutputStreamTest.txt");

        //2.写数据
        fos1.write(97);
        fos1.write(98);
        fos1.write(99);
        fos1.write(100);

        byte[] t = {97, 98, 'c'};
        fos1.write(t);
        fos1.write("hello".getBytes());
        fos1.write("world".getBytes());
        fos1.write("\r\n".getBytes());
        fos1.write(t, 0, 2);
        fos1.close();
    }

```

#### 四、字节流的输入流    FileInputStream类

1.作用  把硬盘中的数据输入（读取）到内存中

2.构造方法
```markdown
FileInputStream(File file) 
FileInputStream(String name) 
```

3.功能方法
```markdown
public int read()   一次读取一个字节并返回，如果到文件最后了，返回-1
public int read(byte[] b)    一次读取一个数组长度的数据 ，返回的是读取到的数据的长度    ,读不到数据就返回-1             
new String(byte[] b)
```


- 代码举例:

```markdown

    public static void readFile() throws IOException {
        //1.建管道
        File f = new File("src\\com\\afinalstone\\file\\IOUtil.java");
        InputStream fis = new FileInputStream(f);
        //FileInputStream fis=new FileInputStream("src\com\afinalstone\file\IOUtil.java");

        //2.读取数据
//		public int read()   一次读取一个字节并返回，如果到文件最后了，返回-1
        int res;
        do {
            res = fis.read();
            System.out.println((char) res);
        } while (res != -1);
        //3.关闭
        fis.close();
    }

    public static void readFileByBufferByte() throws IOException {
        //1.建管道
        File f = new File("src\\com\\afinalstone\\file\\IOUtil.java");
        InputStream fis = new FileInputStream(f);
        //FileInputStream fis=new FileInputStream("c:\\test\\hello.txt");

//		public int read(byte[] b)    一次读取一个数组长度的数据 ，返回的是读取到的数据的长度
        //2.来个缓存区读取数据
        System.out.println(f.length());
        byte[] t = new byte[(int) f.length()];
        //3.装车
        fis.read(t);
        System.out.println(new String(t).trim());
        //4.关闭
        fis.close();
    }
```


#### 五、复制文件

1.复制    先读取目标文件的数据，然后再把数据写入到另一个文件中

2.复制的方式

	a.对于较小文件     一次性读，然后一次性写
	
	b.对于较大文件    边读边写   读一点，写一点，缓存的使用
	
- 代码举例:

```markdown

    public static void copy01_FileIOStream() throws IOException {
        //a.对于较小文件     一次性读，然后一次性写
        //1.建管道
        File f = new File(fileName_source);
        FileInputStream fis = new FileInputStream(f);

        //2.来辆车
        byte[] t = new byte[(int) f.length()];

        //3.装车
        fis.read(t);

        //4.关闭
        fis.close();

        //1.建管道
        FileOutputStream fos = new FileOutputStream(fileName_destination);
        //2.写数据
        fos.write(t);
        //3.关闭
        fos.close();
    }

    public static void copy01_FileIOStreamBufferByte() throws IOException {
        //b.对于较大文件    边读边写   读一点，写一点

        //1.建两个管道
        FileInputStream  fis=new FileInputStream(fileName_source);
        FileOutputStream fos=new FileOutputStream(fileName_destination);

        //2.来辆车
//        byte[] t=new byte[1*1024*1024];    //1M
        byte[] t=new byte[8*1024];    //8k

        //3.装车卸车   读1M写1M
        while(true)
        {
            int res=fis.read(t);  //读
            if(res==-1)
                break;
            fos.write(t,0,res);   //写（最后一趟车可能装不满）
        }

        //4.关闭
        fis.close();
        fos.close();
    }  
    
```

#### 六、字符流的输出流FileWriter类

1.作用   把内存中的数据输出(写)到硬盘的某个文件中       **只适合文本类的文件**

2.构造方法

```markdown
public FileWriter(File file)
public FileWriter(String fileName)
public FileWriter(File file,boolean append)
public FileWriter(String fileName,boolean append)
```

3.功能方法

```markdown
public void write(String str)
public void write(char[] cbuf)
public void write(char[] b,int off, int len)
```

- 代码举例:
```markdown

    public static void writeFile() throws IOException {

        //演示FileWriter类

        //1.建管道
        FileWriter fw=new FileWriter(new File("F03_FileReaderAndWriter.txt"));
        //FileWriter fw=new FileWriter("c:\\test\\hello.txt");

        //2.写数据
        fw.write("hello\r\n");
        char[] c={'a','b','c',100};
        fw.write(c);
        fw.write("\r\n");
        fw.write(c, 0, 2);

        //3.关闭
        fw.close();

    }

```

#### 七、字符流的输入流FileReader类

1.作用   把硬盘中某个文件的数据输入(读取)到内存中

2.构造方法

```markdown
public FileReader(File file)
public FileReader(String fileName)
```

3.功能方法

```markdown
public int read()  一次读一个字符      读到数据返回的就是ASCII码，读不到就返回-1
public int read(char[] cbuf)   读到数据返回的就是数据的长度，读不到就返回-1
```


- 代码举例:

```markdown
    public static void readFile() throws IOException {

        //演示FileReader类

        //1.建管道
        File f=new File("fileName");
        FileReader fr=new FileReader(f);
        //FileReader fr=new FileReader("src\com\afinalstone\file\F03_FileReaderAndWriter.java");

        //2.读数据
        int res;
        do {
            res=fr.read();
            System.out.println((char)res);
        } while (res!=-1);

        //3.关闭
        fr.close();

    }


    public static void readFileByBufferChar() throws IOException {

        //演示FileReader类

        //1.建管道
        File f=new File(fileName);
        FileReader fr=new FileReader(f);
        //FileReader fr=new FileReader("c:\\test\\hello.txt");

        //2.来辆车
        System.out.println(f.length());
        char[] c=new char[(int)f.length()];

        //3.装车
        fr.read(c);
        System.out.println(new String(c).trim());

        //4.关闭
        fr.close();

    }
```

#### 八、字符流的缓冲区

1.字符流有缓冲区,字节流是没有缓冲区的

2.缓冲区：它是内存中的一块区域

3.作用：提高效率  减少对硬盘的频繁读写   保护硬盘

4.字符流缓冲区的默认大小是8K

5.当关闭管道时，会强制把缓冲区中的数据全部写到硬盘中

6.public void flush()     //清缓冲区，强制写入

#### 九、用字符流实现文件复制

复制的方式

	a.对于较小文件     一次性读，然后一次性写
	
	b.对于较大文件    边读边写   读一点，写一点
	
```markdown

   public static void copy02_FileReaderWriter() throws IOException {

        //1.建两个管道
        FileReader fr=new FileReader(fileName_source);
        FileWriter fw=new FileWriter(fileName_destination);

        //3.装车卸车    边读边写
        while(true)
        {
            int res=fr.read();
            if(res==-1)
                break;
            fw.write(res);
        }

        //4.关闭
        fr.close();
        fw.close();
    }

    public static void copy02_FileReaderWriterBufferChar() throws IOException {
        //演示用字符流实现较大文件的复制   边读边写

        //1.建两个管道
        FileReader fr=new FileReader(fileName_source);
        FileWriter fw=new FileWriter(fileName_destination);

        //2.来辆车
        char[] c=new char[1*1024];   //1K

        //3.装车卸车    边读边写
        while(true)
        {
            int res=fr.read(c);
            if(res==-1)
                break;
            fw.write(c,0,res);
        }

        //4.关闭
        fr.close();
        fw.close();
    }

```	

项目地址：[传送门](https://github.com/AFinalStone/Java_IO)

