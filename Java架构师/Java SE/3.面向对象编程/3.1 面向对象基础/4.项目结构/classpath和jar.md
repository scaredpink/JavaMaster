# classpath

​	classpath是JVM用到的一个环境变量，它用来指示JVM如何搜索class。因为Java是编译型语言，我们需要将.java文件编译成.class文件，JVM才能去执行.class文件。

​	JVM需要知道一个类去哪里搜索对应的.class文件，而classpath就是提供这个。

---

## 1.classpath格式

​	classpath一般是多个文件目录，用`;`分隔开。

```plain
C:\work\project1\bin;C:\shared;"D:\My Documents\project1\bin"
```

​	classpath会依次在这些目录查找目标的class文件。如果JVM在前面的目录找到了class，那么就不会继续往后搜索。

​	如果所有路径都找不到，那么会报错。



## 2.设置classpath

​	使用IDEA的情况下，classpath会默认设置为工程的某些目录下，以及包含你引入的jar包