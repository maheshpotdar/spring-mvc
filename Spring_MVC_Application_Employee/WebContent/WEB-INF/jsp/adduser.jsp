<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body bgcolor="cyan">

	<center>
		<h1>Add Employee Form</h1>
		<h3 style="float: right">
			<a href="login">Home</a>
		</h3>
		<br>
		<table border="3px">
			<form:form action="insertUser" method="POST" modelAttribute="user">
				<tr>
					<td>Name:</td>
					<td><form:input path="userName" /></td>
				</tr>
				<tr>
					<td>Password:</td>
					<td><form:input path="passWord" /></td>
				</tr>
				<tr>
					<td>Mobile:</td>
					<td><form:input path="mobile" /></td>
				</tr>
				<tr>
					<td>Address:</td>
					<td><form:input path="address" /></td>
				</tr>
				<tr>
					<td>Designation:</td>
					<td><form:input path="designation" /></td>
				</tr>
				<tr>
					<td colspan="2"><input type="submit" value="Submit" /></td>
				</tr>

			</form:form>
		</table>


	</center>
</body>
</html>