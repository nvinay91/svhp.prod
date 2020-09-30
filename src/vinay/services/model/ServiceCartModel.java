package vinay.services.model;

import java.util.ArrayList;
import java.util.List;

public class ServiceCartModel {
	private List<CartModel> cartList = new ArrayList<CartModel>();
	private String inp_quantity;
	private String inp_productId;
	private String inp_userId;
	
	public String getInp_userId() {
		return inp_userId;
	}

	public void setInp_userId(String inp_userId) {
		this.inp_userId = inp_userId;
	}

	public String getInp_quantity() {
		return inp_quantity;
	}

	public void setInp_quantity(String inp_quantity) {
		this.inp_quantity = inp_quantity;
	}

	public String getInp_productId() {
		return inp_productId;
	}

	public void setInp_productId(String inp_productId) {
		this.inp_productId = inp_productId;
	}

	public List<CartModel> getCartList() {
		return cartList;
	}

	public void setCartList(List<CartModel> cartList) {
		this.cartList = cartList;
	}

}
