<%--
  Created by IntelliJ IDEA.
  User: lihancheng
  Date: 2023/5/14
  Time: 14:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="addDevice" method="post">
        <input type="text" id="deviceName" name="deviceName"/>
        <input type="text" id="deviceDescription" name="deviceDescription"/>
        <input type="text" id="price" name="price"/>
        <input type="text" id="stock" name="stock"/>
        <select name="type">
            <option value="0">xxx</option>
            <option value="1">yyy</option>
            <option value="2">zzz</option>
        </select>
        <input type="submit" value="Add" id="addDevice">
    </form>

</body>
</html>
