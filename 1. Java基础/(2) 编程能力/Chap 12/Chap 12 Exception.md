# 异常的概念

```
public class Exception01 {  
    public static void main(String[] args) {  
        int num1 = 10;  
        int num2 = 0;  
        int res = num1 / num2;  
        System.out.println("程序继续运行");  
    }  
}
```

- 此例中，出现除以0的情况，程序会出现（抛出）异常，`ArithmeticException` 
- 当抛出异常后，程序就退出，崩溃了，接下代码就不会再执行

- 因此 `Java` 设计者提出了 `异常处理机制` 来解决问题，避免程序的非鲁棒

## 基本概念

- 程序执行中发生的不正常情况称为“异常”（开发过程中的语法错误 和 逻辑错误不是异常）

- 两类异常
	- `Error(错误)`：`Java`虚拟机无法解决的严重问题。如 `JVM`系统内部错误、资源耗尽等情况。比如：`StackOverflowError`【栈溢出】 和 OOM(out of memory)，`Error` 是严重错误，程序会崩溃
	- `Exception` ：其它因编程错误 或 偶然的外在因素导致的一般性问题，可以使用针对性的代码进行处理。例如空指针访问，试图读取不存在的文件，网络连接中断等。`Exception` 分为两类：
		- 运行时异常【程序运行时发生的异常】，编译器不要求强制处置的异常，一般指编程时的逻辑错误，是程序员应该避免其出现的异常。（可以不做处理，因为此类异常非常常见，全处理会对程序可读性和运行效率产生影响）
		- 编译时异常【编程时，由编译器检查出的异常】（编译器要求必须处置的异常）

# 异常体系图（重点）


- Java源程序
	- 此阶段 编译器 会检查 `编译异常`
- 字节码文件(由 `javac.exe` 生成)
- 内存中加载、运行类（由 `java.exe` 生成）
	- 此阶段 `jvm` 会检查 `运行异常`

- `Throwable`
	- `Error` (非受检异常，运行异常)
		- `OutofMemoryError`：内存溢出错误
		- `StackOverflowError`：栈溢出错误
	- `Exception`
		- `IOException` (受检异常，编译异常)
			- `EOFException`
			- `FileNotFoundException`
			- `MalformedURLException`
			- `UnknownHostException`
		- `ClassNotFoundException`  (受检异常，编译异常)
		- `CloneNotSupportedException`  (受检异常，编译异常)
		- `RuntimeException` (非受检异常，运行异常)
			- `ArithmeticException`
			- `ClassCastException`
			- `IllegalArgumentException`
			- `IllegalStateException`
			- `IndexOutOffBoundsException`
			- `NoSuchElementException`
			- `NullPointerException`
			- `ArrayIndexOutofBoundException`



# 常见的异常

## 五大运行时异常

### `NullPointerException`：空指针异常

- 发生原因：试图在需要对象的地方使用 `null` 时，抛出此异常
```
public class NullPointerException_ {  
    public static void main(String[] args) {  
        String name = null;  
        System.out.println(name.length());  
    }  
}
```
> 运行结果为：at NullPointerException_.main(NullPointerException_.java:10)
> 进程已结束，退出代码为 1


### `ArithmeticException`：数学运算异常

- 发生原因：数学运算的异常，例如整数“除以0”时，抛出此类的一个实例

### `ArrayIndexOutofBoundException`：数组下标越界异常

- 发生原因：用非法索引访问数组时抛出的异常，如果索引为负 或 大于等于数组大小，则索引为非法索引。
- 例如：`int[] arr = new int[4];   System.out.println(arr[4])`

### `ClassCastException`：类型转换异常

- 发生原因：当试图将对象强制转换为不是实例的子类时，抛出该异常。
- 例如：
	```
	class A{}
	class B extends A{}
	class C extends A{}
	A a = new B(); //正确，向上转型
	B b = (B) a;   //正确，向下转型
	C c = (C) a;   //错误
	```

### `NumberFormatException`：数字格式不正确异常

- 发生原因：试图将字符串转换为一种数值类型，但该字符串不能转换为适当格式时，抛出此异常 => 使用异常可以确保输入是满足条件的数字

## 编译异常

### 介绍

- 在编译期间，必须处理的异常，否则代码不能通过编译

###  常见的编译异常

- `SQLException` //操作数据库时，查询表可能发生异常
- `IOException`   //操作文件时，发生的异常
- `FileNotFoundException`  //操作一个不存在的文件时，发生异常
- `ClassNotFoundException`  //加载类，而该类不存在时，异常
- `EOFException`  //操作文件，到文件末尾，发生异常
- `IllegalArguementException`  //参数异常



# 异常处理

## 基本介绍

- 当异常发生时，对异常的处理方式
## 异常处理的方式

- `try-catch-finally` ：程序员在代码中捕获发生的异常，自行处理

```
try{
代码/可能由异常
}catch(Exception e){

//捕获到异常
//1.当异常发生时
//2.系统将异常封装成Exception对象e，传递给catch
//3.得到异常对象后，程序员自己处理

}finally{

//1.不管try代码块是否有异常发生，始终执行finally
//2.通常将释放资源的代码，放在finally

}
```


- `throws`：将发生的异常抛出，交给调用者(方法)来处理，最顶级的处理者就是`JVM`

```
JVM    main    f1方法    f2方法
若 f2方法发生异常，可使用throw抛给f1，如果f1打算解决，可以用try-catch-finally，如果不想解决，则可以继续通过throw抛给main，以此类推，最上层为 JVM。
```

> 如果程序员没有显式地指明t-c-f，则默认throws给JVM处理




## try-catch方式处理异常

- `try` 块用于包含可能出错地代码，`catch` 块用于处理 `try` 块中发生的异常。可以根据需要在程序中有多个数量的 `try...catch` 块
- 基本语法：

	```
	try{
		//可疑代码
		//将异常生成对应的异常对象，传递给catch块	
	}catch(异常){
		//对异常的处理
	}
	```

- 注意事项
	- 如果异常发生，异常后面的代码不会执行，直接进入到 `catch` 块
	- 如果异常没有发生，则顺序执行 `try` 代码块，不会进入到 `catch` 块
	- 如果希望不管是否发生异常，都执行某段代码（如关闭连接，释放资源等），则使用 `finally{}` 代码块
	- 可以有多个 `catch` 语句，捕获不同的异常（进行不同的业务处理），要求父类异常在后，子类异常在前，比如(`Exception` 在后，`NullPointerException` 在前)，如果发生异常，只会分配一个 `catch`。
	- 可以使用 `try-finally` 配合使用，这种用法相当于没有捕获异常，因此程序直接崩掉/退出。应用场景就是执行一段代码，不管是否发生异常，都必须执行某个业务逻辑。

- 如果没有出现异常，执行 `try` 块中所有语句，不执行 `catch` 块中语句，假如有 `finally`，最后还需要执行 `finally` 里面的语句
- 如果出现异常，则 `try` 块中异常发生后，剩下的语句不再执行，将执行 `catch` 块中语句，如果有 `finally`，最后还需要执行 `finally` 里面的语句


## `throws` 异常处理

### 基本介绍

- 如果一个方法（中的语句执行时）可能生成某种异常，但是并不能确定如何处理这种异常，则此方法应显式地声明抛出异常，声明方法将不对这些异常进行处理，而由该方法地调用者负责处理
- 在方法声明中用 `throws` 语句可以声明抛出异常的列表，`throws`后面的异常类型可以是方法中产生的异常类型，也可以是它的父类。
 
### 注意事项 和 使用细节

- 对于编译异常，程序必须处理，使用 `try-catch` 或 `throws`
- 对于运行时异常，程序中如果没有处理，默认就是 `throws`的方法处理
- 子类重写父类的方法时，对抛出异常的规定：子类重写的方法，所抛出的异常类型要么和父类抛出的异常一致，要么为父类抛出的异常类型的子类型
- 在 `throws` 过程中，如果有方法 `try-catch`，就相当于处理异常，就可以不必 `throws`


# 自定义异常

## 基本概念

- 当程序中出现了某些 “错误”，但该错误并没有在 `Throwable` 子类中描述处理，这个时候可以自己设计异常类，用于描述该错误信息。

## 自定义异常的步骤

- 定义类：自定义异常类名（程序员自己写）继承 `Exception` 或 `RuntimeException`
- 如果继承 `Exception`，属于编译异常
- 如果继承 `RuntimeException`，属于运行异常（一般来说继承 `RuntimeException`）

```
public class CustomException {  
    public static void main(String[] args) {  
        int age = 180;  
        if(!(age >= 18 && age <= 120)){  
            throw new AgeException("年龄需要在 18~120之间");  
        }  
        System.out.println("你的年龄范围正确");  
    }  
}  
  
class AgeException extends RuntimeException{  
    public AgeException(String message) {  
        super(message);  
    }  
}

输出结果为：
Exception in thread "main" AgeException: 年龄需要在 18~120之间
	at main(CustomException.java:11)
```

# `throw` 和 `throws` 的对比


## 一览表

|  | 意义 | 位置 | 后面跟的东西 |
| ---- | ---- | ---- | ---- |
| throws | 异常处理的一种方式 | 方法声明处 | 异常类型 |
| throw | 手动生成异常对象的关键字 | 方法体处 | 异常对象 |
