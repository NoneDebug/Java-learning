> 程序阅读题在 `main` 方法中 执行：`C c = new C();`，输出什么内容？

```
class A{
  public A(){
    System.out.println("我是A类");
  }
}
class B extends A{
  public B(){
    System.out.println("我是B类的无参构造");
  }
  public B(String name){
    System.out.println(name + "我是B类的有参构造");
  }
}
class C extends B{
  public C(){
    this("hello");
    System.out.println("我是c类的无参构造");
  }
}
public C(String name){
  super("hahah");
  System.out.println("我是c类的有参构造");
}
```

- 输出结果：
  - 我是A类
  - hahah我是B类的有参构造
  - 我是c类的有参构造
  - 我是c类的无参构造
  
