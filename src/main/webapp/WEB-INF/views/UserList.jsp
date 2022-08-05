<%@page import="com.bean.UserBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User List</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
	integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2"
	crossorigin="anonymous">
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200" />
</head>
<body>
	<jsp:include page="AdminNavbar.jsp"></jsp:include>

	<table class="table table-striped">
		<thead>
			<tr>
				<th scope="col">#</th>
				<th scope="col">First Name</th>
				<th scope="col">Last Name</th>
				<th scope="col">Contact Number</th>
				<th scope="col">Email</th>
				<th scope="col">Gender</th>
				<th scope="col">Action</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${user}" var="u">
				<tr>
					<th scope="row">${u.userId}</th>


					<td>${u.firstName}</td>
					<td>${u.lastName}</td>
					<td>${u.mobileNo}</td>
					<td>${u.email}</td>
					<td>${u.gender}</td>

					<td><a href="viewexpense?userid=${u.userId }" class="btn btn-outline-success my-2 ">Expenses</a> 
					<a href="admincategorieslist?userid=${u.userId }" class="btn btn-outline-success my-2 ">Categories</a><a
						href="deleteuser?userid=${u.userId }"><span
							class="material-icons" style="color: red;"> delete </span></a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

</body>
</html>