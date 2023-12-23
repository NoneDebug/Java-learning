package com.tybxx.Chap8.Homework13;

public class homework13 {
    public static void main(String[] args) {
        Person[] persons = new Person[4];
        persons[0] = new Student("梅西", '男', 36, "870624");
        persons[1] = new Teacher("董宇辉",'男', 30, 7);
        persons[2] = new Teacher("战鹰", '女', 28, 2);
        persons[3] = new Student("C罗", '男', 38, "850205");
        printPerson(persons);
        bubbleSortPerson(persons);
        System.out.println("====================");
        System.out.println("Sorting....");
        System.out.println("====================");
        printPerson(persons);

        printPersonInfo(persons);

    }

    public static void bubbleSortPerson(Person[] persons) {
        for (int i = 0; i < persons.length; i++) {
            for (int j = 0; j < persons.length - 1 - i; j++) {
                if (persons[j].getAge() > persons[j + 1].getAge()) {
                    Person tempPerson = persons[j];
                    persons[j] = persons[j + 1];
                    persons[j + 1] = tempPerson;
                }
            }
        }
    }
    public static void printPerson(Person[] persons){
        for (int i = 0; i < persons.length; i++) {
            System.out.println(persons[i]);
        }
    }

    public static void printPersonInfo(Person[] persons){
        for (int i = 0; i < persons.length; i++) {
            if(persons[i] instanceof Teacher){
                System.out.println("老师的信息：");
                System.out.println("姓名：" + persons[i].getName());
                System.out.println("年龄：" + persons[i].getAge());
                System.out.println("性别：" + persons[i].getSex());
                System.out.println("工龄：" + ((Teacher) persons[i]).getWork_age());
                ((Teacher) persons[i]).teach();
                persons[i].play();
            }else if(persons[i] instanceof Student){
                System.out.println("学生的信息：");
                System.out.println("姓名：" + persons[i].getName());
                System.out.println("年龄：" + persons[i].getAge());
                System.out.println("性别：" + persons[i].getSex());
                System.out.println("学号：" + ((Student) persons[i]).getStu_id());
                ((Student) persons[i]).study();
                persons[i].play();
            }else{
                System.out.println("类型错误！");
            }
            System.out.println("------------------------");
        }
    }
}

class Person {
    private String name;
    private char sex;
    private int age;

    public Person(String name, char sex, int age) {
        this.name = name;
        this.sex = sex;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String play() {
        return this.name + "爱玩";
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", sex=" + sex +
                ", age=" + age
                ;
    }


}

class Student extends Person {
    private String stu_id;

    public Student(String name, char sex, int age, String stu_id) {
        super(name, sex, age);
        this.stu_id = stu_id;
    }

    public String getStu_id() {
        return stu_id;
    }

    public void setStu_id(String stu_id) {
        this.stu_id = stu_id;
    }

    public void study() {
        System.out.println("我承诺，我会好好学习");
    }

    @Override
    public String play() {
        return super.play() + "足球";
    }

    @Override
    public String toString() {
        return super.toString() +
                ", stu_id='" + stu_id + "\'" +
                '}';
    }
}

class Teacher extends Person {
    private int work_age;

    public int getWork_age() {
        return work_age;
    }

    public void setWork_age(int work_age) {
        this.work_age = work_age;
    }

    public Teacher(String name, char sex, int age, int work_age) {
        super(name, sex, age);
        this.work_age = work_age;
    }

    public void teach() {
        System.out.println("我承诺，我会认真教学");
    }

    @Override
    public String play() {
        return super.play() + "象棋";
    }
    @Override
    public String toString() {
        return super.toString() +
                ", work_age='" + work_age + "\'" +
                '}';
    }
}