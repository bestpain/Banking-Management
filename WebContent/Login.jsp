<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
		<meta charset="ISO-8859-1">
		<title>Insert title here</title>
		<link rel="stylesheet" href="index.css">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<script src="loginValidation.js"></script>
		<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
	</head>
</head>
<body>
	
		<nav id="heading-page" class="nav nav-bar">
			<h1>Bank Management System</h1>
		</nav>
	<form action="LoginController?action=login" method="post">
		<table  id="login-table" class="center">
			<tr>
				<th colspan="2" id="login-th">Login</th>
			</tr>
			<tr>
				<td>Login as:</td><td><input type="radio" value="custexec" name="loginas" id="custexec" onclick="checkLoginas()">&nbsp;Customer Executive&nbsp;&nbsp;&nbsp;
									  <input type="radio" value="cashier" name="loginas" id="cashier"onclick="checkLoginas()">&nbsp;Cashier</td>
			</tr>
		
			<tr>
				<td>Identification no:</td><td><input type="alphanumeric" name="idno" id="idno" placeholder=" eg: ABC123" onblur="idcheck()" disabled></td>
			</tr>
			<tr>
				<td>Password:</td><td><input type="password" name="pswd" id="pswd" onblur="pswdCheck()" disabled></td>
			</tr>
			<tr>
				<td colspan="2" class="btn-align-center btn-center"><button type="submit" class="btn btn-success" id="submit-button-login" disabled>Submit</button></td>
			</tr>
			
		</table>
		</form>
		<div class="alert alert-danger alert-box-resizing center" id="login-alert" role="alert" hidden>
 					 
		</div>
		
		<div id="footer-login">	Copyright &copy; TVM53 TJA281 Group E</div>
</body>
</html>