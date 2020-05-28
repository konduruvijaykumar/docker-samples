<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>Student Info</title>
</head>
<body>
	<form action="${pageContext.request.contextPath}/home">
		<div class="container-fluid">
			<h3>Student Information</h3>
			<p>Student Id: ${ student.studentId }</p>
			<p>First Name: ${ student.firstName }</p>
			<p>Last Name: ${ student.lastName }</p>
			<p>Age: ${ student.age }</p>
			<p>Email: ${ student.email }</p>
			<p>Course: ${ student.course }</p>
			<br></br>
			<input type="submit" value="Go Home">
		</div>
	</form>
</body>
</html>