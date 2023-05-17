<%@ page import="java.util.List" %>
<%@ page import="model.Device" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Collection" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <title>IoTBay-Device Catalogue</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
    <link rel="stylesheet" type="text/css" href="main.css">
</head>

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
    <table class="table device-table">
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

    <%  if (devices != null && !devices.isEmpty()) { %>
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
        <%}%>

    </table>

    <a class="btn btn-outline-success btn-lg" href="addDevice.jsp" role="button">Add New Device</a>
    <a class="btn btn-outline-info btn-lg" href="index.jsp" role="button">Back to Home</a>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe" crossorigin="anonymous"></script>
</body>
</html>
