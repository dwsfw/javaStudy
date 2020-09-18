<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 2020/8/17
  Time: 8:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    pageContext.setAttribute("name1","1");
    request.setAttribute("name2","2");
    session.setAttribute("name3","3");
    application.setAttribute("name4","4");
%>
<%
    String name1=(String)pageContext.findAttribute("name1");
    String name2=(String)pageContext.findAttribute("name2");
    String name3=(String)pageContext.findAttribute("name3");
    String name4=(String)pageContext.findAttribute("name4");
    String name5=(String)pageContext.findAttribute("name5");
%>
<h1>值为：</h1>
<h3>${name1}</h3>
<h3>${name2}</h3>
<h3>${name3}</h3>
<h3>${name4}</h3>
<h3>${name5}</h3>
</body>
</html>
