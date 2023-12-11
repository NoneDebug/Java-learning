# Java历史

## Java技术体系平台

- Java SE(Java Standard Edition)标准版
	- 支持面向桌面级应用（Windows下的应用程序）的Java平台，提供完整的Java API，此版本以前称为J2SE。

- Java EE(Java Enterprise Edition)企业版
	- 为开发企业环境下的应用程序提供的一套解决方案。包含的技术如：Servlet、JSP等，主要针对Web应用程序开发。以前称为J2EE。

- Java ME(Java Micro Edition)小型版
	- 支持Java程序运行在移动终端（手机、PAD）上的平台，对Java API有所精简，并加入了针对移动端的支持。以前称为J2ME。

## Java特点

- Java是面向对象的(OOP)
- Java语言是健壮的，Java的强类型机制、异常处理、垃圾的自动收集等是Java程序健壮性的重要保证
- Java语言是跨平台的
	- 一个编译好的.class文件可以在多个系统下运行。
- Java语言是解释性的
	- 解释性语言：JavaScript,PHP,Java；编译性语言:c/c++
	- 区别：解释性语言，编译后的代码，不能直接被机器执行，需要解释器执行；编译性语言，编译后的代码，可以直接被机器执行，c/c++。

## Java开发工具

- editplus、notepad++
- Sublime Text
- IDEA
- eclipse

先用Sublime Text，做大项目时再用IDEA

## Java运行机制及运行过程

- Test.java -> Test.class -> 不同平台的JVM解释器对其进行执行（因为有了JVM，同一个Java程序可以在三种不同的操作系统上执行，实现了Java的跨平台性）  
- Java核心机制-Java虚拟机【JVM java virtual machine】
	- JVM是虚拟的计算机，具有指令集并使用不同的存储区域。负责执行命令，管理数据、内存、寄存器，包含在**JDK**中
	- 对于不同的平台，有不同的虚拟机
	- Java虚拟机制屏蔽了底层运行平台的差别，实现了“一次编译，到处运行”

- Javac 将Test.java 编译为 Test.class，利用特定系统(Linux、Mac、Windows)的JVM对Test.class运行。

## 什么是JDK,JRE

- JDK基本介绍
	- JDK（JAVA Development Kit, Java开发工具包）JDK = JRE + JAVA的开发工具（java，javac，javadoc，javap等）
	- JDK是提供给Java开发人员使用的，其中包含了Java的开发工具，也包含了JRE，所以安装JDK，就不用单独安装JRE了。

- JRE基本介绍
	- JRE（Java Runtime Environment Java运行环境）JRE = JVM + Java核心类库
	- 包括Java虚拟机（JVM Java Virtual Machine）和Java程序所需的核心类库，如果想要运行一个开发好的Java程序，计算机中只需要安装JRE即可。   

## JAVA环境变量配置

Administer用户变量：该变量配置的JAVA只对本用户生效

系统变量：对所有用户生效
	public static void main(String[] args){
		System.out.println("hello,world~");
	}
}
```
