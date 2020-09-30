package vinay.framework.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import vinay.framework.adapter.CustomerContext;
import vinay.framework.constants.GenericModel;
import vinay.services.model.LoginModel;
import vinay.services.model.ServiceLoginModel;

public class ServiceLoginDAO {

	public static Map<String, Object> fetchData(String sql_stmnt,
			ServiceLoginModel model) throws SQLException {
		Connection conn = GenericModel.getConn();
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String username = "";
		String password = "";
		try {
			pstmt = conn.prepareStatement(sql_stmnt);

			pstmt.setString(1, model.getUsername());
			pstmt.setString(2, model.getPassword());

			synchronized (pstmt) {
				rs = pstmt.executeQuery();
				if (rs.next()) {
					username = rs.getString(1);
					password = rs.getString(2);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("username", username);
		map.put("password", password);
		return map;

	}

	public static CustomerContext fetchCustomerData(String sql_stmnt,
			CustomerContext model) throws SQLException {
		Connection conn = GenericModel.getConn();
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			pstmt = conn.prepareStatement(sql_stmnt);

			pstmt.setString(1, model.getMOBILE());

			synchronized (pstmt) {
				rs = pstmt.executeQuery();
				if (rs.next()) {
					model.setREGISTRATION_NO(rs.getString(1));
					model.setFIRST_NAME(rs.getString(2));
					model.setLAST_NAME(rs.getString(3));
					model.setMOBILE(rs.getString(4));
					model.setEMAIL(rs.getString(5));
					model.setADDRESS1(rs.getString(6));
					model.setADDRESS2(rs.getString(7));
					model.setADDRESS3(rs.getString(8));
					model.setPIN_CODE(rs.getString(9));
					model.setCUSTOM_USER_ID(rs.getString(10));
					model.setCREATED_DATE(rs.getDate(11));
					model.setSTATUS(rs.getString(12));
					model.setGROUP_ID(rs.getString(13));
					model.setPASSWORD(rs.getString(14));
					model.setSTATUS_CD(rs.getString(15));
					model.setGROUP_CD(rs.getString(16));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return model;

	}

	public static Map<String, Object> fetchLoginData(String sql_stmnt,
			ServiceLoginModel model) throws SQLException {
		Connection conn = GenericModel.getConn();
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String username = "";
		Date lastLoginDate = null;
		String isLoggedIn = "";
		String attemptedCount = "";
		try {
			pstmt = conn.prepareStatement(sql_stmnt);

			pstmt.setString(1, model.getUsername());

			synchronized (pstmt) {
				rs = pstmt.executeQuery();
				if (rs.next()) {
					username = rs.getString(1);
					lastLoginDate = rs.getDate(2);
					isLoggedIn = rs.getString(3);
					attemptedCount = rs.getString(4);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("username", username);
		map.put("lastLoginDate", lastLoginDate);
		map.put("isLoggedIn", isLoggedIn);
		if(attemptedCount!="" && attemptedCount!= null){
			map.put("attemptedCount", attemptedCount);
		}else{
			map.put("attemptedCount", "0");
		}
		return map;

	}

	public static int insertOrUpdateLogin(String sql_logintable,
			LoginModel obj) throws SQLException {
		Connection conn = GenericModel.getConn();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		pstmt = conn.prepareStatement(sql_logintable);
		pstmt.setString(1, obj.getUSER_ID());
		pstmt.setString(2, obj.getIS_LOGGEDIN());
		pstmt.setString(3, obj.getMODE_OF_LOGIN());
		pstmt.setTimestamp(4, new Timestamp(obj.getCREATED_DATE().getTime()));
		pstmt.setString(5, obj.getATTEMPTED_COUNT());
		pstmt.setString(6, obj.getFAILED_DESC());
		pstmt.setTimestamp(7, new Timestamp(obj.getLAST_LOGIN_DATE().getTime()));
		
		int save = pstmt.executeUpdate();
		System.out.println("result set:"+save);
		return save;
	}
}
