<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h3 style="float: right">
		<a href="login">Home</a>
	</h3>
	<table border="1px">
		<form:form action="registerAdminActionForm" method="POST"
			modelAttribute="user">
			<tr>
				<td>UserName:<form:input path="userName" /></td>
			</tr>
			<tr>
				<td>PassWord:<form:password path="passWord" /></td>
			</tr>
			<tr>
				<td>Mobile:<form:input path="mobile" /></td>
			</tr>
			<tr>
				<td>Address:<form:input path="address" /></td>
			</tr>
			<tr>
				<td>Designation:<form:input path="designation" /></td>
			</tr>
			<tr>
				<td><input type="submit" value="Register"></td>
			</tr>
		</form:form>
	</table>
</body>
</html>