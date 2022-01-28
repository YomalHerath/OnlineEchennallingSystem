<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
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

                	<form action="AppointmentServer" method="POST" name="myform">
                    <input type = "hidden" name="action" value="/insert">
                    <h2>Add New Appointment</h2>

                    <fieldset class="form-group">
                    	<label>First Name</label> <input type="text" class="form-control" name="firstName" id="firstName"/>
                    </fieldset>

                    <fieldset class="form-group">
                    	<label>Last Name</label> <input type="text" class="form-control" name="secondName" id="secondName"/>
					</fieldset>

                    <fieldset class="form-group">
                    	<label>Contact No</label> <input type="text" class="form-control" name="contact" id="contact"/>
                    </fieldset>

                    <fieldset class="form-group">
                    	<label>Doctor Name</label>
                    	<select class="form-control" name="doctorName">
                    		<option>Select Doctor</option>
                    		<option>Dr.Bandara</option>
                    		<option>Dr.Perera</option>
                    		<option>Dr.Disanayake</option>
                    		<option>Dr.Jinadasa</option>
                    		<option>Dr.Dasanayake</option>
                    		<option>Dr.Jayathilaka</option>
                    		<option>Dr.Madahapola</option>
                    	</select>
					</fieldset>
                        
                    <fieldset class="form-group">
                    	<label>Hospital Name</label> 
                    <select class="form-control" name="hospital">
                        <option>Select Hospital</option>
                        <option>Asiri Hospital</option>
                        <option>Asia Hospital</option>
                        <option>Navaloka Hospital</option>
                        <option>National Hospital</option>
                        <option>National Eye Hospital</option>
                        <option>Dental Hospital</option>
                    </select>
                        </fieldset>
						
					<div class="form-row">
					<div class="form-group col-md-4">
						<label>Date</label>
					<select class="form-control" name="date">
						<option>DATE</option>
       	                <option>01</option>
    	                <option>02</option>
	                    <option>03</option>
                       	<option>04</option>
                       	<option>05</option>
                       	<option>06</option>
                    	<option>07</option>
                	    <option>08</option>
            	        <option>09</option>
        	            <option>10</option>
    	                <option>11</option>
	                    <option>12</option>
                       	<option>13</option>
                       	<option>14</option>
                       	<option>15</option>
                    	<option>16</option>
                	    <option>17</option>
            	        <option>18</option>
        	            <option>19</option>
    	                <option>20</option>
	                    <option>21</option>
                       	<option>22</option>
                       	<option>23</option>
                       	<option>24</option>
                    	<option>25</option>
                	    <option>26</option>
            	        <option>27</option>
        	            <option>28</option>
    	                <option>29</option>
	                    <option>30</option>
					</select>
				</div>
						   
				<div class="form-group col-md-4">
					<label>Month</label>
					<select class="form-control" name="month">
						<option>MONTH</option>
                		<option>Jan</option>
            	    	<option>Feb</option>
        	            <option>Mar</option>
    	                <option>Apr</option>
				        <option>May</option>
		    	        <option>Jun</option>
        	            <option>Jul</option>
            	    	<option>Aug</option>
            		    <option>Sep</option>
    		            <option>Oct</option>
	            	    <option>Nov</option>
        	           	<option>Dec</option>
    	           	</select>
    			</div>
    						
    			<div class="form-group col-md-4">
    				<label>Year</label>
					<select class="form-control" name="year" required="required">
						<option>YEAR</option>
                       	<option>2020</option>
                       	<option>2021</option>
					</select>
    			</div>
			</div>
            
            <button type="submit" class="btn btn-primary" onclick="validate()" >Submit</button>
			</form>
            </div></div></div>
            
            <script>
            	function validate(){
            		var firstName = document.myform.firstName;
            		var secondName = document.myform.secondName;
            		var contact = document.myform.contact;
            		
            		if(firstName.value == null || firstName == "") {
            			alert("Please enter first Name");
            			return false;
            		}
            		if(secondName.value == null || secondName == "") {
            			alert("Please enter Last Name");
            			return false;
            		}
            		if(contact.value == null || contact == "") {
            			alert("Please enter contact Number");
            			return false;
            		}
            		return true;
            	}
            
            </script>
            
            
        	<jsp:include page="/View/Footer.jsp"></jsp:include>
        </body>

        </html>