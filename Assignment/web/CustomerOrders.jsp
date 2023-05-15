<%-- 
    Document   : CustomerOrders
    Created on : 15/05/2023, 6:14:39 PM
    Author     : User
--%>

<%@page import="uts.isd.assignment.Customer"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            Customer customer = (Customer)session.getAttribute("customer");
        %>
        <h1>Your Current Orders</h1>
    </body>
</html>
