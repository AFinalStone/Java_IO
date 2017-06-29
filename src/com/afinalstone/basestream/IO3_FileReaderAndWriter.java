package com.afinalstone.basestream;

import java.io.*;

/**
 * Created by AFinalStone on 2017/6/28.
 */
public class IO3_FileReaderAndWriter {

    public static String fileName_source = "src\\com\\afinalstone\\file\\IO3_FileReaderAndWriter.java";

    public static void readFile() throws IOException {

        //演示FileReader类

        //1.建管道
        File f=new File(fileName_source);
        FileReader fr=new FileReader(f);
        //FileReader fr=new FileReader(fileName_source);

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
        File f=new File(fileName_source);
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

    public static void writeFile() throws IOException {

        //演示FileWriter类

        //1.建管道
        FileWriter fw=new FileWriter(new File("IO3_FileReaderAndWriter.java"));
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


}
