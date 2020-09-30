package vinay.framework.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;

import vinay.framework.constants.GenericModel;
import vinay.services.model.ServiceRegistrationModel;

public class ServiceRegistrationDAO {

	public static int insertOrUpdate(String sql_stmnt, ServiceRegistrationModel obj)
			throws SQLException {
		Connection conn = GenericModel.getConn();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String registrationNo = "";
		
		
		String sqlIdentifier = "select USER_REGISTRATION_SEQ.NEXTVAL from dual";
		pstmt = conn.prepareStatement(sqlIdentifier);
		synchronized( pstmt ) {
		   rs = pstmt.executeQuery();
		   if(rs.next())
			   registrationNo = String.valueOf((Long)rs.getLong(1));
		}
		
		pstmt = conn.prepareStatement(sql_stmnt);
		pstmt.setString(1, registrationNo);
		pstmt.setString(2, obj.getFirstname());
		pstmt.setString(3, obj.getLastname());
		pstmt.setString(4, obj.getMobile());
		pstmt.setString(5, obj.getEmail());
		pstmt.setString(6, obj.getAddress1());
		pstmt.setString(7, obj.getAddress2());
		pstmt.setString(8, obj.getAddress3());
		pstmt.setString(9, obj.getPincode());
		pstmt.setString(10, "");
		pstmt.setTimestamp(11, new Timestamp(System.currentTimeMillis()));
		pstmt.setString(12, "1");
		pstmt.setString(13, "1");
		pstmt.setString(14, obj.getPassword());
		pstmt.setString(15, "100");
		pstmt.setString(16, "101");
		int save = pstmt.executeUpdate();
		System.out.println("result set:"+save);
		return save;
	}
}
