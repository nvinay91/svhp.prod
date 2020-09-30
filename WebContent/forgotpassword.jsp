<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Forgot Password</title>
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
		<form action="<%=request.getContextPath()%>/SendOTP" method="post"
			style="padding-top: 3%">

			<fieldset id='Forgot Password'>
				<legend>Forgot Password</legend>
				<%
					String mobileNumber = "";
					if (null != request.getAttribute("mobile")) {
						mobileNumber = (String) request.getAttribute("mobile");
					}
					String otp = "", URL = request.getContextPath().toString();
					if (null != request.getAttribute("otpValue")) {
						otp = String.valueOf(request.getAttribute("otpValue"));
					}
				%>

				<!-- 				<div class="row">
					<div class="col">

						<input type="text" class="form-control" name="email"
							placeholder="E-Mail">
					</div>
				</div>
				<center>Or</center>
				<br /> -->
				<div class="row">
					<div class="col">
						<input type="text" class="form-control" name="mobile" id="mobile"
							placeholder="Mobile" value="<%=mobileNumber%>">
					</div>
				</div>
				<button type="submit" id="sendOTPBtn" class="btn"
					style="border: solid 2px #82ae46">Send OTP</button>

				<br /> <br />

				<div class="row">
					<div class="col">
						<input type="text" class="form-control" name="validateOTP"
							id="validateOTP" placeholder="Enter OTP">
					</div>
				</div>
				<button type="button" id="validate" class="btn"
					style="border: solid 2px #82ae46">Validate</button>
				<span class="countdown" id="count"></span>
			</fieldset>
			<br />
			<div style="background-color: #FFCCCC; width: 70%; border: #82ae46"
				id="displayerrorMessage">
				<%
					if (null != request.getAttribute("errorMessage")) {
						out.println(request.getAttribute("errorMessage"));
					}
				%>
			</div>
			<div style="background-color: #82ae46; width: 70%; border: #009900"
				id="displaysuccessMessage">
				<%
					if (null != request.getAttribute("successMessage")) {
						out.println(request.getAttribute("successMessage"));
					}
				%>
			</div>
			<input type="hidden" class="form-control" id="otp" name="otp"
				value="<%=otp%>"> <input type="hidden" class="form-control"
				id="url" name="url" value="<%=URL%>"> <input type="hidden"
				class="form-control" id="mobileNumber" name="mobileNumber"
				value="<%=mobileNumber%>">
		</form>
	</div>
	<script>
		$(document).ready(function() {
			if($("#mobileNumber").val() == null || $("#mobileNumber").val()== ""){
				$("#mobile").attr("disabled",false);
				$("#validateOTP,#validate").attr("disabled",true);
			}else{
				startTimer();
			}
			$("#validate").click(function() {
				var messageotp = $("#otp").val();
				var enteredotp = $("#validateOTP").val();
				if (enteredotp == messageotp) {
					
					$.ajax({
						url : $("#url").val()+"/FetchPwd?mobile="+$("#mobileNumber").val(),
						dataType:"json",
						success : function(result) {
							$("#displayerrorMessage").hide();
							$("#displaysuccessMessage").show();
							$("#displaysuccessMessage").html("Your Password is:- "+result);
						},
						error : function(result) {
							if(result.responseText != null){
								$("#displayerrorMessage").hide();
								$("#displaysuccessMessage").show();
								$("#displaysuccessMessage").html("Your Password is:- "+result.responseText);
							}else{
							$("#displaysuccessMessage").hide();
							$("#displayerrorMessage").show();
							$("#displayerrorMessage").html("No user present for this Mobile number. Please Register...");
							}
						}
					});
				} else {
					$("#displaysuccessMessage").hide();
					$("#displayerrorMessage").show();
					$("#displayerrorMessage").html("Please Enter Valid OTP..");
				}
			});
		});
		
		$("#sendOTPBtn").click(function(){				
			$("#validateOTP,#validate").attr("disabled",false);
			$("#mobileNumber").val($("#mobile").val());
			return true;
		});
		
		function startTimer(){
			var counter = 120;
			   setInterval(function() {
			     counter--;
			      if (counter >= 0) {
			         span = document.getElementById("count");
			         span.innerHTML =  "<span style='color:red'> OTP Expires in "+counter +"</span>";
			      }
			      if (counter === 0) {
			         alert('sorry, out of time');
			         clearInterval(counter);
			       }
			     }, 1000);
		}
	</script>
</body> 
</html>