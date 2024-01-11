package com.tybxx.tankgame4;

import javax.swing.*;

/**
 * @author 唐钰渤
 * @version 1.0
 */
public class TybTankGame04 extends JFrame {


    private MyPanel mp = null;
    public static void main(String[] args) {
        TybTankGame04 tybTankGame04 = new TybTankGame04();
    }

    public TybTankGame04(){

        mp = new MyPanel();
        Thread thread = new Thread(mp);
        thread.start();
        this.add(mp);
        this.addKeyListener(mp);
        this.setSize(1200, 950);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

    }
}
