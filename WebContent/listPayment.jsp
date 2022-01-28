<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="payment.model.Payment"%>
<%@ page import="java.util.List"%>
   
<html>
<% List<Payment> listPayment = (List<Payment>) request.getAttribute("listPayment"); %>
<head>
	<title>Payment Management Application</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" 
    integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" 
   	crossorigin="anonymous">
</head>

<body>
	<jsp:include page="/View/Header.jsp"></jsp:include>
             
    <div class="row">

    <div class="container">
    <h3 class="text-center" style="font-weight: bold">Payment History</h3>
    <hr>
	
	<table class="table table-striped" border="1" style="background-color:white">
		<thead class="bg-info">
        	<tr>
            	<th>ID</th>
                <th>Card Name</th>
                <th>Card Number</th>
                <th>Security Code</th>
                <th>Exp Month</th>
				<th>Exp Year</th>
				<th>Action</th>
            </tr>
    	</thead>
    	
            <c:forEach var="payment" items="${listPayment}">																	
					<tr>
						<td>${payment.pId}</td> 
						<td> ${payment.cardName} </td>
						<td> ${payment.cardNo} </td>
						<td> ${payment.secCode} </td>
						<td> ${payment.expMonth} </td>
						<td> ${payment.expYear} </td>
						<td> <a class="btn btn-danger btn-sm" href="PaymentServer?action=/delete&pId=<c:out value='${payment.pId}' />">Delete</a></td>
					</tr>	
			</c:forEach>
	</table>
   	</div>
	</div>
            
	<jsp:include page="/View/Footer.jsp"></jsp:include>
</body>

</html>