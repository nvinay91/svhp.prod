<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List" %>
<%@ page import="vinay.services.model.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page='userDetails.jsp' />
	<jsp:include page='menu.jsp' />
	<input type="hidden" name="url" id="url" value=<%=request.getContextPath().toString() %>/>

	<section class="ftco-section">
	<div class="container">
		<div class="row justify-content-center">
			<div class="col-md-10 mb-5 text-center">
				<ul class="product-category">
					<li><a href="<%=request.getContextPath()%>/Items?param=A" id='a'
					 <%if(request.getParameter("param").equalsIgnoreCase("A") || request.getParameterMap().size() == 0) {%>
						class="active"
					<%}else{%>
					class="inactive"
					<%} %>>All</a></li>
					<li><a href="<%=request.getContextPath()%>/Items?param=SP" id='sp' 
					<%if(request.getParameter("param").equalsIgnoreCase("SP")) {%>
						class="active"
					<%}else{%>
					class="inactive"
					<%} %>>Spice Powders</a></li>
					<li><a href="<%=request.getContextPath()%>/Items?param=S" id='s' 
					<%if(request.getParameter("param").equalsIgnoreCase("S")) {%>
						class="active"
					<%}else{%>
					class="inactive"
					<%} %>>Snacks</a></li> 					
				</ul>
			</div>
		</div>
		<div class="row">
		<%if(null != request.getAttribute("items")){ 
			List<Items> items = (List<Items>)request.getAttribute("items");
			for(int i=0;i<items.size();i++){
				Items item = items.get(i);
		%>
		
			<div class="col-md-6 col-lg-3 ftco-animate">
				<div class="product">
				<!-- src="images/product-1.jpg" -->
					<a href="#" class="img-prod"><img class="img-fluid" data-imageId="<%=item.getPRD_CODE() %>"
						 src="data:image/jpg;base64,<%=item.getBase64Image() %>" alt="Colorlib Template"> <span
						class="status"><%=item.getOFFER_VALUE()+"%"%>
						</span>
						<div class="overlay"></div> </a>
					<div class="text py-3 pb-4 px-3 text-center">
						<h3>
							<a href="#"><%=item.getPRD_NAME() %></a>
						</h3>
						<div class="d-flex">
							<div class="pricing">
								<p class="price">
								<%float value = 0;
								float actual = Integer.valueOf(item.getPRD_AMOUNT());
								float offer = Integer.valueOf(item.getOFFER_VALUE());
								if(offer !=0){
									value = actual  - (actual * (offer/100));
								}else{
									value = actual;
								}
								%>
									<%if(offer !=0){ %><span class="mr-2 price-dc"><%=item.getPRD_AMOUNT()%></span>
									<%} %>
									<span class="price-sale"><%=value %>/KG</span> 
								</p>
							</div>
						</div>
						<div class="bottom-area d-flex px-3">
							<div class="m-auto d-flex">								
								<select class="add-to-cart d-flex justify-content-center align-items-center text-center" id="quantity">
	    								<option value="1"><i class="ion-ios-menu">1 KG</i></option>
	    								<option value="2"><i class="ion-ios-menu">1/2 KG</i></option>
	    								<option value="3"><i class="ion-ios-menu">1/4 KG</i></option>
	    						</select>
	    						<a href="#" id="cart" name="cart"
									class="buy-now d-flex justify-content-center align-items-center mx-1">
									<span><i class="ion-ios-cart"></i></span>
								</a> 
								<!-- <a href="#"
									class="heart d-flex justify-content-center align-items-center ">
									<span><i class="ion-ios-heart"></i></span>
								</a> -->
							</div>
						</div>
					</div>
				</div>
			</div>
		<%}} %>
		</div>


		<!-- <div class="row mt-5">
			<div class="col text-center">
				<div class="block-27">
					<ul>
						<li><a href="#">&lt;</a></li>
						<li class="active"><span>1</span></li>
						<li><a href="#">2</a></li>
						<li><a href="#">3</a></li>
						<li><a href="#">4</a></li>
						<li><a href="#">5</a></li>
						<li><a href="#">&gt;</a></li>
					</ul>
				</div>
			</div>
		</div> -->
	</div>
	</section>

	<footer> <jsp:include page='footer.jsp' /> </footer>

  <div id="ftco-loader" class="show fullscreen"><svg class="circular" width="48px" height="48px"><circle class="path-bg" cx="24" cy="24" r="22" fill="none" stroke-width="4" stroke="#eeeeee"/><circle class="path" cx="24" cy="24" r="22" fill="none" stroke-width="4" stroke-miterlimit="10" stroke="#F96D00"/></svg></div>


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
  <script src="js/utilities.js"></script>
</body>
</html>