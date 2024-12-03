# MVC高级开发

​	直接将MVC搭在Servlet和JSP上还是不太好：

- Servlet提供的接口仍然偏底层，需要实现Servlet调用相关接口；
- JSP对页面开发不友好，更好的替代品是模版引擎；
- 业务逻辑最好由纯粹的Java类实现，而不是强迫继承自Servlet。



​	最好的方法是通过普通的Java类实现MVC的Controller，类似

```java
public class UserController {
    @GetMapping("/signin")
    public ModelAndView signin() {
        ...
    }

    @PostMapping("/signin")
    public ModelAndView doSignin(SignInBean bean) {
        ...
    }

    @GetMapping("/signout")
    public ModelAndView signout(HttpSession session) {
        ...
    }
}
```

​	Java类中的每个方法都对应一个GET或POST请求，方法返回值是ModelAndView，它包含一个View的路径以及一个Model，这样再由MVC框架处理后返回给浏览器。



​	如果是GET请求，我们希望MVC框架能直接把URL参数按方法参数对应起来然后传入

```java
@GetMapping("/hello")
public ModelAndView hello(String name) {
    ...
}
```

​	如果是POST请求，我们希望MVC框架能直接把Post参数变成一个JavaBean后通过方法参数传入：

```java
@PostMapping("/signin")
public ModelAndView doSignin(SignInBean bean) {
    ...
}
```

​	为了增加灵活性，如果Controller的方法在处理请求时需要访问`HttpServletRequest`、`HttpServletResponse`、`HttpSession`这些实例时，只要方法参数有定义，就可以自动传入：

```java
@GetMapping("/signout")
public ModelAndView signout(HttpSession session) {
    ...
}
```

以上就是我们在设计MVC框架时，上层代码所需要的一切信息。





## 设计MVC框架

### 1.ModelAndView类

​	ModelAndView对象顾名思义包含一个View和一个Model，实际上View就是模版的路径，Model可以用Map<String, Object>表示，因此其定义为：

```java
public class ModelAndView {
    Map<String, Object> model;
    String view;
}
```





​	比较复杂的事，我们需要在MVC框架中创建一个接收所有请求的Servlet，通常把它命名为DispatcherServlet，总是映射到/，然后根据不同Controller方法定义的@Get或@Post的Path决定调用哪个方法，最后获得方法返回的ModelAndView后，渲染模版，写入HttpServletResponse，即完成了整个MVC的处理。

```
   HTTP Request    ┌─────────────────┐
──────────────────▶│DispatcherServlet│
                   └─────────────────┘
                            │
               ┌────────────┼────────────┐
               ▼            ▼            ▼
         ┌───────────┐┌───────────┐┌───────────┐
         │Controller1││Controller2││Controller3│
         └───────────┘└───────────┘└───────────┘
               │            │            │
               └────────────┼────────────┘
                            ▼
   HTTP Response ┌────────────────────┐
◀────────────────│render(ModelAndView)│
                 └────────────────────┘
```

​	其中，DispatcherServlet以及如何渲染由MVC框架实现，MVC框架之上只需要编写一个Controller





## DispatcherServlet

​	我们需要存储请求路径到某个具体方法的映射

```java
@WebServlet(urlPatterns = "/")
public class DispatcherServlet extends HttpServlet {
    private Map<String, GetDispatcher> getMappings = new HashMap<>();
    private Map<String, PostDispatcher> postMappings = new HashMap<>();
}
```

​	处理GET请求通过GetDispatcher对象完成，需要如下信息

```java
class GetDispatcher {
    Object instance; // Controller实例
    Method method; // Controller方法
    String[] parameterNames; // 方法参数名称
    Class<?>[] parameterClasses; // 方法参数类型
}
```

​	得到了这些信息就可以定义invoke()来处理真正的请求









