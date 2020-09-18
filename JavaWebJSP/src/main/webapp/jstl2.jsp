<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    ArrayList<String> people=new ArrayList<>();
    people.add("11");
    people.add("22");
    people.add("33");
    people.add("44");
    people.add("55");
    request.setAttribute("list",people);
%>

<c:forEach var="people" items="${list}">
    <c:out value="${people}"/><br/>
</c:forEach>
<%--<c:forEach var="people" items="${list}" begin="1" end="3" step="">--%>
<%--    <c:out value="${people}"/><br/>--%>
<%--</c:forEach>--%>

</body>
</html>
