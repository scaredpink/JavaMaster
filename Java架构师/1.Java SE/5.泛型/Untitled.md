7. 泛型

​        泛型，是从JDK1.5加入到Java语言里的，其主要目的是解决ClassCastException的问题，在进行对象的**向下转型**时，永远都会有安全隐患，Java希望靠泛型解决这个问题。

​        假设，定义一个描述x与y坐标的处理类，并且在这个类之中允许开发者保存有三类数据：

- 整型数据：x = 10、y = 20；
- 浮点型数据：x = 10.2、y = 20.9；
- 字符串型数据：x = 东经120度、北纬30度。

​        于是在设计Point类是需要去考虑具体的x和y属性的类型，这个类型要求可以保存以上三种数据，很明显最为原始的做法就是用Object类来进行定义，因为有如下转型关系：

- 整型数据：基本数据类型 ➡️ 包装为Integer类对象 ➡️ 自动向上转型为Object类
- 浮点数据：基本数据类型 ➡️ 包装为Float类对象 ➡️ 自动向上转型为Object类

- 字符串型数据：String类对象 ➡️ 自动向上转型为Object类对象

```
class Point {
    private Object x;
    private Object y;

    public void setX(Object x) {
        this.x = x;
    }
    public void setY(Object y) {
        this.y = y;
    }
    public Object getX() {
        return this.x;
    }
    public Object getY() {
        return this.y;
    }
}

public class Main {
    public static void main(String[] args) {
        Point point = new Point();
        //第一步：根据需求进行内容的设置
        point.setX(10);//自动装箱
        point.setY(20);//自动装箱

        //第二步：从里面获取数据
        int x = (Integer) point.getX();//向下转型
        int y = (Integer) point.getY();//向下转型
        System.out.println("X坐标：" + x + "、Y坐标：" + y);
    }
}
```

​        这个设计可以解决目标问题，因为Object可以接收所有数据类型。但是也正因此，本代码也会出现严重的安全隐患。

​        输入两个不同类型的数据，就会出现ClassCastException。在装箱时，向上转型没什么问题。但是当拆箱时，如果不事先知道数据类型，就会在向下转型时出错。可以说，真正的原因是Object范围太广了，什么数据都可以接收，这并不是我们希望的，这也催生了泛型。

​        这种情况下编译是不会报错的，只有运行时才会报错。（强制类型转换不会在编译时产生错误）





# 8.4.1 泛型基本定义

​         避免ClassCastException的最好方法就是回避对象的强制类型转换，所以在JDK1.5之后提供有泛型技术，泛型的本质自于类中的属性或方法的参数与返回值的类型可以由对象实例化的时候动态决定。

​         那么此时就需要在类定义的时候明确地定义占位符（泛型标记）

```
class Point <T> {	//T是定义的泛型
    private T x;
    private T y;

    public void setX(T x) {
        this.x = x;
    }
    public void setY(T y) {
        this.y = y;
    }
    public T getX() {
        return this.x;
    }
    public T getY() {
        return this.y;
    }
}
```

​        此时Point类中的x与y属性的数据类型并不确定，而是有外部来决定。

提示：关于默认的泛型类型

由于泛型是属于JDK1.5之后的产物，到那时不少内置的程序类应用到开发之中，为了保证追加泛型之后，原始的程序类依然可以使用，所以如果不设置泛型类型，自动将使用Object为泛型，以保证程序的正常执行，但是编译时会有警告。

​        泛型定义完成后可以在实例化对象的时候进行泛型类型的设置，一旦设置之后，里面的x与y的属性类型就与当前对象绑定了

```
public class Main {
    public static void main(String[] args) {
        Point<Integer> point = new Point<Integer>();
        //第一步：根据需求进行内容的设置
        point.setX(10);//自动装箱
        point.setY(20);//自动装箱

        //第二步：从里面获取数据
        int x = point.getX();//向下转型
        int y = point.getY();//向下转型
        System.out.println("X坐标：" + x + "、Y坐标：" + y);
    }
}
```

​        现在的程序代码之中，由于Point类里面设置的泛型类型为Integer，这样所有的对应此泛型的属性、变量、返回值都转换为了Integer。既然如此，我们获取数据时就不必在向下转型了（Object➡️Integer）。同时，当出现了与泛型不一致的数据类型时，也会在编译时就知晓，而不会讲错误带到运行中。

​        避免了向下转型，可以避免安全隐患

 

泛型的使用注意点： 

- 泛型之中只允许设置引用类型，如果现在要操作基本类型必须使用包装类；
- 从JDK1.7开始，泛型对象实例化可以简化为  Point(Integer) point = new Point<>()，后面尖括号省略了中间的内容

​         使用泛型可以解决大部分的类对象的强制转换处理，这样的程序才是一个合理的设计。

 

# 8.4.2 泛型通配符

​        虽然泛型帮助开发者解决了一系列的对象的强制转换所带来的安全隐患，但是从另外一个角度来讲，泛型也带来了一些新的问题：引用传递处理。

```
class Message <T> {
    private T content;
    public void setContent(T content) {
        this.content = content;
    }

    public T getContent() {
        return this.content;
    }
}

public class Main {
    public static void main(String[] args) {
        Message<String> msg = new Message<>();
        msg.setContent("www.mldn.cn");
        fun(msg);//引用传递
    }
    public static void fun(Message<String> msg) {
        System.out.println(msg.getContent());
    }
}
```

​        问题出在fun()方法上，如果真的用泛型，不应该只能接收一种引用类型。泛型提前订好了限制，但是却影响了引用传递。而且，泛型为参数的方法没法重载，系统认为Message<Integer>和Message<Double>是一样的

```
  class Message <T> {
    private T content;
    public void setContent(T content) {
        this.content = content;
    }

    public T getContent() {
        return this.content;
    }
}

public class Main {
    public static void main(String[] args) {
        Message<String> msg = new Message<>();
        msg.setContent("www.mldn.cn");
        fun(msg);
    }
    public static void fun(Message msg) {//不设置泛型
        msg.setContent(1.5)
        System.out.println(msg.getContent());
    }
}
```

​        如果不设置泛型，那么在方法之中就有可能对你的数据进行修改。一旦不设置泛型，方法就会以为类中的泛型是Object，自然Object可以接受所有类型数据，也就很容易修改其中的内容（哪怕和原本不是一个类型）



​        所以此时我们需要一种方案：可以接收所有的泛型类型，并且不能修改里面数据（允许获取），那么就需要通过通配符"?"来解决。

```
    public class Main {
        public static void main(String[] args) {
            Message<String> msg = new Message<>();
            msg.setContent("www.mldn.cn");
            fun(msg);
        }
        public static void fun(Message<?> msg) {//不设置泛型
            System.out.println(msg.getContent());
        }
    }
```

​        通配符处理逻辑是，我不知道处理的数据是什么类型，自然我也不能去修改对象的数据（哪怕是和原本对应的类型都不行）。反过来，获取数据却并没有受到限制，因此这就是只能获取不能修改。

​        此时在fun()方法里面由于采用了Message结合通配符的处理所以可以接收所有的类型。



​        在"?"的基础上还有两类小的通配符：

- ?extends类：设置泛型的上限：
  - 例如：定义“? extends Number”：表示该泛型类型只允许设置Number或Number的子类
- ?super类：设置泛型的下限：
  - 例如：定义“? super String”：表示只能够使用String或其父类。

​        通配符是一个重要的概念，一定要理解此类概念的定义，在学习Java系统类库的时候会出现大量的通配符





# 8.4.3 泛型接口

​        泛型除了可以在类上定义之外，也可以直接在接口之中进行使用，例如，下面定义一个泛型接口：

```
interface IMessage<T> {
    public String echo(T t);
}
```

 是

​       对于泛型接口的子类而言，现在就有两种实现方式。

- 实现方式一：**在子类中继续设置泛型定义**。

```
interface IMessage<T> {
    public String echo(T t);
}

class MessageImpl<S> implements IMessage<S> {
    public String echo(S t) {
        return "【echo】" + t;
    }
}

public class Main {
    public static void main(String[] args){
        IMessage<String> msg = new MessageImpl<String>();
        System.out.println(msg.echo("www.mldn.cn"));
    }
}
```

- 实现方式二：**在子类实现父接口的时候直接定义出具体泛型类型**。

```
interface IMessage<T> {
    public String echo(T t);
}

class MessageImpl implements IMessage<String> {
    public String echo(String t) {
        return "【echo】" + t;
    }
}

public class Main {
    public static void main(String[] args){
        IMessage<String> msg = new MessageImpl();
        System.out.println(msg.echo("www.mldn.cn"));
    }
}
```

​        泛型接口并不复杂，但是一定要清楚，日后会大量出现。





# 8.4.4 泛型方法

​        泛型方法不一定非要出现在泛型类之中。在非泛型类中使用泛型方法的格式如下：

```
public class Main {
    public static void main(String[] args){
        Integer num[] = fun(1, 2, 3);
        for (int temp: num) {
            System.out.print(temp + "、");
        }
    }

    public static <T> T[] fun(T ... args) {
        return args;
    }
}
```

​        这个东西在以后也很常见，例如在工厂设计中。传统模式下，工厂设计模式会对每个接口都写一个工厂，那么接口很多的情况下，那代码里充斥的只有工厂了。

![image.jpeg](https://km.sankuai.com/api/file/cdn/2364434528/111853128945?contentType=1&isNewContent=false)

​        即便只写一个工厂，这个工厂中也会充斥大量的getXxxInstance()方法。

​        利用泛型我们可以改进我们的工厂。

```
interface IMessage {
    public void send(String str);
}

interface IChannel {
    public void connect();
}

class MessageImpl implements IMessage {
    public void send(String str) {
        System.out.println("消息发送：" + str);
    }
}

class ChannelImpl implements IChannel {
    public void connect() {
        System.out.println("连接成功");
    }
}

class Factory {
    public static <T> T getInstance(String interfaceName, String className) {
        if ("IMessage".equalsIgnoreCase(interfaceName)) {
            if ("MessageImpl".equalsIgnoreCase(className)) {
                return (T) new MessageImpl();
            }
            else
                return null;
        } else if ("IChannel".equalsIgnoreCase(interfaceName)) {
                if ("ChannelImpl".equalsIgnoreCase(className)) {
                    return (T) new ChannelImpl();
                }
                else
                    return null;
        }
        return null;
    }
}

public class Main {
    public static void main(String[] args){
        IMessage msg = Factory.getInstance("IMessage", "MessageImpl");
        IChannel ch = Factory.getInstance("IChannel", "ChannelImpl");
        msg.send("你好");
        ch.connect();
    }
}
```

​        这样子，我们的工厂就不在局限于只能生产某一个接口对应的子类