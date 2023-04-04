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
        <link rel="stylesheet" href="css/style.css"> 
        <title>IoTBay - Register</title>
    </head>
    <body>
        <h1>Register</h1>
        <form action="welcome.jsp" method="post">
            <table>
                <tr><td class="inputlabel">Email:</td><td><input type="email" name="email"  placeholder="Enter Email" required></td></tr>
                <tr><td class="inputlabel">Name:</td><td><input type="text" name="name"  placeholder="Enter Name" required></td></tr>
                <tr><td class="inputlabel">Password:</td><td><input type="password" name="password"  placeholder="Enter Password" minlength="8" required></td></tr>
                <tr><td class="inputlabel">Date of Birth:</td><td><input type="date" name="dob"  required></input></td></tr>
                <tr><td class="inputlabel">Agree to TOS:</td><td><input type="radio" name="tos" value="Yes">Yes</input><input type="radio" name="tos" value="No">No</input></td></tr>
            </table>
            <div>
                <a href="index.jsp">Cancel</a>
                <input type="submit" class="submitbutton" value="Register">
            </div>
        </form>
    </body>
</html>
