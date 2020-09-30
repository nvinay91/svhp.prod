package vinay.framework.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import vinay.framework.constants.GenericModel;

public class RemoveFromCartDAO {

	public static void deleteRows(String sql_stmnt, String cartId) {
		Connection conn = GenericModel.getConn();
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			pstmt = conn.prepareStatement(sql_stmnt);
			pstmt.setString(1, cartId);
			synchronized (pstmt) {
				int save = pstmt.executeUpdate();
				System.out.println("result set:"+save);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
