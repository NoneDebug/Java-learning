package Homework.chapter10;

/**
 * @author 唐钰渤
 * @version 1.0
 */
public class Homework07 {
    public static void main(String[] args) {
        Car.Air a = new Car(41).new Air();
        a.flow();
        Car.Air b = new Car(-1).new Air();
        b.flow();
        Car.Air c = new Car(35).new Air();
        c.flow();
    }
}

class Car{
    private int temperature;

    public Car(int temperature) {
        this.temperature = temperature;
    }

    class Air{
        public void flow(){
            if(temperature > 40){
                System.out.println("吹冷气");
            }else if(temperature < 0){
                System.out.println("吹暖气");
            }else{
                System.out.println("空调关闭");
            }
        }
    }
}