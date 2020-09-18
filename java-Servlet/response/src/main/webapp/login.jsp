<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 2020/8/13
  Time: 14:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>登录</h1>
    <div>
        <form action="${pageContext.request.contextPath}/login" method="post">
            用户名:<input type="text" name="username"><br>
            密码:<input type="password" name="password"><br>
            爱好:
            <input type="checkbox" name="hobby" value="女孩">女孩
            <input type="checkbox" name="hobby" value="代码">代码
            <input type="checkbox" name="hobby" value="电影">电影
            <input type="checkbox" name="hobby" value="唱歌">唱歌
            <br>
            <input type="submit" value="提交">
        </form>
    </div>
</body>
</html>
