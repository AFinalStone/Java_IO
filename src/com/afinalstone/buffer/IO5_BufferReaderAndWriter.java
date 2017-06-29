package com.afinalstone.buffer;

import java.io.*;

/**
 * Created by AFinalStone on 2017/6/28.
 */
public class IO5_BufferReaderAndWriter {

    public static String fileName_source = "src\\com\\afinalstone\\buffer\\IO5_BufferReaderAndWriter.java";
    public static String fileName_destination = "IO5_BufferReaderAndWriter.java";

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

}
