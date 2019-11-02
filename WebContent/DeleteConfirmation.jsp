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
			<h1>Bank Management System</h1>
		</nav>
		
		<%ArrayList<Account> accList=(ArrayList<Account>)request.getAttribute("acclist");
		if(accList!=null)
		{%>
		
		<form >
		 
			<table align="center">
				
				<tr><td>Your Current Account Balance is</td>
				</tr>
				<tr>
				<th>Account Type</th>
				<th>Balance</th>
				</tr>
				<%for(Account a:accList)
					{%>
				<tr>
				<td><%=a.getAccType() %></td>
				<td><%=a.getBalance() %></td>
				</tr>
				<%} %>
				<tr>
					<td colspan="2"><a href="CustomerServlet?action=delete&custid=<%=request.getParameter("custid")%>">Delete Customer</a></td>
					<td ><a href="CustomerServlet?action=deleteaccount&custid=<%=request.getParameter("custid")%>">Delete Account</a></td>
					<td><a href="Search.jsp">No</a></td>
					</tr>
			</table>
			<h6>Note: Your balance will set to 0 if you delete your account</h6>
			<h6>If you delete customer accounts related to customer will be deleted along with customer</h6>
		</form>
		<%} %>		
			<center><div class="home-link-container-div"><a href="CustExecLogin.jsp">HOME</a></div></center>
	</body>
</html>