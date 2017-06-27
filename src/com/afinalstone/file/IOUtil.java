package com.afinalstone.file;

import java.io.*;

/**
 * Created by AFinalStone on 2017/6/27.
 */
public class IOUtil {

    /**
     * 把流对象转换为字符串
     * @param inputStream
     * @return
     */
    public static String inputStreamToString(InputStream inputStream) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        StringBuilder sb = new StringBuilder();
        String line = null;

        while ((line = reader.readLine()) != null) {
            sb.append(line + "\n");
        }
        inputStream.close();

        return sb.toString();
    }

    /**
     * @param filename
     * @return
     * @throws Exception
     */
    public static String fileToString(File filename) throws IOException {
        BufferedReader bufferReader = new BufferedReader(new FileReader(filename));
        String s;
        StringBuffer sb = new StringBuffer();
        while ((s = bufferReader.readLine()) != null) {
            sb.append(s + "\n");
        }
        bufferReader.close();
        return sb.toString();
    }




}
