package vinay.services.service;

import java.util.List;

import vinay.framework.dao.FetchItemsDAO;
import vinay.services.model.Items;

public class FetchItems {

public List<Items> fetchItems() {
	String sql_stmnt = "select pd.PRD_CODE,pd.PRD_NAME,pd.PRD_CTGRY,pd.PRD_AMOUNT,pi.IMAGE,po.OFFER_VALUE from PRD_DTLS pd, PRD_IMAGE pi ,PRD_OFFERS po where pd.PRD_CODE = pi.PRD_CODE and pd.PRD_CODE=po.PRD_CODE";
	FetchItemsDAO dao= new FetchItemsDAO();
	List<Items> list = dao.execute(sql_stmnt);
	return list;
}

public List<Items> fetchSpiceItems() {
	String sql_stmnt = "select pd.PRD_CODE,pd.PRD_NAME,pd.PRD_CTGRY,pd.PRD_AMOUNT,pi.IMAGE,po.OFFER_VALUE from PRD_DTLS pd, PRD_IMAGE pi ,PRD_OFFERS po where pd.PRD_CODE = pi.PRD_CODE and pd.PRD_CODE=po.PRD_CODE and pd.PRD_CTGRY=1";
	FetchItemsDAO dao= new FetchItemsDAO();
	List<Items> list = dao.execute(sql_stmnt);
	return list;
}

public List<Items> fetchSnacksItems() {
	String sql_stmnt = "select pd.PRD_CODE,pd.PRD_NAME,pd.PRD_CTGRY,pd.PRD_AMOUNT,pi.IMAGE,po.OFFER_VALUE from PRD_DTLS pd, PRD_IMAGE pi ,PRD_OFFERS po where pd.PRD_CODE = pi.PRD_CODE and pd.PRD_CODE=po.PRD_CODE and pd.PRD_CTGRY=2";
	FetchItemsDAO dao= new FetchItemsDAO();
	List<Items> list = dao.execute(sql_stmnt);
	return list;
}
}
