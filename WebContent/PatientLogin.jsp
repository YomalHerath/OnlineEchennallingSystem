<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Online Echennal System</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" 
    integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" 
    crossorigin="anonymous"></head>
<body>
<jsp:include page="/View/HomeHeader.jsp"></jsp:include>
	<div class="container col-md-3">
    	<div class="card">
        	<div class="card-body">
            			         	
            	<h3 align="center" style="font-weight:bold">Patient Sign In</h3>
                     	
                	<form action ="PatientServer" method="POST">
            			<input type="hidden" name="action" value="list" />

                        <fieldset class="form-group">
                            <label>User Name</label> <input type="text" class="form-control" name="Username" required >
                        </fieldset>

                        <fieldset class="form-group">
                            <label>Password</label> <input type="password" class="form-control" name="password" required>
                        </fieldset>
						<button type="submit" class="btn btn-primary">Sign In</button><br><br>
						<b class="font-italic">If you don't have account</b>&nbsp;<a href="PatientRegister.jsp"><b>Sign Up</b></a>
                  </form>
			</div>
		</div>
	</div>
<jsp:include page="/View/Footer.jsp"></jsp:include>
</body>
</html>