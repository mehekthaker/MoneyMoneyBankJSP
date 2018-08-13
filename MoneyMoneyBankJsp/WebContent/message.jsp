<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Message</title>
</head>
<body>
<div align="center">
${requestScope.msg}

<jstl:if test="${requestScope.msg} != 'Does not meet Minimum Balance Requirement'">
<a href="">Click here to view account details</a>
</jstl:if>

<jstl:if test="${requestScope.msg} == 'Does not meet Minimum Balance Requirement'">
<p>Does not meet Minimum Balance Requirement</p>
</jstl:if>
</div>
</body>
</html>