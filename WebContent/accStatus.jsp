<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>	
	<head>
		<meta charset="ISO-8859-1">
		<title>Insert title here</title>
		<link rel="stylesheet" href="index.css">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<script src="vaildator.js"></script>
		<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
	</head>
	<body>
		
		<nav id="heading-page" class="nav nav-bar">
			<h1>Bank Management System</h1>
		</nav>
			
		
			<form name="createCustomer" action="" method="post">
				<table class="center container-form center">
					<tr>
						<td>Customer SSN ID:</td><td><input type="text" name="ssnid" placeholder=" Social Security No"/></td>
					</tr>
					
					<tr>
						<td>Customer Name:</td><td><input type="text" name="custname" placeholder=" eg: FirstName LastName"/></td>
					</tr>
					
					<tr>
						<td>Age:</td><td><input type="number" name="age" placeholder=" Age"/></td>
					</tr>
					
					<tr>
						<td>Address Line 1:</td><td><input type="text" name="add1" placeholder=" eg: Building/Area/Block No."/></td>
					</tr>
					
					<tr>
						<td>Address Line 2:</td><td><input type="text" name="add2" placeholder=" eg: Landmark/Street/Road"/></td>
					</tr>
					
					<tr>
						<td>City:</td><td><input type="text" name="city" placeholder=" eg: Trivandrum"></td>
					</tr>
					
					<tr>
						<td>State:</td><td><input type="text" name="state" placeholder=" eg: Kerala"></td>
					</tr>
					
					<tr>
						<td colspan="2" align="center"><button type="submit" class="btn btn-primary">Submit</button></td>
					</tr>
					
				</table>
			</form>
			
			<center><div class="home-link-container-div"><a href="CustExecLogin.jsp">HOME</a></div></center>		
	</body>
</html>