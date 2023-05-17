
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>IoTBay-Add Device</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
    <link rel="stylesheet" type="text/css" href="main.css">
</head>
<body>
<form action="addDevice" method="post" class="device-form">
    <div class="form-row">
        <input type="text" id="deviceName" name="deviceName" class="form-input" placeholder="Device Name"/>
        <input type="text" id="deviceDescription" name="deviceDescription" class="form-input" placeholder="Device Description"/>
    </div>
    <div class="form-row">
        <input type="number" id="price" name="price" class="form-input" placeholder="Price"/>
        <input type="number" id="stock" name="stock" class="form-input" placeholder="Stock"/>
    </div>
    <select name="type" class="form-select">
        <option value="0">Device Type 1</option>
        <option value="1">Device Type 2</option>
        <option value="2">Device Type 3</option>
    </select>
    <button type="submit" id="addDevice" class="btn btn-primary">Add</button>
</form>
<a href="showDevices" class="btn btn-outline-success btn-lg add-device-btn" role="button">See device list</a>
<a class="btn btn-outline-info btn-lg add-device-btn" href="index.jsp" role="button">Back to Home</a>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe" crossorigin="anonymous"></script>
</body>
</html>
