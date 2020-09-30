<%@page import="vinay.framework.constants.GenericModel"%>
<%@page import="vinay.framework.adapter.CustomerContext"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="vinay.framework.*"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<nav
		class="navbar navbar-expand-lg navbar-dark ftco_navbar bg-dark ftco-navbar-light"
		id="ftco-navbar">
	<div class="container">
		<a class="navbar-brand" href="index.html">Sri Vadiraja Home
			Products</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#ftco-nav" aria-controls="ftco-nav"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="oi oi-menu"></span> Menu
		</button>

		<div class="collapse navbar-collapse" id="ftco-nav">
			<ul class="navbar-nav ml-auto">
				<li class="nav-item active"><a href="<%=request.getContextPath()%>/Items?param=A"
					class="nav-link">Shop</a></li>
				<!-- <li class="nav-item dropdown"><a
					class="nav-link dropdown-toggle" href="#" id="dropdown04"
					data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Actions</a>
					<div class="dropdown-menu" aria-labelledby="dropdown04">
						<a class="dropdown-item" href="shop.html">Shop</a> 
						<a class="dropdown-item" href="wishlist.html">Wishlist</a>
						<a
							class="dropdown-item" href="product-single.html">Single
							Product</a>  <a class="dropdown-item" href="cart.html">Cart</a>
						<a class="dropdown-item" href="checkout.html">Checkout</a>
					</div></li> -->
				<!-- <li class="nav-item"><a href="about.html" class="nav-link">About</a></li>
				<li class="nav-item"><a href="blog.html" class="nav-link">Blog</a></li> -->
				<%
					if (null != request.getAttribute("groupid")
							&& "1".equalsIgnoreCase(request.getAttribute("groupid")
									.toString())
							|| null != CustomerContext.getInstance().getGROUP_ID()
							&& "1".equalsIgnoreCase(CustomerContext.getInstance()
									.getGROUP_ID())) {
				%>
				<li class="nav-item"><a
					href="<%=request.getContextPath()%>/Admin" id="adminLink" class="nav-link">Admin</a></li>
				<%
					}
				%>
				<li class="nav-item"><a href="contact.html" class="nav-link">Contact</a></li>
				<%  String cartCount="0";
						cartCount = (String) GenericModel.getCartNumber();%>
				<li class="nav-item cta cta-colored"><a href="<%=request.getContextPath() %>/OpenCart"
					class="nav-link"><span class="icon-shopping_cart" id="CART">[<%=cartCount %>]</span></a></li>

			</ul>
		</div>
	</div>
	</nav>
</body>
</html>