# 枚举介绍

- enumeration(枚举) -- 简写为 `enum`

- 枚举的实现方式
	- 自定义实现枚举
	- 使用 `enum` 关键字实现枚举

## 使用 `enum` 关键字实现枚举

# 自定义类实现枚举

- 不需要提供 `setXxx` 方法，因为枚举对象值通常为只读
- 对枚举对象/属性 使用 `final + static` 共同修饰，实现底层优化
- 枚举对象名通常使用全部大写，常量的命名规范
- 枚举对象根据需要，可以有多个属性

具体实例如下：

```
package com.tybxx.enum_;  
  
/**  
 * @author 唐钰渤  
 * @version 1.0  
 */public class Enumeration02 {  
    public static void main(String[] args) {  
        System.out.println(Season.AUTUMN);  
    }  
}  
class Season {  
    private String name;  
    private String desc;  
    public final static Season SPRING = new Season("春天", "温暖");  
    public final static Season AUTUMN = new Season("秋天", "凉爽");  
    public final static Season WINTER = new Season("冬天", "寒冷");  
    public final static Season SUMMER = new Season("夏天", "炎热");  
    @Override  
    public String toString() {  
        return "Season{" +  
                "name='" + name + '\'' +  
                ", desc='" + desc + '\'' +  
                '}';  
    }  
    public String getName() {  
        return name;  
    }  
    public String getDesc() {  
        return desc;  
    }  
    // 防止new  
    private Season(String name, String desc) {  
        this.name = name;  
        this.desc = desc;  
    }  
}
```


# `enum` 关键字实现枚举

- 使用关键字 `enum` 代替 `class`
- `public final static Season SPRING = new Season("春天", "温暖");` 直接用 `SPRING("春天", "温暖");` 替换 以表示常量（二者等价）
- 多个常量对象，使用 `,` 号间隔即可
- 使用 `enum` 实现枚举，需要把常量写在最前面

## `enum` 关键字实现枚举的注意事项

- 使用 `enum` 关键字实现一个枚举类时，默认会继承 `Enum` 类
- 传统的 `public static final Season2 SPRINT = new Season2("春天", "温暖")` 简化为 `SPRING("春天","温暖")`，必须知道使用的是什么构造器
- 如果使用无参构造器 创建 枚举对象，则实参列表 和 小括号都可以省略
- 当有多个枚举对象时，使用 `,` 间隔，最后有一个分号结尾
- 枚举对象必须放在枚举类行首

## `enum` 常用方法说明

- 使用关键字 `enum`时，会隐式继承 `Enum` 类，这样就可以使用 `Enum` 类相关的方法
- 相关方法：
	- `name()` ：返回枚举对象名
	- `ordinal()` ：返回枚举对象次序(编号，从0开始编号)
	- `values()`：将所有对象返回
	- `valueOf()` ：将字符串转换为枚举对象，要求字符串必须为己有的常量名，否则报异常
	- `compareTo()` ：比较两个枚举常量，比较的是位置号（用前面的位置减去后面的位置）


- 增强 `for` 循环
```
for(Seson2 season: values){

}//从values中取值，赋给season变量，直至遍历到values结尾
```

## `enum` 实现接口

- `enum xxx extends xxx`：错误，因为 `enum` 类隐式继承 `Enum` 类，不允许继承多个类
- `enum xxx interface xxx:` 正确，因为 `interface` 类是对 `Java` 单继承机制的补充
- **语法：** `enum 类名 implements 接口1, 接口2{}`

# `JDK` 内置的基本注解类型

## 注解的理解

- 注解(Annotation)也被称为元数据(Metadata)，用以修饰解释 包、类、方法、属性、构造器、局部变量等数据信息
- 和注释一样，注解不影响程序运行逻辑，但注解可以被编译或运行，相当于嵌入在代码中的补充信息
- `JavaSE`中，注解的使用目的比较简单，例如标记过时的功能，忽略警告等。`JavaEE`中，它占据了更重要的角色，例如用来配置应用程序的任何切面，代替 `Java EE`旧版总所遗留的冗余代码 和 `XML`配置等。

## 基本的 `Annotation` 介绍

- 使用 `Annotation` 时要在其前面增加 `@` 符号，并把该 `Annotation` 当作修饰符使用，用来修饰它支持的程序元素
- 三个基本的 `Annotation`：
	- `@Override`：限定某个方法，是重写父类方法，该注解只能用于方法
	- `@Deprecated`：用于表示某个程序元素（类，方法等）已过时
	- `@SuppressWarnings` ：抑制编译器警告
	查看源码时，会看到定义：`public @interface xxx`，表示这是一个 **注解类**

### `@Override`

- 写没写不会影响方法的重写，如果写了 `@override` ，编译器就会去检查该方法是否真的重写了父类的方法，若没有重写，则编译错误
#### 使用说明

- `@Override` 表示指定重写父类的方法（从编译层面验证），如果父类没有 `@override` 下所写的方法，则会报错
- 如果不写 `@override`注解，如果父类有对应方法，仍然构成重写
- `@override` 只能修饰方法，不能修饰其它类，包，属性等等
- 查看 `@override` 注解源码为： `@Target(ElemnetType.method)`，说明只能修饰方法
- `@Target` 是修饰注解的注解，称为元注解

### `@Deprecated`

- 用于表示某个程序元素（类、方法等）已过时
- 可以修饰方法，类，字段，包，参数 等等
- `@Target(value = {CONSTRUCTOR, FIELD, LOCAL_VARIABLE, METHOD, PACKAGE, PARAMETER, TYPE})`
- `@Deprecated` 的作用可以做到新旧版本的兼容 和 过渡

### `@SuppressWarning`

- 抑制编译器警告
- `@SuppressWarnings({"all"})` 表示抑制所有警告类型
- 作用范围：和写的位置相关
	- 放在 `main` 上，作用范围为 `main` 方法
	- 放在 某个语句上，作用范围则为该语句
- 可以放在 语句、类、方法上
- `{"xxx"}`的各种取值：
	- `unchecked`：忽略没有检查的警告
	- `rawtypes`：忽略没有指定泛型的警告（传参时没有指定泛型的警告错误）
	- `unused`：忽略没有使用某个变量的警告错误
	- `@SuppressWarning` 可以修饰的元素为
	- 生成`@SuppressWarning` 时，不用背，直接点击左侧的黄色提示，就可以选择





# `JDK` 的元 `Annotation`

## 基本介绍

- 用以修饰其它 `Annotation`
- 元注解：作用不大，只需知道其作用即可

## 元注解类型

- `Retetion` ：指定注解的作用范围
	- 只能修饰一个 `Annotation`的定义，用以指定该`Annotation` 可以保留多长时间，`@Retention` 包含一个 `RetetionPolicy` 类型的成员变量，使用 `@Retention` 时必须为该 `value` 成员变量指定值
	- `Retention` 的三种值：
		- `RetentionPolicy.SOURCE`：编译器使用后，直接丢弃这种策略的注释
		- `RetentionPolicy.CLASS`：编译器将把注释记录在 `class` 文件中，当运行 Java程序时，JVM不会保留注解，这是默认值
		- `RetentionPolicy.RUNTIME`：编译器将把注释记录在 `class` 文件中，当运行 Java程序时，JVM 会保留注解，程序可以通过反射获得该注解。

- `Target` ：指定注解可以在哪些地方使用
	- 用以修饰 `Annotation` 定义，指定修饰符的 `Annotation` 能用于修饰哪些程序元素。`@Target` 也包含一个名为 value 的成员变量


- `Documented`：指定该注解是否会在 `javadoc` 体现
	- 用以指定被元 `Annotation` 修饰的 `Annotation` 类将被 `javadoc` 工具提取成文档，即生成文档时，可以看到该注释


- `Inherited` ：子类会继承父类注解
	- 被它修饰的 `Annotation` 将具有继承性，如果某个类使用了被 `@Inherited` 修饰的 `Annotation`，则其子类将自动具有该注解
