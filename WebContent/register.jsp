<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register User</title>
<script src="js/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<link href="css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<link href="css/login.css" rel="stylesheet" id="bootstrap-css">

</head>
<body>
	<div class="sidenav">
		<div class="login-main-text">
			<h2>
				Sri Vadiraja Home Products<br>
			</h2>
			<img style="width: 90%;" alt="" src="images/logo.jpg">
		</div>
	</div>
	<div class="main">
		<form action="<%= request.getContextPath() %>/Register" method="post" style="padding-top:3%">
		<fieldset id='registration' >
		<legend>Registration</legend>
		<%String firstname = "";
					String lastname = "";
					String mobile = "";
					String email = "";
					String address1 = "";
					String address2 = "";
					String address3 = "";
					String pincode = "";
					if(request.getAttribute("firstname") != null ){
						firstname = (String)request.getAttribute("firstname");
					}
					if(request.getParameter("lastname") != null){
						lastname = (String)request.getParameter("lastname");
					}
					if(request.getParameter("mobile") != null){
						mobile = (String)request.getParameter("mobile");
					}
					if(request.getParameter("email") != null){
						email = (String)request.getParameter("email");
					}
					if(request.getParameter("address1") != null){
						address1 = (String)request.getParameter("address1");
					}
					if(request.getParameter("address2") != null){
						address2 = (String)request.getParameter("address2");
					}
					if(request.getParameter("address3") != null){
						address3 = (String)request.getParameter("address3");
					}
					if(request.getParameter("pincode") != null){
						pincode = (String)request.getParameter("pincode");
					}
					%>
			<div class="row">
				<div class="col">
					
					<input type="text" class="form-control" name="firstname" required placeholder="First name" value = "<%=firstname%>">
				</div>
				<div class="col">
					<input type="text" class="form-control" name="lastname" placeholder="Last name" value = "<%=lastname%>">
				</div>
				</div>
				<div class="row">
				<div class="col">
					<input type="text" class="form-control" name="mobile" required placeholder="Mobile" value = "<%=mobile%>">
				</div>
				<div class="col">
					<input type="text" class="form-control" name="email" placeholder="E-mail" value = "<%=email%>">
				</div>
				</div>
				<div class="row">
				<div class="col">
					<input type="text" class="form-control" name="address1" placeholder="Address" value = "<%=address1%>">
				</div>
				<div class="col">
					<input type="text" class="form-control" name="address2" placeholder="Address" value = "<%=address2%>">
				</div>
				</div>
				<div class="row">
				<div class="col">
					<input type="text" class="form-control" name="address3" placeholder="Near by Landmark" value = "<%=address3%>">
				</div>
				<div class="col">
					<input type="text" class="form-control" name="pincode" placeholder="Pin Code" value = "<%=pincode%>">
				</div>
			</div>
			<div class="row">
				<div class="col">
					<input type="password" class="form-control" name="password" placeholder="Password" required>
				</div>
				<div class="col">
					<input type="password" class="form-control" name="confirmpassword" placeholder="Confirm Password" required>
				</div>
			</div>
		<button type="submit" id="register" class="btn"
			style="border: solid 2px #82ae46">Register</button>
		</fieldset>
		<div style="background-color: #FFCCCC; width: 50%;border: 1px solid #009900 */">
			<%
				if(null!=request.getAttribute("errorMessage"))
			  {
					out.println(request.getAttribute("errorMessage"));
				}
			%>
		</div>
		
		</form>
	</div>	
</body>
</html>