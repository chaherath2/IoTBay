<%-- 
    Document   : ConfirmShipping
    Created on : 16/05/2023, 5:58:50 PM
    Author     : eric
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>IoTBay | | Shipping Details</title>
        <link rel="stylesheet" href="css/style.css"> 
    </head>
    <body>
        <h1>Confirm Shipping Details</h1>
        <p>Please input valid addresses</p>
        <form action="DisplaySuccessfulOrder.jsp" method="post">
            <table>
                <tr>
                    <td> <label for="billingAddress">Billing Address: </label></td>
                    <td><input type="text" name="billingAddress" required></td>
                </tr>
                <tr>
                    <td><label for="shippingAddress">Shipping Address: </label></td>
                    <td><input type="text" name="shippingAddress" ></td>
                </tr>
            </table>
            
                <input type="submit" value="Proceed to Order Confirmation">
        </form>
    </body>
</html>
