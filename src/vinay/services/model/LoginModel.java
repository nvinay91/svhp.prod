package vinay.services.model;

import java.io.Serializable;
import java.sql.Date;

public class LoginModel implements Serializable {
	private String USER_ID;
	private String IS_LOGGEDIN;
	private String MODE_OF_LOGIN;
	private Date CREATED_DATE;
	private String ATTEMPTED_COUNT;
	private String FAILED_DESC;
	private Date LAST_LOGIN_DATE;

	public String getUSER_ID() {
		return USER_ID;
	}

	public void setUSER_ID(String uSER_ID) {
		USER_ID = uSER_ID;
	}

	public String getIS_LOGGEDIN() {
		return IS_LOGGEDIN;
	}

	public void setIS_LOGGEDIN(String iS_LOGGEDIN) {
		IS_LOGGEDIN = iS_LOGGEDIN;
	}

	public String getMODE_OF_LOGIN() {
		return MODE_OF_LOGIN;
	}

	public void setMODE_OF_LOGIN(String mODE_OF_LOGIN) {
		MODE_OF_LOGIN = mODE_OF_LOGIN;
	}

	public Date getCREATED_DATE() {
		return CREATED_DATE;
	}

	public void setCREATED_DATE(Date cREATED_DATE) {
		CREATED_DATE = cREATED_DATE;
	}

	public String getATTEMPTED_COUNT() {
		return ATTEMPTED_COUNT;
	}

	public void setATTEMPTED_COUNT(String aTTEMPTED_COUNT) {
		ATTEMPTED_COUNT = aTTEMPTED_COUNT;
	}

	public String getFAILED_DESC() {
		return FAILED_DESC;
	}

	public void setFAILED_DESC(String fAILED_DESC) {
		FAILED_DESC = fAILED_DESC;
	}

	public Date getLAST_LOGIN_DATE() {
		return LAST_LOGIN_DATE;
	}

	public void setLAST_LOGIN_DATE(Date lAST_LOGIN_DATE) {
		LAST_LOGIN_DATE = lAST_LOGIN_DATE;
	}

}
