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
<%String s=request.getParameter("ssnid"); 
if(s!=null)
	{%>
<p>Customer creation initiated successfully with SSNID:<%=request.getParameter("ssnid") %></p>
<%} %>

<%String str1=request.getParameter("custid1"); 
if(str1!=null)
	{%>
<p>Customer deletion initiated successfully with CustId:<%=request.getParameter("custid1") %></p>
<%} %>

<%String str2=request.getParameter("custid2");
if(str2!=null)
	{%>
<p>`Account Created Successfully with customer_id<%=str2 %></p>
<%} %>
<%String str=request.getParameter("custid8");
if(str!=null)
{
%>
<p>Customer update initiated successfully with custId:<%=str%>
<%} %>
<%String str3=request.getParameter("accid1");
if(str3!=null)
{
%>
<p>Account Deactivated Successfully with AccId:<%=str3%>
<%} %>

<center><div class="home-link-container-div"><a href="CustExecLogin.jsp">HOME</a></div></center></body>
</html>