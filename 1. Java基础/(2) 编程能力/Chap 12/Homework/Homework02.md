```
  //2 说出以下代码是否会发生异常，如果会，是哪种异常?如果不会，则打印结果是什么
  HomeworkO2.java
  public static void main(String[] args){
  if(args[4].equals("john")){
    System.out.println("AA");
  }else{
    System.out.println("BB");
  }
  Object o = args[2];
  Integer i = (Integer)o;
```

> 可能会发生 `NullPointerException`，异常语句为：`args[4].equals("john")`
> 一定会发生 `ClassCastException`，异常语句为：`Integer i = (Integer)o;`
