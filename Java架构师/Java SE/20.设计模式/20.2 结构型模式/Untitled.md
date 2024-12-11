## 1.模仿Thread类的代理设计模式

​	假设当前有一个抽象类`Person`，它有一个抽象方法`eat()`

```java
abstract class Person {
 
    private String name;

    public abstract void eat();
  	
  	//省略构造方法和getter、setter方法
}
```

​	现在，我们想创建具体的类，比如学生、老师等等，都可以继承此类并实现eat()方法

```java
class Student extends Person {
    @Override
    public void eat() {
        System.out.println("去食堂");
        System.out.println("【关键操作】学生吃饭");
        System.out.println("回教室");
    }
}

class Teacher extends Person {
    @Override
    public void eat() {
        System.out.println("去食堂");
        System.out.println("【关键操作】老师吃饭");
        System.out.println("回教室");
    }
}
```



​	可以看到，学生和老师有一些不重要的共通步骤需要在代码里重复写，这就一点也不优美了。实际上我们只有吃饭的关键步骤是需要老师和学生自己实现的，那么聪明的你肯定想到了，不如我们在Person类里把共通步骤完成：

```java
abstract class Person {
    private String name;

    public abstract void eat();
  
  	public void before() {
      	System.out.println("去食堂");
    }
  
  	public void after() {
      	System.out.println("回教室");
    }
}

class Student extends Person {
    @Override
    public void eat() {
        System.out.println("【关键操作】学生吃饭");
    }
}

class Teacher extends Person {
    @Override
    public void eat() {
        System.out.println("【关键操作】老师吃饭");
    }
}
```



​	现在，出现了新的问题，虽然从实现具体类的角度已经简单了，但是从代码的角度来看，我们对Person实现了什么功能更容易混淆了。不妨这样，我们把eat()这个方法当作接口抽出来：

```java
interface Eatable {
    public abstract void eat();
}

abstract class Person implements Eatable {
    private String name;

  	public void before() {
      	System.out.println("去食堂");
    }
  
  	public void after() {
      	System.out.println("回教室");
    }
}
```



​	其实到目前为止，这个代理模式已经很完善了，但是精益求精的你发现，Eatable是一个典型的函数式接口，那是不是应该提供可以直接用函数式接口接收`eat()`方法的能力

```java
interface Eatable {
    public abstract void eat();
}

class Person implements Eatable {
    private String name;

    private Eatable eatable;
    
    public Person(){}
    
    public Person(Eatable eatable) {
        this.eatable = eatable;
    }

    @Override
    public void eat() {
        this.eatable.eat();
    }

    public void before() {
        System.out.println("去食堂");
    }

    public void after() {
        System.out.println("回教室");
    }
}
```



​	恭喜你，你已经实现了一个完备的代理设计模式。接下来，你成为了自己的用户，你要怎么样使用你的类呢？

```java	
public class Proxy {
    public static void main(String[] args) {
        Person student = new Student("bt");
        student.before();
        student.eat();
        student.after();
        System.out.println("-----------------------------");
        Person person = new Person(() -> {
            System.out.println("【关键操作】人吃吃吃");
        });
        person.before();
        person.eat();
        person.after();
    }
}
```

```
去食堂
【关键操作】学生吃饭
回教室
-----------------------------
去食堂
【关键操作】人吃吃吃
回教室
```

​	作为用户的你可以只专心写好“吃”这个方法，饭前和餐后的准备都已经提前写好了，只需要调用就可以





