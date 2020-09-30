<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*" %>
<%@ page import="java.math.*" %>
<%@ page import="vinay.services.model.*" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="viewport" content="width=device-width">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page='userDetails.jsp' />
	<jsp:include page='menu.jsp' />
	<input type="hidden" name="url" id="url" value=<%=request.getContextPath().toString() %>/>




<form action="<%=request.getContextPath() %>\orders" method="POST">
<section class="ftco-section">
      <div class="container">
        <div class="row justify-content-center">
          <div class="col-xl-7 ftco-animate">
							<h3 class="mb-4 billing-heading">Billing Details</h3>
	          	<div class="row align-items-end">
	          		<div class="col-md-6">
	                <div class="form-group">
	                	<label for="firstname">Firt Name</label>
	                  <input type="text" class="form-control" placeholder="">
	                </div>
	              </div>
	              <div class="col-md-6">
	                <div class="form-group">
	                	<label for="lastname">Last Name</label>
	                  <input type="text" class="form-control" placeholder="">
	                </div>
                </div>
                <div class="w-100"></div>
		            <div class="col-md-12">
		            	<div class="form-group">
		            		<label for="country">State / Country</label>
		            		<div class="select-wrap">
		                  <div class="icon"><span class="ion-ios-arrow-down"></span></div>
		                  <input type="text" class="form-control" placeholder="Country name">
		                </div>
		            	</div>
		            </div>
		            <div class="w-100"></div>
		            <div class="col-md-6">
		            	<div class="form-group">
	                	<label for="streetaddress">Street Address</label>
	                  <input type="text" class="form-control" placeholder="House number and street name">
	                </div>
		            </div>
		            <div class="col-md-6">
		            	<div class="form-group">
	                  <input type="text" class="form-control" placeholder="Appartment, suite, unit etc: (optional)">
	                </div>
		            </div>
		            <div class="w-100"></div>
		            <div class="col-md-6">
		            	<div class="form-group">
	                	<label for="towncity">Town / City</label>
	                  <input type="text" class="form-control" placeholder="">
	                </div>
		            </div>
		            <div class="col-md-6">
		            	<div class="form-group">
		            		<label for="postcodezip">Postcode / ZIP *</label>
	                  <input type="text" class="form-control" placeholder="">
	                </div>
		            </div>
		            <div class="w-100"></div>
		            <div class="col-md-6">
	                <div class="form-group">
	                	<label for="phone">Phone</label>
	                  <input type="text" class="form-control" placeholder="">
	                </div>
	              </div>
	              <div class="col-md-6">
	                <div class="form-group">
	                	<label for="emailaddress">Email Address</label>
	                  <input type="text" class="form-control" placeholder="">
	                </div>
                </div>
                <div class="w-100">
                                <div class="col-md-12">
                	<!-- <div class="form-group mt-4">
										<div class="radio">
										  <label class="mr-3"><input type="checkbox" name="optradio"> Want to be a VIP User to avail COD option? </label>										  
										</div>
									</div> -->
                </div>
                </div>
	            </div>
			</div>
					<div class="col-xl-5">
			
	          <div class="row mt-5 pt-3">
	          	<div class="col-md-12 d-flex mb-5">
	          		<div class="cart-detail cart-total p-3 p-md-4">
	          			<h3 class="billing-heading mb-4">Cart Total</h3>
	          			<p class="d-flex">
		    						<span>Subtotal</span>
		    						<span><%=request.getAttribute("originalAmount") %></span>
		    					</p>
		    					<p class="d-flex">
		    						<span>Delivery</span>
		    						<span><%=request.getAttribute("shippingAmount") %></span>
		    					</p>
		    					<p class="d-flex">
		    						<span>Discount</span>
		    						<span><%=request.getAttribute("discountedValue") %></span>
		    					</p>
		    					<hr>
		    					<p class="d-flex total-price">
		    						<span>Total</span>
		    						<span><%=new BigDecimal(request.getAttribute("totalAmount").toString()) %></span>
		    					</p>
								</div>
	          	</div>
<p style="margin-left: 30%;"><input type="button" id="createOrder" class="btn btn-primary py-3 px-4" value="Place an order"></p>
<input type="hidden" id="amount" value="<%=new BigDecimal(request.getAttribute("totalAmount").toString()) %>"/>
<input type="hidden" id="currency" value="INR"/>
<input type="hidden" id="receipt_id" value=<%=1 %>/>

 <input type="hidden" id="orderId">
	          </div>
          </div> <!-- .col-md-8 -->
        </div>
      </div>
    </section> <!-- .section -->
</form>


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
  
   <script type="text/javascript">
   
// Function to lazy load a script
   // -----------------------------------------------
   var loadExternalScript = function(path) {
     var result = $.Deferred(),
         script = document.createElement("script");

     script.async = "async";
     script.type = "text/javascript";
     script.src = path;
     script.onload = script.onreadystatechange = function(_, isAbort) {
       if (!script.readyState || /loaded|complete/.test(script.readyState)) {
         if (isAbort)
           result.reject();
         else
           result.resolve();
       }
     };

     script.onerror = function() {
       result.reject();
     };

     $("head")[0].appendChild(script);

     return result.promise();
   };
//Use loadScript to load the Razorpay checkout.js
//-----------------------------------------------
var callRazorPayScript = function(itemId, amount, qty, processorId) {
var merchangeName = "S.V.H.P",
    img = "images/logo.jpg",
    name = "",
    description = "",
    amount = amount,
    qty = qty;
    
loadExternalScript('https://checkout.razorpay.com/v1/checkout.js').then(function() { 
  var options = {
    key: 'rzp_test_90qEymhpdc8P2M',
    protocol: 'https',
    hostname: 'api.razorpay.com',
    amount: amount,
    name: merchangeName,
    description: description,
    image: img,
    prefill: {
      name: name,
    },
    theme: {
      color: '#82ae46'
    },
    handler: function (transaction, response){
      console.log('Tshirt\\ntransaction id: ' + transaction.razorpay_payment_id);
      console.log(transaction.razorpay_payment_id);
    },error: function(transaction, response){
    	console.log('Tshirt\\ntransaction id: ' + transaction.razorpay_payment_id);
    }
  };

  window.rzpay = new Razorpay(options);

		console.log('Item Id: ', amount);
  console.log('Amount: ', amount);
  console.log('Quantity: ', qty);
  console.log('Processor Id: ', processorId);

  rzpay.open();
});
}

//Trigger call to action buttons depending on the bundle packs
//-----------------------------------------------
var $payBundle = $('#createOrder');

$payBundle.on('click', function() {
	var itemId = $(this).data('receipt_id'),
			amount =parseFloat($('#amount').val())*100,
			processorid = $('#amount').val(),
			qty = '1';

	callRazorPayScript(itemId, amount, processorid, qty);
});
 
 </script>
</body>
</html>