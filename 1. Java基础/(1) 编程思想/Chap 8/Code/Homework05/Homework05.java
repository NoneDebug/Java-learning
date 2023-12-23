package com.tybxx.Chap8.Homework05;

public class Homework05 {
    public static void main(String[] args) {
        Test t = new Test();
        t.test();
    }
}

class Test{
    public void test(){
        Employee e1 = new Worker(26, 100.2);
        e1.printSal();
        Employee e2 = new Waiter(30, 237.6);
        e2.printSal();
        Employee e3 = new Farmer(30, 160.2);
        e3.printSal();
        Employee e4 = new Teacher(25, 600, 1000, 8);
        e4.printSal();
        Employee e5 = new Scientist(30, 400, 50000);
        e5.printSal();
    }
}
class Employee{
    private int workDay;
    private double daySal;

    public Employee(int workDay, double daySal) {
        this.workDay = workDay;
        this.daySal = daySal;
    }

    public int getWorkDay() {
        return workDay;
    }

    public void setWorkDay(int workDay) {
        this.workDay = workDay;
    }

    public double getDaySal() {
        return daySal;
    }

    public void setDaySal(double daySal) {
        this.daySal = daySal;
    }
    public void printSal(){
        return;
    }
}

class Worker extends Employee{
    public Worker(int workDay, double daySal) {
        super(workDay, daySal);
    }
    public void printSal(){
        System.out.println("The sal is " + getDaySal() * getWorkDay());
    }
}

class Farmer extends Employee{
    public Farmer(int workDay, double daySal) {
        super(workDay, daySal);
    }
    public void printSal(){
        System.out.println("The sal is " + getDaySal() * getWorkDay());
    }
}

class Waiter extends Employee{
    public Waiter(int workDay, double daySal) {
        super(workDay, daySal);
    }
    public void printSal(){
        System.out.println("The sal is " + getDaySal() * getWorkDay());
    }
}

class Teacher extends Employee{
    double tuitionFee;
    double tuitionDay;

    public Teacher(int workDay, double daySal, double tuitionFee, double tuitionDay) {
        super(workDay, daySal);
        this.tuitionFee = tuitionFee;
        this.tuitionDay = tuitionDay;
    }

    public double getTuitionFee() {
        return tuitionFee;
    }

    public void setTuitionFee(double tuitionFee) {
        this.tuitionFee = tuitionFee;
    }

    public double getTuitionDay() {
        return tuitionDay;
    }

    public void setTuitionDay(double tuitionDay) {
        this.tuitionDay = tuitionDay;
    }
    public void printSal(){
        System.out.println("The sal is " + (getDaySal() * getWorkDay() + tuitionFee * tuitionDay));
    }
}

class Scientist extends Employee{
    private double yearEndAward;

    public Scientist(int workDay, double daySal, double yearEndAward) {
        super(workDay, daySal);
        this.yearEndAward = yearEndAward;
    }

    public double getYearEndAward() {
        return yearEndAward;
    }

    public void setYearEndAward(double yearEndAward) {
        this.yearEndAward = yearEndAward;
    }
    public void printSal(){
        System.out.println("The sal is " + (getDaySal() * getWorkDay() + yearEndAward));
    }
}