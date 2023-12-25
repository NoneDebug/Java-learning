package Homework.chapter10;

import com.sun.org.apache.bcel.internal.generic.NEW;

/**
 * @author 唐钰渤
 * @version 1.0
 */
public class homework04 {
    public static void main(String[] args) {
        Cellphone cellphone = new Cellphone();
        cellphone.testWork(
                new Icalculator() {
                    @Override
                    public double work(double n1, double n2) {
                        return n1 + n2;
                    }
                }, 10, 8
        );
    }
}

interface Icalculator{
    public double work(double n1, double n2);
}

class Cellphone{
    public void testWork(Icalculator icalculator, double n1, double n2){
        double result = icalculator.work(n1, n2);
        System.out.println("运算结果为：" + result);
    }
}