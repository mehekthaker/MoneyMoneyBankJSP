<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core" %>
	<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>MM Bank</title>
<style>body {
	background-color: lightsalmon;
}</style>
</head>
<body>
<div>
	<jsp:include page="header.jsp"></jsp:include>
</div>

<div align="center">
<h3>Enter Account Holder Details</h3>
<form id="basic" method="post" action="add.app">
<table>
<tr><td>Name:</td><td> <input type="text" name="customerName" required="required"></td></tr>
<tr><td>Email-id: </td><td><input type="email" name="customerEmail" required="required"></td></tr> 
<tr><td>Date of Birth:	</td><td><input type="date" name="dob" required="required"></td></tr>
<tr><td>Contact Number: </td><td><input type="tel" name="contact" min=10 max=10 required="required"></td></tr>
<tr><td>Account Type:	</td><td><select id="accountType" name="accountType" onchange="setButton();" required="required">
<option value="default" selected="selected">----SELECT----</option>
<option value="savingaccount">Saving Account</option>
<option value="currentaccount" >Current Account</option>
</select>
</td></tr>
<tr><td>
<div id="sa" style="display:none">
<input type="radio" id="salary" name="salary" value="Blue" onclick="setBalance(this.value);">Salary<input type="radio" id="salary" name="salary" value="Red" onclick="setBalance(this.value);">Not Salaried
</div>
</td></tr>
<tr><td>
<div id="ca" style="display:none">
Enter Over Draft Limit:<input type="number" min=0 name="odLimit" >
Enter account balance:<input type="number" min=10000 name="cbal" >
</div>
</td></tr>
<tr><td>
<div id="salbal" style="display:none">
Enter Opening Balance: <input type="number" name="salbal" min=0 placeholder="Minimum 0" >
</div>
</td></tr>
<tr><td>
<div id="bal" style="display:none">
Enter Opening Balance: <input type="number" name="bal" min=5000 placeholder="Minimum 5000">
</div>
</td></tr>
<tr><td align="center"><input type="submit" value="Create Account"></td><td align="center"><input type="reset" value="Clear"></td></tr>
</table>
</form>
</div>
<div>
	<jsp:include page="footer.jsp"></jsp:include>
</div>
</body>
<script>
function setButton(){
var dropdown = document.getElementById("accountType");
var type= dropdown.options[dropdown.selectedIndex].value;
if(type == "savingaccount"){
document.getElementById("sa").style.display = "block";
document.getElementById("ca").style.display = "none";
}else if(type == "currentaccount"){
document.getElementById("ca").style.display = "block";
document.getElementById("sa").style.display = "none";
}
else if(type == "default"){
document.getElementById("sa").style.display = "none";
document.getElementById("ca").style.display = "none";
}
}
function setBalance(bal){
switch (bal)
{
case "Blue":
document.getElementById("salbal").style.display = "block";
document.getElementById("bal").style.display = "none";
break
case "Red":
document.getElementById("bal").style.display = "block";
document.getElementById("salbal").style.display = "none";
break
}
}
</script>
</html>