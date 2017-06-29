package com.afinalstone.buffer;

import java.io.*;

/**
 * Created by AFinalStone on 2017/6/29.
 */
public class IO6_InputStreamReaderAndOutStreamWriter {

    public static String fileName_source = "src\\com\\afinalstone\\buffer\\IO6_InputStreamReaderAndOutStreamWriter.java";
    public static String fileName_destination = "IO6_InputStreamReaderAndOutStreamWriter.java";

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

    public static void writeByOutputStreamWriter() throws IOException {
        //演示OutputStreamWriter类      把字符转换为字节

        //1.建管道
        OutputStreamWriter osw  = new OutputStreamWriter(new FileOutputStream(fileName_destination),"UTF-8");

        //2.写数据
        osw.write("中国");

        //3.关闭
        osw.close();

    }
}
