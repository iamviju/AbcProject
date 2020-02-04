<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
loan is applied successfully
<br>
<%
out.println("Your Loan detals:" );
%>
<br>
<%
out.println("principal amount:" + session.getAttribute("pamount"));
%>
<br>
<%
out.println("time:"+session.getAttribute("time"));
%>
<br>
<%
out.println("rate:"+session.getAttribute("rate"));
%>
<br>
<%
out.println("simple interest:" +session.getAttribute("simple_interest"));
%>
<br>
<br>
<a href="success.html"> Go to home page </a>

</body>
</html>