<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Account</title>
</head>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
	integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2"
	crossorigin="anonymous">
<body>
	<jsp:include page="UserNavbar.jsp"></jsp:include>
	<section class="vh-100 gradient-custom">
		<div class="container py-5 h-100">
			<div class="row justify-content-center align-items-center h-50">
				<div class="col-12 col-lg-9 col-xl-7">
					<div class="card shadow-2-strong card-registration"
						style="border-radius: 20px;">
						<div class="card-body p-4 p-md-5">
							<h3 class="mb-4 pb-2 pb-md-0 mb-md-5">Add Account</h3>
							<s:form action="accounts" method="post" modelAttribute="account">

								<div class="row">
									<div class="col-md-6 mb-4">

										<div class="form-outline">
											<label class="form-label" for="firstName">Account Name / Bank Name</label> <s:input  path="acc_name"
												class="form-control form-control-lg" placeholder="Account Name" /> <s:errors path="acc_name"></s:errors>
										</div><br>
										<div class="form-outline">
											<label class="form-label" for="firstName">Account Number</label> <s:input  path="acc_no"
												class="form-control form-control-lg" placeholder="Account Number" /> <s:errors path="acc_no"></s:errors>
										</div><br>
										<div class="form-outline">
										<label  class="form-label">Choose a Payment Mode :</label> <s:select
												path="accounttypeid">
												<option value="" selected>Select a Payment Mode</option>
												<c:forEach items="${accType}" var="type">
													<option value="${type.accounttypeid}" class="form-control form-control-lg">${type.acc_type}</option>
												</c:forEach>
											</s:select><BR>
											<s:errors path="accounttypeid"></s:errors>
										</div><br>
										<div class="form-outline">
											<label class="form-label" for="firstName">Account Balance</label> <s:input  path="acc_balance"
												class="form-control form-control-lg" placeholder="Account Balance"  /> <s:errors path="acc_balance"></s:errors>
										</div>
										


									</div>
								</div>
								<div class="mt-4 pt-2">
									<input class="btn btn-primary btn-lg" type="submit" value="Add" />
								</div>

							</s:form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
</body>
</html>