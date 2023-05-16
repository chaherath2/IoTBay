<%-- 
    Document   : DisplaySuccessfulOrder
    Created on : 13/05/2023, 3:50:03 PM
    Author     : eric
--%>
    <%@page import="java.util.ArrayList"%>
<%@page import="model.*"%>
<% 
        Order order = (Order)session.getAttribute("order");
        
        ArrayList<OrderLine> orderLine = (ArrayList<OrderLine>) session.getAttribute("orderLines");
        request.setAttribute("orderLines", orderLine);
    %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>IoTBay || Order Invoice</title>
    </head>
    <body>
        <h1>Order Confirmation</h1>
        <table>
            <tr>
                <td>Order ID: </td>
                <td>${order.orderID}</td>
            </tr>
            <tr>
                <td>Order Date: </td>
                <td>${order.orderDate}</td>
            </tr>
            <tr>
                <td>Shipping Address: </td>
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
        <c:forEach items="${orderLines}" var="orderLine">
            
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
    </body>
</html>
