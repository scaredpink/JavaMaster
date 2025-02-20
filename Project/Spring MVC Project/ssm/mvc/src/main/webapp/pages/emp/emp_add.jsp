<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="${request.contextPath}/pages/emp/add" method="post">
        雇员编号：<input type="text" name="empNo" value="123"><br>
        雇员姓名：<input type="text" name="empName" value="白涛"><br>
        雇佣日期：<input type="date" name="empDate" value="2033-09-18"><br>
        部门编号：<input type="text" name="dept.deptNo" value="10"><br>
        部门名称：<input type="text" name="dept.dName" value="教学部"><br>
        部门位置：<input type="text" name="dept.loc" value="洛阳"><br>
        <button type="submit">提交</button>
        <button type="reset">重置</button>
    </form>
</body>
</html>
