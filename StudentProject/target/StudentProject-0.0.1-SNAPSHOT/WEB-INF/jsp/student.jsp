<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ include file="/WEB-INF/jsp/includes.jsp"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
<title>Student Management</title>
</head>
<body>
	<div class="container">
		<div class="page-header">
			<h1 class="display-4">Students Data - Page Header</h1>
		</div>
	</div>
	<form:form action="student.do" method="POST" commandName="student">
		<table class="table">
			<tr>
				<td>ID</td>
				<td><form:input path="id" /></td>
			</tr>
			<tr>
				<td>School year</td>
				<td><form:input path="schoolYear" /></td>
			</tr>
			<tr>
				<td>Campus</td>
				<td><form:input path="campus" /></td>
			</tr>
			<tr>
				<td>Student ID</td>
				<td><form:input path="studentId" /></td>
			</tr>
			<tr>
				<td>Entry Date</td>
				<td><form:input path="entryDate" /></td>
			</tr>
			<tr>
				<td>Grade Level</td>
				<td><form:input path="gradeLevel" /></td>
			</tr>
			<tr>
				<td>Name</td>
				<td><form:input path="name" /></td>
			</tr>
			<tr>
				<td colspan="2"><input class="btn btn-secondary" type="submit"
					name="action" value="Add" /> <input class="btn btn-secondary"
					type="submit" name="action" value="Edit" /> <input
					class="btn btn-danger" type="submit" name="action" value="Delete" />
					<input class="btn btn-secondary" type="submit" name="action"
					value="Search" /></td>
			</tr>
		</table>
	</form:form>
	<br>
	<h1 class="display-4">Students List Data Table</h1>
	<table class="table">
		<thead class="thead-dark">
			<tr>
				<th scope="col">ID</th>
				<th scope="col">School Year</th>
				<th scope="col">Campus</th>
				<th scope="col">Student ID</th>
				<th scope="col">Entry Date</th>
				<th scope="col">Grade Level</th>
				<th scope="col">Name</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${studentList}" var="student">
				<tr>
					<td>${student.id}</td>
					<td>${student.schoolYear}</td>
					<td>${student.campus}</td>
					<td>${student.studentId}</td>
					<td>${student.entryDate}</td>
					<td>${student.gradeLevel}</td>
					<td>${student.name}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<!-- Footer -->
	<footer class="page-footer font-small unique-color-dark pt-4">

	<!-- Footer Elements -->
	<div class="container">

		<!-- Call to action -->
		<ul class="list-unstyled list-inline text-center py-2">
			<li class="list-inline-item">
				<h5 class="mb-1">Footer Display</h5>
			</li>
			<li class="list-inline-item"><a href="#!"
				class="btn btn-outline-white btn-rounded">Sign up!</a></li>
		</ul>
		<!-- Call to action -->

	</div>
	<!-- Footer Elements --> <!-- Copyright -->
	<div class="footer-copyright text-center py-3">
		© 2019 Copyright: <a
			href="https://mdbootstrap.com/education/bootstrap/">
			SampleWebsite.com</a>
	</div>
	<!-- Copyright --> </footer>
	<!-- Footer -->
</body>
</html>