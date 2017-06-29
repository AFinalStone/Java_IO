package com.afinalstone.basestream;

import java.io.*;

/**
 * Created by AFinalStone on 2017/6/28.
 */
public class IO2_FileInputAndOutputStream {

    public static String fileName_source = "src\\com\\afinalstone\\file\\IO2_FileInputAndOutputStream.java";


    public static void readFile() throws IOException {
        //1.建管道
        File f = new File(fileName_source);
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
        File f = new File(fileName_source);
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


    public static void writeFile() throws IOException {
        //演示FileOutputStream类
        //1.建管道
        FileOutputStream fos1 = new FileOutputStream(new File("IO2_FileInputAndOutputStream.java"));
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

}
