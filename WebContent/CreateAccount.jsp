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
		<script src="createAccountValidation.js"></script>
		<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
	</head>
	<body>
		
		<nav id="heading-page" class="nav nav-bar">
			<h1>Bank Management System</h1><span id="logout-btn" class="pull-right"><a href="LoginController?action=logout">Logout</a></span>
		</nav>
		
	
			<form name="createAccount" action="AccountServlet" method="post">
				<table class="center container-form center">
					<tr>
						<th class="center-align-th" colspan="2">CREATE ACCOUNT</th>
					</tr>
					<tr>
						<td>Customer ID:</td><td><input type="number" name="custid" id="custid" placeholder=" Social Security No" onblur="validateCustId()"/></td>
					</tr>
					
					<tr>
						<td>Account Type:</td><td><select name="accType" id="accType" onblur="validateCustId()">
														<option value="">---SELECT---</option>
														<option value="S">SAVINGS ACCOUNT</option>
														<option value="C">CURRENT ACCOUNT</option>
													</select></td>
					</tr>
					
					<tr>
						<td>Deposit Amount:</td><td><input type="number" name="damount" id="damount" placeholder=" (in INR)" onkeyup="validateCustId()"/></td>
					</tr>
					
					<tr>
						<td colspan="2" class="btn-center"><button type="submit" class="btn btn-success" id="btn-create-acc" disabled>Submit</button></td>
					</tr>
					</table>
			</form>		
			
			<center><div class="home-link-container-div"><a href="CustExecLogin.jsp">HOME</a></div></center>			
			<div id="footer-login">	Copyright &copy; TVM53 TJA281 Group E</div>
	</body>
</html>