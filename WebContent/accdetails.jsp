<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
       <%@ page import="com.model.Account" %>
       <%@ page import="java.util.*" %>
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
		
		
	
		<div id="body-page" class="center">
			<form name="searchCustomer" action="AccountServlet" method="get">
				<table>
					<th colspan="2">Account Details</th>
					<tr>
						<td>Customer SSN ID:</td><td><input type="number" name="ssnid"></td>
					</tr>
					<tr>
						<td>Customer Id:</td><td><input type="number" name="custid"></td>
					</tr>
				<tr>
						<td colspan="2" align="center"><input type="submit" class="btn btn-primary" name="action" value="Search"></td>
					</tr>
					</table>
			</form>		
			
		</div>	
		<br>
		<br>
	<%ArrayList<Account> accList=(ArrayList<Account>)request.getAttribute("account");
		if(accList!=null)
		{
		%>
		<div class="center display-table-container">
		<form name="Detail" >
		<table class="display-table" align="center"> 
		<tr>
		<th>Customer Id</th>
		<th>Account ID</th>
		<th>Account Type</th>
		<th>Balance</th>
		<th>CR Date</th>
		<th>CR LastDate</th>
		</tr>
		<%for(Account a:accList) 
		{%>
				<tr>	
					<td><%=a.getCustId()%></td>
					<td><%=a.getAccId()%></td>
					<td><%=a.getAccType()%></td>
					<td><%=a.getBalance()%></td>
					<td><%=a.getCrdate()%></td>
					<td><%=a.getCrlastdate()%></td>
					<td colspan="2" align="center"><a href="AccountServlet?action=delete&accid=<%=a.getAccId()%>">DeleteAccount</a></td>
					</tr>
					<%} %>
				</table>
				</form>
				</div>
		<%} %>
		
		<center><div class="home-link-container-div"><a href="CustExecLogin.jsp">HOME</a></div></center>
	</body>
</html>