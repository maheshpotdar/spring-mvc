<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="m" uri="http://java.sun.com/jsp/jstl/core"%>
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
	<table border="2px">
		<tr>
			<td>ID</td>
			<td>Name</td>
			<td>Password</td>
			<td>Mobile</td>
			<td>Address</td>
			<td>Designation</td>
			<td>Edit</td>
			<td>Delete</td>
		</tr>
		<m:forEach var="pr" items="${lst}">
			<tr>
				<td>${pr.id}</td>&nbsp;&nbsp;
				<td>${pr.userName}</td>&nbsp;&nbsp;
				<td>${pr.passWord}</td>&nbsp;&nbsp;
				<td>${pr.mobile}</td>&nbsp;&nbsp;
				<td>${pr.address}</td>&nbsp;&nbsp;
				<td>${pr.designation}</td>
				<td><a href="edituser/${pr.id}"><input type="submit"
						value="Edit forms"></a></td>
				<td><a href="deleteuser/${pr.id}"><input type="submit"
						value="Delete forms"></td>
				<td></td>
			</tr>
		</m:forEach>
	</table>
</body>
</html>