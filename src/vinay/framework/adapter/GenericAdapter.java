package vinay.framework.adapter;

import java.sql.SQLException;

import vinay.framework.dao.ServiceLoginDAO;

public class GenericAdapter {

	public static CustomerContext createCustomerContext(String loginId) {
		CustomerContext objCustomerContext = CustomerContext.getInstance();
		objCustomerContext.setMOBILE(loginId);
		try {
			ServiceLoginDAO.fetchCustomerData("Select REGISTRATION_NO,FIRST_NAME,LAST_NAME,MOBILE,EMAIL,ADDRESS1,ADDRESS2,ADDRESS3,PIN_CODE,CUSTOM_USER_ID,CREATED_DATE,STATUS,GROUP_ID,PASSWORD,STATUS_CD,GROUP_CD from USER_REGISTRATION where MOBILE = ?", objCustomerContext);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return objCustomerContext;
	}
}
