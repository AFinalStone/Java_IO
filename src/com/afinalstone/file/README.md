JavaIO 总结笔记<一> IO简介和File文件

简介:

IO操作面临很多问题，信息量的巨大，网络的环境等等，因为IO不仅仅是对本地文件、目录的操作，有时对二进制流、还有一部分是网络方面的资源，

所以多种原因直接造成IO操作无疑是耗时且复杂多变的。Java对IO的支持是个不断的演变过程，经过了很多的优化，直到JDK1.4以后，才趋于稳定，

在JDK1.4中，加入了nio类，解决了很多性能问题，虽然我们有足够的理由不去了解关于Java IO以前的情况，但是为了学好现在的类，

我们还是打算去研究下，通过掌握类的优化情况来彻底理解IO的机制！Java IO主要主要在java.io包下，分为四大块近80个类：

- 1基于字节操作的I/O接口：InputStream和OutputStream

- 2基于字符操作的I/O接口：Writer和Reader

- 3基于磁盘操作的I/O接口：File

- 4基于网络操作的I/O接口：Socket（不在java.io包下）

影响IO性能的无非就是两大因素：数据的格式及存储的方式，前两类主要是数据格式方面的，后两个类是存储方式方面的：本地和网络。
所以策划好这两个方面的活动，有助于我们合理使用IO。

IO结构图：

![结构图](../../../../picture/IO结构图.jpg)

一、java io的开始：

File文件

1. 我们主要讲的是流，流的本质也是对文件的处理，我们循序渐进一步一步从文件讲到到流去。

2. java 处理文件的类 File，java提供了十分详细的文件处理方法，这里只列举一些简单的例子，其他的可以查API接口文档

```java
package com.afinalstone.file;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by AFinalStone on 2017/6/27.
 */
public class F01_FileTest {

    //获取系统的行分隔符,文件分隔符
    private  String line = System.getProperty("line.separator");
    private  String separator_Path = System.getProperty("file.separator");

    /**
     * @throws IOException 检测当前目录是否存在文件，不存在则创建
     */
    public static void createFile() throws IOException {

        File f = new File(IO01_FileTest);
        System.out.println(f);
        //public boolean exists()	判断文件是否存在
        if (f.exists()) {
            System.out.println("File Exists");
        } else {
            System.out.println("File No Exists");
//			public boolean createNewFile()	创建新文件
//			public boolean mkdir()	根据路径创建单级目录
//		    public boolean mkdirs()	根据路径创建目录且允许创建多级目录
            f.createNewFile();
        }
    }

    /**
     * 获得文件最后一次修改时间
     */
    public static void getTimeOfLastModified() {
        File f = new File(IO01_FileTest);

        //public long lastModified()	文件最后一次被修改的时间,UNIX时间
        long time = f.lastModified();
        System.out.println(time);

        Date d = new Date(time);
        System.out.println(d);

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm");
        System.out.println(sdf.format(d));
    }

    public static void operateFile() {

        File f = new File(IO01_FileTest);

        //public boolean canWrite()	文件是否可写
        System.out.println("canWrite: "+f.canWrite());

        //public long length()	返回文件内容长度，单位字节
        System.out.println("length: "+f.length());

        //public String getPath()	返回文件的路径信息
        System.out.println("getPath: "+f.getPath());

        //public boolean isFile()	判断给定的路径是否是一个文件
        System.out.println("isFile: "+f.isFile());

        //public boolean isDirectory()	判断给定的路径是否为目录
        System.out.println("isDirectory: "+f.isDirectory());

        //public String getName()	获得目录的名字
        System.out.println("getName: "+f.getName());
        System.out.println("getPath: "+f.getPath());

        //public boolean renameTo(File dest)	重命名文件，路径不同会新建
        //f.renameTo(new File("c:\\test\\b.txt"));

        //public boolean delete()	删除文件或者空目录
//        f.delete();

    }

    public static void listFile(){

//		public File[] listFiles()	列出指定目录的全部文件和文件夹
        File fs=new File("src\\com\\afinalstone\\file");
        File[] temp=fs.listFiles();
        for (int i = 0; i < temp.length; i++) {
            System.out.println(temp[i]+"\t"+temp[i].length()+"\t"+temp[i].lastModified());
        }

//		public String[] list()	列出指定目录的全部文件或文件夹的名称
        String[] s=fs.list();
        for (int i = 0; i < s.length; i++) {
            System.out.println(s[i]);
        }

        temp = fs.listFiles(new FileFilter(){//自定义一个过滤器类

            public boolean accept(File f) {   //.java
                //1.
                if(f.isFile())
                {
                    //2.
                    String name=f.getName();
                    //System.out.println(name);
                    //3.
                    if(name.endsWith(".java"))
                        return true;
                    else {
                        return false;
                    }
                }
                else {
                    return false;
                }
            }});
        for (int i = 0; i < temp.length; i++) {
            System.out.println(temp[i]);
        }
    }

}


```

