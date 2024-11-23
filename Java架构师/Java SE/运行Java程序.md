# 运行Java程序

​	首先打开记事本，写一个HelloWorld

```java
public class HelloWorld {
	public static void main(String[] args) {
		System.out.println("Hello World!");
	}
}
```

​	存储为`HelloWorld.java`



​	现在我们有了一个Java程序，需要经过以下步骤运行：

- 用编译器将其编译为`.class`文件
- 用JVM运行`.class`文件

# 1.编译

命令：`javac HelloWorld.java`



# 2.运行

命令：`java Hello`

这里不需要写.class，虚拟机会自己找类名，不是找文件

![image-20241123142240785](C:\Users\76497\AppData\Roaming\Typora\typora-user-images\image-20241123142240785.png)