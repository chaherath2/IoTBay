<%@ page import="java.util.Map" %>
<%@ page import="java.util.Collections" %>
<%@ page import="java.util.stream.Collectors" %>
<%@ page import="java.util.HashMap" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update Devices</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
    <link rel="stylesheet" type="text/css" href="main.css">
</head>
<body>
<%
    Map<String, String[]> parameters = Collections.list(request.getParameterNames()).stream()
            .collect(Collectors.toMap(parameterName -> (String) parameterName, request::getParameterValues));
    Map<Integer, String> types = new HashMap<>();
    types.put(0, "Device Type 1");
    types.put(1, "Device Type 2");
    types.put(2, "Device Type 3");
    types.put(3, "Device Type 4");
%>
<table class="styled-table">
    <tr>
        <th>Name</th>
        <th>Type</th>
        <th>Description</th>
        <th>Price</th>
        <th>Stock</th>
        <th>Operation</th>
    </tr>
    <tr>
        <form action="updateDevice" method="post">
            <input type="hidden" name="id" value="<%=parameters.get("id")[0]%>">
            <td>
                <input type="text" value="<%=parameters.get("deviceName")[0]%>" id="deviceName" name="deviceName" class="form-input">
            </td>
            <td>
                <select name="type" class="form-select">
                    <%
                        for (int i = 0; i < 4; i++) {
                            if (i == Integer.parseInt(parameters.get("type")[0])) {%>
                    <option selected value="<%=i%>"><%=types.get(i)%></option>
                    <%} else%> <option value="<%=i%>"><%=types.get(i)%></option>
                    <%}%>
                </select>
            </td>
            <td>
                <input type="text" value="<%=parameters.get("deviceDescription")[0]%>" id="deviceDescription" name="deviceDescription" class="form-input">
            </td>
            <td>
                <input type="number" value="<%=parameters.get("price")[0]%>" id="price" name="price" class="form-input">
            </td>
            <td>
                <input type="number" value="<%=parameters.get("stock")[0]%>" id="stock" name="stock" class="form-input">
            </td>
            <td>
                <button type="submit" class="btn btn-primary">Update</button>
            </td>
        </form>
    </tr>
</table>


<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe" crossorigin="anonymous"></script>
</body>
</html>
