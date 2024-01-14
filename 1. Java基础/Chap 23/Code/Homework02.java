package com.tybxx.Homework;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * @author 唐钰渤
 * @version 1.0
 */
public class Homework02 {
    public static void main(String[] args) throws Exception {
        Class<?> fileCls = Class.forName("java.io.File");
        Constructor<?>[] declaredConstructors = fileCls.getDeclaredConstructors();
        for (Constructor<?> declaredConstructor : declaredConstructors) {
            System.out.println("File构造器为：" + declaredConstructor);
        }
        Constructor<?> declaredConstructor = fileCls.getDeclaredConstructor(String.class);
        String allPath = "d:\\mynew.txt";
        Object file = declaredConstructor.newInstance(allPath);

        System.out.println(file.getClass());

        Method createNewFile = fileCls.getDeclaredMethod("createNewFile");
        createNewFile.invoke(file);
        System.out.println("创建成功！");
    }
}
