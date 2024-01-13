package tankgame6;

import javax.sound.sampled.AudioSystem;
import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Scanner;

/**
 * @author 唐钰渤
 * @version 1.0
 */
public class TybTankGame06 extends JFrame {

    private MyPanel mp = null;
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("请输入选择 1：新游戏 2：继续上局");
        String key = scanner.next();
        TybTankGame06 tybTankGame06 = new TybTankGame06(key);

//        new AePlayWave("src\\shots.wav").start();
    }

    public TybTankGame06(String key){

        mp = new MyPanel(key);
        Thread thread = new Thread(mp);
        thread.start();
        this.add(mp);
        this.addKeyListener(mp);
        this.setSize(1300, 950);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setVisible(true);

        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                Recorder.keepRecord();
                System.exit(0);
            }
        });


    }
}
