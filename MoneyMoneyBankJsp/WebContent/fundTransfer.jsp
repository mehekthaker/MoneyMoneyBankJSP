<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Fund Transfer</title>
<style>body {
	background-color: palegoldenrod;
}</style>
</head>
<body>
<div>
	<jsp:include page="header.jsp"></jsp:include>
</div>
<div align= "center">
<p>Account Number: ${requestScope.reciever}  received  Rs.${requestScope.amount}  from  Account Number: ${requestScope.sender}</p>
</div>
<div>
	<jsp:include page="footer.jsp"></jsp:include>
</div>
</body>
</html>