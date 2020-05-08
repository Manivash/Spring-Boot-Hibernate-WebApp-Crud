<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Employees List</h1>
	<table border="1">
		<tr>
			<th>Name</th>
			<th>Gender</th>
			<th>Department</th>
			<th>DOB</th>
			<th>Actions</th>
		</tr>
		<c:forEach items="${list}" var="e">
			<tr>
				<td>${e.name}</td>
				<td>${e.gender}</td>
				<td>${e.department}</td>
				<td>${e.dob}</td>
				<td><a href = "${pageContext.request.contextPath}/employee/?id=${e.id}">Edit</a> | <a href = "${pageContext.request.contextPath}/delete/${e.id}">Delete</a></td>
			</tr>
		</c:forEach>
	</table>
	<button onclick="window.location.href = '${pageContext.request.contextPath}/showEmployeeForm'">Add Employee</button>
</body>
</html>