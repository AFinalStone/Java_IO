package com.afinalstone.file;

import java.io.*;

/**
 * Created by AFinalStone on 2017/6/27.
 */
public class FileStreamDemo {


    public static void FileInputStreamTest() throws IOException {
        //定义两个变量用户存储获取到的字符和缓存过渡数据
        StringBuffer sb = new StringBuffer();
        String line = null;

        //通过文件路径名获取当前文件的具体字节流内容
        InputStream inputStream = new FileInputStream("src/com/afinalstone/file/FileStreamDemo.java");
        //把 fileInputStream 封装成  InputStreamReader
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        //把 fileInputStream 封装成  BufferedReader
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        while ((line = bufferedReader.readLine()) != null) {
            sb.append(line + "\n");
        }
        inputStream.close();

        System.out.print(sb);
    }

    public static void FileOutStreamTest() {
        try {

            byte bWrite[] = {11, 21, 3, 40, 5};
            OutputStream os = new FileOutputStream("src/com/afinalstone/file/FileStreamDemo.java");
            for (int x = 0; x < bWrite.length; x++) {
                os.write(bWrite[x]); // writes the bytes
            }
            os.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
