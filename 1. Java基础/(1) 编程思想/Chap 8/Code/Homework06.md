> 在 父类 和 子类中通过 `this` 和 `super` 都可以调用哪些属性和方法，假定 `Grand`,`Father`,`Son`在同一个包
```
class Grand{
  String name = "AA";
  private int age = 100;
  public void g1(){};
}
class Father extends Grand{
  String id = "001";
  private double score;
  public void f1(){
    //super 可以访问哪些成员（属性和方法）？
    //this 可以访问哪些成员？
  }
}
class Son extends Father{
  String name = "BB"
  public void g1(){}
  private void show(){
    //super 可以访问哪些成员（属性和方法）？
    //this 可以访问哪些成员？
  }
}
```

- 对于`Father`类而言：
  - `super` 可以访问来自 `Grand` 类中的 `name` 和 `age` 属性，以及 `g1` 方法
  - `this` 可以访问来自
    - `Grand` 类中的 `name` 属性 以及 `g1` 方法
    - 本类中的 `id` 和 `score` 属性 以及 `f1` 方法

- 对于 `Son` 类而言：
  - `super` 可以访问来自
    - `Grand` 类中的 `name` 属性 以及 `g1` 方法
    - `Father` 类中的 `id` 和 `scre` 属性 以及 `f1` 方法
  - `this` 可以访问来自
    - `Grand` 类中的 `name` 属性以及 `g1` 方法
    - `Father` 类中的 `id` 属性 以及 `f1` 方法
    - 本类中的 `name` 属性 以及 `g1` 和 `show` 方法    
