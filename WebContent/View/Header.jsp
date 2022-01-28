<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>

<style>
.back{
	background-image: url('https://www.bistatedev.org/wp-content/uploads/2017/08/iStock-532963888.jpg');
	background-size:cover;
}
</style>

<head>
	<meta charset="ISO-8859-1">
	<title>Header</title>
</head>

<body class="back">
	
	<h1 class="display-3" align="center" style="font-weight: bold">E-channeling System</h1>
	
	<nav class="navbar navbar-expand-lg navbar navbar-dark bg-dark">
 	<div class="collapse navbar-collapse" id="navbarTogglerDemo01">
    <ul class="navbar-nav mr-auto mt-2 mt-lg-0">
      	<li class="nav-item">
        	<a class="nav-link" href="AppointmentServer">Appointments</a>
      	</li>
      	<li class="nav-item">
        	<a class="nav-link" href="PaymentServer">Payments</a>
      	</li>
      	<li class="nav-item">
        	<a class="nav-link" href="Logout.jsp">Logout</a>
      	</li>
    </ul>
    
  	</div>
	</nav>
<%
	if(session.getAttribute("username") != null && session.getAttribute("password") != null) {
		out.println("------ WELCOME to the site " + session.getAttribute("username") + " --------");
	}else {
		response.sendRedirect("PatiantLogin.jsp");
	}
%>
    <br>
    
</body>
</html>