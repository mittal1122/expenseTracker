<%@page import="com.bean.UserBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Expense List</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
</head>
<body>
<% UserBean bean = (UserBean) session.getAttribute("user");
String usertype = bean.getUserType();
if(usertype.equals("admin")){
%><jsp:include page="AdminNavbar.jsp"></jsp:include>
<%}else{%>
	<jsp:include page="UserNavbar.jsp"></jsp:include>
<%}
%>
	<table class="table table-striped">
		<thead>
			<tr>
				<th scope="col">#</th>
				<th scope="col">Expense Name</th>
				<th scope="col">Location</th>
				<th scope="col">Expense Amount</th>
				<th scope="col">Expense Date</th>
				<th scope="col">Expense Time</th>
				<th scope="col">category</th>
				<th scope="col">Subcategory</th>
				<th scope="col">Account</th>
				<th scope="col">Payment Mode</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${expenseList}" var="expenseList">
			<tr>
				<th scope="row">${expenseList.expenseid}</th>
				
				
				<td>${expenseList.exp_name}</td>
				<td>${expenseList.exp_loc}</td>
				<td>${expenseList.exp_amount}</td>
				<td>${expenseList.exp_date}</td>
				<td>${expenseList.exp_time}</td>
				<td>${expenseList.cat_name}</td>
				<td>${expenseList.subcat_name}</td>
				<td>${expenseList.acc_name}</td>
				<td>${expenseList.acc_type}</td>
			</tr>
			</c:forEach>
		</tbody>
	</table>

</body>
</html>