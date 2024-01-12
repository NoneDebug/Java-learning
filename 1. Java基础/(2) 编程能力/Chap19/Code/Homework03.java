package com.tybxx.Homework;

import java.io.*;
import java.util.Properties;

/**
 * @author 唐钰渤
 * @version 1.0
 */
public class Homework03 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Properties properties = new Properties();
        properties.load(new FileReader("src\\dog.properties"));
//        properties.list(System.out);
        String name = properties.get("name") + "";
        int age = Integer.parseInt(properties.get("age") + "");
        String color = properties.get("color") + "";

        Dog dog = new Dog(name, age, color);
        String outputPath = "e:\\dog.dat";
        File file = new File(outputPath);
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
        oos.writeObject(dog);

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
        System.out.println(ois.readObject());

        oos.close();
    }
}

class Dog implements Serializable{
    private String name;
    private int age;
    private String color;

    public Dog(String name, int age, String color) {
        this.name = name;
        this.age = age;
        this.color = color;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", color='" + color + '\'' +
                '}';
    }
}
