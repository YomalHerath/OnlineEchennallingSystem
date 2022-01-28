<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

<head>

<meta charset="ISO-8859-1">
<title>Online Echannel System</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" 
    integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" 
    crossorigin="anonymous">
</head>

<body>
<jsp:include page="/View/HomeHeader.jsp"></jsp:include>
<br>
<div align="center" class="shadow-lg p-3 mb-2 rounded">
	<a class="btn btn-primary btn-lg" href="#">Admin Login</a><br><br>
	<a class="btn btn-primary btn-lg" href="#">Doctor Login</a><br><br>
	<a class="btn btn-primary btn-lg" href="PatientLogin.jsp">Patient Login</a>
</div>
<br>
<jsp:include page="/View/Footer.jsp"></jsp:include>
</body>
</html>