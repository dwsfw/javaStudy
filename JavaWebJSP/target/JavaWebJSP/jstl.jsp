<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 2020/8/17
  Time: 9:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    if测试<br>

<form action="jstl.jsp" method="get">

    <input type="text" name="username" value="${param.username}">
    <input type="submit" value="提交">
</form>
<c:if test="${param.username=='admin'}" var="isAdmin">
    <c:out value="管理员，欢迎你"/>
</c:if>
<c:out value="${isAdmin}"/>
</body>
</html>
