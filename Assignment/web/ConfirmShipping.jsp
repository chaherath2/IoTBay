<%-- 
    Document   : ConfirmShipping
    Created on : 16/05/2023, 5:58:50 PM
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>IoTBay | | Shipping Details</title>
    </head>
    <body>
        <form action="DisplayCompleteOrderServlet">
            <table>
                <tr>
                    <td> <label for="billingAddress">Billing Address: </label></td>
                    <td><input type="text" name="billingAddress"></td>
                </tr>
                <tr>
                    <td><label for="shippingAddress">Shipping Address: </label></td>
                    <td><input type="text" name="shippingAddress"></td>
                </tr>
            </table>
                <input type="submit" value="Proceed to Order Confirmation">
        </form>
    </body>
</html>
