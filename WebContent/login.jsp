<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
<script src="js/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<link href="css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<link href="css/login.css" rel="stylesheet" id="bootstrap-css">

<script>
$(document).ready(function(){
	$("#register").click(function(){
		$("#param").val("register");
		return true;
	});
});
</script>
</head>
<body>

<div class="sidenav">
         <div class="login-main-text">
            <h2>Sri Vadiraja Home Products<br></h2>
            <img style="width: 90%;" alt="" src="images/logo.jpg" >
         </div>
      </div>
      <div class="main">
         <div class="col-md-6 col-sm-12">
            <div class="login-form">   
            <div style="background-color: #FFCCCC; width: 200%;border: 1px solid #009900 */">
			<%
				if(null!=request.getAttribute("errorMessage"))
			  {
					out.println(request.getAttribute("errorMessage"));
				}
			%>
		</div>
		         
			<div
				style="background-color: #82ae46; width: 200%; border: #009900">
				<%
					if (null != request.getAttribute("successMessage")) {
						out.println(request.getAttribute("successMessage"));
					}
				%>
				</div>
				<br/>	
               <form action="<%=request.getContextPath() %>/Login" method="post">
                  <div class="form-group">
                     <label>User Name</label>
                     <input type="text" class="form-control" name="username" placeholder="User Name">
                  </div>
                  <div class="form-group">
                     <label>Password</label>
                     <input type="password" class="form-control" name="password" placeholder="Password">
                  </div>
                  <button type="submit" id="login" class="btn" style="background-color:#82ae46">Login</button>
                  <button type="submit" id="register" class="btn" style="border:solid 2px #82ae46">Register</button>
                  <a href="<%= request.getContextPath()%>/Login?param=forgotPwd">Forgot Password?</a>
      			 <input type="hidden" name="param" id="param" value="" />      			      			 
               </form> 
            </div>
         </div>
      </div>
      
            
</body>
</html>