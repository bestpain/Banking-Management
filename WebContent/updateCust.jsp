<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
       <%@ page import="com.model.Customer" %>
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
			<h1>Bank Management System</h1><span id="logout-btn" class="pull-right"><a href="LoginController?action=logout">Logout</a></span>
		</nav>
	
	<%Customer customer=(Customer)request.getAttribute("customer");
		if(customer!=null)
		{
		%>
		<form action="CustomerServlet?custid=<%=customer.getCustId()%>" method="post">
		<table>
					<tr>
						<td>Customer SSN ID:</td><td><input type="number" name="ssnid" value="<%=customer.getSSN()%>" disabled></td>
					</tr>
					<tr>
						<td>Customer Id:</td><td><input type="number" name="custid" value="<%=customer.getCustId()%>" disabled></td>
					</tr>
					
					<tr>
						<td>Customer Name:</td><td><input type="text" name="name" value="<%=customer.getName()%>" ></td>
					</tr>
					
					<tr>
						<td>Address:</td><td><input type="text" name="address" value="<%=customer.getAddress()%>" ></td>
					</tr>
					
					<tr>
						<td>Age:</td><td><input type="number" name="age" value="<%=customer.getAge()%>" ></td>
					</tr>
					<tr>
						<td colspan="2" align="center"><input type="submit" class="btn btn-primary" name="action" value="Edit"></td>
					</tr>
					
				</table>
		</form>
		
		<center><div class="home-link-container-div"><a href="CustExecLogin.jsp">HOME</a></div></center>
		<%} %>
	</body>
</html>