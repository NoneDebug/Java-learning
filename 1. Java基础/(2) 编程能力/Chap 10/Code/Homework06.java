package Homework.chapter10;

/**
 * @author 唐钰渤
 * @version 1.0
 */
public class Homework06 {
    public static void main(String[] args) {

        factory factory = new factory();
        System.out.println("一般情况下...");
        Horse horse = factory.getHorse();
        new Person("唐僧", horse);
        System.out.println("遇到大河时...");
        Boat boat = factory.getBoat();
        new Person("唐僧", boat);
    }
}

interface Vehicles{
    void work();
}

class Horse implements Vehicles{
    @Override
    public void work() {
        System.out.println("The horse is running");
    }
}

class Boat implements Vehicles{
    @Override
    public void work() {
        System.out.println("The boat is floating");
    }
}

class factory{

    public Horse getHorse(){
        Horse horse = new Horse();
        return horse;
    }
    public Boat getBoat(){
        Boat boat = new Boat();
        return boat;
    }
}

class Person{
    private String name;
    private Vehicles vh;

    public Person(String name, Vehicles vh) {
        this.name = name;
        this.vh = vh;
        System.out.println(name);
        vh.work();
    }
}