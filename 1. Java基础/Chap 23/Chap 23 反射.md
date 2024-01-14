
- 需求来源：通过配置文件（properties）来指定类的信息，调用类的方法。
- 传统方法：通过 `properties.load()` 可以获得对应的 类地址，类方法，但是仍然是字符串形式，并不能在代码中直接创建对应类
- 因此需要采用反射的方式，通过外部文件配置，在不修改源码情况下，控制程序，符合设计模式的 `ocp` 原则（开闭原则：不修改源码，扩展功能）

# 反射机制

## 语法

```
//0. 准备工作
String classfullpath = properties.get("classfullpath");//获取对象名
String methodName = properties.get("method");//获取方法名

//1. 加载类，返回Class类型的对象（一个类）
Class cls = Class.forName(classfullpath);//根据对象名获取该类

//2. 通过 cls 得到 加载的类 的对象（示例）
Object o = cls.newInstance();

//3. 通过 cls 得到 加载的类 的 methodName 的 方法对象
//   即，在反射中，可以把方法视为对象
Method method1 = cls.getMethod(methodName);

//调用此方法
mehot1.invoke(o); //调用对象 o 的 method1方法
```

## `Java Reflection`

- 反射机制允许程序在执行期借助于 `Reflection API` 取得任何类的内部信息（比如成员变量，构造器，成员方法等），并能操作对象的属性及方法，在设计模式 和 框架底层都会用到
- 加载完类后，在堆中会产生一个 `Class` 类型的对象（一个类只有一个 `Class` 对象），这个对象包含了类的完整内部结构信息。通过这个对象得到的类结构，这个对象就像一个镜子，透过过这个镜子看到类的结构，所以形象称之为，反射。

- `Java` 程序在计算机中的三个阶段（重点围绕 类）
	- **代码阶段/编译阶段：**`.java` 程序经过 `javac` 编译产生 `.class` 字节码文件
		- `.class` 中包含 类的各种属性
	- **类的加载阶段**：类的加载器 `ClassLoader` 在代码阶段调用类方法或创建类，在此阶段就会在堆中产生 `Class` 类对象，包含成员变量、构造器、成员方法等
		- 成员变量： `Filed[] fields`
		- 构造器：`Constructor[] cons`
		- 成员方法：`Method[] ms`
	- **`Runtime` 运行阶段：**
		- 堆中创建一个 `Cat` 对象，该对象直到它属于哪个 `Class` 对象
		- 得到 `Class` 对象后
			- 创建对象，调用对象方法
			- 操作属性
			- .etc

## 反射机制可以完成

- 在运行时判断任意一个对象所属的类
- 运行时构造任意一个类的对象
- 运行时得到任意一个类所具有的成员变量和方法
- 在运行时调用任意一个对象的成员变量和方法
- 生成动态代理

## 反射相关的主要类

- `java.lang.Class`：代表一个类，`Class` 对象表示某个类加载后在堆中的对象
- `java.lang.reflect.Method`：代表类的方法
- `java.lang.reflect.Field`：代表类的成员变量
- `java.lang.reflect.Constructor`：代表类的构造方法


## 反射的优缺点

- 优点：动态地创建和使用对象（框架底层核心），使用灵活，没有反射机制，框架技术就是去底层支撑
- 缺点：使用反射基本是解释执行，对执行速度有影响


## 反射调用性能优化 - 关闭访问检查

- `Method` 和 `Field、Constructor` 对象都有 `setAccessible()` 方法
- `setAccessible` 作用是启动和禁用安全检查的开关
- 参数值为 `true` 表示 反射的对象在使用时取消访问检查，提高反射的效率，参数值为 `false` 则表示反射的对象执行访问检查。
- 性能会产生小幅度提高


# `Class` 类

## 基本介绍

- `Class` 也是类，因此也继承 `Object` 类
- `Class` 类对象不是 `new` 出来的，而是系统创建的
- 对于某个类，在内存中只有一份，因为类只加载一次
- 每个类的实例都会记得自己是由哪个 `Class` 实例所生成
- 通过 `Class` 可以完整地得到一个类的完整结构，通过一系列 `API`
- `Class` 对象是放在堆地
- 类的字节码二进制数据，是放在方法区地，有的地方称为类的元数据（包括 方法代码、变量名、方法名、访问权限等）

## `Class` 常用方法（可以理解是类的抽象）

- `static Class forName(String name)`：返回指定类名的 `Class` 对象
- `Object newInstance()`：调用缺省的构造函数，返回该对象的一个实例
- `getName()`：返回此 `Class` 对象所表示的实体（类、接口、数组类、基本类型等）名称
- `Class getSuperClass()`：返回当前 `Class` 对象的 父类的 `Class` 对象
- `Class[] getInterfaces()`：返回当前 `Class` 对象的父类的 `Class` 对象
- `ClassLoader getClassLoader()`：返回该类的类加载器
- `Class getSuperclass()`：返回此 `Class` 所表示的实体的超类的 `Class`
- `Constructor[] getConstructor()`：返回一个包含某些 `Constructor` 对象的数组
- `Field[] getDeclaredFields()`：返回 `Field` 对象的一个数组
- `Method getMethod(String name, Class ... paramTypes)`：返回一个 `Method` 对象，此对象的形参类型为 `paramType`

## 获取 `Class` 对象的 6 种方式


- 大体上分为4种：
	- 代码阶段：使用  `Class.forName()` 方法
	- 加载阶段：使用 `类.class`
	- 运行阶段：使用 `对象.getClass()`
	- 类加载器：`getClassLoader`
### 1.
- 前提：已知一个类的全类名，且该类在类路径下，可通过 `Class` 类的静态方法 `forName()` 获取，可能抛出 `ClassNotFoundException`
- 实例：`Class cls1 = Class.forName("java.lang.Cat");`
- 应用场景：多用于配置文件，读取类全路径，加载类（代码阶段）

### 2. 
- 前提：若已知具体的类，通过类的 `class` 获取，该方式 最为安全可靠，程序性能最高
- 实例：`Class cls2 = Cat.class`
- 应用场景：多用于参数传递，通过反射得到对应构造器对象（加载阶段）

### 3. 
- 前提：已知某个类的实例，调用该实例的 `getClass()` 方法获取 `Class` 对象，实例：`Class clazz = 对象.getClass();`
- 应用场景：通过创建好的对象，获取 `Class` 对象

### 4. 其它方式

- `ClassLoader cl = 对象.getClass().getClassLoader();`
- `Class clazz4 = cl.loadClass("类的全类名")`

### 5. 基本数据类型

- `Class cls = 基本数据类型.class`

### 6.基本数据类型对应的包装类

- `Class cls = 包装类.TYPE`

## 有 `Class` 对象的类型

- 外部类，成员内部类，静态内部类，局部内部类，匿名内部类
- `interface`：接口
- 数组
- `enum`：枚举
- `annotation`：注解
- 基本数据类型
- `void`


# 类加载

## 基本说明

- 反射机制是 `java` 实现动态语言的关键，也就是通过反射实现类动态加载
	- 静态加载：编译时加载相关的类，如果没有则报错，依赖性太强
	- 动态加载：运行时加载需要的类，如果运行时不用该类，则不报错，降低了依赖性


## 类加载时机

- 当创建对象时（new）（静态加载）
- 当子类被加载时，父类也被加载  （静态加载）
- 调用类中的静态成员时  （静态加载）
- 通过反射  （动态加载）


## 类加载过程（由JVM机完成）

- Java源码 经过 javac 编译后得到 字节码文件 
- 运行时，对类进行加载，分为3个阶段
	- 加载 `Loading` ：将类的 `class` 文件读入内存，并为之创建一个 `java.lang.Class` 对象，此过程由类加载器完成
	- 连接 `Linking` ：将类的二进制数据合并到 `JRE` 中
		- 验证 `verification`
		- 准备 `Preparation`
		- 解析 `Resolution`
	- 初始化 `initialization` ：对类进行初始化，主要指静态成员

- 类加载后的内存布局
	- 方法去创建了 类的字节码的二进制数据
	- 堆区生成 类的 `Class` 对象

## 加载

- 将字节码从不同的数据源（可能是 `class` 文件、也可能是 `jar` 包，甚至网络）转换成二进制字节流加载到内存，并生成一个代表该类的 `java.lang.Class` 对象

## 连接

#### 验证

- 确保 `.Class` 文件的字节流中包含的信息符合当前虚拟机的要求，并且不会危害虚拟机自身的安全
- 包括：文件格式验证（是否以魔数 `oxcafebabe` 开头）、元数据验证、字节码验证和符号引用验证
- 可以考虑 `-Xverify:none` 参数来关闭大部分的类验证措施，缩短虚拟机类加载的时间

#### 准备

- 对静态变量，分配内存并默认初始化（对应数据类型的默认初始值，如 0、0L、null、false等）。这些变量使用的内存都将在方法区中进行分配。
	- `public int n = 12;` 在准备阶段不会分配内存
	- `public static int n1 = 220;` 在准备阶段会分配内存，初始化为0（在初始化阶段为设置为220）
	- `public static final int n3 = 12;` 在准备阶段会分配内存，初始化就是12 
#### 解析

- 将常量池内的符号引用替换为直接引用的过程

## 初始化

- 才真正执行类中定义的 `Java` 程序代码·1，执行 `<clinit>()` 方法的过程
- `<clinit>()` 方法是由编译器按语句在源文件中出现的顺序，依次自动收集类中的所有 **静态变量** 的赋值动作 和 静态代码块中的语句，进行合并
- 虚拟机会保证一个类 `<clinit>()` 方法在多线程环境中被正确地加锁、同步，如果多个线程同时去初始化一个类，那么只会有一个线程去执行这个类的 `<clinit>()` 方法，其他线程都需要阻塞等待，直到活动线程执行 `<clinit>()` 方法完毕


# 通过反射获取类的结构信息

## `java.lang.Class` 类

- `getName`：获取全类名
- `getSimpleName`：获取简单类名
- `getFields`：获取所有 `public` 修饰的属性，包含本类以及父类的
- `getDeclaredFields`：获取本类中所有方法
- `getMethods`：获取所有 `public` 修饰的方法，包含本类以及父类的
- `getDeclaredMethods`：获取本类的所有方法
- `getConstructors`：获取本类中所有`public`修饰的构造器，仅包含本类的
- `getDeclaredConstructors`：获取本类中所有构造器
- `getPackage`：以 `Package` 形式返回 包信息
- `getSuperClass`：以 `Class` 形式返回父类信息
- `getInterfaces`：以 `Class[]` 形式返回接口信息
- `getAnnotations`：以 `Annontation[]` 形式返回注解信息

## `java.lang.reflect.Field` 类

- `getModifiers`：以 `int` 形式返回修饰符
	- 默认修饰符是 0， public 是 1，private 是 2，protected 是 4，static 是 8， final 是 16
- `getType`：以 `Class` 形式返回类型
- `getName`：返回属性名


## `java.lang.reflect.Method` 类

- `getModifiers`：以 `int` 形式返回修饰符
	- 默认修饰符是 0， public 是 1，private 是 2，protected 是 4，static 是 8， final 是 16
- `getReturnType`：以 `Class` 形式获取返回类型
- `getName`：返回方法名
- `getParameterTypes`：以 `Class[]` 返回参数类型数组 


## `java.lang.reflect.Constructor` 类

- `getModifiers`：以 `int` 形式返回修饰符
- `getName`：返回构造器名（全类名）
- `getParameterTypes`：以 `Class[]` 返回参数类型数组



# 反射暴破


## 创建对象

- 方式1：调用类中的 `public` 修饰的无参构造器
- 方式2：调用类中的指定构造器

- `Class` 类相关方法
	- `newInstance`：调用类中的无参构造器，获取对应类的对象
	- `getConstructor(Class...clazz)`：根据参数列表，获取对应的`public`构造器对象
	- `getDeclaredConstructor(Class...clazz)`：根据参数列表，获取对应的构造器对象

-  `Constructor` 类相关方法
	- `setAccessible`：暴破
	- `newInstance(Object...obj)`：调用构造器


## 访问类中成员

### 属性

- 根据属性名获取 `Field` 对象
	- `Field f = clazz对象.getDeclaredField(属性名);`
- 暴破：`f.setAccessible(true);//f 是 Field对象`
- 访问
	- `f.set(o,值);`
	- `syso(f.get(o))`
- 如果是静态属性，则 `set` 和 `get` 中的参数 `o`，可以写成 `null`


## 方法

- 根据方法名 和 参数列表获取 `Method` 方法对象：`Method m = clazz.getDeclaredMethod(方法名, XX.class);`
- 获取对象：`Object o = clazz.newInstance();`
- 暴破：`m.setAccessible(true);`
- 访问：`Object returnValue = m.invoke(o, 实参列表);`
- 如果是静态方法，`invoke`的参数 `o`，可以写成 `null`
