package vinay.services.model;

import java.util.ArrayList;
import java.util.List;

public class OpenCartModel {
	public List<CartModel> cartList = new ArrayList<CartModel>();

	public List<CartModel> getCartList() {
		return cartList;
	}

	public void setCartList(List<CartModel> cartList) {
		this.cartList = cartList;
	}
}
