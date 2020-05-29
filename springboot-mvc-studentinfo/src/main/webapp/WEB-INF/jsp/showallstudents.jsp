<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
<script type="text/javascript">
	function deleteStudent(url) {
		$('#delete_student').attr('action', url).submit();
	}

	function goHome() {
		$('#go_home').submit();
	}
</script>
<title>Student Info</title>
</head>
<body>
	<div class="container-fluid">
		<h3 class="font-weight-bold">Students</h3>
		<br></br>
		<div class="table-responsive">
			<table class="table table-striped">
				<thead>
					<tr>
						<th>Id</th>
						<th>First Name</th>
						<th>Last Name</th>
						<th>Age</th>
						<th>Email</th>
						<th>Course</th>
						<th>Edit/Delete</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${ students }" var="student">
						<tr>
							<td>${ student.studentId }</td>
							<td>${ student.firstName }</td>
							<td>${ student.lastName }</td>
							<td>${ student.age }</td>
							<td>${ student.email }</td>
							<td>${ student.course }</td>
							<td><a
								href="${pageContext.request.contextPath}/updatestudent?studentid=${student.studentId}">Edit</a>&nbsp;<a
								href="javascript:deleteStudent('${pageContext.request.contextPath}/deletestudent/${student.studentId}?_method=DELETE')">Delete</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<br></br>
		<button type="button" class="btn btn-success"
			onclick="javascript:goHome()">Home</button>
	</div>
	<!-- As HTTP PUT and DELETE not supported by HTML let's use POST method to delete data -->
	<!-- https://stackoverflow.com/questions/165779/are-the-put-delete-head-etc-methods-available-in-most-web-browsers -->
	<!-- Example URL: ${pageContext.request.contextPath}/deletestudent/${student.studentId}?_method=DELETE" -->
	<form action="" method="post" id="delete_student"></form>
	<form action="${pageContext.request.contextPath}/home" id="go_home"></form>
</body>
</html>