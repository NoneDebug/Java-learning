package Homework.chapter11;

/**
 * @author 唐钰渤
 * @version 1.0
 */
public class Homework01 {
    public static void main(String[] args) {
        Color g = Color.GREEN;
        switch (g){
            case GREEN:
                System.out.println("The color is green");
                g.show();
                break;
            case RED:
                System.out.println("The color is red");
                g.show();
                break;
            case BLACK:
                System.out.println("The color is black");
                g.show();
                break;
            case BLUE:
                System.out.println("The color is blue");
                g.show();
                break;
            case YELLOW:
                System.out.println("The color is yellow");
                g.show();
                break;
        }
    }
}



interface IC{
    void show();
}

enum Color implements IC{
    RED(255, 0, 0), BLACK(0,0,255),
    BLUE(0,0,255),YELLOW(255,255,0),
    GREEN(0,255,0);
    private int redValue;
    private int greenValue;
    private int blueValue;

    Color(int redValue, int greenValue, int blueValue) {
        this.redValue = redValue;
        this.greenValue = greenValue;
        this.blueValue = blueValue;
    }

    @Override
    public void show() {
        System.out.println("The redValue is " + redValue +
                            " The greenValue is " + greenValue +
                            " The blueValue is " + blueValue);
    }
}