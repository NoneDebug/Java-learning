package com.tybxx.Chap8.Homework04;

public class Homework04 {
    public static void main(String[] args) {
        Employee dogPush = new Employee("狗推", 10, 30);
        dogPush.printSal();
        origEmp coder = new origEmp("zhongma", 20, 30);
        coder.printSal();
        Manager m = new Manager("wangchuanjun", 200, 30);
        m.printSal();

    }
}


class Employee{
    private String name;
    private double daySal;
    private int workDay;

    public Employee(String name, double daySal, int workDay) {
        this.name = name;
        this.daySal = daySal;
        this.workDay = workDay;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getDaySal() {
        return daySal;
    }

    public void setDaySal(double daySal) {
        this.daySal = daySal;
    }

    public int getWorkDay() {
        return workDay;
    }

    public void setWorkDay(int workDay) {
        this.workDay = workDay;
    }

    public void printSal(){
        double totalSal = this.daySal * this.workDay;
        System.out.println("The sal is " + totalSal);
    }
}

class Manager extends Employee{
    private double Rank = 1.2;

    public Manager(String name, double daySal, int workDay) {
        super(name, daySal, workDay);
    }

    @Override
    public void printSal() {
        double totalSal = this.Rank * this.getDaySal() * this.getWorkDay() + 1000;
        System.out.println("The sal is " + totalSal);
    }
}
class origEmp extends Employee{
    private double Rank = 1.0;

    public origEmp(String name, double daySal, int workDay) {
        super(name, daySal, workDay);
    }

    @Override
    public void printSal() {
        double totalSal = this.Rank * this.getDaySal() * this.getWorkDay();
        System.out.println("The sal is " + totalSal);
    }
}