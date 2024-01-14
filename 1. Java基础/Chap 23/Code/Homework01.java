package com.tybxx.Homework;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author 唐钰渤
 * @version 1.0
 */
@SuppressWarnings({"all"})
public class Homework01 {
    public static void main(String[] args) throws Exception {

        //获取对应 Class 对象
        Class<PrivateTest> privateTestClass = PrivateTest.class;

        //创建对象实例
        PrivateTest privateTest = privateTestClass.newInstance();

        //获取成员属性并进行暴破和修改
        Field field = privateTestClass.getDeclaredField("name");
        field.setAccessible(true);

        field.set(privateTest, "花园宝宝");

        Method methodName = privateTestClass.getDeclaredMethod("getName");
        Object returnVal = methodName.invoke(privateTest);
        System.out.println(returnVal);
    }
}


@SuppressWarnings({"all"})
class PrivateTest{
    private String name = "hellokitty";
    public String getName(){
        return name;
    }
}
