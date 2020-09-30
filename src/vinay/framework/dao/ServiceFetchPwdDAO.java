package vinay.framework.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import vinay.framework.constants.GenericModel;
import vinay.services.model.ServiceFetchPwdModel;

public class ServiceFetchPwdDAO {

	public static String fetchData(String sql_stmnt, ServiceFetchPwdModel model) {
		Connection conn = GenericModel.getConn();
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String password = "";
		try {
			pstmt = conn.prepareStatement(sql_stmnt);
			pstmt.setString(1, model.getMobile());
			synchronized (pstmt) {
				rs = pstmt.executeQuery();
				if (rs.next()) {
					password = rs.getString(1);
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}

		return password;
	}

}
