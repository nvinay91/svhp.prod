package vinay.services.service;

import java.sql.Date;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import vinay.framework.dao.ServiceLoginDAO;
import vinay.framework.interfaces.AbstractBusinessService;
import vinay.services.model.LoginModel;
import vinay.services.model.ServiceLoginModel;

public class ServiceLogin implements AbstractBusinessService {

	@Override
	public Object execute(HttpServletRequest request, Object object) {
		int _return = 0;
		ServiceLoginModel model = (ServiceLoginModel) object;
		String sql_stmt = "Select MOBILE,PASSWORD from USER_REGISTRATION where MOBILE=? and PASSWORD=?";
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			map = ServiceLoginDAO.fetchData(sql_stmt, model);
			if (model.getPassword().equalsIgnoreCase(
					map.get("password").toString())) {
				_return = 1;
			} else if (!model.getPassword().equalsIgnoreCase(
					map.get("password").toString())) {
				_return = 2;
			}
//			_return = validateCustomerSession(_return, model);
		} catch (SQLException e) {
			e.printStackTrace();
			_return = 0;
		}

		return _return;
	}

	private int validateCustomerSession(int _return, ServiceLoginModel model) throws SQLException {
		String sql_stmnt = "Select USER_ID,LAST_LOGIN_DATE,IS_LOGGEDIN,ATTEMPTED_COUNT from USER_LOGIN where USER_ID=? order by LAST_LOGIN_DATE desc";
		Map<String,Object> map = ServiceLoginDAO.fetchLoginData(sql_stmnt, model);
		String sql_logintable = "";
		String errorMessage = "";
		int mode = 0;
		LoginModel loginmodel = new LoginModel();

		if(map.get("isLoggedIn").toString().equalsIgnoreCase("1")){
			sql_logintable = "Insert into USER_LOGIN (USER_ID,IS_LOGGEDIN,MODE_OF_LOGIN,CREATED_DATE,ATTEMPTED_COUNT,FAILED_DESC,LAST_LOGIN_DATE) values (?,?,?,?,?,?,?)";
			errorMessage = "User Already Logged in another session.Clearing the session and creating new one.";
			mode =11;
			loginmodel.setIS_LOGGEDIN("0");
			loginmodel.setATTEMPTED_COUNT("0");
		}
		else if(Integer.valueOf(map.get("attemptedCount").toString()) > 3 && _return != 1){
			sql_logintable = "Insert into USER_LOGIN (USER_ID,IS_LOGGEDIN,MODE_OF_LOGIN,CREATED_DATE,ATTEMPTED_COUNT,FAILED_DESC,LAST_LOGIN_DATE) values (?,?,?,?,?,?,?)";
			errorMessage = "User exceeded the limit with wrong Password/Username";
			mode =22;
			loginmodel.setIS_LOGGEDIN("0");
			loginmodel.setATTEMPTED_COUNT(String.valueOf(Integer.valueOf(map.get("attemptedCount").toString())+1));
		}
		if(_return ==2 && Integer.valueOf(map.get("attemptedCount").toString()) <= 3){
			//insert Error message in table and increase the ATTEMPTED_COUNT by 1.
			sql_logintable = "Insert into USER_LOGIN (USER_ID,IS_LOGGEDIN,MODE_OF_LOGIN,CREATED_DATE,ATTEMPTED_COUNT,FAILED_DESC,LAST_LOGIN_DATE) values (?,?,?,?,?,?,?)";
			errorMessage = "User Entered Wrong Password.";
			mode =33;
			loginmodel.setIS_LOGGEDIN("0");
			loginmodel.setATTEMPTED_COUNT(String.valueOf(Integer.valueOf(map.get("attemptedCount").toString())+1));
		}else if(!map.get("isLoggedIn").toString().equalsIgnoreCase("1") && errorMessage == "") {
			//insert Success message in table and set the ATTEMPTED_COUNT to zero
			sql_logintable = "Insert into USER_LOGIN (USER_ID,IS_LOGGEDIN,MODE_OF_LOGIN,CREATED_DATE,ATTEMPTED_COUNT,FAILED_DESC,LAST_LOGIN_DATE) values (?,?,?,?,?,?,?)";
			errorMessage = "User Logged in successfully.";
			mode =44;
			loginmodel.setIS_LOGGEDIN("1");
			loginmodel.setATTEMPTED_COUNT("0");
		}
		loginmodel.setUSER_ID(model.getUsername());
		
		loginmodel.setMODE_OF_LOGIN("1");
		loginmodel.setCREATED_DATE(new Date(System.currentTimeMillis()));
		
		loginmodel.setFAILED_DESC(errorMessage);
		loginmodel.setLAST_LOGIN_DATE(new Date(System.currentTimeMillis()));
		int save = ServiceLoginDAO.insertOrUpdateLogin(sql_logintable,loginmodel);
		return mode;
	}

}
