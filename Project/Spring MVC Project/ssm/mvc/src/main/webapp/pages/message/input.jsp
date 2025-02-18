<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="${request.contextPath}/pages/message/echo" method="post">
        请输入信息:
        <input type="text" name="message" value="I Love Wsq"><br>

        消息级别:
        <select id="level" name="level">
            <option value="0">紧急</option>
            <option value="1">普通</option>
            <option value="2">延迟</option>
        </select><br>

        发布日期：
        <input type="date" id="pubDate" name="pubDate" value="2025-02-18"><br>

        消息标签：
        <input type="checkbox" name="tags" id="tags" value="政治" checked>政治
        <input type="checkbox" name="tags" id="tags" value="经济" checked>经济
        <input type="checkbox" name="tags" id="tags" value="文化" checked>文化

        <button type="submit">发送</button>
        <button type="reset">重置</button>
    </form>
</body>
</html>
