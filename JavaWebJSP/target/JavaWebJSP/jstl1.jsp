<%@ page import="java.util.ArrayList" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 2020/8/17
  Time: 9:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<c:set var="scope" value="85"/>
<c:choose>
    <c:when test="${scope>=90}">
        优秀
    </c:when>
    <c:when test="${scope>=80}">
        良好
    </c:when>
    <c:when test="${scope>=70}">
        一般
    </c:when>
    <c:when test="${scope>=60}">
        及格
    </c:when>
    <c:when test="${scope<60}">
        不及格
    </c:when>
</c:choose>
</body>
</html>
