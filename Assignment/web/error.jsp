
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
