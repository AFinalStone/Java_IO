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

![结构图](picture/结构图.jpg)

一、java io的开始：文件

1. 我们主要讲的是流，流的本质也是对文件的处理，我们循序渐进一步一步从文件将到流去。
2. java 处理文件的类 File,java提供了十分详细的文件处理方法，举了其中几个例子，其余的可以去

```java
/**
 * Created by AFinalStone on 2017/6/27.
 */
public class FileDemo {

    /**
     * 文件处理示例
     */
    public static void createFile() {
        File f = new File("D:\\Java\\IdeaProjects\\Java_IO\\create.txt");
        try {
            f.createNewFile();  //当且仅当不存在具有此抽象路径名指定名称的文件时，不可分地创建一个新的空文件。
            System.out.println("Size of File:" + f.getTotalSpace() / (1024 * 1024 * 1024) + "G"); //返回由此抽象路径名表示的文件或目录的名称。
            f.mkdirs();  //创建此抽象路径名指定的目录，包括所有必需但不存在的父目录。
//          f.delete(); //  删除此抽象路径名表示的文件或目录
            System.out.println("File Name:" + f.getName());  //  返回由此抽象路径名表示的文件或目录的名称。
            System.out.println("Name OF Parent:" + f.getParent());// 返回此抽象路径名父目录的路径名字符串；如果此路径名没有指定父目录，则返回 null。

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

```