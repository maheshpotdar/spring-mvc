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
	<center>

		<table border="1px">
			<form:form action="loginFormAction" method="POST"
				modelAttribute="user">
				<tr>
					<td>UserName</td>
					<td><form:input path="userName" /> <form:errors
							path="userName" /></td>
				</tr>
				<tr>
					<td>Password</td>
					<td><form:input path="passWord" /> <form:errors
							path="passWord" /></td>
				</tr>

				<tr>
					<td colspan="2"><input type="submit" value="Login"></td>
				</tr>
				<tr>
					<td colspan="2"><a href="register">Register</a></td>
				</tr>
			</form:form>
		</table>
	</center>
</body>
</html>