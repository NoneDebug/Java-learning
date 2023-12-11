## JAVA快速入门

- 需求：开发一个Hello.java程序，可输出"Hello,world!"

- 开发步骤：
	- 将Java代码编写到扩展名Hello.java
	- 通过javac命令对该java文件进行编译，生成.class文件
	- 通过java命令对生成的class文件进行运行
```
//这是java的快速入门，演示java的开发步骤
//对代码的相关说明
//1. public class Hello 表示Hello是一个类，是一个public公有的类
//2. Hello{ } 表示一个类的开始和结束
//3. public static void main(String[] args)表示一个主方法，即程序的入口
//4. main() {}表示方法的开始和结束
//5. System.out.println("hello world~")：表示输出"hello,world~"到屏幕
//6. 表示语句的结束
public class Hello{

	//编写一个main方法
	public static void main(String[] args){
		System.out.println("hello,world~");
	}
}
```

## JAVA执行流程分析

.java文件（源文件） -->(编译)    .class文件（字节码文件）  -->(运行.exe)     结果

- 编译：通过编译器将Java源文件编译成JVM可识别的字节码文件；并在该源文件目录下，通过javac编译工具对Hello.java文件进行编译；如果程序未出错，没有提示，且目录会出现一个Hello.class文件，该文件称为字节码文件，即可执行的java的程序。

## JAVA开发注意事项

- Java源文件以.java为扩展名，源文件的基本组成部分是类(class)，如Hello类；
- Java应用程序的执行接口是main()方法，有固定的书写格式：
	```
	public static void main(String[] args){...}
	```
- Java语言严格区分大小写
- Java方法由一条条语句构成，每个语句以";"结束
- 大括号成对出现，缺一不可
- **一个源文件最多只能有一个public类，其它类的个数不限** （编译后，每一个类都对应一个.class）
- **如果源文件包含一个public类，则文件名必须按照该类命名！**
- **一个源文件最多只能有一个public类，其它类的个数不限，也可以将main方法写在非public类中，然后指定运行非public类，这样入口方法就是非public的main方法。**

## 转义字符

- \\t ：制表位
- \\n：换行符
- \\\\：一个\
- \\"：一个"
- \\'：一个\
- \\r：一个回车
	```
	//		\r: 一个回车
		System.out.println("韩顺平教育\r北京");
	//输出结果为：背景平教育
	```
> ps：一个System.out.println()结束后会自动换行。

## 初学Java易犯错误

- 找不到文件
	- 解决方案：源文件名不存在或者写错，或者当前路径错误
- 主类名和文件名不一致
	- 解决方案：声明为public的主类应该与文件名一致，否则编译失败
- 缺少分号
	- 解决方案：编译失败，注意错误出现的行数，再到源代码中指定位置改错

- 常见错误总结
	违反语法规则，例如忘记了分号、大括号、引号，或者拼错了单词。


## 注释

### 语句注释

- 单行注释：```//注释文字```
- 多行注释：```/* 注释文字 */```

- 注释细节：注释部分不会被JVM解释执行；
- 注释风格：尽可能简单易懂

### 文档注释

- 文档注释：可以被JDK提供的工具javadoc所解析，生成一套以网页文件形式体现的该程序的说明文档，一般写在类
- xxx.java文档注释基本格式：
```
/**
	* @author xxx
	* @version 1.0
**/
public class XXX{
	public static void main(String[] args){
		...
	}
}
```
- Prompt格式：
```
	javadoc -d 文件夹名 -xx -yy xxx.java
```

javadoc工具软件识别标签：

| 标签 | 描述 | 示例 |
| --- | --- | --- |
| @author | 标识一个类的作者 | @author description |
| @deprecated | 指名一个过期的类或成员 | @deprecated description |
| {@docRoot} | 指明当前文档根目录的路径 | Directory Path |
| @exception | 标志一个类抛出的异常 | @exception exception-name explanation |
| {@inheritDoc} | 从直接父类继承的注释 | Inherits a comment from the immediate surperclass. |
| {@link} | 插入一个到另一个主题的链接 | {@link name text} |
| {@linkplain} | 插入一个到另一个主题的链接，但是该链接显示纯文本字体 | Inserts an in-line link to another topic. |
| @param | 说明一个方法的参数 | @param parameter-name explanation |
| @return | 说明返回值类型 | @return explanation |
| @see | 指定一个到另一个主题的链接 | @see anchor |
| @serial | 说明一个序列化属性 | @serial description |
| @serialData | 说明通过writeObject( ) 和 writeExternal( )方法写的数据 | @serialData description |
| @serialField | 说明一个ObjectStreamField组件 | @serialField name type description |
| @since | 标记当引入一个特定的变化时 | @since release |
| @throws | 和 @exception标签一样. | The @throws tag has the same meaning as the @exception tag. |
| {@value} | 显示常量的值，该常量必须是static属性。 | Displays the value of a constant, which must be a static field. |
| @version | 指定类的版本 | @version info |


## Java代码规范

- 类、方法的注释，要以javadoc的方式来写
- 非Java Doc的注释，往往是给代码的维护者看的，着重告诉读者为什么这样写，如何修改，注意什么问题等
- 使用tab操作，实现缩进，默认整体向右易懂，用shift + tab整体向左移动；
- 运算符和 = 两边习惯性各加一个空格。
- 源文件使用utf-8编码
- 行宽度不要超过80字符
- 代码编写次行风格和行尾风格（区别在于{ }要不要换行）

## DOS原理（了解）

- DOS基本原理：指令 -> DOS系统 -> 运行
	- DOS系统基本步骤：(1) 接受指令 (2) 解析指令 (3) 执行指令

-  **路径**
	- 相对路径：从当前目录开始定位形成的路径
	- 绝对路径：从顶级目录d，开始定位，形成的路径

- 常见DOS命令
	- dir xx:\\xx\\xx：查看路径下目录
	- cd xx:\\xx\\xx：切换到当前盘的其它目录下
		- cd /D c: 切换到C盘
		- cd .. ：切换到上一级
		- cd \\ ：切换到根目录
	- tree：查看指定目录所有子集目录
	- cls：清屏
	- exit：退出DOS
	- 其它少见DOS命令：
		- md xx\\\\xx：创建目录xx\\\\xx
		- rd xx\\\\xx：删除目录xx\\\\xx
		- copy：拷贝文件
		- del：删除文件
		- echo：输入内容到文件
		- move：剪切
