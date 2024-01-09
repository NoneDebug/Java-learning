package com.tybxx.Homework;

/**
 * @author 唐钰渤
 * @version 1.0
 */
public class Homework02 {
    public static void main(String[] args) {
        Card card1 = new Card();
        Card card2 = new Card();
        card1.start();
        card2.start();
    }
}

class Card extends Thread {
    public static int credit = 10000;

    @Override
    public synchronized void run() {
        while(true){
            System.out.println("线程 = " + Thread.currentThread().getName() + " 余额 = " + credit);
            credit -= 1000;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());;
            }
            if(credit <= 1000){
                System.out.println("余额不足，退出");
                break;
            }
        }
    }
}
