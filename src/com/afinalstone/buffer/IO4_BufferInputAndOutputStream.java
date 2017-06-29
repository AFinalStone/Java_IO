package com.afinalstone.buffer;

import java.io.*;

/**
 * Created by Administrator on 2017/6/28.
 */
public class IO4_BufferInputAndOutputStream {

    public static String fileName_source = "src\\com\\afinalstone\\buffer\\IO4_BufferInputAndOutputStream.java";
    public static String fileName_destination = "IO4_BufferInputAndOutputStream.java";

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



}
