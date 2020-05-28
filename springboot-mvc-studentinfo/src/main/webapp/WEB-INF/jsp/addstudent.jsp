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
	<form action="${pageContext.request.contextPath}/addstudent"
		method="post">
		<div class="container-fluid">
			<h3>Add Student Information</h3>
			<p>
				First Name: <input type="text" name="firstName"
					value="${ student.firstName }">
			</p>
			<p>
				Last Name: <input type="text" name="lastName"
					value="${ student.lastName }">
			</p>
			<p>
				Age: <input type="text" name="age" value="${ student.age }">
			</p>
			<p>
				Email: <input type="text" name="email" value="${ student.email }">
			</p>
			<p>
				Course: <input type="text" name="course" value="${ student.course }">
			</p>
			<input type="submit" value="Add Student">
		</div>
	</form>
</body>
</html>