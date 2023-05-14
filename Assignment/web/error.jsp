<%--
  Created by IntelliJ IDEA.
  User: lihancheng
  Date: 2023/5/14
  Time: 18:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    String errorMsg = (String) request.getAttribute("error");
%>


<h1><%=errorMsg%></h1>
<a href="showDevices">See device list</a><br>
<a>Back to homepage</a>

</body>
</html>
