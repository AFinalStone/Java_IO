package com.afinalstone;

import java.io.FileWriter;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        System.out.println("Hello World!");
        try {
            IOUtil.StringToFile("测试数据","Main.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("测试数据");
    }
}
