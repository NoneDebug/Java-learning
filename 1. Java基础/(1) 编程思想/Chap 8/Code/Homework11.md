> 现有 `Person` 类，里面有方法 `run`，`eat`，`Student` 类继承了 `Person` 类，并重写了 `run` 方法，自定义了 `study` 方法，试写出对象向上转型 和 向下转型的代码，并写出各自都可以调用哪些方法，并写出方法输出什么？

```
class Person{
  public void run(){System.out.println("person run");}
  public void eat(){System.out.println("person eat");}
}
class Student extends Person{
  public void run(){System.out.println("student run");}
  public void study(){System.out.println("student study..");}
}
```

- 向上转型代码（父类引用指向子类对象）
```
Person p = new Student(); 
p.run();    //输出 student run（因为重写了方法）
//p.study();  //无法输出
p.eat();    //输出 person eat
```

- 向下转型代码（把指向子类对象的父类引用，转成指向子类对象的子类引用）
```
Student s = (Student)p;
s.run();    //输出student run
s.study();  //输出student study..
s.eat();    //输出person eat
```
