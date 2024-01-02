# 包装类(Wrapper)

## 包装类的分类

- 针对八种基本类型定义相关的**引用类型** -- 包装类
- 有了类的特点，就可以调用类中的方法

| 基本数据类型 | 包装类 |
| :--: | :--: |
| boolean | Boolean |
| char | Character |
| byte | Byte |
| short | Short |
| int | Integer |
| long | Long |
| float | Float |
| double | Double |
- 前二者不属于数值类型，后六者属于数值类型
	![[Pasted image 20231231115511.png]]

## 包装类和基本数据的转换

- `jdk5` 前的手动装箱 和 拆箱方式，装箱：基本类型 -> 包装类型，反之拆箱
- `jdk5` 后(含 `jdk5`)的自动装箱 和 拆箱方式
- 自动装箱底层调用的是 `valueOf` 方法，比如`Integer.valueOf()`

```
// 手动装箱 和 拆箱(jdk5以前)
	
	//手动装箱 int -> Integer
	int n1 = 100;  
	Integer integer = new Integer(n1);
	Integer integer1 = Integer.valueOf(n1);]
	
	//手动拆箱 Integer -> int
	int i = integer.intValue();

// 自动装箱 和 拆箱
	
	// 自动装箱
	int n2 = 200;  
	Integer integer2 = n2;  
	
	// 自动拆箱  
	int n3 = integer2;
```

- `jdk5` 以后，底层提供内置的分配内存以及提取数值

## 包装类型 和 `String` 类型相互转换

- `包装类型 => String类型`
	- 语法：
		- 方式1：`str = i + "";` //其中，i是某个包装类型
		- 方式2：`str = i.toString();` //其中，i是某个包装类型
			- 等价方式：`str = String.valueOf(i)`

- `String类型 => 包装类型`
	- 语法：
		- 方式1：`i = Integer.parseInt(str);` // 其中，i为`Integer`引用类型，`str`为字符类型，这里还使用了自动装箱技术。 
		- 方式2：`i = new Integer(str);` //其中，i为`Integer`引用类型，`str`为字符类型，这里使用的是`Integer`的构造器。

## `Integer` 和 `Character`类的常用方法

- `Integer`
	- `Integer.MIN_VALUE`：返回最小值
	- `Integer.MAX_VALUE`：返回最大值

- `Character`
	- `Character.isDigit('a');`：判断是不是数字
	- `Character.isLetter('a');`：判断是不是字母
	- `Character.isUpperCase('a');`：判断是不是大写
	- `Character.isLowerCase('a');`：判断是不是小写
	- `Character.isWhiteSpace('a');`：判断是不是空格
	- `Character.toUpperCase('a');`：转为大写
	- `Character.toLowerCase('a');`：转为小写

# `String`

## `String`类的理解 和 创建对象

- `String` 对象用于保存字符串，也就是一组字符序列
- 字符串常量对象是用双引号括起的字符序列
- 字符串的字符使用`Unicode`字符编码，一个字符占两个字节
- `String` 类较常用构造方法(构造器)：
	- `String s1 = new String();`
	- `String s2 = new String(String original);`
	- `String s3 = new String(char[] a);`
	- `String s4 = new String(char[] a, int startIndex, int count)`

- `String`的继承关系
	![[Pasted image 20231231152952.png]]
	- 实现了`Serializable` 接口，说明 `String` 类可以串行化（可在网络中传输）
	- 实现了`Comparable` 接口，说明 `String` 类可以比较大小
	- 实现了 `CharSequence` 接口

- `String` 是 `final` 类，不能被其他类继承
- `String` 有属性 `private final char value[]`，用于存放字符串内容
- `value` 是一个 `final` 类型，不可以修改（地址），对应的地址上的值可以修改，该变量不能指向其它值

## 创建`String`对象的两种方式

> 注意两种方式在内存中分布不同

- 方式一：直接赋值 `String s = "hsp"`
	- 先从常量值查看是否有 `"hsp"` 字符串，如果有，直接指向；如果没有重新创建，然后指向。`s` 最终指向的是常量池的空间地址 
- 方式二：调用构造器 `String s = new String("hspedu")`
	- 先在堆中创建空间，里面维护了 `value` 属性，指向常量池的 `hsp` 空间，如果常量池没有 `"hsp"`，重新创建，如果有，通过 `value`指向，最终指向的是堆中空间地址。

## 字符串的特性

- `String` 是一个 `final` 类，代表不可变的字符序列
- 字符串是不可变的，一个字符串对象一旦被分配，其内容是不可变的
- 当多个字符串相加后对某个字符串变量赋值时，编译器会先进行优化，将其合并为一个字符串常量，赋值给字符串变量（即只在常量池中创建一个对象）
- 两个常量相加，看的是 `常量池`，两个变量相加，看的是 `堆`


## `String` 常用方法

- `String` 类是保存字符串常量的。每次更新都需要重新开辟空间，效率较低，因此java设计者提供了`StringBuffer` 和 `StringBuilder` 来增强 `String` 的功能，并提高效率。

- `String` 类的常见方法
	- `equals`：区分大小写，判断内容是否相等
	- `equalsIgnoreCase`：忽略大小写，判断内容是否相等
	- `length`：获取字符的个数，字符串的长度
	- `indexOf`：获取字符在字符串中第1次出现的索引，索引从0开始，如果找不到，返回-1
	- `lastIndexOf`：获取字符在字符串中最后一次出现的索引，索引从0开始，如果找不到，返回-1
	- `substring`：截取指定范围的子串（若为1个参数，则截取此参数后所有的内容；若有2个参数，则截取该范围内所有的内容）
	- `trim`：去前后空格
	- `charAt`：获取某索引处的字符，不能使用`Str[index]`方式
	- `toUpperCase`：将字符串全部转换为大写
	- `toLowerCase`：将字符串全部转换为小写
	- `concat`：字符串的拼接
	- `replace`：替换字符串中的字符（将所有的字符子串转换为指定字符子串），返回的是替换过的`String`对象，对原字符串没有影响，除非赋值给原字符串。
	- `split`：分割字符串，对某些分割字符，需要转义，比如 `|,\\` 等等，返回一个数组
	- `compareTo`：比较两个字符串的大小，若长度相等，返回最开始不同的字符相减后的结果；若长度不等，返回二者长度之差；如果二者完全相同，则返回0.
	- `toCharArray`：转换成字符数组
	- `format`：格式化字符串，`%s` 字符串，`%c` 字符，`%d` 整型，`%.2f` 浮点型

# `StringBuffer`

## 基本介绍

- `java.lang.StringBuffer` 代表可变的字符序列，可以对字符串内容进行增删
- 很多方法与`String`相同，但是 `StringBuffer` 是可变长度的
- `StringBuffer` 是一个容器
- 直接父类为 `AbstractStringBuilder`
- `StringBuffer` 实现了 `Serializable`，即`StringBuffer`对象可以串行化
- 在父类中，`AbstractStringBulider` 有属性 `char[] value`，不是 `final`
	- 该 `value` 数组存放 字符串内容，引出存放在堆中的
- `StringBuffer` 是一个 `final` 类，不能被继承

## `String` vs. `StringBuffer`

- `String` 保存的是字符串常量，里面的值不能修改，每次`String`类的更新实际上就是更改地址，效率较低
- `StringBuffer` 保存的是字符串变量，里面的值可以更改，每次 `StringBuffer` 的更新实际上可以更新内容，不用每次更新地址，效率较高
	- `char[] value`：这个放在堆，和`String`类不同
- `StringBuffer` 是一个 `final` 类，不能被继承

## `StringBuffer` 构造器

- `StringBuffer()`：构造一个其中不带字符的字符串缓存区，其初始容量为16个字符
- `StringBuffer(CharSequence seq)`：构造一个字符串缓存区，包含与指定的`CharSequence` 相同的字符
- `StringBuffer(int capacity)`：构造一个不带字符，但有指定初始容量的字符串缓存区，即对 `char[]` 大小进行指定
- `StringBuffer(String str)`：构造一个字符串缓存区，将其内容初始化为指定字符串内容

## `String` 和  `StringBuffer` 的相互转换

### `String` -> `StringBuffer`

- 方式1 使用构造器
	```
	String str = "hello tom";
	StringBuffer stringBuffer = new StringBuffer(str);//不会对str有影响，只会提取值
	```

- 方式2 使用append方法
	```
	String stringBuffer1 = new StringBuffer();
	StringBuffer append = stringBuffer1.append(str);
	```

### `StringBuffer` -> `String`

- 方式1 使用 `StringBuffer` 提供的 `toString` 方法
	```
	StringBuffer stringBuffer3 = new StringBuffer("hello world");
	String str = StringBuffer3.toString();
	```
- 方式 使用 `new` 的方法（构造器）
	```
	String s1 = new String(stringBuffer3);
	```

## `StringBuffer` 常见类方法

- 增 `append`
- 删 `delete(start, end)`
- 改 `replace(start, end, string)` //将 start --- end 间的内容替换掉，不含end
- 查 `indexOf` //查找子串在字符串第1次出现的索引，如果找不到返回-1
- 插 `insert`
- 获取长度 `length`


# `StringBuilder`

## 基本介绍

- 一个可变的字符序列，提供一个与 `StringBuffer` 兼容的 API，但不保证同步（不是线程安全）。该类被设计用作 `StringBuffer` 的一个简易替换，用在字符串缓存区被单个线程使用的时候。如果可能，建议优先采用该类，在大多数实现中，它比 `StringBuffer` 要快。
- `StringBuilder` 上的主要操作是 `append` 和 `insert` 方法，可重载这些方法，以接受任意类型的数据。
- `StringBuilder` 是 `final` 类，不能被继承
- `StringBuilder` 对象字符序列仍然是存放在其父类 `AbstractStringBuilder` 的 `char[] value`，因此，字符序列是堆中。
- `StringBuilder` 的方法，没有做互斥的处理，即没有 `synchronized` 关键字，因此在单线程的情况下使用


## `String`、`StringBuffer` 和 `StringBuilder` 的比较

- `StringBuilder` 和 `StringBuffer` 非常类似，据代表可变的字符序列，而且方法也一样
- `String`：不可变字符序列，效率低，但复用率高
- `StringBuffer`：可变字符序列、效率较高（增删）、线程安全
- `StringBuilder`：可变字符序列、效率最高、线程不安全
- `String` 使用注意说明：
	- `string s = "a"` 创建了一个字符串
	- `s += "b"` 原来的 "a" 已经被丢弃，又产生一个字符串 "ab"，如果多次执行这些改变串内容的操作，会导致大量副本字符串对象留在内存中，降低效率。如果这样的操作放到循环中，会极大影响程序的性能，如果对 `String` 做大量修改，不要使用`String`。
- 效率： `StringBuilder > StringBuffer > String`
- 使用原则
	- 如果字符串存在大量修改操作，使用 `StringBuffer` 或 `StringBuilder`（单线程情况使用后者，否则使用前者）
	- 如果字符串很少修改，被多个对象引用，使用 `String`，比如配置信息等

# `Math`

## 基本介绍

- 包含用于执行基本数学运算的方法，比如初等指数、对数、平方根和三角函数
- 相关方法（均为静态方法）
	- `abs`：求绝对值
	- `sqrt`：求平方根
	- `pow`：求幂
	- `ceil`：向上取整
	- `floor`：向下取整
	- `round`：四舍五入
	- `random`：随机整数，返回的是 \[0,1)的随机小数

# `Arrays`

## `Arrays` 常见方法
- `Arrays` 里面包含了一系列静态方法，用于管理或操作数组（排序 和 搜索）

### `toString` 返回数组的字符串形式
- 语法：`Arrays.toString(arr)`

### `sort`排序（自然排序和定制排序）

- 数组是引用类型，通过`sort`排序后，会直接影响到 实参 `arr`
- `sort`是重载的，也可以传入一个接口，通过 `Comparator` 实现定制排序

#### 自然排序

- 语法：`Arrays.sort(arr)`
#### 定制排序

- 语法：`Arrays.sort(arr, new Comparator c)`
- 通过重载 `sort` 方法，以及重写匿名内部类 `c`，实现接口编程

### `binarySearch` 二分搜索进行查找

- 要求必须排好序
- 语法：`int index = Arrays.binarySearch(arr, 3);`
- 如果不存在某个数，则返回`-(low + 1), low表示该数在数组中应该存在的位置`，否则返回该数在数组中下标

### `copyOf` 数组元素复制

- 语法：`Integer[] newArr = Arrays.copyOf(arr, arr.length)`
- 语句解释：将 `arr` 中所有元素复制到 `newArr` 中

### `fill`数组元素的填充

- 语法：
	```
	Integer[] num = new Integer[]{9, 3, 2}
	Arrays.fill(num, 99); // num变为 {99, 99, 99}
	```
- 语句解释：将数组 `num` 中所有元素替换为 指定元素

### `equals` 比较两个数组元素内容是否完全一致

- 语法：`boolean equals = Arrays.equals(arr, arr2);`
- 语句解释：比较 `arr` 和  `arr2` 是否完全一致

### `asList` 将一组值，转换成 `list`

- 语法：`List<Integer> asList = Arrays.asList(2, 3, 4, 5, 6, 1);`
- 语句解释：如题



# `System`

## `System`类常见方法 和 案例

- `exit`：退出当前程序
- `arraycopy`：复制数组元素，比较适合底层调用，一般使用 `Arrays.copyOf` 完成复制数组
	```
	int[] src = {1, 2, 3};
	int[] dest = new int[3];
	System.arraycopy(src, 0, dest, 0, 3);
	```
- `currentTimeMillens`：返回当前时间距离 `1970-1-1` 的毫秒数
- `gc`：运行垃圾回收机制 `System.gc()`


# `BingInteger BigDecimal` 

## 应用场景

- `BigInteger` 适合保存比较大的整型
- `BigDecimal` 适合保存精度更高的浮点型（小数）

## `BigInteger`

- 在对 `BigInteger` 进行 加减乘除时，需要使用对应方法，不能直接进行 + - * /
- 创建实例时，在括号内是以字符串的形式创建。

### 相关计算方法

- `xxx.add(yyy)`：`xxx,yyy`一个具体 `BigInteger`实例，`substract、multiply、divide`同·1

### `BigDecimal`

- 相关方法和 `BigInteger` 比较类似，需注意的是，`divide` 方法可能会出现无限循环小数，此时没有精度限制，此时会抛出异常。
	- 解决方案：添加参数 `BigDecimal.ROUND_CEILING`，结果会保留分子的精度，即可避免出现无限循环小数的问题。

# `Date、Calender、LocalDate`

## `Date` 类

### 该类为第一代日期类

- `Date`：精确到毫秒，代表特定的瞬间
- `SimpleDateFormat`：格式和解析日期的类
	- 格式化 和 解析日期的具体类，允许进行格式化（日期 -> 文本）、解析（文本 -> 日期）和规范化。

## `Calender` 类

### 该类为第二代日期类

- `public abstract class Calendar extends Object implement Serializable, Cloneable, Comparable<Calendar>`
- 是一个抽象类，为特定瞬间与一组如 `YEAR`、`MONTH`、`DAY_OF_MONTH`、`HOUR`等日历字段之间的转换提供了一些方法，并为操作日历字段（例如获得下星期日期）提供了方法
- `Calendar`类没有格式化方法，需要自己组合

## `LocalDate` 类

## 该类为第三代日期类

- 前面两代日期类的不足分析
	- `JDK 1.0` 中包含了一个 `java.util.Date` 类，但它的大多数方法已经在 `JDK.1.1` 引入 `Calendar` 类之后弃用了。而 `Calendar` 也存在的问题是：
		- 可变性：像日期 和 时间这样的类应该也是不可变的
		- 偏移性：`Date`中的年份都是从 1900 开始的，月份都是从0开始
		- 格式化：格式化只对 `Date` 有用，`Calendar` 则不行
		- 此外，它们不是线程安全的；不能处理闰秒（每隔2天，多出1s）

### 第三代日期类常用方法

- `LocalDate（日期）`、`LocalTime（时间）`、`LocalDateTime（日期时间）`

- `LocalDate` 只包含日期，可以获取日期字段
- `LocalTime` 只包含时间，可以获取时间字段
- `LocalDateTime` 包含日期 + 时间，可以获取日期 和 时间字段


### `DateTimeFormatter` 格式日期类

- 类似于 `SimpleDateFormat`
- 语法

	```
	DateTimeFormatter dtf = DateTimeFormatter.ofPattern(格式);
	String str = dtf.format(日期对象);
	```

### `Instant` 时间戳

- 类似于 `Date`
- 提供了一系列和 `Date` 类转换的方式
- 语法：`Instant now = Instant.now();`
- `Instant ---> Date`：
	- `Date date = Date.from(instant);`
- `Date ---> Instant`：
	- `Instant instant = date.toInstant();`

### 其它方法

- `MonthDay`类：检查重复事件
- 是否是闰年
- 增加日期的某个部分
- 使用 `plus` 方法测试增加时间的某个部分
- 使用 `minus` 方法测试查看一年前 和 一年后的日期
