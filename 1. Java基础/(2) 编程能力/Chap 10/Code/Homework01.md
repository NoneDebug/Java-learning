```
main(){
  Car c = new Car();
  Car c1 = new Car(100);
  System.out.println(c);
  System.out.println(c1);
}

class Car{
  double price = 10;
  static String color = "white";
  public String toString(){
    return price + "\t" + color;
  }
  public Car(){
    this.price = 9;
    this.color = "red";
  }
  public Car(double price){
    this.price = price;
  }
}
```
> 试写出上述代码的执行结果

- 输出结果为：
  - 9.0  red
  - 100.0  red
