<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="vinay.services.model.*" %>
<%@ page import="java.util.*" %>
<%@ page import="java.io.*,java.util.*, javax.servlet.*" %>
<%@ page import="javax.servlet.http.*" %>
<%@ page import="org.apache.commons.fileupload.*" %>
<%@ page import="org.apache.commons.fileupload.disk.*" %>
<%@ page import="org.apache.commons.fileupload.servlet.*" %>
<%@ page import="org.apache.commons.io.output.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:include page='userDetails.jsp' />
<jsp:include page='menu.jsp' />
<div id="product" class="float-right product" style="
    height: 400px;
    width: 335px;    
    margin: 20px;
    overflow-y:auto">
<p>Available Products</p>
<table class="table-dark table-striped table-bordered table-hover" name="products">
  <thead>
    <tr>
      <th style="width:10%" scope="col">Product Id</th>
      <th style="width:10%" scope="col">Product Name</th>
    </tr>
  </thead>
  <tbody>
  <%if(null != request.getAttribute("items")){ 
			List<Items> items = (List<Items>)request.getAttribute("items");
			for(int i=0;i<items.size();i++){
				Items item = items.get(i);
				Map<String,Object> map = new HashMap<String,Object>();
				map.put("OFFER_VALUE",item.getOFFER_VALUE());
				map.put("PRD_AMOUNT",item.getPRD_AMOUNT());
				map.put("PRD_CODE",item.getPRD_CODE());
				map.put("PRD_CTGRY",item.getPRD_CTGRY());
				map.put("PRD_NAME",item.getPRD_NAME());				
				%>
    <tr>
      <th scope="row"><%=item.getPRD_CODE()%></th>
      <td><a href ="#" data-params="<%=map%>" id=><%=item.getPRD_NAME()%></a></td>
    </tr>
    <%}} %>
  </tbody>
 </table>
</div>
<form action="<%=request.getContextPath()%>/Product" enctype="multipart/form-data" class="billing-form" method="post">
	<input type="hidden" name="mode" id="mode">
	<section class="ftco-section1">
		<div class="container1">
			<div class="row justify-content-center">
			<div id="errorMessage" style="background-color: #FFCCCC; width: 200%;border: 1px solid #009900 */">
			<%
				if(null!=session.getAttribute("errorMessage"))
			  {
					out.println(session.getAttribute("errorMessage"));
				}
			%>
		</div>
		         
			<div id="successMessage"
				style="background-color: #82ae46; width: 200%; border: #009900">
				<%
					if (null != session.getAttribute("successMessage")) {
						out.println(session.getAttribute("successMessage"));
					}
				%>
				</div>
				<div class="col-xl-10 ftco-animate"> 
						<h3 class="mb-4 billing-heading">Add/Update Product</h3>
						<div class="row align-items-end">
							<div class="col-md-6">
								<div class="form-group">
									<label for="firstname">Product Id</label> <input name="productId" style="color: black !important;" type="text"
										class="form-control" id="productId">
								</div>
							</div>
							<div class="col-md-6">
								<div class="form-group">
									<label for="lastname">Product Name</label> <input name="productName" type="text" style="color: black !important;"
										class="form-control" id="productName">
								</div>
							</div>
							<div class="w-100"></div>
							<div class="col-md-6">
								<div class="form-group">
									<label for="country">Product Category</label>
									<div class="select-wrap">
										<div class="icon">
											<span class="ion-ios-arrow-down"></span>
										</div>
										<select name="category" id="category" class="form-control" style="color: black !important;">
											<option value=" ">Select</option>
											<option value="1">Spice Powder</option>
											<option value="2">Snacks</option>
										</select>
									</div>
								</div>
							</div>
							<div class="col-md-6">
								<div class="form-group">
									<label for="lastname">Product Amount</label> <input type="text" style="color: black !important;"
										class="form-control" name="productAmount" id="productAmount">
								</div>
							</div>
							<div class="w-100"></div>
							<div class="col-md-6">
								<div class="form-group">
									<label for="streetaddress">Product Image</label> <input
										type="file" class="form-control" style="color: black !important;" name="image" id="image">
								</div>
							</div>
							<div class="w-100"></div>
							<div class="col-md-6">
								<div class="form-group"> 
									<label for="towncity">Discount Value in %</label> <input type="text"
										class="form-control" id="offerValue" style="color: black !important;" name="offerValue">
								</div>
							</div>
						</div>
						<button type="submit" id="create">Create New Product</button>
						<button type="submit" id="modify">Update Existing Product</button>
							 <%-- <p style="display:inline"><a href="<%=request.getContextPath()%>/Product?mode=1" class="btn btn-primary py-3 px-4" id="create">Create New Product</a></p>
							 <p style="display:inline"><a href="<%=request.getContextPath()%>/Product?mode=2" class="btn btn-primary py-3 px-4" id="update">Update Existing Product</a></p> --%>
				</div>
			</div>
			<!-- END -->
		</div>
	</section>
 </form>
	<!-- .section -->
	<!-- loader -->
	<div id="ftco-loader" class="show fullscreen">
		<svg class="circular" width="48px" height="48px">
			<circle class="path-bg" cx="24" cy="24" r="22" fill="none"
				stroke-width="4" stroke="#eeeeee" />
			<circle class="path" cx="24" cy="24" r="22" fill="none"
				stroke-width="4" stroke-miterlimit="10" stroke="#F96D00" /></svg>
	</div>


	<script src="js/jquery.min.js"></script>
	<script src="js/jquery-migrate-3.0.1.min.js"></script>
	<script src="js/popper.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/jquery.easing.1.3.js"></script>
	<script src="js/jquery.waypoints.min.js"></script>
	<script src="js/jquery.stellar.min.js"></script>
	<script src="js/owl.carousel.min.js"></script>
	<script src="js/jquery.magnific-popup.min.js"></script>
	<script src="js/aos.js"></script>
	<script src="js/jquery.animateNumber.min.js"></script>
	<script src="js/bootstrap-datepicker.js"></script>
	<script src="js/scrollax.min.js"></script>
	<script src="js/main.js"></script>

	<script>
		$(document).ready(function() {
			
			$("table[name='products'] a").click(function(){
				var map={};
				//map = $(this).data("params");
				map = convertString($(this).data("params"),map);
				$("#productId").val(map.PRD_CODE);
				$("#productName").val(map.PRD_NAME);
				$("#category").val(map.PRD_CTGRY);
				$("#productAmount").val(map.PRD_AMOUNT);
				$("#offerValue").val(map.OFFER_VALUE);
			});
			
			$("#create").click(function(){
				$("#mode").val("1");
			});
			
			$("#modify").click(function(){
				$("#mode").val("2");
			});
		});
		
		function convertString(string,map) {
				var tmap={};
				string = string.slice(1, string.length - 1);
		      string.split(', ').map(function(a) {
		        var kvArr = a.split('=');
				map[kvArr[0]]=kvArr[1];
		      });
		        return map;
		}
	</script>

</body>
</html>