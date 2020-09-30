package vinay.services.service;

import java.sql.SQLException;

import vinay.framework.dao.ServiceCartDao;
import vinay.services.model.ServiceCartModel;

public class ServiceCart {
	
	public String getCartCount(ServiceCartModel model){
		ServiceCartDao dao = new ServiceCartDao();
		String cartCount = "";
		
		String sql_stmnt = "Select count(*) from CART_DETAILS where USER_ID=? and STATUS=?";
		cartCount = dao.getcartCount(model, sql_stmnt);

		
		
		return cartCount;
	}

	public int insertNewProductToCart(ServiceCartModel model) throws SQLException {
		ServiceCartDao dao = new ServiceCartDao();
		
		String sql_stmnt = "INSERT INTO CART_DETAILS (CART_ID, USER_ID, PRD_CODE, PRD_QUANTITY, CREATED_DATE, OFFER_ID, MOD_OF_TXN, STATUS, REMARKS) VALUES (?,?,?,?,?,?,?,?,?)";
		int rows = dao.insertNewProductToCart(model, sql_stmnt);
		
		return rows;		
	}
}
