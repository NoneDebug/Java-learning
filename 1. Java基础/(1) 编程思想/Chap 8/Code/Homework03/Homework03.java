package com.tybxx.Chap8.Homework03;
/*
* 编写老师类
* (1) 要求有属性 "姓名name", "年龄age", "职称post", "基本工资salary"
* (2) 编写业务方法,introduce(),实现输出一个教师的信息
* (3) 编写教师的三个子类：教授类、副教授类、讲师类。工资级别分别是：
*     教授为1.3、副教授为1.2、讲师类1.1。在三个子类里面都重写父类的introduce()方法
* (4) 定义并初始化一个老师对象，调用业务方法，实现对象基本信息的后台打印
* */
public class Homework03 {
    public static void main(String[] args) {
        Teacher l = new Prof("Wenjian Luo", 48, "Prof", 40000);
        l.introduce();
        Teacher g = new assoProf("Jicheng Guo", 50, "AssoProf", 70000);
        g.introduce();
        Teacher s = new Lecturer("Suffy", 39, "Lect", 20000);
        s.introduce();
        Teacher gd = new Teacher("Dan Gan", 40, "Techer", 30000);
        gd.introduce();


    }
}

class Teacher{
    private String name;
    private int age;
    private String post;
    private double salary;

    public String SalaryRank = "";
    public Teacher(String name, int age, String post, double salary) {
        this.name = name;
        this.age = age;
        this.post = post;
        this.salary = salary;
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

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", post='" + post + '\'' +
                ", salary=" + salary +
                '}';
    }

    public void introduce(){
        System.out.println(this);
    }
}

class Prof extends Teacher{

    public Prof(String name, int age, String post, double salary) {
        super(name, age, post, salary);
        super.SalaryRank = "1.1";
    }

    @Override
    public String toString() {
        return  "Teacher{" +
                "name='" + super.getName() + '\'' +
                ", age=" + super.getAge() +
                ", post='" + super.getPost() + '\'' +
                ", salary=" + super.getSalary() +
                ", salaryRank=" + super.SalaryRank +
                '}';
    }

    @Override
    public void introduce() {
        System.out.println(this);
    }
}

class assoProf extends Teacher{


    public assoProf(String name, int age, String post, double salary) {
        super(name, age, post, salary);
        super.SalaryRank = "1.2";
    }

    public String getSalaryRank() {
        return SalaryRank;
    }

    public void setSalaryRank(String salaryRank) {
        this.SalaryRank = salaryRank;
    }
    @Override
    public String toString() {
        return  "Teacher{" +
                "name='" + super.getName() + '\'' +
                ", age=" + super.getAge() +
                ", post='" + super.getPost() + '\'' +
                ", salary=" + super.getSalary() +
                ", salaryRank=" + SalaryRank +
                '}';
    }

    @Override
    public void introduce() {
        System.out.println(this);
    }
}

class Lecturer extends Teacher{


    public Lecturer(String name, int age, String post, double salary) {
        super(name, age, post, salary);
        SalaryRank = "1.3";
    }

    public String getSalaryRank() {
        return SalaryRank;
    }

    public void setSalaryRank(String salaryRank) {
        this.SalaryRank = salaryRank;
    }
    @Override
    public String toString() {
        return  "Teacher{" +
                "name='" + super.getName() + '\'' +
                ", age=" + super.getAge() +
                ", post='" + super.getPost() + '\'' +
                ", salary=" + super.getSalary() +
                ", salaryRank=" + this.SalaryRank +
                '}';
    }

    @Override
    public void introduce() {
        System.out.println(this);
    }
}