<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Withdraw</title>
<style>body {
	background-color: palegoldenrod;
}</style>
</head>
<body>
<div>
	<jsp:include page="header.jsp"></jsp:include>
</div>
<div align ="center">
<form id="withdraw" action="withdraw.app">
<table>
<tr><td>Enter account Number: </td><td><input type = "number" name="accNo" min=101 required="required"></td></tr>
<tr><td>Enter amount to be withdrawn:</td><td><input type="number" name="withdrawamount" min="0" required="required"></td></tr>
<tr><td><input type="submit" value="Withdraw"></td></tr>
</table>
</form>
<div>
	<jsp:include page="footer.jsp"></jsp:include>
</div>
</div>
</body>
</html>