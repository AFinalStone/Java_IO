IO流的命名：

FileInputStream
FileOutputStream
BufferedInputStream
BufferedOutputStream

FileReader
FileWriter
BufferedReader
BufferWriter

InputStreamReader
OutputStreamWriter

一、File

1.该类既可以封装单个文件，也可以封装一个目录

2.exists  isFile isDirectory  getName  getPath  length list  listFiles
  createNewFile  mkdir  mkdirs  delete renameTo  

详细描述：[JavaIO 总结笔记<一> IO简介和File文件](src/com/afinalstone/file)

二、基本字节流和基本字符流

1.字节流

FileInputStream

FileOutputStream

read()   read(byte[] b) write(int c)   write(byte[] b)   write(byte[] b,int off,int length)

2.字符流

FileReader

FileWriter

read()  read(char[] c)  write(int c)  write(char[] c)  write(char[] b,int off,int length)  write(String s)

3.复制

1.架两个管道

2.来辆车

```markdown
while(true)
{
	int res=输入流对象.read(车);
	if(res==-1)
		break;
	else
		输出流对象.write(车);
}
```

详细描述：[JavaIO 总结笔记<二> 基本字节字符输入输出流和文件复制](src/com/afinalstone/basestream)

三、缓冲流和转换流

1.缓冲流

实际开发时如果遇到较大的文件，例如视频，就需要用到缓冲流来提高效率

BufferedInputStream

BufferedOutputStream

BufferedReader    readLine()

BufferWriter    newLine()

2.转换流

当文件的编码跟系统默认编码不一致时，容易出现中文乱码问题，这时候就需要用到转换流

InputStreamReader

OutputStreamWriter

详细描述：[JavaIO 总结笔记<三> 缓冲流和转换流](src/com/afinalstone/buffer)


五、打印流、Properties类、对象流

1.打印流

- 打印流是输出流，PrintStream和PrintWriter
- 可以更方便的输出各种类型的数据
- print(Xxx x) println(Xxx x)

2.Properties类

- 什么是属性配置文件
- Properties类存储数据时跟Map是一样的，但是可以结合IO流实现对属性配置文件的读写
- put  setProperties  get  getProterties  list(输出流对象)  store(输出流对象，注释)  load(输入流对象)

3.对象流

- 使用其他流写对象时，只能写toString的返回值
- 对象流可以直接写对象(序列化)，还可以反序列化(组装成对象)
- ObjectOutputStream（writeObject）    ObjectInputStream(readObject)

详细描述：[JavaIO 总结笔记<四> 打印流、Properties类、对象流、序列化](src/com/afinalstone/object)


八、装饰设计模式

1.现有一个类，功能较弱，在不改变源码的前提下，进行功能加强

2.继承    臃肿

3.吃饭的案例

九、字符串编码

统一先打回原形(byte[]),然后new String的时候指定编码重新组合


