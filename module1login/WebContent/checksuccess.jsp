<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
out.println("your balance is:");
out.println(session.getAttribute("balance"));

%>
<br>
<br>
<a href="success.html"> Go to home page </a>
</body>
</html>