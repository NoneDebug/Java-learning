package com.tybxx.Chap8.Homework10;

import javax.print.Doc;

public class Homework10 {
    public static void main(String[] args) {
        Doctor d1 = new Doctor("李文亮", 35, "doctor", '男', 0);
        Doctor d2 = new Doctor("张文宏", 54, "doctor", '男', 50000);
        Doctor d3 = new Doctor("李兰娟", 76, "doctor", '女', 500000);
        Doctor d4 = new Doctor("李文亮", 35, "doctor", '男', 0);
        Object o = new Object();
        System.out.println(d1.equals(d3));
        System.out.println(d1.equals(d2));
        System.out.println(d1.equals(d4));
        System.out.println(d1.equals(o));

    }
}

class Doctor{
    private String name;
    private int age;
    private String job;
    private char gender;
    private double sal;

    public Doctor(String name, int age, String job, char gender, double sal) {
        this.name = name;
        this.age = age;
        this.job = job;
        this.gender = gender;
        this.sal = sal;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public double getSal() {
        return sal;
    }

    public void setSal(double sal) {
        this.sal = sal;
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj){
            return true;
        }
        if(obj instanceof Doctor){
            return ((Doctor) obj).age == this.age &&
                   ((Doctor) obj).sal == this.sal &&
                   ((Doctor) obj).gender == this.gender &&
                   ((Doctor) obj).job.equals(this.job) &&
                   ((Doctor) obj).name.equals(this.name);
        }
        return false;
    }
}