<%@ page import="java.util.Map" %>
<%@ page import="java.util.Collections" %>
<%@ page import="java.util.stream.Collectors" %>
<%@ page import="java.util.HashMap" %><%--
  Created by IntelliJ IDEA.
  User: lihancheng
  Date: 2023/5/14
  Time: 15:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        Map<String, String[]> parameters = Collections.list(request.getParameterNames()).stream()
        .collect(Collectors.toMap(parameterName -> (String) parameterName, request::getParameterValues));
        Map<Integer, String> types = new HashMap<>();
        types.put(0, "xxx");
        types.put(1, "yyy");
        types.put(2, "aaa");
        types.put(3, "bbb");
    %>
    <table>
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
                    <input type="text" value="<%=parameters.get("deviceName")[0]%>" id="deviceName" name="deviceName">
                </td>
                <td>
                    <select name="type">
                        <%
                            for (int i = 0; i < 4; i++) {
                                if (i == Integer.parseInt(parameters.get("type")[0])) {%>
                                        <option selected value="<%=i%>"><%=types.get(i)%></option>
                                <%} else%> <option value="<%=i%>"><%=types.get(i)%></option>
                        <%}%>
                    </select>
                </td>
                <td>
                    <input type="text" value="<%=parameters.get("deviceDescription")[0]%>" id="deviceDescription" name="deviceDescription">
                </td>
                <td>
                    <input type="text" value="<%=parameters.get("price")[0]%>" id="price" name="price">
                </td>
                <td>
                    <input type="text" value="<%=parameters.get("stock")[0]%>" id="stock" name="stock">
                </td>
                <td>
                    <input type="submit" value="Update">
                </td>
            </form>

        </tr>
    </table>
</body>
</html>
