<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Add Employee</h1>
	<form:form action="${pageContext.request.contextPath}/save" modelAttribute="employee">
		Enter name: <form:input path="name"/><br/>
		Select gender: <form:radiobutton path="gender" value="Male"/>Male&nbsp;
						<form:radiobutton path="gender" value="Female"/>Female&nbsp;<br/>
		Select Department: <form:select path="department">
			<form:option value="Development">Development</form:option>
			<form:option value="Support">Support</form:option>
			<form:option value="Testing">Testing</form:option>
			<form:option value="Business Analyst">Business Analyst</form:option>
		</form:select>
		<br/>
		Enter date of birth: <form:input path="dob" type="date"/><br/>
		<form:hidden path="id"/>
		<button type="submit">Save</button>
	</form:form>
	
</body>
</html>