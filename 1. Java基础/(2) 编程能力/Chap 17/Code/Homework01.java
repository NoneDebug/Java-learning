package com.tybxx.Homework;

import java.util.Scanner;


public class Homework01 {
    public static void main(String[] args) {

        Thread1 thread1 = new Thread1();
        Thread2 thread2 = new Thread2(thread1);
        thread1.start();
        thread2.start();
    }

}

class Thread1 extends Thread {
    private int num;
    private boolean loop = true;

    @Override
    public void run() {
        while (loop) {
            num = (int) (100 * Math.random() + 1);
            System.out.println("线程 = " + Thread.currentThread().getName() + "\t" + num);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void setLoop(boolean loop) {
        this.loop = loop;
    }
}

class Thread2 extends Thread {
    private Thread1 thread1;
    private Scanner scanner = new Scanner(System.in);

    public Thread2(Thread1 thread1) {
        this.thread1 = thread1;
    }

    @Override
    public void run() {
        while (true) {
            System.out.println("请输入你的指令：");
            char ch = scanner.next().toUpperCase().charAt(0);
            System.out.println("你当前输入的字符为：" + ch);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            if (ch == 'Q') {
                thread1.setLoop(false);
                break;
            }

        }
    }
}
