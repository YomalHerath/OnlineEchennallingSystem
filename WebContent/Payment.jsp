<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>

<html>
<head>
    <title>Payment Management Application</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" 
    integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" 
    crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/sweetalert2@9"></script>
</head>

<body>
<jsp:include page="/View/Header.jsp"></jsp:include>
			
	<div class="container col-md-4">
    	<div class="card">
        	<div class="card-body">
        	
            <form action="PaymentServer" method="POST"> 
           	<input type="hidden" name="action" value="/insert">
            <h3>Payment</h3>
            
            <p>Channelling Bill Total : <span class="price" style="color:black"><b> Rs 1500.00</b></span></p>
            
            <fieldset class="form-group">
           	<label>Name on Card</label> <input type="text" class="form-control" name="cardName" required="required">
            </fieldset>
			
			<fieldset class="form-group">
           	<label>Credit Card Number</label> <input type="text" class="form-control" name="cardNo" required="required">
            </fieldset>
            
            <div class="form-row">
            	<div class="form-group col-md-4">
					<label>CVV</label>
					<input type="text" class="form-control" name="secCode" required="required">
				</div>
				
				<div class="form-group col-md-4">
					<label>Exp Month</label>
					<select class="form-control" name="expMonth" required="required">
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
					<label>ExpYear</label>
					<select class="form-control" name="expYear" required="required">
   	       				<option>2020</option>
            	        <option>2021</option>
        	            <option>2022</option>
    	                <option>2023</option>
	                    <option>2024</option>
                       	<option>2025</option>
                    </select>
				</div>
				
			</div>
                  
            <button type="submit" class="btn btn-primary" onclick="showAlert(); validate(cardNo);">Confirm Payment</button>
            </form>
           	</div>
		</div>
	</div>
            
<script>
function showAlert() {
	Swal.fire('Your Appointment was Successfully Added');
}

function validate(cardNo) {
	var cardNo = /^(?:4[0-9]{15})?)$/;
	if(text.value.match(cardNo)) {
		alert('Value is accepted');
		return true;
	} else {
		alert('Invalid Card');
		return false;
	}
}
</script>
            
<jsp:include page="/View/Footer.jsp"></jsp:include>
</body>
</html>