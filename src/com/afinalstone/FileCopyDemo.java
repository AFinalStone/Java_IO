package com.afinalstone;

import java.io.*;

/**
 * Created by AFinalStone on 2017/6/28.
 */
public class FileCopyDemo {

    public static String fileName_source = "src\\com\\afinalstone\\FileCopyDemo.java";
    public static String fileName_destination = "FileCopyDemo.java";

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

    public static void copy04_BufferReaderWriter() throws IOException {
        //使用字符缓冲流复制文本文件

        //1.建两个管道
        BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName_source));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileName_destination));

        //2.边读边写
        while(true)
        {
            String temp = bufferedReader.readLine();
            if(temp == null)
                break;
            bufferedWriter.write(temp);
            bufferedWriter.newLine();
        }

        //3.关闭
        bufferedReader.close();
        bufferedWriter.close();
    }

}
