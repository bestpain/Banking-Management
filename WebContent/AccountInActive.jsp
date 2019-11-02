<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%ArrayList<Integer> accidList=(ArrayList<Integer>)request.getAttribute("accidList");
if(accidList!=null)
{
%>
<p>Accounts with following AccountId are Deactivated and Balance is set to 0 !!!</p>
<%for(Integer a:accidList)
{
%>
<p><%=a%>
<%} %>
<%} %>
<center><div class="home-link-container-div"><a href="CustExecLogin.jsp">HOME</a></div></center>
</body>
</html>