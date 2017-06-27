package com.afinalstone.file;

import java.io.File;

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
