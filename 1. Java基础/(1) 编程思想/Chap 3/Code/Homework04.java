/*
  要求：
    (1) 用变量名将姓名、年龄、成绩、性别、爱好存储
    (2) 使用加号
    (3) 使用适当的注释
    (4) 添加转义字符，使用一条语句输出
*/

public class Homework04{
  public static void main(String[] args){
    System.out.println("姓名" + "\t" + "年龄" + "\t" +
                       "成绩" + "\t" + "性别" + "\t" +
                       "爱好");
    String name = "Yubo Tang";
    int age = 23;
    double grade = 567.0;
    char gender = "男";
    String hobby = "唱、" + "跳、" + "rap、" + "篮球";
    System.out.println(name + "\t" + age + "\t" +
                       grade + "\t" + gender + "\t" +
                       hobby);
  }
}
