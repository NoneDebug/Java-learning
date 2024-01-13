package tankgame5;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Scanner;

/**
 * @author 唐钰渤
 * @version 1.0
 */
public class TybTankGame05 extends JFrame {


    private MyPanel mp = null;
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("请输入选择 1：新游戏 2：继续上局");
        String key = scanner.next();
        TybTankGame05 tybTankGame05 = new TybTankGame05(key);
    }

    public TybTankGame05(String key){

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
