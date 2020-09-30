<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Sri Vadiraja Home Products</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
</head>
<body>
	<jsp:include page='userDetails.jsp' />
	<jsp:include page='menu.jsp' />
	<!-- END nav -->

	<%--<section id="home-section" class="hero">
	<div class="home-slider owl-carousel" style="height:80%"">
	 <jsp:include page="slider.jsp"></jsp:include> 

		<
	</div>
	</section>--%>		
 
	<%-- <section class="ftco-section">
	<div class="container">
		<!-- <div class="row justify-content-center mb-3 pb-3">
			<div class="col-md-12 heading-section text-center ftco-animate">
				<span class="subheading">Featured Products</span>
				<h2 class="mb-4">Our Products</h2>
				<p>Much better price, Prepared with love and care.</p>
			</div>
		</div> --> 
	</div>
	<div class="container">
		<div class="row">
			<jsp:include page='items.jsp'/>
		</div>
	</div>
	</section> --%>

	<section class="ftco-section img"
		style="background-image: url(images/bg_3.jpg);">
	<div class="container">
		<jsp:include page="deals.jsp"></jsp:include>	
	</div>
	</section>

<section class="ftco-section">
	<div class="container">
		<jsp:include page="features.jsp"></jsp:include> 
	</div>
	</section>
	
<%-- <jsp:include page="feedback.jsp"></jsp:include> --%>
	<hr> 

	<section class="ftco-section ftco-no-pt ftco-no-pb py-5 bg-light">
	<div class="container py-4">
		<div class="row d-flex justify-content-center py-5">
			<div class="col-md-6">
				<h2 style="font-size: 22px;" class="mb-0">Subcribe to our
					Newsletter</h2>
				<span>Get e-mail updates about our latest shops and special
					offers</span>
			</div>
			<div class="col-md-6 d-flex align-items-center">
				<form action="#" class="subscribe-form">
					<div class="form-group d-flex">
						<input type="text" class="form-control"
							placeholder="Enter email address"> <input type="submit"
							value="Subscribe" class="submit px-3">
					</div>
				</form>
			</div>
		</div>
	</div>
	</section>

<footer>
<jsp:include page='footer.jsp'/>
</footer>



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
	<script
		src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBVWaKrjvy3MaE7SQ74_uJiULgl1JY0H2s&sensor=false"></script>
	<script src="js/google-map.js"></script>
	<script src="js/main.js"></script>


</body>
</html>