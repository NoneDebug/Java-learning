package com.tybxx.homework;

import java.util.Scanner;

/**
 * @author 唐钰渤
 * @version 1.0
 */
public class Homework01 {
    public static void main(String[] args) {

        try {
            if(args.length != 2){
                throw new ArrayIndexOutOfBoundsException("参数个数不对");
            }
            int n1 = Integer.parseInt(args[0]);
            int n2 = Integer.parseInt(args[1]);
            double res = cal(n1, n2);
            System.out.println("计算结果为：" + res);

        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
        }catch (ArithmeticException e){
            System.out.println(e.getMessage());
        }

    }

    public static int cal(int n1, int n2) {
        int res = 0;
        res = n1 / n2;
        return res;
    }
}
