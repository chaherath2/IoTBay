<%@ page import="java.util.List" %>

<%@ page import="java.util.ArrayList" %>
<%@ page import="model.Device" %><%--
  Created by IntelliJ IDEA.
  User: lihancheng
  Date: 2023/5/14
  Time: 12:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<script type="application/javascript" src="https://code.jquery.com/jquery-3.7.0.min.js"></script>
<script>
    $(document).ready(function() {
        $('#addDevice').click(function(event) {
            let deviceName = $('#deviceName').val();
            let deviceDescription = $('#deviceDescription').val();
            let stock = $('#stock').val();
            $.post('addDevice', {
                deviceName : deviceName,
                deviceDescription: deviceDescription,
                stock: stock,
            }, function(data) {
                alert(data);
            });
        });
        onload(function (e) {
            $.get('getDevices', {

            }, function(data) {
                alert(data);

            });
        })
    });
</script>

<head>
    <title>Title</title>
</head>
<body>

    <%

        List<Device> devices = (List<Device>) request.getAttribute("devices");
    %>
    <table>
        <tr>
            <th>Device ID</th>
            <th>Name</th>
            <th>Type</th>
            <th>Description</th>
            <th>Price</th>
            <th>Stock</th>
            <th>Create Time</th>
            <th>Update Time</th>
            <th>Availability</th>
            <th>Operation</th>
        </tr>


    <%
        for (Device device : devices) {
            %>
        <tr>
            <td><%=device.getDeviceId()%></td>
            <td><%=device.getDeviceName()%></td>
            <td><%=device.getType()%></td>
            <td><%=device.getDeviceDescription()%></td>
            <td><%=device.getPrice()%></td>
            <td><%=device.getStock()%></td>
            <td><%=device.getCTime()%></td>
            <td><%=device.getUTime()%></td>
            <td><%=device.getAvailable()%></td>
            <td>
                <a href="updateDevice.jsp?id=<%=device.getId()%>&deviceName=<%=device.getDeviceName()%>&deviceDescription=<%=device.getDeviceDescription()%>&type=<%=device.getType()%>&price=<%=device.getPrice()%>&stock=<%=device.getStock()%>">Edit</a>
                <a href="deleteDevice?id=<%=device.getId()%>">Delete</a>
            </td>
        </tr>
    <%
        }
    %>
    </table>


</body>
</html>
