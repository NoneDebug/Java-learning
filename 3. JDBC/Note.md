# Chap 1 前言


## 1.1 USB

  - USB: Unversal Serial Bus（通用串行总线）的缩写，一个外部总线标标准，用于规范电脑与外部设备的连接和通讯
  - USB 是 电脑 和 外部设备 的连接枢纽
	  - 电脑USB接口：电脑端根据USB规范设计出的具体外接接口
	  - USB串口规范：一套设计标准方案，不是具体的接口
	  - 外设USB接口：外设根据USB规范设计出连接电脑接口，并且具体编写发送通信信号的驱动程序
	  - 等价：
		  - 电脑设计了 **接口** 
		  - USB串口规范是一个多态的 **概念**
		  - 外设USB接口是一个 **实现类**
 
## 1.2 JDBC技术介绍

- JDBC: Java Database Connectivity，Java连接数据库技术
	- Java代码中，使用JDBC提供的方法，可以发送字符串类型的SQL语句导数据库管理软件(MySQL, Oracle等)，并且获取语句执行结果，实现数据库数据的 CURD 操作的技术
	- DBMS --> 数据库数据（对数据库数据进行CRUD）
		- `sqlyog`：通过撰写 `sql` 语句 操作 `DBMS` 软件，从而对数据库数据进行CURD
		- `navicat`：同上
		- `java`：通过连接 `jdbc` 后 撰写 `sql` 语句，进一步操纵数据库，从而对数据库数据进行 CURD操作
	- JDBC是由各种数据库软件（`MySQL, Oracle`）共同提供的一个通用规范，即Java程序可以通过 JDBC 调用 数据库软件中的方法。
	- 对于JDBC规范和接口：java语言只提供规范（接口），规定数据库操作方法，标准的类库在 `java.sql, javax.sql` 包下；
	- 对于`JDBC`， 它是 java 连接 数据库技术的统称
	- 对于 第三方数据库厂商(`MySQL, Oracle`等)，它们根据 `java` 的 `jdbc` 规范（接口），完成具体的实现驱动代码(`jar`)，实现代码可以不同，结果都相同。
		> 就是大家都知道你这个接口要干啥，每个厂家分别根据你的需求，撰写对应的数据库语句以实现对数据库的修改。  		

- JDBC的组成
	- `Java` 提供的 `jdbc` 规范（接口）
	- 各个数据库厂商的实现驱动 `jar` 包
	- `JDBC` 技术是一种典型的面向接口编程
	- 优势：
		- 只需学习 `jdbc` 接口规定方法，即可操作所有数据库软件
		- 中期若需要切换数据库，只需要更新第三方驱动 `jar` 包，不需要更改代码

## 1.3 jdbc 本质理解

- Java程序
	- JBDC规范（JDBC一组接口）
		- 第三方实现 jar 包
			- MySQL实现
			- Oracle 实现
			- DB2实现
			- 三者共同操纵数据库

- 代码：
	- 步骤1：`java.sql.*`， `JDBC接口 对象 = 第三方实现类实例;`
	- 步骤2：`对象.jdbc标准方法();`



# Chap 2 全新 JDBC 技术概述

## 2.1 jdbc 技术概念和理解

- jdbc 技术组成
	- jdk下jdbc规范接口，存储在 java.sql 和 javax.sql 包中的 api
		- 为了项目代码的可移植性，可维护性，SUN公司从最初就制定了 Java程序来凝结各种数据库的统一 接口规范，不管连接哪一种 DBMS 软件，Java程序可以保持一致性。
	- 各个数据库厂商提供的驱动 `jar` 包
		- 各个数据库厂商DBMS软件不同，内部如何通过 `sql` 进行 CURD等管理数据，只有厂商自己清楚，因此把接口规范的实现交给各个数据库厂商自己实现。
	- `jar` 包
		- `Java` 程序打成的一种压缩包形式，可以将这些 `jar` 包引入项目中，可以使用这个 `java` 程序中类和方法以及属性。
## 2.2 jdbc核心 api 和 使用路线

- jdbc 技术组成：见上
- 涉及具体核心类和接口
	- `DriverManager`
		- 将第三方数据库厂商的实现驱动 `jar` 注册到程序中
		- 可以根据数据集连接信息获取 `connection`
	- `Connection`
		- 和数据库建立的连接，在连接对象上，可以多次执行数据 `crud` 操作
		- 可以获取 `statement` 和 `preaparedstatement, callablestatement` 对象
	- `Statement| PreparedStatement| CallableStatement`
		- 具体发送 `SQL` 语句到数据库管理软件的对象
		- 不同发送方式稍有不同，`preparedstatement`使用是重点
	- `Result`
		- 面向对象思维的产物（抽象成数据库的查询结果表）
		- 存储`DQL`查询数据库结果的对象
		- 需要进行解析，获取具体的数据库数据

- jdbc api 使用路线
	- 静态SQL路线（没有动态值语句）
		- `DriverManager`
		- `Connection`
		- `Statement`
		- `Result`
	- 预编译SQL路线（有动态值语句）
		- `DriverManager`
		- `Connection`
		- `PreparedStatement`
		- `Result`
	- 执行标准存储过SQL路线
		- `DriverManager`
		- `Connection`
		- `CallableStatement`
		- `Result`

## 2.3 为什么选择全新 8+ 版本 `mysql-jdbc` 驱动

- 支持 8.0+ 版本 mysql 数据管理软件
- 支持 java jdbc 规范 4.2+ 版本新特性
- 支持 jdk 1.8 版本语法变更新特性
- 支持全新的驱动 api，增加自动选择 和 默认 `utf-8` 编码格式设置

# Chap 3 全新 JDBC 核心 API

## 3.1 引入 `mysql-jdbc` 驱动 `jar`

- 驱动 `jar` 版本选择
	- 选择 `8.0.27` 版本
	- mysql 8.x 的推荐驱动版本为 `8.0x`
	- 建议使用：`8.0.25+`省略时区设置，`com.mysql.cj.jdbc.Driver`


## 3.2 jdbc 基本使用步骤分析

- 注册驱动
	- 对依赖的 `jar` 包，进行安装
- 获取连接
	- `connection`
- 创建发送 `sql` 语句对象
	- `statement`的定义
- 发送 `sql` 语句，并获取返回结果
	- `statement` 对象发送 `SQL` 语句到数据库，并且获取返回结果
- 结果集解析
	- 对 `resultset` 结果对象进行解析
- 资源关闭
	- 销毁资源

## 3.3 基于 `statement` 演示查阅

- (1) 注册驱动
	- `DriverManager.registerDriver(new Driver())`
	- 依赖：驱动版本 8+ `Driver`导入 `com.mysql.cj.jdbc.Driver`
		- 驱动版本 5+ `Driver` 导入 `com.mysql.jdbc.Driver`
- (2) 获取连接
	- Java 和 数据库创建连接
	- Navicat等数据库可视化工具，都需要通过构建和数据库的连接才能进行进一步的数据库CRUD
	- 调用方法，该方法需要填入连接数据库的基本信息
		- 数据库ip地址 ：localhost
		- 数据库端口号：3306
		- 账号：root
		- 密码：123456
		- 连接数据库的名称：atguigu
	- 方法：
		- `Connection connection = DriverManager.getConnection(url, user, password) // 接口 = 实现类`
		- `url` 格式：`jdbc:数据库厂商名://ip地址:port/数据库名
			- `jdbc:mysql://localhost:3306/atguigu`
- (3) 创建 `statement`
	- `Statement statement = connection.createStatement()`
- (4) 编写 以及 发送 `sql` 语句
	- 编写 `sql` 语句：`String sql = "select xxx from xxx";`
	- 发送 `sql` 语句： `Result resultSet = statement.executeQuery(sql);`
- (5) 遍历 结果集 `resultset`
	- `while(resultSet.next())`
	- `getInt('字段名k')`、`getString('字段名j')`
	- 输出
- (6) 关闭连接
	- `resultSet.close()`
	- `statement.close()`
	- `connection.close()`

## 3.4 基于 `statement` 方式问题

- **step 1** 注册驱动: 原先注册 `Driver()` 驱动的问题
	- 查看源码，看到 `new Driver()` ，其静态代码块也会注册一次驱动，因此重复冗余，需要省略（以下语句只触发一次驱动）
		- 方案1：`DriverManager.registerDriver(new Driver(), null)`
		- 方案2：使用反射，这种方案更加灵活
			- 语法：`Class.forname("com.mysql.cj.jdbc.Driver") //里面的字符串可以来自外部配置文件，今天我想使用mysql，明天我想使用Oracle，只需要修改外部配置文件即可`

- 复习java类加载和静态代码块的触发
	- 触发静态代码块
		- 类加载时（加载 -> 连接 -> 初始化），会触发静态代码块
	
	- 触发类加载：
		- `new 关键字`
		- 调用静态方法
		- 调用静态属性
		- 接口 1.8 `default` 默认实现
		- 反射
		- 程序的入口

- **step 2** 获取数据库连接
	- 核心是 `DriverManager` 的 `getConnection(url, user, password)` 方法，允许开发者用不同的方式接入数据库
	- 核心属性 `url`
		- 数据库软件 所在主机的 ip 地址：`localhost | 127.0.0.1`
		- 数据库软件 所在主机的端口号： `3306`
		- 连接的具体库：`atguigu`
	- 核心属性 连接的账号 `user`
	- 核心属性 密码 `password`
	- 可选的属性：无
	- `getConnection(String url)` 的三种重写
		- `getConnection(String url, String user, String password)`
			- `url`：数据库软件所在的信息，连接的数据库，以及其他可选的信息
				- 格式：`jdbc:数据库管理软件名[mysql, oracle]://ip地址 | 主机名:port 端口号/数据库名?key=value&key=value`
					- `?` 后面是可选的键值对，表示一些可选的配置信息
				-  tips：如果数据库安装到本机，可以进行一些省略 
				     具体：`jdbc:mysql:///atguigu` 省略了 本机地址 和 3306端口，默认是连接本机数据库 和 3306 端口（如果数据库初始端口设置不是3306，则需要对应显式写出端口号）
			- `user`：数据库账号 `root`
			- `password`：12346
		- `getConnection(String url, Properties info)`
			- `url`: 和三参数的 `url` 作用相同，包括 数据库 `ip`，端口号，具体的数据库和可选信息
			- `info`：存储账号和密码，类似 `Map`，但是 key:value 都是字符串形式
				- 应该至少包含 `user` 和 `password` 的 `value`
		- `getConnection(String url)`
			- `url`：数据库ip，端口号，具体数据库，可选信息（账号密码）
				- `jdbc:数据库软件名://ip:port/数据库名?key=value&key=value&key=value`
			- tips：8.0.27 版本驱动，下面都是一些可选属性
				- 8.0.25 以后，自动识别时区 `serverTimezone=Asia/Shanghai` 不用添加，在这之前，需要添加
				- 8版本以后，默认使用utf-8格式，`userUnicode=true&characterEncoding=utf8&serverTimezone=Asia/Shanghai` 都可以省略了。
- step 3 创建发送 `SQL` 的 `statement` 对象
	- `Statement statement = connection.createStatement();`
- step 4 编写 并 发送 `SQL` 语句
	- `String sql = xxx`
	- 两种方式发送 `SQL` 语句
		- (1) `int id = statement.executeUpdate(sql);`
			- 如果是 `INSERT, DELETE, UPDATE` 这种 `DML` 语句，返回的是所影响的语句数量
			- 如果不是 `DML` 语句，则返回0。
		- (2) `ResultSet resultset = statement.executeQuery(sql);`
			- 如果是 `SELECT` 这种 `DQL` 语句，返回的是 `ResultSet` 这种结果封装对象
- step 5 解析 `resultSet`
	- 游标移动问题
		- `resultSet` 内部包含一个游标，指定当前行数据
		- 默认游标指定的是第一行数据
		- 调用 `next()` 向后移动一行游标
		- 多行数据，可以使用 `while(next){获取每一行数据}`
		- 移动游标的方法有很多，只需要记忆 `next` 即可，配合 `while` 循环获取数据
	- 获取列数据问题
		- 获取光标指定行的数据
		- `resultSet.get类型(String columnlabel | int columnIndex)`
			- 根据列标签，获取对应值
			- 根据 列数 获取对应值（1对应第一行，2对应第二行）

- `statement` 存在的问题
	- `SQL` 语句需要进行 字符串拼接，比较麻烦
	- 只能拼接字符类型，其他数据库类型无法处理
	- 可能发生注入攻击
		- 动态值充当 `SQL` 语句结构，影响了原有的查询结果

## 3.5 基于 `preparedStatement` 方式优化

- 语法：
	- `String sql = "xxx where xx = ? and xxx = ?";`
	- `PreparedStatement prepareStatement = connection.preparedStatement(sql);`
	- `preparedStatement.setObject(1, xxx);` //将第一个占位符的值设置为 `xxx`

- 将原先的 `connection.createStatement(sql)` 替换为上面即可，使用这种方式，让 SQL 语句可以认知到什么是 动态语句 什么是静态语句，可有效避免注入攻击。


## 3.6 基于 `preparedStatement` 演示 `crud`

- 一些新知识
	- 查询时，想要获得 `resultSet` 时，不手动指定列名（因为随着后续需求的改变，对应的列名会发生改变），自动获得对应的列名 和 值
		- `int ResultSetMetaData metaData = resultSet.getMetaData();  `
		- `int columnCount = metaData.getColumnCount();`
		- 在遍历 `ResultSet` 时，
			```
			for (int i = 1; i <= columnCount; i++) {  
			    String key = metaData.getColumnLabel(i);  
			    Object value = resultSet.getObject(i);  
			    // map.put(key, value);  
			}
			```

## 3.7 `preparedStatement` 使用方式总结

- 注册驱动
- 获得连接
- 编写 `SQL` 语句
- 创建 `preparedStatement` 语句
- 占位符赋值（可选）
- 发送 `SQL` 语句，获得结果
- 结果集解析（可选）
- 关闭资源

# Chap 4 全新 JDBC 扩展提升

## 4.1 自增长主键回显实现

- `java` 程序获取插入数据时，mysql 维护自增长维护的主键 id值，这就是主键回显
- 作用：在多表关联插入数据时，一般主表的主键都是自动生成的，所以在插入数据之前无法直到这条数据的主键，但是从表需要在插入数据之前就绑定主表的主键，可使用主键回显技术。

- 具体实现
	- 在声明 `preparedStatement` 时，告知，携带回数据库自增长的主键
		- `connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)`
	-  获取主键值结果
		```
			ResultSet resultSet = preparedStatement.getGeneratedKeys();  
			resultSet.next();  
			int id = resultSet.getInt(1);
		```

## 4.2 批量数据插入性能提升

- `DriverManager.getConnection(url)`中 路径 `url` 最后面加入
	- `rewriteBatchedStatements=true`
- `insert into values[必须写]`，不能添加分号结束
- 不是执行语句每条，而是批量添加 `addBatch();`
- 最后统一批量执行 `statement.executeBatch();`
- 相比普通循环执行插入效率大大提升
- 本质：单个执行语句会增加大量的运行时间

## 4.3 `jdbc` 中数据库事务实现

- 事务的概念
	- `SQL` 语句可执行的缓存机制，不会单条执行完毕就更新数据库数据，最终根据缓存内的多条语句执行结果统一判定。
	- 一个事务的所有语句都成功即事务成功，可以出发 `commit` 提交事务来结束事务，更新数据
	- 一个事务的一条语句失败，即事务失败，可以出发 `rollback` 回滚结束事务，事务回到之前状态

- 场景
	- 一个业务涉及多条修改数据库语句

- 事务特性（ACID）
	- 原子性 (**Atomicity**) 指事务不可再分，要么都发生，要么都不发生
	- 一致性 (**Consistency**) 指事务必须使数据库从一个一致性状态转到另一个一致性状态
	- 隔离性 (**Isolation**) 指一个事务的执行不能被其他事务干扰，即一个事务内部不被干扰
	- 持久性 (**Duration**) 指一个事务一旦提交，他对数据库的改变就是永久性的

- 自动提交：每条语句可自动存储在一个事务中，执行成功自动提交，执行失败自动回滚（`MySQL`）
- 手动提交：手动开启事务，添加语句，手动开启事务，添加语句，手动提交或者手动回滚即可。

- `SQL` 开启事务方式
	- 针对自动提交：关闭自动提交即可，最终手动提交或者回滚（推荐）
		- `SET autocommit = off;` 对当前连接的所有 `SQL` 语句生效，到 `commit` 或 `Rollback` 结束，这是 `SQL` 语句中的代码形式，在 `Java` 中的代码形式为：
			- `connection.setAutoCommit(false)` 即可在当前连接中关闭自动提交
	- 针对手动提交：需要开启事务的代码，添加 `SQL` 语句，事务提交或者事务回滚（不推荐）

- 
# Chap 5 国货之光 Druid 连接池技术

- 连接性能消耗问题分析
	- `connection` 可以复用，但是消耗了性能

- 数据库连接池作用
	- 使用步骤：创建(耗时T1)、使用(耗时T2)、销毁(耗时T3)
		- `T1 + T3 << T2` 合理，反之不合理
	- 具体原理：
		- 提前创建连接，断开后，在其他进程中回收连接
		- 事务只需要和数据库连接池建立 连接 和 断开 连接，这是就极大节约了时间，几乎只有 `T2` 的时间
	- 连接池可以容纳一定量的连接对象，一开始先对用户创建连接对象，用户可以直接使用，不用新建，用完，其他人可以继续用
	- 提高连接的使用率，当池中的连接都用完了，连接池可以向服务器申请新的连接池放到池中
	- 直到池中连接达到”最大连接数“，就不能再申请新的连接了，如果没有拿到连接用户只能等待。

- 市面常见连接池产品和对比
	- `javax.sql.DataSource` 接口规范了连接池获取连接的方法，规范了连接池回收连接的方法
	- `DataSource` 规范了 连接池回收连接的方法
	- 具体产品有：`DBCP`、`C3P0`、`Proxool`、`Druid`


- 国货之光 `druid` 连接池使用
	- 导入 `druid` 工具类 `jar`
	- 硬编码方式，在代码中写入账号密码
		- `druid` 声明
		- 声明连接池对象：`DruidDataSource dataSource = new DruidDataSource()`
		- 必须参数
			- `dataSource.setUrl("jdbc:mysql:///xxx");`
			- `dataSource.setUsername("root");`
			- `dataSource.setPassword("123456");`
			- `dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");`
		- 非必须参数
			- `dataSource.setInitialSize(5);` //初始化连接数量
			- `dataSource.setMaxActive(10)`// 最大数量
		- 获得连接
			- `Connection connection = dataSource.getConnection();`
		- 数据库 `crud`
		- 关闭连接
			- `connection.close();`
	- 软编码方式，在 `src/druid.properties` 中以键值对形式写入账号密码（推荐）
		- 新建配置文件：`Properties properties = new Properties();`
		- src下的文件，使用类加载器提供的方法：
			- `InputStream ips = DruidUserPart.class.getClassLoader().getSourceAsStream("druid.properties");`
			- `properties.load(ips);`
		- 创建 连接池工具类的工程模式，创建连接池
			- `DataSource dataSource = DataSourceFactory.createDataSource(properties);`
		- 后续操作同上，继续建立连接、数据库curd，以及关闭连接




# Chap 6 全新 JDBC 使用优化以及工具类封装

## 6.1 工具类v1

- 将与 `Druid` 连接池连接的代码进行了封装
## 6.2 工具类v2

- 对 v1 进行了优化，考虑事务情况下，一个线程不同方法获取的连接应该是相同的
- 使用 `ThreadLocal` 解决
	- `java.lang.ThreadLocal`，为解决多线程的并发问题提供一种新的思路。使用本工具类可以很简洁地写出优美的多线程程序。通常用来在多线程中管理共享数据库连接、`Session`等
	- `ThreadLocal` 用于保存某个线程的共享变量，原因是 `Java` 中，每一个线程对象都有一个 `ThreadLocalMap<ThreadLocal, Object>`，其 `key` 就是一个 `ThreadLocal`，而 `Object` 即为该线程的共享变量，这个 `Map` 通过 `ThreadLocal` 的 `set` 和 `get` 方法操作。对于同一个 `static ThreadLocal`，不同线程只能从 `get`、`set`、`remove`自己的变量，而不会影响其它线程的变量
		- `get`：获取 `ThreadLocal` 中当前线程共享变量的值
		- `set`：设置 `ThreadLocal` 中当前线程共享变量的值
		- `remove`：移除 `ThreadLocal` 中当前线程共享变量的值



# Chap 7 基于 CMS 项目 JDBC 实战练习

- 跟着课程看代码即可
