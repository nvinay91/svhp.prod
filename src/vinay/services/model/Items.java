package vinay.services.model;

import java.io.Serializable;
import java.sql.Blob;

public class Items implements Serializable {

	private String PRD_CODE;
	private String PRD_NAME;
	private String PRD_CTGRY;
	private String PRD_AMOUNT;
	private Blob IMAGE;
	private String OFFER_VALUE;
	private String base64Image;

	public String getBase64Image() {
		return base64Image;
	}

	public void setBase64Image(String string) {
		this.base64Image = string;
	}

	public String getPRD_CODE() {
		return PRD_CODE;
	}

	public void setPRD_CODE(String pRD_CODE) {
		PRD_CODE = pRD_CODE;
	}

	public String getPRD_NAME() {
		return PRD_NAME;
	}

	public void setPRD_NAME(String pRD_NAME) {
		PRD_NAME = pRD_NAME;
	}

	public String getPRD_CTGRY() {
		return PRD_CTGRY;
	}

	public void setPRD_CTGRY(String pRD_CTGRY) {
		PRD_CTGRY = pRD_CTGRY;
	}

	public String getPRD_AMOUNT() {
		return PRD_AMOUNT;
	}

	public void setPRD_AMOUNT(String pRD_AMOUNT) {
		PRD_AMOUNT = pRD_AMOUNT;
	}

	public Blob getIMAGE() {
		return IMAGE;
	}

	public void setIMAGE(Blob blob) {
		IMAGE = blob;
	}

	public String getOFFER_VALUE() {
		return OFFER_VALUE;
	}

	public void setOFFER_VALUE(String oFFER_VALUE) {
		OFFER_VALUE = oFFER_VALUE;
	}

}
