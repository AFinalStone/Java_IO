### JavaIO 总结笔记<三> 缓冲流和转换流

一、缓冲流

1.缓冲区   基本字节流没有缓冲区    基本字符流有缓冲区（8K）

2.对于基本字节流，Java后来提供了字节流的缓冲流和字符流的缓冲流

3.缓冲流

```markdown
java.io.BufferedInputStream    字节缓冲流(读)
java.io.BufferedOutputStream    字节缓冲流(写)
java.io.BufferedReader   字符缓冲流(读)
java.io.BufferedWriter   字符缓冲流(写)
```

二、BufferedOutputStream类

1.作用   把内存中的数据写入到硬盘的某个文件中（有缓冲区）

2.构造方法

```markdown
public BufferedOutputStream(OutputStream out)   默认大小是8k
public BufferedOutputStream(OutputStream out,  int size)可以自己指定缓冲区大小，单位字节
```

3.功能方法

```markdown
public void write(int b)  参数是ASCII表中的码值，不是普通数字
public void write(byte[] b)
public void flush() 
```

代码举例：
```markdown
    public static void writeFileByBufferByte() throws IOException {
        //演示BufferedOutputStream类

        //1.建管道
        BufferedOutputStream bos=new BufferedOutputStream(new FileOutputStream(fileName_destination));
        //BufferedOutputStream bos=new BufferedOutputStream(new FileOutputStream("demo.txt"),32*1024);

        //2.写数据
        bos.write(97);
        bos.write("\r\nhello你好".getBytes("GBK"));

        //3.关闭
        bos.close();
    }
    
```

三、BufferedInputStream类

1.作用   把硬盘中某个文件的数据读取到内存中（有缓冲区）

2.构造方法
```markdown
public BufferedInputStream(InputStream in)  默认缓冲区是8k
public BufferedInputStream(InputStream out,  int size)可以自己指定缓冲区大小，单位字节
```

3.功能方法
```markdown
public int read()
public int read(byte[] b)
public void close()
```

代码举例：
```markdown
    public static void readFile() throws IOException {
        //演示BufferedInputStream类

        //1.建管道
        File f = new File(fileName_source);
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(f));
        //BufferedInputStream  bis=new BufferedInputStream(new FileInputStream("demo.txt"),32*1024);

        //2.读取数据
//		public int read()   一次读取一个字节并返回，如果到文件最后了，返回-1
        int res;
        do {
            res = bis.read();
            System.out.print((char) res);
        } while (res != -1);

        //4.关闭
        bis.close();
    }

    public static void readFileByBufferByte() throws IOException {
        //演示BufferedInputStream类

        //1.建管道
        File f = new File(fileName_source);
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(f));
        //BufferedInputStream  bis=new BufferedInputStream(new FileInputStream(fileName_source),32*1024);

        //2.来辆车
        byte[] t = new byte[(int) f.length()];

        //3.装车
        bis.read(t);
        System.out.println(new String(t));

        //4.关闭
        bis.close();
    }
    
```

四、复制文件

在实际开发时，对于较大文件的复制，推荐使用缓冲流

```markdown

    public static void copy03_BufferIOStream() throws IOException {
        //使用字节缓冲流复制文件

        //1.建两个管道
        BufferedInputStream bis=new BufferedInputStream(new FileInputStream(fileName_source));
        BufferedOutputStream bos=new BufferedOutputStream(new FileOutputStream(fileName_destination));

        //2.来辆车
        byte[] t=new  byte[8*1024];

        //3.边读边写
        while(true){
            int res=bis.read(t);
            if(res==-1)
                break;
            bos.write(t, 0, res);
        }

        //4.关闭
        bis.close();
        bos.close();
    }

```

五、BufferedWriter类

1.作用    把内存中的数据写入到硬盘的某个文件中（缓冲区的大小是可以自己设置的）

2.构造方法

```markdown
public BufferedWriter(Writer out)   默认大小是8k
public BufferedWriter(Writer out,  int sz)可以自己指定缓冲区大小，单位字节
```

3.功能方法

```markdown
public void write(char[] cbuf)
public void write(String str)
public void newLine()   \r\n   特有方法，优势是跨平台
public void flush()  
public void close()
```

代码举例：

```markdown
    public static void writeFile() throws IOException {

        //演示BufferedWriter类

        //1.建管道
        BufferedWriter bw=new BufferedWriter(new FileWriter(fileName_destination));
        //BufferedWriter bw=new BufferedWriter(new FileWriter("fileName_destination"),16*1024);

        //2.写数据
        bw.write("hello");
        bw.newLine();    //跨平台
        bw.write("world 你好世界");

        //3.关闭
        bw.close();

    }

```

六、BufferedReader类

1.作用   把硬盘中某个文件的数据读取到内存中（缓冲区的大小可以自己设置）

2.构造方法

```markdown
public BufferedReader(Reader in)   默认大小是8k
public BufferedReader(Reader in,  int sz)可以自己指定缓冲区大小，单位字节
```

3.功能方法

```markdown
public int read()
public int read(char[] cbuf)
public String readLine()    特有方法   碰到换行或回车即一行结束
public void close()
```

```markdown

    public static void readFile() throws IOException {

        //演示BufferedReader类

        //1.建管道
        BufferedReader br=new BufferedReader(new FileReader(fileName_source));
        //BufferedReader br=new BufferedReader(new FileReader("fileName_source"),16*1024);

        //2.独有方法
        String s;
        do {
            s=br.readLine();
            System.out.println(s);
        } while (s!=null);

        //3.关闭
        br.close();
    }

```

七、转换流

1.所有文件最终都是以字节形式存储在硬盘上，但是用户在读写时需要的是字符，因此字符和字节之间需要互相转换。
字节到字符是读(输入流)，字符到字节是写(输出流)。

2.转换时需要按照某种字符编码进行转换，常见的编码有：ISO-8859-1(西方字符)    UTF-8(国际通用标准)    GBK(中国国家标准)

3.在UTF-8编码标准中，一个汉字占三个字节；在GBK编码标准中，一个汉字占两个字节(请使用Eclipse更改文件编码格式)

4.中文Win操作系统默认编码GBK，Java中的char和String在存储汉字时采用GBK编码

5.当文件的编码跟系统默认编码不一致时，就会出现中文乱码问题，就需要用到Java的转换流来解决

6.InputStreamReader 是字节流通向字符流的桥梁，起到转换作用(读)

  OutputStreamWriter 是字符流通向字节流的桥梁，起到转换作用(写)
  
7.思考：今天要讲的转换流需要读写文件？之前讲的基本流已经有了读写文件的功能？那么转换流还需要自己再实现读写文件的功能吗？

八、InputStreamReader类

1.作用   读取  输入流   把硬盘上某个文件的二进制字节数据转换为字符

2.构造方法
```markdown
public InputStreamReader(InputStream in)   默认字符编码GBK
public InputStreamReader(InputStream in,  String charsetName)可以自己指定编码(要跟文件编码一致)
```

3.功能方法
```markdown
public int read()
public int read(char[] cbuf)
```

代码举例：

```markdown

    public static void readByInputStreamReader() throws IOException {
        //演示InputStreamReader类     从字节转换为字符

        //1.建管道
        File f = new File(fileName_source);
        InputStreamReader isr=new InputStreamReader(new FileInputStream(f),"UTF-8");

        //2.来辆车
        char[] c=new char[(int)f.length()];

        //3.装车
        isr.read(c);
        System.out.println(new String(c).trim());
        //4.关闭
        isr.close();

    }

```

九、OutputStreamWriter类

1.作用   写   输出流     把字符转换为字节存到硬盘上

2.构造方法
```markdown
public OutputStreamWriter(OutputStream out)  默认字符编码GBK
public OutputStreamWriter(OutputStream out,  String charsetName)可以自己指定编码(要跟文件编码一致)
```

3.功能方法
```markdown
public void write(int c)
public void write(char[] cbuf)
public void write(String str)

public void flush()
public void close()
```

代码举例：

```markdown

    public static void writeByOutputStreamWriter() throws IOException {
        //演示OutputStreamWriter类      把字符转换为字节

        //1.建管道
        OutputStreamWriter osw  = new OutputStreamWriter(new FileOutputStream(fileName_destination),"UTF-8");

        //2.写数据
        osw.write("中国");

        //3.关闭
        osw.close();

    }

```

十、另一种解决中文乱码文件的方式

1.先打回原形

2.重新组合成字符串，可以设置编码

十一、基本流、缓冲流和转换流

用基本字节流读写文本文件，也需要在字节和字符之间转换，getBytes()   new String()

用基本字符流读写文本文件，也需要在字节和字符之间转换，字符流的爸爸是转换流

十二、总结基本流、缓冲流和转换流的应用场景？

1.基本流      文件小  编码是gbk

2.缓冲流     文件大

3.转换流     编码跟系统不一致

十三、装饰设计模式

1.如果我想在不改变某类源代码的前提下，扩展该类中某个方法的功能

a.继承-方法重写,会造成子类非常臃肿，子类会越来越庞大

```markdown
class  A{
	public void a(){}
	public void b(){}
	public void c(){}
	public void d(){}
	public void e(){}
}

class B extends A{
	public void a(){
	}
}
```

b.装饰设计模式

BufferedReader br=new BufferedReader(new InputStreamReader(new FileInputStream(...)))






