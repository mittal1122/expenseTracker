<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Expense</title>

</head>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
	integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2"
	crossorigin="anonymous">
<body>
	<jsp:include page="UserNavbar.jsp"></jsp:include>
	<section class="vh-10" style="background-color: #eee;">
		<div class="container h-50">
			<div
				class="row d-flex justify-content-center align-items-center h-50">
				<div class="col-lg-12 col-xl-11">
					<div class="card text-black" style="border-radius: 25px;">
						<div class="card-body p-md-5">
							<div class="row justify-content-center">
								<div class="col-md-10 col-lg-6 col-xl-5 order-2 order-lg-1">

									<p class="text-center h1 fw-bold mb-5 mx-1 mx-md-4 mt-1">Add
										Expense</p>
									<s:form class="mx-1 mx-md-4" action="expense" method="post"
										modelAttribute="expenseBean">


										<div class="d-flex flex-row align-items-center mb-4">
											<div class="form-outline flex-fill mb-0">
												<s:input path="exp_name" id="form3Example1c"
													class="form-control" placeholder="Expense Name" />

												<s:errors path="exp_name"></s:errors>
											</div>
										</div>
										<div class="d-flex flex-row align-items-center mb-4">

											<div class="form-outline flex-fill mb-0">
												<s:input path="exp_loc" id="form3Example1c"
													class="form-control" placeholder="Location" />

												<s:errors path="exp_loc"></s:errors>
											</div>
										</div>
										<div class="d-flex flex-row align-items-center mb-4">

											<div class="form-outline flex-fill mb-0">
												<s:input path="exp_amount" id="form3Example1c"
													class="form-control" placeholder="Expense Amount" />
												<s:errors path="exp_amount"></s:errors>
											</div>
										</div>
									
										<div class="d-flex flex-row align-items-center mb-4">
											<div class="form-outline flex-fill mb-0">
												<input name="exp_date" id="form3Example1c"
													class="form-control" value="${expenseBean.exp_date }" readonly /> 

											</div>
										</div>
										<div class="d-flex flex-row align-items-center mb-4">
											<div class="form-outline flex-fill mb-0">
												<input name="exp_time" id="form3Example1c"
													class="form-control" value="${expenseBean.exp_time }" readonly /> 

											</div>
										</div>



										<div class="form-outline">
											<label class="form-label">Choose a Category:</label>
											<s:select path="catid" id="catid">
												<option value="" selected disabled>Select a Category</option>
												<c:forEach items="${category}" var="cat">
													<option value="${cat.catid}"
														class="form-control form-control-lg">${cat.cat_name}</option>
												</c:forEach>
											</s:select>
											<BR>
											<s:errors path="catid"></s:errors>
										</div>
										<br>
										<div class="form-outline">
											<label class="form-label">Choose a Subcate :</label>
											<s:select path="subcatid" id="subcategory">
												<option value="" selected disabled>Select a Subcategory</option>
											</s:select>
											<BR>
											<s:errors path="subcatid"></s:errors>
										</div>
										<br>
										<div class="form-outline">
											<label class="form-label">Choose a Payment Mode :</label>
											<s:select path="accountTypeid" id="accounttypeid">
												<option value="" selected disabled>Select a Payment Mode</option>
												<c:forEach items="${AccountType}" var="type">
													<option value="${type.accountTypeid}"
														class="form-control form-control-lg">${type.acc_type}</option>
												</c:forEach>
											</s:select>
											<BR>
											<s:errors path="accountTypeid"></s:errors>
										</div>
										<br>
										<div class="form-outline">
											<label class="form-label">Choose a account :</label>
											<s:select path="accountid" id="accounts">
												<option value="" selected disabled>BankName  Account NO. Balance</option>
												
											</s:select>
											<BR>
											<s:errors path="accountid"></s:errors>
										</div>
										<br>
										<div class="d-flex justify-content-center mx-4 mb-3 mb-lg-4">
											<button type="submit" class="btn btn-primary btn-lg">Add Expense</button>
										</div>
									</s:form>
								</div>
								<div
									class="col-md-10 col-lg-6 col-xl-7 d-flex align-items-center order-1 order-lg-2">

									<img
										src="https://mdbcdn.b-cdn.net/img/Photos/new-templates/bootstrap-registration/draw1.webp"
										class="img-fluid" alt="Sample image">

								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
	<script src="https://code.jquery.com/jquery-3.6.0.min.js"
	integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4="
	crossorigin="anonymous"></script>
	<script>
		$(document).ready(function(){
			$("#catid").change(function(){
				var id = document.getElementById("catid").value;
				let url = "http://localhost:9998/subcategory?catid="+id;
				$.get(url)
				.done(function(data){
					console.log(data);
					let subcategory = $("#subcategory");
					subcategory.empty();
					for(let i=0;i<data.length;i++){ 
						subcategory.append("<option value="+data[i].subcatid+">"+data[i].subcat_name+"</option>");
					}
					
				}).fail(function(){
					console.log("something went wrong"); 
				});
	})	
})

$(document).ready(function(){
			$("#accounttypeid").change(function(){
				var id = document.getElementById("accounttypeid").value;
				let url = "http://localhost:9998/accountsbytype?accounttypeid="+id;
				$.get(url)
				.done(function(data){
					console.log(data);
					let subcategory = $("#accounts");
					subcategory.empty();
					for(let i=0;i<data.length;i++){ 
						subcategory.append("<option value="+data[i].accountid+">"+data[i].acc_name+"  "+data[i].acc_no+"  "+"Rs."+data[i].newbalance+"</option>");
					}
					
				}).fail(function(){
					console.log("something went wrong"); 
				});
	})	
})
	</script>

</body>
</html>