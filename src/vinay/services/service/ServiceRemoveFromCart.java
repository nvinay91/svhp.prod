package vinay.services.service;

import vinay.framework.dao.RemoveFromCartDAO;

public class ServiceRemoveFromCart {

	public void execute(String cartId){
		
		String sql_stmnt = "delete from CART_DETAILS where cart_id=?";
		RemoveFromCartDAO.deleteRows(sql_stmnt, cartId);
	}
}
