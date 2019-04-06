<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body bgcolor="cyan">
	<center>
		<form:form method="POST"
			action="/Spring_MVC_Application_Employee/updateuser/${user.id}"
			modelAttribute="user">
			<h3 style="float: right"><a href="login">Home</a></h3>
			<table border="3px">
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
					<td>Admin Approve</td>
					<td><form:checkbox path="aprv" /></td>
				</tr>
				<tr>
					<td colspan="2"><input type="submit" value="Submit" /></td>
				</tr>
			</table>
		</form:form>

	</center>
</body>
</html>