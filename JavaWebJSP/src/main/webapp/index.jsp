<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<%@ page errorPage="500.jsp" %>--%>
<html>
<body>
<h2>Hello World!</h2>
<%=new java.util.Date()%>
<%
    int sum=0;
    for (int i = 0; i < 100; i++) {
        sum+=i;
    }
    out.print("<h1>sum="+sum+"</h1>");
%>
</body>
</html>
