package vinay.framework.adapter;

import java.io.Serializable;
import java.util.Date;

public class CustomerContext implements Serializable{

	private String REGISTRATION_NO;
	private String FIRST_NAME;
	private String LAST_NAME;
	private String MOBILE;
	private String EMAIL;
	private String ADDRESS1;
	private String ADDRESS2;
	private String ADDRESS3;
	private String PIN_CODE;
	private String CUSTOM_USER_ID;
	private Date CREATED_DATE;
	private String STATUS;
	private String GROUP_ID;
	private String PASSWORD;
	private String STATUS_CD;
	private String GROUP_CD;

	private static CustomerContext objCustomerContext = null;
	
	private CustomerContext (){
	}

	public static CustomerContext getInstance(){
		if(objCustomerContext == null){
			objCustomerContext = new CustomerContext();
		}
		return objCustomerContext;
	}
	public String getREGISTRATION_NO() {
		return REGISTRATION_NO;
	}

	public void setREGISTRATION_NO(String rEGISTRATION_NO) {
		REGISTRATION_NO = rEGISTRATION_NO;
	}

	public String getFIRST_NAME() {
		return FIRST_NAME;
	}

	public void setFIRST_NAME(String fIRST_NAME) {
		FIRST_NAME = fIRST_NAME;
	}

	public String getLAST_NAME() {
		return LAST_NAME;
	}

	public void setLAST_NAME(String lAST_NAME) {
		LAST_NAME = lAST_NAME;
	}

	public String getMOBILE() {
		return MOBILE;
	}

	public void setMOBILE(String mOBILE) {
		MOBILE = mOBILE;
	}

	public String getEMAIL() {
		return EMAIL;
	}

	public void setEMAIL(String eMAIL) {
		EMAIL = eMAIL;
	}

	public String getADDRESS1() {
		return ADDRESS1;
	}

	public void setADDRESS1(String aDDRESS1) {
		ADDRESS1 = aDDRESS1;
	}

	public String getADDRESS2() {
		return ADDRESS2;
	}

	public void setADDRESS2(String aDDRESS2) {
		ADDRESS2 = aDDRESS2;
	}

	public String getADDRESS3() {
		return ADDRESS3;
	}

	public void setADDRESS3(String aDDRESS3) {
		ADDRESS3 = aDDRESS3;
	}

	public String getPIN_CODE() {
		return PIN_CODE;
	}

	public void setPIN_CODE(String pIN_CODE) {
		PIN_CODE = pIN_CODE;
	}

	public String getCUSTOM_USER_ID() {
		return CUSTOM_USER_ID;
	}

	public void setCUSTOM_USER_ID(String cUSTOM_USER_ID) {
		CUSTOM_USER_ID = cUSTOM_USER_ID;
	}

	public Date getCREATED_DATE() {
		return CREATED_DATE;
	}

	public void setCREATED_DATE(Date cREATED_DATE) {
		CREATED_DATE = cREATED_DATE;
	}

	public String getSTATUS() {
		return STATUS;
	}

	public void setSTATUS(String sTATUS) {
		STATUS = sTATUS;
	}

	public String getGROUP_ID() {
		return GROUP_ID;
	}

	public void setGROUP_ID(String gROUP_ID) {
		GROUP_ID = gROUP_ID;
	}

	public String getPASSWORD() {
		return PASSWORD;
	}

	public void setPASSWORD(String pASSWORD) {
		PASSWORD = pASSWORD;
	}

	public String getSTATUS_CD() {
		return STATUS_CD;
	}

	public void setSTATUS_CD(String sTATUS_CD) {
		STATUS_CD = sTATUS_CD;
	}

	public String getGROUP_CD() {
		return GROUP_CD;
	}

	public void setGROUP_CD(String gROUP_CD) {
		GROUP_CD = gROUP_CD;
	}
}
