<%-- 
    Document   : register
    Created on : 15/03/2023, 2:07:00 PM
    Author     : ericp
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>IoTBay - Register</title>
    </head>
    <body>
        <h1>Register</h1>
        <form action="welcome.jsp" method="post">
            <table>
                <tr><td>Email:</td><td><input type="email" name="email"  placeholder="Enter Email" required></td></tr>
                <tr><td>Name:</td><td><input type="text" name="name"  placeholder="Enter Name" required></td></tr>
                <tr><td>Password:</td><td><input type="password" name="password"  placeholder="Enter Password" minlength="8" required></td></tr>
                <tr><td>Date of Birth:</td><td><input type="date" name="DOB"  required></input></td></tr>
                <tr><td>Agree to TOS:</td><td><input type="radio" name="tos" value="Yes">Yes</input><input type="radio" name="tos" value="No">No</input></td></tr>
            </table>
            

            <input type="submit" value="Register">
        </form>
    </body>
</html>
