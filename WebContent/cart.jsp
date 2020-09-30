<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="vinay.services.model.*" %>
<%@ page import="java.util.List" %>
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
<%OpenCartModel model = (OpenCartModel) request.getAttribute("CART_MODEL"); 
float discountedValue = 0,shippingAmount=0;
float totalPrice = 0;
float originalAmount = 0;%>
<input type="hidden" id="url" name="url" value="<%=request.getContextPath()%>"/>
<section class="ftco-section ftco-cart">
			<div class="container">
				<div class="row">
    			<div class="col-md-12 ftco-animate">
    				<div class="cart-list">
	    				<table class="table">
						    <thead class="thead-primary">
						      <tr class="text-center">
						        <th>&nbsp;</th>
						        <th>&nbsp;</th>
						        <th>Product name</th>
						        <th>Price</th>
						        <th>Quantity</th>
						        <th>Total</th>
						      </tr>
						    </thead>
						    <tbody>
						    <%for(int i=0;i<model.getCartList().size();i++){ 
						    	CartModel objCartModel = (CartModel) model.getCartList().get(i);
								Items items = objCartModel.getItem();
								
						    	%>
						      <tr class="text-center">
						        <td class="product-remove"><a href="#" id="remove" data-params="<%=objCartModel.getCartId() %>"><span class="ion-ios-close"></span></a></td>
						        
						        <td class="image-prod"><div class="img" style="background-image:url(data:image/jpg;base64,<%=items.getBase64Image() %>);"></div></td>
						        <td class="product-name">
						        	<h3><%=items.getPRD_NAME() %></h3>						        	
						        </td>
						        
						        <td class="price"><%=items.getPRD_AMOUNT() %></td>
						        
						        <td class="quantity">
						        
						        	<div class="input-group mb-3 ">
					             		<input type="button" value="-" class="quantity-left-minus">
					             		<input type="text" id="quantity" name="quantity" style="height: 65px !important;" class="quantity form-control input-number" value="<%=objCartModel.getProductQuantity() %>" min="1" max="100">
					             		<input type="button" value="+" class="quantity-right-plus">
					          		</div>
					          </td>
						        <%
								float actual = Float.valueOf(items.getPRD_AMOUNT());
						        originalAmount = originalAmount + actual;
						        if(originalAmount!=0){
						        	shippingAmount = 30;
						        }
								float offer = Integer.valueOf(items.getOFFER_VALUE());
								if(offer !=0){
									discountedValue = discountedValue + (actual * (offer/100));
								}else{
									discountedValue = discountedValue + 0;
								} %>
						        <td class="total"><%=(actual*Float.valueOf(objCartModel.getProductQuantity()))%></td>
						      </tr><!-- END TR-->						    
						      <%} %>  
						    </tbody>
						  </table>
					  </div>
    			</div>
    		</div>
    		<div class="row justify-content-end">
    			<div class="col-lg-4 mt-5 cart-wrap ftco-animate">
    				<div class="cart-total mb-3">
    					<h3>Coupon Code</h3>
    					<p>Enter your coupon code if you have one</p>
  						<form action="#" class="info">
	              <div class="form-group">
	              	<label for="">Coupon code</label>
	                <input type="text" class="form-control text-left px-3" placeholder="">
	              </div>
	            </form>
    				</div>
    				<p><a href="#" class="btn btn-primary py-3 px-4">Apply Coupon</a></p>
    			</div>
    			<div class="col-lg-4 mt-5 cart-wrap ftco-animate">
    				<div class="cart-total mb-3">
    					<h3>Shipping Details</h3>
    					<p>Know whether shipping is available in your area..</p>
  						<form action="#" class="info">	              
	              <div class="form-group">
	              	<label for="country">Zip/Postal Code</label>
	                <input type="text" class="form-control text-left px-3" placeholder="">
	              </div>
	            </form>
    				</div>
    				<p><a href="#" class="btn btn-primary py-3 px-4">Submit</a></p>
    			</div>
    			<div class="col-lg-4 mt-5 cart-wrap ftco-animate">
				<form action="<%=request.getContextPath() %>/Checkout" id="cart-sumbit" name="cart-submit" method="post">
    				<div class="cart-total mb-3">
    				<input type="hidden" name="originalAmount" id="originalAmount" value="<%=originalAmount %>"/>
    				<input type="hidden" name="shippingAmount" id="shippingAmount" value="<%=shippingAmount %>"/>
    				<input type="hidden" name="discountedValue" id="discountedValue" value="<%=discountedValue %>"/>
    				<input type="hidden" name="totalAmount" id="totalAmount" value="<%=(originalAmount+shippingAmount)-discountedValue %>"/>
    					<h3>Cart Totals</h3>
    					<p class="d-flex">
    						<span>Subtotal</span>
    						<span id="subTotal"><%=originalAmount %></span>
    					</p>
    					<p class="d-flex">
    						<span>Shipping</span>
    						<span id="shipping"><%=shippingAmount %></span>
    					</p>
    					<p class="d-flex">
    						<span>Discount</span>
    						<span id="discount"><%=discountedValue %></span>
    					</p>
    					<hr>
    					<p class="d-flex total-price">
    						<span>Total</span>
    						<span id="finalAmt"><%=(originalAmount+shippingAmount)-discountedValue %></span>
    					</p>
    				</div>
    				<p>
    					<input type="hidden" name="hrefVal" id="hrefVal" value="<%=request.getContextPath() %>/Checkout?originalAmount=<%=originalAmount %>&shippingAmount=<%=shippingAmount %>&discountedValue=<%=discountedValue %>&totalAmount=<%=(originalAmount+shippingAmount)-discountedValue %>" />
    					<!-- <a href="#" id="proceedToCheckout" class="btn btn-primary py-3 px-4">Proceed to Checkout</a> -->
    					<input type="submit" name="submit" value="Proceed to Checkout" class="btn btn-primary py-3 px-4"/>    					
    				</p>
    			</form>
    			</div>
    		</div>
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