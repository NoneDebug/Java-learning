# 文件的基本使用

## 文件

- **定义**： 保存数据的地方
- 示例：word文档，txt文件，excel文件
- 用以保存视频，声音

## 文件流

- 文件在程序中是以流的形式来操作的
- 包含输入流和输出流（站在程序的视角上）
	- **流**：数据在数据源（文件）和 程序（内存）之间经历的路径
	- **输入流**：数据从数据源（文件） 到 程序（内存）的路径
	- **输出流**：数据从程序（内存）到数据源（文件）的路径

## 常用的文件操作

### 创建文件对象相关构造器和方法

- 相关方法

```
new File(String pathname);// 根据路径构建一个File对象
new File(File parent, String child);// 根据父目录文件 + 子路径构建
new File(String parent, String child);// 根据父目录 + 子路径构建
```

### 获取文件相关信息

- `getName`, `getAbsolutePath`, `getParent`, `length`, `exits`, `isFile`, `isDirectory`


### 目录操作和文件删除

- `mkdir` 创建一级目录，`mkdirs`创建多级目录，`delete`删除空目录或文件




# IO流原理及流的分类

## `IO` 流原理

- `I/O` 是 `Input/Output` 的缩写，`I/O` 技术是非常实用的技术，用于处理数据传输，如读/写文件，网络通讯等
- `Java` 程序中，对于数据的输入/输出操作以“流(stream)” 的方式进行。
- `java.io` 包下提供了各种 “流” 类 和 接口，用以获取不同种类的数据，并通过方法输入或输出数据。
- 输入`Input` ：读取外部数据（磁盘、光盘等存储设备的数据） 到程序（内存）中
- 输出 `Output` ：将程序（内存）数据输出到磁盘、光盘等存储设备中

## 流的分类

- 按照操作数据单位不同分：
	- 字节流（8 bit）二进制文件
	- 字符流（按字符）文本文件
- 按数据流的流向不同分为：
	- 输入流
	- 输出流
- 按流的角色不同分为：
	- 节点流
	- 处理流/包装流

| 抽象基类 | 字节流 | 字符流 |
| ---- | ---- | ---- |
| 输入流 | `InputStream` | `Reader` |
| 输出流 | `OutputStream` | `Writer` |
> 1) Java 的 IO流共涉及 40多个类，实际上非常规则，都是从如上4个抽象基类派生的
> 2) 由这4个类派生子类名称都是以其父类作为子类名后缀的 `xxxInputStream, xxxOutputStream`

# 节点流 和 处理流

## 基本介绍

- 节点流：从一个特定数据源 读写数据，如 `FileReader`、`FileWriter`
- 处理流（也叫包装流）：“连接”在已存在的流（节点流或处理流）之上，为程序提供更为强大的读写功能，如 `BufferedReader`、`BufferedWriter`


## 节点流 和 处理流的区别和联系

- 节点流 是 底层流/低级流，直接跟数据源相接
- 处理流包装节点流，既可以消除不同节点流之间的差异，也可以提供更方便的方法来完成输入输出
- 处理流（也叫包装流）对节点流进行包装，使用了修饰器设计模式，不会直接与数据相连

- 处理流的功能体现：
	- 性能提高：缓冲的方式来提高输入输出效率
	- 操作的便捷：提供了一系列便捷的方法来一次输入输出大批量的数据，使用更加灵活便捷

## `BufferedReader` 和  `BufferedWriter`

- 继承自 `Reader` 或  `Writer`
- 可以对节点流进行包装，是一种包装类

- `BufferedReader` 和 `BufferedWriter` 属于字符流，是按照字符来读取数据的
- 关闭时，只需要关闭外层流即可（会自动关闭内存被包装的节点流）

## 标准输入输出流

|  | 类型 | 默认设备 |
| ---- | ---- | ---- |
| `System.in` 标准输入 | `InputStream` | 键盘 |
| `System.out` 标准输出 | `PrintStream` | 显示器 |


# 输入流 和 输出流

## `InputStream` & `OutputStream` 

- `InputStream`：字节输入流
	- `InputStream`抽象类是所有类字节输入流的超类（抽象类）
	- 常用子类
		- `FileInputStream`：文件输入流
			- 单个字节的读取，不能读取中文字符，效率低
			- 可在参数中定义字节数组，以读取中文字符（按照字符数组大小进行读取）
		- `BufferedInputStream`：缓冲字节输入流（父类是`FilterInputStream`）
		- `ObjectInputStream`：对象字节输入流

- `OutputStream`：字节输出流

### `FileInputStream` 和 `FileOutputStream`

- 可以对二进制文件进行读写
### `BufferedInputStream` 和 `BufferedOutputStream`

- 是包装类（节点流），可以对其它 `OutputStream` 和 `InputStream` 进行包装，实现对应的包装。


## `Reader` & `Writer`

### `FileReader` 和 `FileWriter`

#### 介绍

- `FileReader` 和 `FileWriter` 是字符流，即按照字符来操作io

#### 相关方法

- `new FileReader(File/String)`
- `read`：单次读取单个字符，返回该字符，如果达到文件末尾返回-1
- `read(char[])`：批量读取多个字符到数组，返回读取到的字符数，如果到文件末尾返回-1

- `new FileWriter(File/String)`：覆盖模式，相当于流的指针在首端
- `new FileWriter(File/String, true)`：追加模式，相当于流的指针在尾端
- `write(int)`：写入单个字符
- `write(char[])`：写入指定数组
- `write(char[], off, len)`：写入整个字符串
- `write(string)`：写入整个字符串
- `write(String, off, len)`：写入字符串的指定部分

#### 相关API

- `new String(char[])`：将 `char[]` 转换成 `String`
- `new String(char[], off, len)`：将 `char[]` 的指定部分转换成 `String`

- `toCharArray`：将 `String` 转换成 `char[]` 

#### 注意事项

- `FileWriter` 使用后，必须要关闭(`close()`) 或 刷新(`flush()`)，否则写入不到指定的文件







# 对象流 

- 需求来源：保存一个数值时，不仅需要实现保存的功能，还需要实现对类型的保存
- 保存一个数据到文件，还需要保证能够从文件中恢复
- 需求解析：能够将 基本数据类型 或者 对象 进行序列化 和 反序列化操作

## `ObjectInputStream` 和 `ObjectOutputStream`

- 是一种包装类，修饰器模式

### 序列化 和 反序列化

- 序列化：保存数据时，同时保存 **数据的值** 和 **数据类型**
- 反序列化：恢复数据时，**恢复** 数据的 **值** 及其 **类型**
- 需要让某个对象支持序列化机制，则必须让其类是可序列化的，为了让某个类是可序列化的，必须实现如下二接口之一：
	- `Serializable`：标记接口
	- `Externalizable` //需要实现方法，一般实现 `Serializable` 即可

### 注意事项 和 细节说明

- 读写顺序要一致
- 要求实现序列化或反序列化对象，需要实现 `Serializable`
- 序列化的类中建议添加 `SerialVersionUID`（序列化的版本号），以提高版本的兼容性
- 序列化对象时，默认将里面所有的属性进行序列化，但除了 `static` 或 `transient` 修饰的成员
- 序列化对象时，要求里面的类型也需要实现序列化接口
- 序列化具备可继承性，也就是如果某类已经实现了序列化，则它的所有子类也已经默认实现了序列化






# 转换流

- 目标：字节流 -> 字符流，避免乱码的问题
- 乱码本质原因：没有指定读取文件的编码方式

## `InputStreamReader` 和  `OutputStreamWriter`

- `InputStreamReader`
	- `InputStreamReader(InputStream, Charset)`，传入一个 `InputStream` 类型数据，以及 `CharSet` 表示编码方式
		- 将 `InputStream` 字节流 包装成 `Reader`
- `OutputStreamWriter`
	- 将 `OutputStream` 字节流 包装成 `Writer`

- 处理纯文本数据时，使用字符流效率更高，且可以有效解决中文问题，建议将字节流转换为字符流
- 可以在使用时指定编码格式（比如 utf-8, gb2312, gbk, ISO8859-1 等）

### 基本语法

#### `InputStreamReader`

- 创建 `InputStreamReader` 对象
	- `BufferReader reader = new BufferedReader(new InputStream(new FileInputStream("src\\a.txt"), "utf-8"));`
- 读取
	- `Stream line = reader.readLine();`
	- `System.out.println(line);`
- 关闭
	- `reader.close();`

#### `OutputStreamReader`

- 创建 `OutputStreamReader` 对象
	- `OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("src\\a.txt"), "gbk");`
- 写入
	- `osw.write("hello,韩顺平教育~");`
- 关闭
	- `osw.close();`
	- `System.out.println("保存成功~");`

## 打印流 `PrintStream` 和 `PrintWriter`

- 前者字节流，后者字符流
- `setOut`：可对 `System.out` 输出位置将默认的显示器转到设置的位置


# `Properties` 类

## 基本介绍

- 专门用于读写配置文件的集合类
	- 配置文件格式（键值对）：
		- 键 = 值
		- 键 = 值
		- ...
	- 键值对不需要有空格，值不需要用引号引起来，默认类型是 `String`

## 常用方法

- `load`：加载配置文件的键值对 到 `Properties` 对象
- `list`：将数据显示到指定设备/流对象
- `getProperty(key)`：根据键值对获取值
- `setProperty(key, value)`：将键为 `key` 的对象值设置为 `value`
- `store`：将 `Properties` 中的键值对存储到配置文件中，在 `idea` 中，保存信息到配置文件，如果含有中文，会存储为 `unicoude` 码
