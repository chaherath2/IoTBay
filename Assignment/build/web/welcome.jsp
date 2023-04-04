<%-- 
    Document   : welcome
    Created on : 3 Apr 2023, 1:03:44 am
    Author     : shawaiz
--%>
<%@page import="uts.isd.assignment.Customer"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/style.css"> 
        <title>IOTBay Welcome</title>
    </head>
    <body>
        <%
            String name = request.getParameter("name");
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            String dob = request.getParameter("dob");
            String tos = request.getParameter("tos");
        %>
        <%
        String validate = "No";
         if (validate.equals(tos)){
            
        %>
        <p>Sorry, you must agree to the Terms of Service.</p>
        <p>Click <a href='register.jsp'>here</a> to go back</p>

        
        <% } else{ %>
        %>
        <h1>Welcome <%=name%></h1>
        <p>Your email is: <%=email%></p>
        <p>Your password is: <%=password%></p>
        <p>Your DOB is: <%=dob%></p>
        <a href="index.jsp">Cancel</a>
        <a href="main.jsp">Main</a>
        <%}%>
        <%
            Customer customer = new Customer(name, email, password, dob);
            session.setAttribute("customer", customer);
        %>
        
    </body>
</html>
