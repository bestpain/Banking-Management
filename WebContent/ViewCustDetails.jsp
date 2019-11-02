<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ page import="com.model.Customer" %>
	  <%@ page import="java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="./index.css">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<script src="vaildator.js"></script>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>
<body>

<nav id="heading-page" class="nav nav-bar">
			<h1>Bank Management System</h1>
		</nav>
	
	<%ArrayList<Customer> customer=(ArrayList<Customer>)request.getAttribute("customer");
	if(customer!=null)
	{
	%>
	
		<form name="accStatus">
			<table class="display-table-result" align="center">
				<tr>
					<th colspan="4">Customer List</th>
				</tr>
				<tr>
					<th>SSN ID</th>
					<th>Status</th>
					<th>Message</th>
					<th>Last Updated</th>
					
				</tr>
				<% for(Customer c:customer)
				{
				%>
				<tr>
					<td><%=c.getSSN()%></td>
					<td><%=c.getStatus()%></td>
					<td><%=c.getMessage()%></td>
					<td><%=c.getLastupdate()%></td>
					
				</tr>
				<%} %>	
			</table>
		</form>
	
	<%} %>
	<center><div class="home-link-container-div"><a href="CustExecLogin.jsp">HOME</a></div></center>
</body>
</html>