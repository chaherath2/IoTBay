<%-- 
    Document   : logout
    Created on : 3 Apr 2023, 8:46:49 pm
    Author     : shawaiz
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/style.css"> 
        <title>IOTBay Logout Page</title>
    </head>
    <body>
        <h1>You have logged out</h1>
        <a href="index.jsp">Return to Home</a>
        <% session.invalidate(); %>
    </body>
</html>
