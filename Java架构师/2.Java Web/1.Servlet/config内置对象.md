# 4.8 config内置对象

​        通过web.xml文件实现的程序映射访问，除了可以获得更加安全的保护之外，也可以实现初始化参数的配置，在JSP中所有的初始化参数需要通过config内置对象（对应类型为“**javax.servlet.ServletConfig**”接口）实现接收。

​        Config内置对象没有与协议绑定。

提示：和application内置对象配置初始化属性的区别：        application内置对象的初始化属性在web.xml中配置，是在容器启动前就配置好的。        config内置对象的初始化属性是程序内可以随时配置的。

| **No.** | **方法**                                                | **类型** | **描述**                   |
| ------- | ------------------------------------------------------- | -------- | -------------------------- |
| 1       | public String **getServletName**()                      | 方法     | 获取Servlet程序名称        |
| 2       | public ServletContext **getServletContext**()           | 方法     | 获取ServletContext接口实例 |
| 3       | public String  **getInitParameter**(String name)        | 方法     | 获取指定名称的初始化参数   |
| 4       | public Enumeration<String>  **getInitParameterNames**() | 方法     | 获取所有初始化参数的名称   |





#  配置初始化参数

​        首先在web.xml文件中配置初始化参数。在<servlet>标签中配置<init-param>

```
<servlet>
        <servlet-name>HelloJSP</servlet-name>
        <jsp-file>/WEB-INF/hello.jsp</jsp-file>
        <init-param>
            <param-name>dataBase</param-name>
            <param-value>mysql</param-value>
        </init-param>
        <init-param>
            <param-name>dataBaseHost</param-name>
            <param-value>www.mysql.com</param-value>
        </init-param>
    </servlet>
```



​        接下来获取初始化参数，过程类似于用application，也是通过遍历Enumration

```
<%@ page import="java.util.Enumeration" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    Enumeration<String> initParameterNames = config.getInitParameterNames();
    while (initParameterNames.hasMoreElements()) {
        String param = initParameterNames.nextElement();
        String value = config.getInitParameter(param);
%>
        <h1><%=param%> = <%=value%></h1>
<%
    }
%>
</body>
</html>
```



```
dataBase = mysql
fork = false
classdebuginfo = true
xpoweredBy = false
dataBaseHost = www.mysql.com
jspFile = /WEB-INF/hello.jsp
```

​        除了自定义的初始化参数，也会包含一些其他系统内置的参数处理，重点是关注这些初始化参数的获取以及配置操作。