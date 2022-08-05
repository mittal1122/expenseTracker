<%@page import="com.bean.UserBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Category</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
	integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2"
	crossorigin="anonymous">
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
	<%= usertype %>
	<section class="vh-100 gradient-custom">
		<div class="container py-5 h-100">
			<div class="row justify-content-center align-items-center h-100">
				<div class="col-12 col-lg-9 col-xl-7">
					<div class="card shadow-2-strong card-registration"
						style="border-radius: 20px;">
						<div class="card-body p-4 p-md-5">
							<h3 class="mb-4 pb-2 pb-md-0 mb-md-5">Add Category</h3>
							<form action="categories" method="post">

								<div class="row">
									<div class="col-md-6 mb-4">

										<div class="form-outline">
											<label class="form-label" for="firstName">Category
												Name</label> <input id="firstName" name="cat_name"
												class="form-control form-control-lg" /> ${error }
											<%-- <s:errors path="cat_name"></s:errors> --%>
										</div>


									</div>
								</div>
								<div class="mt-4 pt-2">
									<input class="btn btn-primary btn-lg" type="submit" value="Add" />
								</div>

							</form>
						</div>
					</div>
				</div>
			</div>
</div>
</section>
			
	<script>
		/* $(document).ready(function(){
			$("#btnGo").click(function(){
						let url = "http://localhost:9998/categories";	
						 	 
						$.get(url)
						.done(function(data){
							console.log(data);
							let category = $("#category");
							for(let i=0;i<data.length;i++){ 
								category.append("<option value="+data[i].categoryId+">"+data[i].categoryName+"</option>");
							}
							
						}).fail(function(){
							console.log("something went wrong"); 
						});
			})	
		}) */
	</script>

</body>
</html>