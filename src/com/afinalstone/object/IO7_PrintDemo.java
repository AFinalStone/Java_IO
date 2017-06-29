package com.afinalstone.object;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;

/**
 * Created by AFinalStone on 2017/6/29.
 */
public class IO7_PrintDemo {

    public static String fileName_destination = "IO7_PrintDemo.java";

    public static void writeByPrintStream() throws IOException {
        int score = 100;
        double price = 100.9;

        //演示PrintStream类
        //1.建管道
        PrintStream ps = new PrintStream(fileName_destination);
        //2.写数据
        ps.println(score);
        ps.println(price);
        ps.println("writeByPrintStream");

        //3.关闭
        ps.close();
    }

    public static void writeByPrintWriter() throws IOException {
        //1.建管道
        PrintWriter pw = new PrintWriter(fileName_destination);

        //2.写数据
        pw.println(100);
        pw.println(100.9);
        pw.println("writeByPrintWriter");

        //3.关闭
        pw.close();
    }
}
