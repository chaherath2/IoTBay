<%-- 
    Document   : main.jsp
    Created on : 3 Apr 2023, 8:09:42 pm
    Author     : shawaiz
--%>
<%@page import="uts.isd.assignment.Customer"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/style.css"> 
        <title>IOTBay Main Page</title>
    </head>
    <body>
        <%
            Customer customer = (Customer)session.getAttribute("customer");
        %>
        <h1>Customer Profile</h1>
        <table id="customer">
            <thead><th>Name</th><th>Email</th><th>Password</th><th>Date of Birth</th></thead>
            <tr><td>${customer.name}</td><td>${customer.email}</td><td>${customer.password}</td><td>${customer.dob}</td></tr>
        </table>
        
        <a href="logout.jsp">Logout</a>
    </body>
</html>
