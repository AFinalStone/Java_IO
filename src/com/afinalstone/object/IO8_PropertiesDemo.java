package com.afinalstone.object;

import java.io.*;
import java.util.Properties;
import java.util.Set;

/**
 * Created by AFinalStone on 2017/6/29.
 */
public class IO8_PropertiesDemo {

    public static void writeProperties01() throws IOException {
        //演示Properties类   Properties = HashMap  +  IO

        //1.创建对象
        Properties prop=new Properties();

        //2.往属性配置文件中写键值对
        prop.setProperty("name", "AFinalStone");
        prop.setProperty("pwd", "12345");
        prop.setProperty("email", "AFinalStone@gmail.com");

		//3.把键值对写到文件中    list
		PrintWriter pw=new PrintWriter("demo.properties");
		prop.list(pw);

		//4.关闭
		pw.close();

    }

    public static void writeProperties02() throws IOException {
        //演示Properties类   Properties = HashMap  +  IO

        //1.创建对象
        Properties prop=new Properties();

        //2.往属性配置文件中写键值对
        prop.setProperty("name", "AFinalStone");
        prop.setProperty("pwd", "12345");
        prop.setProperty("email", "AFinalStone@gmail.com");

        //3.把键值对写到文件中    store
        FileWriter fw = new FileWriter("demo.properties");
        prop.store(fw, "--这是属性配置文件--");

        //4.关闭
        fw.close();
    }

    public static void readProperties() throws IOException {
        //演示Properties类的load方法

        //1.创建对象
        Properties prop=new Properties();

        //2.读取数据
        FileReader fr=new FileReader("demo.properties");
        prop.load(fr);

        //3.关闭
        fr.close();

        //4.取数据
        Set<String> keys=prop.stringPropertyNames();    //keySet()
        for (String s : keys) {
            String val=prop.getProperty(s);     //get()
            System.out.println(s+"="+val);
        }
    }

}
