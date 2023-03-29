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
            <label for="email">Email:</label>
            <input type="email" name="email"  required><br>
            
            <br>
            
            <label for="name">Name:</label>
            <input type="text" name="name" required><br>
            
            <br>
            <label for="password">Password:</label>
            <input type="password" name="password" minlength="8" required><br>
            
            <br>
            
            <label for="gender">Gender:</label>
            <input type="radio" name="gender" value="Male">Male</input>
            <input type="radio" name="gender" value="Female">Female</input>
            <input type="radio" name="gender" value="Other">Other</input><br>      
            <br>
            
            <label for="phone">Phone Number:</label>
            <input type="number" name="phone" value="04" minlength="8" maxlength ="8" required></input><br>
            
            <br>
            
            <label for="tos">Agree to TOS: </label>
            <input type="radio" name="tos" value="Yes">Yes</input>
            <input type="radio" name="tos" value="No">No</input>
            
            <br>   

            <input type="submit" value="Register">
        </form>
    </body>
</html>
