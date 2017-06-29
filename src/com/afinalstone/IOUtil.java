package com.afinalstone;

import java.io.*;

/**
 * Created by AFinalStone on 2017/6/27.
 */
public class IOUtil {

    //获取系统的行分隔符,文件分隔符,这里我没有使用
    private static String line = System.getProperty("line.separator");
    private static String separator_Path = System.getProperty("file.separator");

    /**
     * @throws IOException 检测当前目录是否存在文件，不存在则创建
     */
    public static void createFile(String filePath) throws IOException {

        File f = new File(filePath);
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
     * 检测文件长度
     */
    public static void readLengthOfFile(String filePath) throws IOException {
        int count = 0;  //统计文件字节长度
        //通过文件路径名获取当前文件的具体字节流内容
        InputStream inputStream = new FileInputStream(filePath);
        while (inputStream.read() != -1) {  //读取文件字节，并递增指针到下一个字节
            count++;
        }
        System.out.println("---长度是： " + count + " 字节");
    }

    /**
     * 使用缓冲区，读取文件和检测文件长度,
     */
    public static void readLengthOfFileByBuffer(String filePath) throws IOException {
        byte[] buffer = new byte[512];   //一次取出的字节数大小,缓冲区大小
        int numberRead = 0;
        int countRead = 0;
        //通过文件路径名获取当前文件的具体字节流内容
        InputStream inputStream = new FileInputStream(filePath);
        while ((numberRead = inputStream.read(buffer)) == 512) {
            //读取文件字节，并递增指针到下一个位置，其中用到的numberRead的目的在于防止最后一次读取的字节小于buffer长度
            countRead++;
        }
        System.out.println("最后一段buffer" + numberRead);

        int lengthOfFile = 512 * countRead + numberRead;

        System.out.println("---长度是： " + lengthOfFile + " 字节");
    }

    /**
     * @return
     * @throws IOException 获取当前FileStreamDemo.java的文件内容，并把文件内容打印到控制台
     *                     把File->FileReader->BufferedReader->String
     */
    public static void fileToStringByFileReader(String filePath) throws IOException {
        //定义两个变量用户存储获取到的字符和缓存过渡数据
        StringBuffer sb = new StringBuffer();
        String line = null;

        //把filepath转换成FileReader
        FileReader fileReader = new FileReader(filePath);
        BufferedReader bufferReader = new BufferedReader(fileReader);

        while ((line = bufferReader.readLine()) != null) {
            sb.append(line + "\n");
        }

        bufferReader.close();
        System.out.println(sb);
    }

    /**
     * @throws IOException
     * 获取当前FileStreamDemo.java的文件内容，并把文件内容打印到控制台
     *   File->InputStream->InputStreamReader->BufferedReader->String，
     */
    public static String fileToStringByInputStreamReader(String filePath) throws IOException {
        //定义两个变量用户存储获取到的字符和缓存过渡数据
        StringBuffer sb = new StringBuffer();
        String line = null;

        //通过文件路径名获取当前文件的具体字节流内容
        InputStream inputStream = new FileInputStream(filePath);
        //把 fileInputStream 封装成  InputStreamReader
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        //把 fileInputStream 封装成  BufferedReader, 转化成BufferReader主要在这一步，BufferedReader(Reader in)的输入参数
        //可以为InputStreamReader,StringReader等。
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        while ((line = bufferedReader.readLine()) != null) {
            sb.append(line + "\n");
        }
        inputStream.close();

        return sb.toString();
    }

    public static void StringToFile(String msg) throws IOException {
        System.out.println(msg);
    }

    public static void StringToFile(String msg, String fileName) throws IOException {
        FileWriter fileWriter = new FileWriter(fileName);
        fileWriter.write(msg);
        fileWriter.close();
    }

    public static void StringAppendToFile(String msg, String fileName) throws IOException {
        FileWriter fileWriter = new FileWriter(fileName);
        fileWriter.append(msg);
        fileWriter.close();
    }

    /**
     * @throws IOException
     * 把当前文件FileStreamDemo.java通过InputStream和OutputStream复制到工程目录下面
     */
    public static void copyByFileStreamInputToOutput(String fileNameSource, String fileNameDestination) throws IOException {

        InputStream fileInputStream = new FileInputStream(fileNameSource);

        OutputStream fileOutputStream = new FileOutputStream(fileNameDestination);

        byte[] buffer = new byte[1024];   //一次取出的字节数大小,缓冲区大小
        int numberRead = 0;

        while ((numberRead = fileInputStream.read(buffer)) != -1) {
            fileOutputStream.write(buffer, 0, numberRead);
        }
        fileOutputStream.close();
        fileInputStream.close();
    }

    /**
     * @throws IOException
     * 把当前文件FileStreamDemo.java通过InputStream和OutputStream复制到工程目录下面
     */
    public static void copyByFileReaderToWriter(String fileNameSource, String fileNameDestination) throws IOException {

        //演示用字符流实现较大文件的复制   边读边写

        //1.建两个管道
        FileReader fr=new FileReader(fileNameSource);
        FileWriter fw=new FileWriter(fileNameDestination);

        //2.来辆车
        char[] c=new char[8*1024];   //1K

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

}
