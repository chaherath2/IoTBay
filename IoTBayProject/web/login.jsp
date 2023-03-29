<%-- 
    Document   : login
    Created on : 29/03/2023, 1:57:08 PM
    Author     : chahe
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>IoTBay - Login</title>
    </head>
    <body>
        <h1>Login</h1>
        <form action="welcome.jsp" method="post">
            <table>
                <tr><td>Email:</td><td><input type="email" name="email"  placeholder="Enter Email" required></td></tr>
                <tr><td>Password:</td><td><input type="password" name="password"  placeholder="Enter Password" minlength="8" required></td></tr>
            </table>
            <input type="submit" value="login">
        </form>
    </body>
</html>