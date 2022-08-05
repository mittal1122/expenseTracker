<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Subcategories</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
	integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2"
	crossorigin="anonymous">
</head>
<body>
	<jsp:include page="UserNavbar.jsp"></jsp:include>
	<section class="vh-100 gradient-custom">
		<div class="container py-5 h-100">
			<div class="row justify-content-center align-items-center h-100">
				<div class="col-12 col-lg-9 col-xl-7">
					<div class="card shadow-2-strong card-registration"
						style="border-radius: 20px;">
						<div class="card-body p-4 p-md-5">
							<h3 class="mb-4 pb-2 pb-md-0 mb-md-5">Add Sub Category</h3>
							<form action="subcategories" method="post">

								<div class="row">
									<div class="col-md-6 mb-4">

										<div class="form-outline">
											<label for="cars">Choose a Category:</label> <select
												name="catid">
												<option value="null" selected disabled>Select a Category</option>
												<c:forEach items="${category}" var="cat">
													<option value="${cat.catid}">${cat.cat_name}</option>
												</c:forEach>
											</select><br> ${error }<br>
											<br> <label class="form-label" for="firstName">SubCategory
												Name</label> <input id="firstName" name="subcat_name"
												class="form-control form-control-lg" value="" /> ${error }
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
</body>
</html>