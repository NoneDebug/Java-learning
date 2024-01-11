package com.tybxx.tankgame3;

import javax.swing.*;

/**
 * @author 唐钰渤
 * @version 1.0
 */
public class TybTankGame03 extends JFrame {


    private MyPanel mp = null;
    public static void main(String[] args) {
        TybTankGame03 tybTankGame03 = new TybTankGame03();
    }

    public TybTankGame03(){

        mp = new MyPanel();
        Thread thread = new Thread(mp);
        thread.start();
        this.add(mp);
        this.addKeyListener(mp);
        this.setSize(1000, 750);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

    }
}
