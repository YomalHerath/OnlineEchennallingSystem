<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Patient Sign Up</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" 
    integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" 
    crossorigin="anonymous"></head>
</head>
<body>
<jsp:include page="/View/HomeHeader.jsp"></jsp:include>

<div class="container col-md-4">
	<div class="card">
	<div class="card-body">
	
	<form action="PatientServer" method="POST">
	<input type = "hidden" name="action" value="/insert">
	
		<h2 style="font-weight:bold">Patient Sign Up</h2>
		<table class="table table-borderless">
			<tr>
				<td>First Name</td>
				<td><input type="text" class="form-control" name="firstName" /></td>
			</tr>
			<tr>
				<td>Last Name</td>
				<td><input type="text" class="form-control" name="lastName" /></td>
			</tr>
			<tr>
				<td>UserName</td>
				<td><input type="text" class="form-control" name="Username" /></td>
			</tr>
			<tr>
				<td>Password</td>
				<td><input type="password" class="form-control" name="password" /></td>
			</tr>
			<tr>
				<td>Email</td>
				<td><input type="text" class="form-control" name="email" /></td>
			</tr>
			<tr>
				<td>Contact No</td>
				<td><input type="text" class="form-control" name="contact" /></td>
			</tr>
		</table>
		<button type="reset" class="btn btn-primary">Reset</button>&nbsp;
		<button type="submit" class="btn btn-primary">Sign Up</button><br><br>
		<b class="font-italic">If you already have account</b>&nbsp;<a href="PatientLogin.jsp"><b>Sign In</b></a>
	</form>
	</div>
	</div>
</div>

<jsp:include page="/View/Footer.jsp"></jsp:include>
</body>
</html>