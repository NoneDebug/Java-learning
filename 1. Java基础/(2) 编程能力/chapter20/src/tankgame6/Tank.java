package tankgame6;

/**
 * @author 唐钰渤
 * @version 1.0
 */
public class Tank {
    private int x;
    private int y;
    private int direct = 0;
    private int speed = 2;
    boolean isLive = true;

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void moveUp() {
        y -= speed;
    }

    public void moveDown() {
        y += speed;
    }

    public void moveLeft() {
        x -= speed;
    }

    public void moveRight() {
        x += speed;
    }

    public int getDirect() {
        return direct;
    }

    public void setDirect(int direct) {
        this.direct = direct;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getSpeed() {
        return speed;
    }

    public Tank(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
