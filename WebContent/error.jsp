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
			<h1>Bank Management System</h1><span id="logout-btn" class="pull-right"><a href="LoginController?action=logout">Logout</a></span>
		</nav>
		<%String s=request.getParameter("ssnid"); 
if(s!=null)
	{int a=Integer.parseInt(s);
	%>
	
<p>Customer already exist <%=a%></p>
<%} %>

<%String str1=request.getParameter("custid1"); 
if(str1!=null)
	{%>
<p>Error occurred while deleting a customer</p>
<%} %>

<%String str2=request.getParameter("custid2");
if(str2!=null)
	{%>
<p>`Account Already Exist with customer_id<%=str2 %></p>
<%} %>
<%String str=request.getParameter("custid8");
if(str!=null)
{
%>
<p>Error occurred while updating a customer details</p>
<%} %>
<%String str3=request.getParameter("accid1");
if(str3!=null)
{
%>
<p>Error Occurred while deactivating a account</p>
<%} %>
<%String str4=request.getParameter("searchid");
if(str3!=null)
{
%>
<p>Error Occurred while searching a record please check your input</p>
<%} %>

<center><div class="home-link-container-div"><a href="CustExecLogin.jsp">GO TO HOME</a></div></center>
</body>
</html>