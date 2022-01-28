<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@ page import="appointment.model.Appointment" %>
        <html>
			<% Appointment existingAppointment = (Appointment) request.getAttribute("existingAppointment"); %>
        <head>
            <title>Appointment Management Application</title>
            <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" 
            integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" 
            crossorigin="anonymous">
            <link rel = "stylesheet" type = "text/css" href = "echannel.css" />
        </head>

        <body>
			<jsp:include page="/View/Header.jsp"></jsp:include>
			
			
            <div class="container col-md-4">
                <div class="card">
                    <div class="card-body">
            			         	
                     	<h2>UPDATE APPOINTMENT</h2>
                     	
                     	<form action = "AppointmentServer" method="POST">
            				<input type="hidden" name="action" value="/update" />
            				<input type="hidden" name="Id" value="${existingAppointment.id}">

                        <fieldset class="form-group">
                            <label>First Name</label> <input type="text" class="form-control" name="firstName"
                            value="${existingAppointment.firstName}" >
                        </fieldset>

                        <fieldset class="form-group">
                            <label>Second Name</label> <input type="text" class="form-control" name="secondName" 
                            value="${existingAppointment.secondName}" >
                        </fieldset>

                        <fieldset class="form-group">
                            <label>Contact No</label> <input type="text" class="form-control" name="contact" 
                            value="${existingAppointment.contact}" >
                        </fieldset>

                        <fieldset class="form-group">
                            <label>Doctor Name</label> <input type="text" class="form-control" name="doctorName" 
                            value="${existingAppointment.doctorName}">
                        </fieldset>
                        
                        <fieldset class="form-group">
                            <label>Hospital Name</label> <input type="text" class="form-control" name="hospital" 
                            value="${existingAppointment.hospitalName}">
                        </fieldset>
						
						<div class="form-row">
							<div class="form-group col-md-4">
							<fieldset class="form-group">
                            	<label>Date</label> <input type="text" class="form-control" name="date" 
                            	value="${existingAppointment.date}">
                        	</fieldset>
							 </div>
						   
							<div class="form-group col-md-4">
								<label>Month</label><input type="text" class="form-control" name="month"
								 value="${existingAppointment.month}"> 
                	       	</div>
    						
							<div class="form-group col-md-4">
								<label>Year</label><input type="text" class="form-control" name="year"
								 value="${existingAppointment.year}"> 
                	       	</div>  
                	       	
						</div>
                        <button type="submit" class="btn btn-primary">Save</button>
                        </form>
                    </div>
                </div>
            </div>
            
        	<jsp:include page="/View/Footer.jsp"></jsp:include>
        </body>

        </html>