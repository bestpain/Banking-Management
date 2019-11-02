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
		<script src="Search.js"></script>
		<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
	</head>
	<body>
		
			<nav id="heading-page" class="nav nav-bar">
			<h1>Bank Management System</h1><span id="logout-btn" class="pull-right"><a href="LoginController?action=logout">Logout</a></span>
		</nav>
		
	
		<div id="body-page" class="center">
			<form name="searchCustomer" action="CustomerServlet" method="get">
				<table>
					<tr>
						<td>Customer SSN ID:</td><td><input type="number" id="ssnid" name="ssnid" onkeyup="accdetailValidator()"></td>
					</tr>
					<tr><td colspan="2" style="text-align: center">OR</td></tr>
					<tr>
						<td>Customer Id:</td><td><input type="number" id="custid" name="custid" onkeyup="accdetailValidator()"></td>
					</tr>
				<tr>
						<td colspan="2" align="center"><input type="submit" class="btn btn-primary" name="action" id="submit-id" value="Search" disabled></td>
					</tr>
					</table>
			</form>		
			
		</div>	
		<br>
		<br>
		
		
	<%Customer customer=(Customer)request.getAttribute("customer");
		if(customer!=null)
		{
		%>
		<center>
		<div class="center">
		<form name="Detail" >
		<table id=""border="1">
					<tr>
						<th>Customer SSN ID:</th><th>Customer Id:</th><th>Customer Name:</th><th>Address:</th><th>Age:</th>	
					</tr>
					<tr>
						<td><%=customer.getSSN()%></td><td><%=customer.getCustId()%></td><td><%=customer.getName()%></td><td><%=customer.getAddress()%></td><td><%=customer.getAge()%></td>
					</tr>
						<td colspan="2" align="center"><a href="CustomerServlet?action=update&custid=<%=customer.getCustId()%>">UpdateCustomer </a></td>
						<td colspan="2" align="center"><a href="AccountServlet?action=deleteconfirm&custid=<%=customer.getCustId()%>" >DeleteCustomer</a></td>
					</tr>
				</table>
				</form>
				</div>
				</center>
		<%} %>
		
		<center><div class="home-link-container-div"><a href="CustExecLogin.jsp">HOME</a></div></center>
	</body>
</html>