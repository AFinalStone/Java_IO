package com.afinalstone.file;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by AFinalStone on 2017/6/27.
 */
public class IO01_File {

    //获取系统的行分隔符,文件分隔符
    private  String line = System.getProperty("line.separator");
    private  String separator_Path = System.getProperty("file.separator");
    public static String fileName_source = "src\\com\\afinalstone\\file\\IO01_File.java";

    /**
     * @throws IOException 检测当前目录是否存在文件，不存在则创建
     */
    public static void createFile() throws IOException {

        File f = new File(fileName_source);
        System.out.println(f);
        //public boolean exists()	判断文件是否存在
        if (f.exists()) {
            System.out.println("File Exists");
        } else {
            System.out.println("File No Exists");
//			public boolean createNewFile()	创建新文件
//			public boolean mkdir()	根据路径创建单级目录
//		    public boolean mkdirs()	根据路径创建目录且允许创建多级目录
            f.createNewFile();
        }
    }

    /**
     * 获得文件最后一次修改时间
     */
    public static void getTimeOfLastModified() {
        File f = new File(fileName_source);

        //public long lastModified()	文件最后一次被修改的时间,UNIX时间
        long time = f.lastModified();
        System.out.println(time);

        Date d = new Date(time);
        System.out.println(d);

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm");
        System.out.println(sdf.format(d));
    }

    public static void operateFile() {

        File f = new File(fileName_source);

        //public boolean canWrite()	文件是否可写
        System.out.println("canWrite: "+f.canWrite());

        //public long length()	返回文件内容长度，单位字节
        System.out.println("length: "+f.length());

        //public String getPath()	返回文件的路径信息
        System.out.println("getPath: "+f.getPath());

        //public boolean isFile()	判断给定的路径是否是一个文件
        System.out.println("isFile: "+f.isFile());

        //public boolean isDirectory()	判断给定的路径是否为目录
        System.out.println("isDirectory: "+f.isDirectory());

        //public String getName()	获得目录的名字
        System.out.println("getName: "+f.getName());
        System.out.println("getPath: "+f.getPath());

        //public boolean renameTo(File dest)	重命名文件，路径不同会新建
        //f.renameTo(new File("c:\\test\\b.txt"));

        //public boolean delete()	删除文件或者空目录
//      f.delete();

    }


    /**
     * 遍历文件夹的全部文件，以及添加过滤器
     */
    public static void listFile(){

//		public File[] listFiles()	列出指定目录的全部文件和文件夹
        File fs=new File("src\\com\\afinalstone\\file");
        File[] temp=fs.listFiles();
        for (int i = 0; i < temp.length; i++) {
            System.out.println(temp[i]+"\t"+temp[i].length()+"\t"+temp[i].lastModified());
        }

//		public String[] list()	列出指定目录的全部文件或文件夹的名称
        String[] s=fs.list();
        for (int i = 0; i < s.length; i++) {
            System.out.println(s[i]);
        }

        temp = fs.listFiles(new FileFilter(){//自定义一个过滤器类

            public boolean accept(File f) {   //.java
                //1.
                if(f.isFile())
                {
                    //2.
                    String name=f.getName();
                    //System.out.println(name);
                    //3.
                    if(name.endsWith(".java"))
                        return true;
                    else {
                        return false;
                    }
                }
                else {
                    return false;
                }
            }});
        for (int i = 0; i < temp.length; i++) {
            System.out.println(temp[i]);
        }
    }

}
