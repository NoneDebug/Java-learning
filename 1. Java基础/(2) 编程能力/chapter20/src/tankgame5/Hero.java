package tankgame5;

import java.util.Vector;

/**
 * @author 唐钰渤
 * @version 1.0
 */
public class Hero extends Tank{
    Shot shot = null;
    Vector<Shot> shots = new Vector<>();


    public Hero(int x, int y) {
        super(x, y);
    }

    public void shotEnemyTank() {

        if(shots.size() == 5){
            return;
        }
        switch (getDirect()) {
            case 0:
                shot = new Shot(getX() + 20, getY(), 0);
                break;
            case 1:
                shot = new Shot(getX() + 60, getY() + 20, 1);
                break;
            case 2:
                shot = new Shot(getX() + 20, getY() + 60, 2);
                break;
            case 3:
                shot = new Shot(getX(), getY() + 20, 3);
                break;
        }
        shots.add(shot);
        new Thread(shot).start();
    }
}
