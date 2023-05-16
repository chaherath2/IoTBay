<%-- 
    Document   : cart
    Created on : 12/05/2023, 5:24:38 PM
    Author     : eric
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="uts.isd.model.dao.DBOrderLineManager"%>
<%@page import="model.Order"%>
<%@page import="model.OrderLine"%>
<%@page import="model.Device"%>
<% 
    Order order = (Order)session.getAttribute("order");
    ArrayList<OrderLine> orderLine = (ArrayList<OrderLine>) session.getAttribute("orderLines");
    request.setAttribute("orderLine", orderLine);
    session.setAttribute("orderLine", orderLine);
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/style.css"> 
        <title>IOTBAY | | Your Cart</title>
    </head>
    <body>
        <h1>View Cart</h1>
        <table id="customer">

                <tr>
                <thead>
                    <th>Product Name</th>
                    <th>Quantity</th>
                    <th>Total Price</th>
                  </thead>
                </tr>
                <c:forEach items="${orderLine}" var="orderLine">
                    <td>${orderLine.deviceName}</td>
                    <form method ="post" action="addQuantity">
                        <input type ="hidden" name="orderlineID" values ="${orderLine.orderlineID}">
                        <input type ="hidden" name="productID" values ="${orderLine.productID}">
                        <input type="submit" value="Add">
                    </form>
                    <td>${orderLine.quantity}</td>
                    <td>
                    <form method="post" action="decreaseQuantity">
                    <input type="hidden" name="orderLineID" value="${orderLine.orderlineID}">
                    <input type="hidden" name="productID" value="${orderLine.productID}">
                    <input type="submit" value="Remove">
                    </form>
                    </td>
                    <td>${orderLine.totalPrice}</td>
                </c:forEach>
            </table>
            <tr>
                <td>Total Price (exc. gst):</td>
                <td>${order.totalPrice}<td>
            </tr>
            <tr>
                <td>GST: </td>
                <td>${order.tax}</td>
            </tr>
        </table>
        <form action="ConfirmShipping.jsp" method="post">
            <input type="submit" value="Proceed to Shipping Details">
        </form>
        <form action="main.jsp" method="post">
            <input type="submit" value="Cancel">
        </form>
    </body>
</html>
