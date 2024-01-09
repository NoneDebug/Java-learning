package com.tybxx.Homework;

public class Homework02 {
    public static void main(String[] args) {
        Card card1 = new Card();
        Card card2 = new Card();
        Card card3 = new Card();
        card1.start();
        card2.start();
        card3.start();
    }
}

class Card extends Thread {
    public static int credit = 10000;

    @Override
    public synchronized void run() {

        while (true) {
            System.out.println("线程 = " + Thread.currentThread().getName() + " 余额 = " + credit);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
                ;
            }
            if (credit < 1000) {
                System.out.println("余额不足，退出");
                break;
            }
            credit -= 1000;

        }
        System.out.println("余额为：" + credit);
    }
}
