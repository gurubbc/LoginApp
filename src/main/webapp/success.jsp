<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body bgcolor="green">
<h1> Success Page</h1>
<p> Welcome to the success page!</p>
<p> If you have landed in this page, that means you are a valid user </p>
<%
	String username= (String) request.getAttribute("userName");
	out.println("<h1> Hello " + username + "</h1>");
	out.println("Your login time is " + new java.util.Date() + "</h1>");
%>
</body>
</html>