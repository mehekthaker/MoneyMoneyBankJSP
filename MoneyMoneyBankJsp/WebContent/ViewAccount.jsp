
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
body {
	background-color: palegoldenrod;
}
</style>
</head>
<body>
	<div>
		<jsp:include page="header.jsp"></jsp:include>
	</div>
	<div align="center">
		<h1>Account Holder List</h1>
		<jstl:if test="${requestScope.bankAccount != null }">
			<table>
				<tr>
					<th>Account Number</th>
					<th>Customer ID</th>
					<th>Account Type</th>
					<th>Account Balance</th>
					<jstl:if test="${classType.equals('MMCurrentAccount')}">
						<th>OD Limit</th>
					</jstl:if>
					<jstl:if test="${classType.equals('MMSavingsAccount')}">
						<th>Salary</th>
					</jstl:if>

				</tr>
				<tr>
					<td>${bankAccount.accountNumber}</td>
					<td>${bankAccount.customer.customerId}</td>
					<td>${classType}</td>
					<td>${bankAccount.accountBalance}</td>
					<jstl:if test="${classType.equals('MMCurrentAccount')}">
						<td>${bankAccount.odLimit}</td>
					</jstl:if>
					<jstl:if test="${classType.equals('MMSavingsAccount')}">
						<td>${bankAccount.salaryValue}</td>
					</jstl:if>
			</table>
		</jstl:if>
		<jstl:if test="${requestScope.bankAccount == null }">
			<h4>No ACCOUNT Found!</h4>
		</jstl:if>
	</div>
	<div>
		<jsp:include page="footer.jsp"></jsp:include>
	</div>
</body>
</html>