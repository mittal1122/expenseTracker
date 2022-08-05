<%@page import="com.bean.ExpenseBean"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Chart</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
	integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2"
	crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.6.0.min.js"
	integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4="
	crossorigin="anonymous"></script>

<script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
<body>
	<jsp:include page="UserNavbar.jsp"></jsp:include>


	<div class="container">
		<canvas id="myChart"></canvas>
	</div>



	<%
	List<ExpenseBean> expense = (List<ExpenseBean>) request.getAttribute("expense");
	%>
	<script>
		
		const data = {
			labels :[ 
				
				<%for (ExpenseBean cr : expense) {%>
				'<%=cr.getCat_name()%>',
				<%}%>
		]  ,
			datasets : [ {
				label : 'Expense Wise Investment',
				backgroundColor : 'rgb(255, 99, 132)',
				borderColor : 'rgb(255, 99, 132)',
				data : [ 
					<%for (ExpenseBean cr : expense) {%>
					<%=cr.getExp_amount()%>,
				<%}%> ],
			} ]
		};
		const config = {
			type : 'bar',
			data : data,
			options : {}
		};
	</script>
	<script>
		const myChart = new Chart(document.getElementById('myChart'),config);
	</script>
</body>
</html>