<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ page import="com.model.Account" %>
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
	
	<%ArrayList<Account> account=(ArrayList<Account>)request.getAttribute("account");
	if(account!=null)
	{
	%>
		<center>
		<form name="accStatus">
			<table class="display-table-result">
				<tr>
					<th colspan="6">Customer Accounts</th>
				</tr>
				<tr>
					<th>CustomerID</th>
					<th>Account Id</th>
					<th>Account Type</th>
					<th>Status</th>
					<th>Message</th>
					<th>Last Updated</th>
										
				</tr>
				<% for(Account a:account)
				{
				%>
				<tr>
					<td><%=a.getCustId()%></td>
					<td><%=a.getAccId()%></td>
					<td><%=a.getAccType()%></td>
					<td><%=a.getStatus()%></td>
					<td><%=a.getMessage()%></td>
					<td><%=a.getLastup()%></td>
					</tr>
				<%} %>	
			</table>
		</form>
		</center>
		
		<center><div class="home-link-container-div"><a href="CustExecLogin.jsp">HOME</a></div></center>
	<%} %>
</body>
</html>