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
	<div class="container-fluid">
		<h3>Add Student Information</h3>
		<p>${ student.firstName }</p>
		<p>${ student.lastName }</p>
		<p>${ student.age }</p>
		<p>${ student.email }</p>
		<p>${ student.studentId }</p>
		<p>${ student.course }</p>
	</div>
</body>
</html>