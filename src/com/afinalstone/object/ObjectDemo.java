package com.afinalstone.object;

import java.io.*;

/**
 * Created by AFinalStone on 2017/6/28.
 */
public class ObjectDemo {

    private static String fileName_Object = "student";


    /**
     * @throws IOException
     * @throws ClassNotFoundException
     * 把对象转换成文件
     */
    public static void ObjectToFileByObjectInputStream() throws IOException, ClassNotFoundException {

        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(fileName_Object));
        objectOutputStream.writeObject(new Student("gg", 22));
        objectOutputStream.writeObject(new Student("tt", 18));
        objectOutputStream.writeObject(new Student("rr", 17));
        objectOutputStream.close();
    }


    /**
     * @throws IOException
     * @throws ClassNotFoundException
     * 读取文件里面的Object对象，
     */
    public static void FileToObjectByObjectInputStream() throws IOException, ClassNotFoundException {
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(fileName_Object));

        for (int i = 0; i < 3; i++) {
            Object object = objectInputStream.readObject();
            System.out.println(object);
        }
        objectInputStream.close();
    }


}

