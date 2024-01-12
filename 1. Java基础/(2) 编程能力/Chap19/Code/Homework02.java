package com.tybxx.Homework;

import java.io.*;

/**
 * @author 唐钰渤
 * @version 1.0
 */
public class Homework02 {
    public static void main(String[] args) throws IOException {
        String filePath = "e:\\a.txt";
        BufferedReader bf = new BufferedReader(new InputStreamReader(new FileInputStream(filePath), "gbk"));
        String s = "";
        int count = 0;
        while ((s = bf.readLine()) != null) {
            System.out.print(++count + "\t");
            System.out.println(s);
        }
        bf.close();
    }
}
