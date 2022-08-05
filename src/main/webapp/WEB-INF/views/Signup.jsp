<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Signup</title>
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<style type="text/css">
@import "font-awesome.min.css";

@import "font-awesome-ie7.min.css";
/* Space out content a bit */
body {
	padding-top: 20px;
	padding-bottom: 20px;
}

/* Everything but the jumbotron gets side spacing for mobile first views */
.header, .marketing, .footer {
	padding-right: 15px;
	padding-left: 15px;
}

/* Custom page header */
.header {
	border-bottom: 1px solid #e5e5e5;
}
/* Make the masthead heading the same height as the navigation */
.header h3 {
	padding-bottom: 19px;
	margin-top: 0;
	margin-bottom: 0;
	line-height: 40px;
}

/* Custom page footer */
.footer {
	padding-top: 19px;
	color: #777;
	border-top: 1px solid #e5e5e5;
}

/* Customize container */
@media ( min-width : 768px) {
	.container {
		max-width: 730px;
	}
}

.container-narrow>hr {
	margin: 30px 0;
}

/* Main marketing message and sign up button */
.jumbotron {
	text-align: center;
	border-bottom: 1px solid #e5e5e5;
}

.jumbotron .btn {
	padding: 14px 24px;
	font-size: 21px;
}

/* Supporting marketing content */
.marketing {
	margin: 40px 0;
}

.marketing p+h4 {
	margin-top: 28px;
}

/* Responsive: Portrait tablets and up */
@media screen and (min-width: 768px) {
	/* Remove the padding we set earlier */
	.header, .marketing, .footer {
		padding-right: 0;
		padding-left: 0;
	}
	/* Space out the masthead */
	.header {
		margin-bottom: 30px;
	}
	/* Remove the bottom border on the jumbotron for visual effect */
	.jumbotron {
		border-bottom: 0;
	}
}
</style>
</head>
<body>

	<div class="container">
		<h1 class="well">Registration Form</h1>
		<div class="col-lg-12 well">
			<div class="row">
			<s:form action="saveuser" method="post" modelAttribute="user">
				
					<div class="col-sm-12">
						<div class="row">
							<div class="col-sm-6 form-group">
								<label>First Name</label> <s:input path="firstName"
									placeholder="Enter First Name Here.." class="form-control"/>
									<s:errors path="firstName"></s:errors>
							</div>
							<div class="col-sm-6 form-group">
								<label>Last Name</label> <s:input path="lastName"
									placeholder="Enter Last Name Here.." class="form-control"/>
									<s:errors path="lastName"></s:errors>
							</div>
						</div>
						<!-- <div class="form-group">
							<label>Address</label>
							<textarea placeholder="Enter Address Here.." rows="3"
								class="form-control"></textarea>
						</div> -->
						<!-- <div class="row">
							<div class="col-sm-4 form-group">
								<label>City</label> <input type="text"
									placeholder="Enter City Name Here.." class="form-control">
							</div>
							<div class="col-sm-4 form-group">
								<label>State</label> <input type="text"
									placeholder="Enter State Name Here.." class="form-control">
							</div>
							<div class="col-sm-4 form-group">
								<label>Zip</label> <input type="text"
									placeholder="Enter Zip Code Here.." class="form-control">
							</div>
						</div> -->

						<div class="form-group">
							<label>Phone Number</label> <s:input path="mobileNo"
								placeholder="Enter Phone Number Here.." class="form-control"/>
								<s:errors path="mobileNo"></s:errors>
						</div>
						<div class="form-group">
							<label>Email</label> <s:input
								placeholder="Enter Email Address Here.." path="email"
								class="form-control"/>
								<s:errors path="email"></s:errors>
						</div>
						<div class="row">
							<div class="col-sm-6 form-group">
								<label>Password</label> <s:password  path="password"
									placeholder="Enter Password Here.." class="form-control"/>
									<s:errors path="password"></s:errors>
							</div>
							<div class="col-sm-6 form-group">
								<label>Confirm-Password</label> <s:password path="confirm_password"									name="confirm_password"
									placeholder="Enter confirm-password Here.."
									class="form-control"/>
									<s:errors path="confirm_password"></s:errors>
							</div>
						</div>
						<div>
							<label>Gender :</label> <s:radiobutton  path="gender"
								value="male"/> <label>Male</label> <s:radiobutton
								path="gender" value="female"/> <label>Female</label><br>
								<s:errors path="gender"></s:errors>
						</div>
						<button type="submit" class="btn btn-lg " style="background-color: #008080;">Submit</button>
						<a href="login" class="btn btn-lg " style="float: right;background-color: #008080;">Login Here</a>
					</div>
				</s:form>
			</div>
		</div>
	</div>

</body>
</html>