<%-- 
    Document   : CustomerOrders
    Created on : 14/05/2023, 6:14:39 PM
    Author     : eric
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
         <link rel="stylesheet" href="css/style.css"> 
    </head>
    <body>
        <h1>Your Current Orders</h1>
               <table id="customer">
            <tr>
                <td>Order ID: </td>
                <td>${order.orderID}</td>
            </tr>
            <tr>
                <td>Order Date: </td>
                <td>${order.orderDate}</td>
            </tr>
            <tr>
                <td>Shipping Address: ${order.shippingAddress}</td>
                <td>${order.shippingAddress}</td>
            </tr>
            <tr>
                <td>Billing Address: </td>
                <td>${order.billingAddress}</td>
            </tr>
                <tr>
                    <th>Product Name</th>
                    <th></th>
                    <th>Quantity</th>
                    <th></th>
                    <th>Total Price</th>
                </tr>
        <c:forEach items="${orderLine}" var="orderLine">
            
            <tr>
                <td>${orderLine.productName}</td> 
                <td></td>                
                <td>${orderLine.quantity}</td>
                <td></td>
                <td>${orderLine.totalPrice}</td>
            </tr>                       
        </c:forEach>
            <tr></tr>
            <tr>
                <td>Price:</td>
                <td>${order.totalPrice}<td>
            </tr>
            <tr>
                <td>GST: </td>
                <td>${order.tax}</td>
            </tr>
            <tr>
                <td>Total Price: </td>
                <td>${order.totalPrice + order.tax}</td>
            </tr>
            </table>
            <table>
                <td>
            <form action="ConfirmShipping.jsp" method="post"> 
                <input type="submit" value="Edit Shipping Details">
            </form>
                    </td>
                    <td>
            <form action="main.jsp" method="post"> 
                <input type="submit" value="Head Back">
            </form>
                    </td>
            </table>
    </body>
</html>
