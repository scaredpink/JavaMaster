<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="${request.contextPath}/pages/message/echo" method="post">
        请输入信息： <input type="text" name="message" value="I Love Wsq">
        <button type="submit">发送</button>
    </form>
</body>
</html>
