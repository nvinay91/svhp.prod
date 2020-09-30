package vinay.framework.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import vinay.framework.adapter.CustomerContext;
import vinay.framework.constants.GenericModel;
import vinay.services.model.ServiceCartModel;

public class ServiceCartDao {

	public String getcartCount(ServiceCartModel model,String sql_stmnt) {
		Connection conn = GenericModel.getConn();
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String cartCount = "";
		try {
			pstmt = conn.prepareStatement(sql_stmnt);
			pstmt.setString(1, model.getInp_userId());
			pstmt.setString(2, "1");
			synchronized (pstmt) {
				rs = pstmt.executeQuery();
				if (rs.next()) {
					cartCount = rs.getString(1);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return cartCount;
	}
	
	public int insertNewProductToCart(ServiceCartModel obj,String sql_stmnt) throws SQLException {
		
		Connection conn = GenericModel.getConn();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String cartId = "";
		String offerId="";
		
		String sqlIdentifier = "select CART_SEQ.NEXTVAL from dual";
		pstmt = conn.prepareStatement(sqlIdentifier);
		synchronized( pstmt ) {
		   rs = pstmt.executeQuery();
		   if(rs.next())
			   cartId = String.valueOf((Long)rs.getLong(1));
		}
		
		String offer_sql = "select OFFER_ID from PRD_OFFERS where PRD_CODE="+obj.getInp_productId();
		pstmt = conn.prepareStatement(offer_sql);
		synchronized( pstmt ) {
		   rs = pstmt.executeQuery();
		   if(rs.next())
			   offerId = String.valueOf((Long)rs.getLong(1));
		}
		
		pstmt = conn.prepareStatement(sql_stmnt);
		pstmt.setString(1, cartId);
		pstmt.setString(2, CustomerContext.getInstance().getMOBILE());
		pstmt.setString(3, obj.getInp_productId());
		pstmt.setString(4, obj.getInp_quantity());
		pstmt.setTimestamp(5, new Timestamp(new java.util.Date().getTime()));
		pstmt.setString(6, offerId);
		pstmt.setString(7, "1");
		pstmt.setString(8, "1");
		pstmt.setString(9, "Added Succesfully");
		
		int save = pstmt.executeUpdate();
		System.out.println("result set:"+save);
		return save;
		
	}
}
