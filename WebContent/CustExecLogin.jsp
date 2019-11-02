<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%
   response.addHeader("Cache-Control", "no-cache,no-store,private,must-revalidate,max-stale=0,post-check=0,pre-check=0"); 
   response.addHeader("Pragma", "no-cache"); 
   response.addDateHeader ("Expires", 0);
 %>
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
		
		<%String name=session.getAttribute("username").toString(); %>
		<p>Welcome <%=name%> !!!</p>
		
		<center>
		<div class="table-container center">
			<table class="menu-container">
				<th colspan="2">Customer Services</th>
				<tr><td  class="for-hover"><a href="createCust.jsp">Create Customer</a></td></tr>
				<tr><td  class="for-hover"><a href="Search.jsp">Search Customer</a></td></tr>
				<tr><td  class="for-hover"><a href="CustomerServlet?action=statuscust">View Customer Status</a></td></tr>
			</table>
			
			<table class="menu-container margin-left-accser-table">
				<th colspan="2">Account Services</th>
					<tr><td  class="for-hover"><a href="CreateAccount.jsp">Create Account</a></td></tr>
					<tr><td  class="for-hover"><a href="accdetails.jsp">Search Account</a></td></tr>
					<tr><td  class="for-hover"><a href="AccountServlet?action=statusacct">View Account Status</a></td></tr>
			</table>
		</div>
		
		<div id="footer-login">	Copyright &copy; TVM53 TJA281 Group E</div>
	</body>
	</center>
</html>