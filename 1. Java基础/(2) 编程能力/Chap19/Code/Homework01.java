package com.tybxx.Homework;

import java.io.*;

/**
 * @author 唐钰渤
 * @version 1.0
 */
public class Homework01 {
    public static void main(String[] args) throws IOException {
        String directoryPath = "e:\\mytemp";
        File file = new File(directoryPath);
        if (!file.exists()) {
            if (file.mkdirs()) {
                System.out.println("创建 " + directoryPath + " 成功！");
            } else {
                System.out.println("创建 " + directoryPath + " 失败！");
            }
        }
        String filePath = directoryPath + "\\hello.txt";
        file = new File(filePath);
        if (!file.exists()) {
            if (file.createNewFile()) {
                System.out.println(filePath + "创建成功！");
                BufferedWriter bfw = new BufferedWriter(new FileWriter(file));
                bfw.write("hello world~~~");
                bfw.close();
            }else{
                System.out.println(filePath + "创建失败！");
            }
        }else{
            System.out.println(filePath + " 已经存在，不再重复创建！");
        }

    }
}
