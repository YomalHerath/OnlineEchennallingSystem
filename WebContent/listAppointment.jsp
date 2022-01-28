<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="appointment.model.Appointment" %>
<%@ page import="java.util.List" %>
<html>
	<% List<Appointment> listAppointment = (List<Appointment>) request.getAttribute("listAppointment"); %>
<head>
	<title>Appointment Management Application</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" 
    integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" 
    crossorigin="anonymous">
</head>

<body>
	<jsp:include page="/View/Header.jsp"></jsp:include>

	<div class="row">

    <div class="container">
    	<h3 class="text-center" style="font-weight: bold">List of Appointments</h3>
        <hr>
        <div class="container text-left">
        
    <form class="form-inline my-2 my-lg-0" action="AppointmentServer" method="POST">
    	<input class="form-control mr-sm-2" type="search" placeholder="Search here..." name="search" aria-label="Search">
    	<input type="hidden" name="action" value="/search">
    	<button class="btn btn-outline-primary" type="submit">Search</button>
    </form>
    
    <br>
			<a href="Appointment.jsp" class="btn btn-primary">Add New Appointment</a>
        </div>
        <br>
        
        <table class="table table-striped" border="1" style="background-color:white">
        	
        	<thead class="bg-info">
            <tr>
            	<th>ID</th>
                <th>First Name</th>
                <th>Second Name</th>
                <th>Contact</th>
                <th>Doctor Name</th>
                <th>Hospital Name</th>
                <th>Date</th>
                <th>Month</th>
                <th>Year</th>
                <th>Action</th>
        	</tr>
            </thead>
            
            <tbody>
            <c:forEach var="appointment" items="${listAppointment}">
            <tr>
            	<td><c:out value="${appointment.id}" /></td>
				<td><c:out value="${appointment.firstName}" /></td>
				<td><c:out value="${appointment.secondName}" /></td>
                <td><c:out value="${appointment.contact}" /></td>
				<td><c:out value="${appointment.doctorName}" /></td>
				<td><c:out value="${appointment.hospitalName}" /></td>
				<td><c:out value="${appointment.date}" /></td>
				<td><c:out value="${appointment.month}" /></td>
                <td><c:out value="${appointment.year}" /></td>
                <td>
                	<a class="btn btn-primary btn-sm" href="AppointmentServer?action=/edit&Id=<c:out value='${appointment.id}'/>">Edit</a> 
	                &nbsp; 
                    <a class="btn btn-danger btn-sm" href="AppointmentServer?action=/delete&Id=<c:out value='${appointment.id}' />">Delete</a>
                </td>
         	</tr>
            </c:forEach>
            </tbody>

		</table>
	</div>
    </div>
            
    <jsp:include page="/View/Footer.jsp"></jsp:include>
</body>

</html>