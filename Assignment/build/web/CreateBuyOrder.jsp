<%-- 
    Document   : CreateBuyOrder
    Created on : 15/05/2023, 8:53:16 PM
    Author     : User
--%>

<%@page import="model.Device"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            Device selectedDevice = (Device) session.getAttribute("purchaseDevice");
        %>
        <form method="post">
            <h1>Summary of purchase</h1>
            <h2>Device Details</h2>
            <p>${device.deviceName}</p>
        </form>
    </body>
</html>
