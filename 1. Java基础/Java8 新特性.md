
- 简介：`Java 8` （也称 `jdk1.8`）是 `Java` 语言开发的一个主要版本，为 `Java` 语言、编译器、类库、开发工具 与 `JVM` 带来了大量的新特性。
- 新特性
	- 速度更快
	- 代码更少（增加了新语法：`Lambda 表达式`）
	- 强大的 `Stream API`
	- 便于并行
	- 最大化减少空指针异常：`Optional
	- Nashorn引擎，允许在 `JVM` 上运行 `JS` 应用

# `Lambda` 表达式

- 定义：`Lambda` 是一个匿名函数，可以把 `Lambada` 表达式理解为是一段可以传递的代码（将代码像数据一样进行传递）。使用它可以写出更为简洁、灵活的代码。

- 语法：`(o1, o2) -> Integer.compare(o1, o2);`
	- `->`：`lambda` 操作符
	- `-> 左边`：`lambda` 形参列表操作符（接口中抽象方法的形参列表）
	- `-> 右边`：`lambda` 方法体（重写的接口中抽象方法体）

- `Lambda` 表达式的六种格式
	- 格式1：无参、无返回值
		- `Runnable r1 = () -> {System.out.println("Hello Lambda1";)};
	- 格式2：需要一个参数、无返回值
			在括号中写入类型 + 形参名
		- 格式3：数据类型可以省略，由编译器推断得出，称为“类型推断”
	- 格式4：只需要一个参数时，参数的小括号可以省略
	- 格式5：需要两个或以上的参数，多条执行语句，并且可以有返回值
	- 格式6：当 `Lambda` 体只有一条语句时， `return` 与 大括号若有，都可以省略

- `Lambda` 表达式的本质：作为函数式接口的实例

# 函数式(Functional)接口

## 定义

- 如果一个接口中，只声明了一个方法，则称此接口为函数式接口

- 例如：
	 ```
	 public interface Runnable{
		 public abstract void run();
	 }
	```

- 自己定义一个函数式接口时，可以加注解符 `@FunctionalInterface`（不加也不影响，加了编译器会帮我们验证是否是函数式接口）

- 可以通过 `Lambda` 表达式来创建该接口的对象。（若 `Lambda` 表达式抛出一个受检异常（非运行时异常）），那么该异常需要在目标接口的抽象方法上声明
- 可以在接口使用 `@FunctionalInterface` 注解，`javadoc` 会包含一条申明，说明此接口是一个函数式接口
- `java.util.function` 包下定义了 `Java8` 的丰富的函数式接口

## 内置四大核心函数式接口

| 函数式接口 | 参数类型 | 返回类型 | 用途 |
| ---- | ---- | ---- | ---- |
| `Consumer<T>` 消费型接口 | T | void | 对类型为 T的对象应用操作，包含方法`void accept(T t)` |
| `Supplier<T>` 供给型接口 | 无 | T | 返回类型为 T的对象，包含方法： `T get()` |
| `Function<T,R>` 函数型接口 | T | R | 对类型为 T的对象应用操作，返回结果，结果是R类型的对象，包含方法：`R apply(T t)` |
| `Predicate<T>` 断定型接口 | T | boolean | 确定类型为 T的对象是否满足约束，并返回 `boolean` 值。包含方法：`boolean test(T t)` |





# 方法引用 与 构造器引用

## 方法引用

- 当要传递给 `Lambda` 体的操作，已经有实现的方法了，可以使用方法引用
- 方法引用可以看做是 `Lambda` 表达式深层次的表达。方法引用就是 `Lambda` 表达式，也就是函数式接口的一个实例，通过方法的名字指向一个方法，可以认为是 `Lambda` 表达式的一个语法糖。
- 要求：实现接口的抽象方法的参数列表和返回值类型，必须与方法引用的方法的参数列表和返回值类型保持一致
- 格式：使用操作符 `::` 将类（或对象） 与 方法名分隔开
- 三种主要使用方式
	- `对象::实例方法名`
	- `类::静态方法名`
	- `类::实例方法名`

## 构造器引用

> 和方法引用类似，抽象方法返回值类型即为构造器所属类的类型

- 语法：`Supplier<Employee> sup1 = () -> new Employee();` => `Supplier<Employee> sup1 = Employee :: new;` 这是对无参构造器的调用
- 语法：`Supplier<Employee, Integer> sup2 = id -> new Employee(id);` => `Supplier<Integer, Employee> sup1 = Employee :: new;`

## 数组引用

> 看作一个特殊的类

- `Lambda`表达式写法：`Function<Integer, Stringp[]> func1 = length -> new String[length]; String[] arr1 = func1.apply(5);`
- 数组引用写法： `Function<Integer, Stringp[]> func1 = String[] :: new; String[] arr1 = func1.apply(5);`

# 强大的 Stream API

- `Java 8` 的两个改变：`Lambda` 表达式；`Stream API`
- 真正把函数式编程风格引入到 Java 中。提高生产力。
- `Stream` 是 `Java8` 中处理集合的关键抽象概念，可指定希望对集合进行的操作，可以进行非常复杂的查找、过滤和映射数据等操作。使用 `Stream API` 对集合数据进行操作，就类似于使用 SQL 执行的数据库查询。也可以使用 `Stream API` 来并行执行操作。它提供了一种高效且易于使用的处理数据的方式。

## 使用 Stream API 的原因

- 实际开发中，多数数据源来自 `MySQL`，`Oracle` 等。现在数据源可以更多，有 `MongDB, Radis` 等，这些 `NoSQL` 数据需要 `Java` 层面去处理
- `Stream` 和  `Collection` 集合的区别是：`Collection` 是一种静态的内存数据结构，`Stream` 是有关计算的。前者面向内存，存储在内存中，后者面向 CPU，通过CPU进行计算。

## 定义

- `Stream`：数据渠道，用于操作数据源（集合、数组等）所生成的元素序列
	- “集合讲的是数据，Stream讲的是计算”
	- 注意：
		- Stream不会自己存储元素
		- Stream不会改变源对象，相反，他们会返回一个持有结果的新Stream
		- Stream操作是延迟执行的，会等到需要结果的时候才执行。

## Stream的操作的三个步骤

- 1 - 创建 `Stream`
	- 一个数据源（如：集合、数组），获得一个流
- 2 - 中间操作
	- 一个中间操作链，对数据源的数据进行处理
- 3 - 终止操作
	- 一旦执行终止操作，就执行中间操作链，并产生结果，之后就不会再被使用

### 步 骤 一. 创建  `Stream` 对象的四种方式 

- 方式1：通过集合获得顺序流/并行流
	- 语法：`Stream <集合类名> stream名 = 集合名.stream();` 按照顺序
	- 因为在集合中定义了默认方法`default stream()`，只能通过集合来调用
	- 语法：`Stream <集合类名> stream名 = 集合名.parellelStream()` 返回并行流，同时取数据
- 方式2：通过数组
	- 语法：`Arrays.stream(数组名) ` 实现 `Stream` 的获取
- 方式3：通过 `Stream` 的 `of()`
	- 语法：`Stream.of(实例1, 实例2, ... , 实例n)`
	- 返回值便是对应的流对象
- 方式4：创建无限流
	- 语法：`Stream.iterate()`
		- 实例：`Stream.iterate(seed, t -> t + 2).limit(10).forEach(System.out :: println)` 限制无限流的输出个数为10个，从0开始，每次 加 2（即输出前10个偶数）
	- 语法：`Stream.generate()`
		- 实例：`Stream.generate(Math:random).limit(10).forEach(System.out :: println)` 随机生成 10 个数据


### 步 骤 二. `Stream` 中间操作

- 多个中间操作可以连接起来成为一个流水线，除非流水线上出发终止操作，否则中间操作不会执行任何的处理。而在终止时一次性全部处理，称为“惰性求值”。


#### 1 - 筛选 与 切片

| 方法 | 描述 |
| ---- | ---- |
| `filter(Predicate p)` | 接收 `Lambda`，从流中排除某些元素，括号内是满足条件的 `Lambda` 表达式 |
| `distinct()` | 筛选，通过流所生成元素的 `hashCode()` 和 `equals` 去除重复元素 |
| `limit(long maxSize)` | 截断流，使其元素不超过给定数量 |
| `skip(long n)` | 跳过元素，返回一个扔掉了前n个元素的流。若流中元素不足n个，则返回一个空流，与 `limit(n)` 互补。 |

#### 2 - 映射

| 方法 | 描述 |
| ---- | ---- |
| `map(Function f)` | 接收一个函数作为参数，该函数会应用到每个元素上，将其映射成一个新的元素 |
| `mapToDouble(ToDoubleFunction f)` | 接收一个函数作为参数，该函数会被应用到每个元素上，产生一个新的 `DoubleStream` |
| `mapToint(TointFunction f)` | 接受一个函数作为参数，该函数会应用到每个元素上，产生一个新的 `IntStream` |
| `mapToLong(ToLongFunction f)` | 接受一个函数作为参数，该函数会应用到每个元素上，产生一个新的 `LongStream` |
| `flatMap(Function f)` | 接收一个函数作为参数，将流中的每个值都换成一个流，然后把所有流连接成一个流（遍历集合中的每个元素） |

#### 3 - 排序

| 方法 | 描述 |
| ---- | ---- |
| `sorted()` | 产生一个新流，按自然顺序排序 |
| `sorted(Comparator com)` | 产生一个心流，按比较器顺序排序 |

### 步 骤 三. `Stream` 的终止操作

#### 1 - 匹配与查找

| 方法 | 描述 |
| ---- | ---- |
| `allMatch(Predicate p)` | 检查是否匹配所有元素，返回布尔类型 |
| `anyMatch(Predicate p)` | 检查是否至少匹配一个元素，返回布尔类型 |
| `noneMatch(Predicate p)` | 检查是否没有匹配所有元素，返回布尔类型 |
| `findFirst()` | 返回第一个元素 |
| `findAny()` | 返回当前流中的任意元素 |
| `count()` | 返回流中元素总个数 |
| `max(Comparator c)` | 返回流中的最大值 |
| `min(Comparator c)` | 返回流中的最小值 |
| `forEach(Consumer c)` | 内部迭代 |

#### 2 - 规约

| 方法 | 描述 |
| ---- | ---- |
| `reduce(T iden, BinaryOperator b)` | 将流中元素反复结合起来，得到一个值，返回 `T`，`iden` 为初始值，`b` 为操作函数 |
| `reduce(BinaryOperator b)` | 将流中元素反复结合起来，得到一个值，返回 `Optional<T>` |
- `map` 和  `reduce` 的连接通常称为 `map-reduce` 模式，因 `Google` 用它来进行网络搜索而出名

#### 3 - 收集

| 方法 | 描述 |
| ---- | ---- |
| `collect(Collector c)` | 将流转换成其他形式，接收一个 `Collector` 接口的实现，用于给 `Stream` 中 元素做汇总的方法 |
`Collector` 接口中方法的实现决定了如何对流执行收集的操作（如收集 `List`、`Set`、`Map`），另外，`Collectors` 实用类提供了很多静态方法，可以方便地创建常见收集器实例。


# `Optional` 类

## 介绍

- 空指针异常是导致 Java 应用程序失败的 最常见原因，因此引入 `Optional` 类来解决空指针异常问题
- `Optional<T>` 类 `java.util.Optional` 是一个容器类，它可以保存类型 T 的值，代表这个值存在。或者仅仅保存 `null`，表示这个值不存在。原来用 `null` 表示一个值不存在，现在用 `Optional` 可以更好地表达这个概念，且可以避免空指针异常。
- `Optional` 类的 `Javadoc` 描述：可以为 `null` 的容器对象，如果值存在，则 `isPresent()` 方法会返回 `true`，调用 `get()` 方法会返回该对象。

## 常见方法

- 创建 `Optional` 类对象的方法
	- `Optional.of(T t)`：创建一个 `Optional` 实例，`t` 必须非空
	- `Optional.empty()`：创建一个空的 `Optional` 实例
	- `Optional.ofNullable(T t)`：`t` 可以为 `null`

- 判断 `Optional` 容器中是否包含对象
	- `boolean isPresent()`：判断是否包含对象
	- `void ifPresent(Consumer<? super T> consumer)`：如果有值，就执行 `Consumer` 接口的实现代码，并且该值会作为参数传给它

- 获取 `Optional` 容器的对象
	- `T get()`：如果调用对象包含值，返回该值，否则抛异常
	- `T orElse(T other)`：如果有值，则将其返回，否则返回指定的 `other` 对象
	- `T orElseGet(Supplier<? extends T> other)`：如果有值则将其返回，否则返回由 `Supplier` 接口实现提供的对象
	- `T orElseThrow(Supplier<? extends X> exceptionSupplier)`：如果有值，则将其返回，否则抛出由 `Supplier` 接口实现提供的异常。

