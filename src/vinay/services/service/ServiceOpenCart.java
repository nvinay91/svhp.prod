package vinay.services.service;

import vinay.framework.adapter.CustomerContext;
import vinay.framework.dao.OpenCartDAO;
import vinay.services.model.OpenCartModel;

public class ServiceOpenCart {

	public OpenCartModel getcartList() {
		OpenCartModel model = new OpenCartModel();
		String sql_stmnt = "SELECT cd.PRD_CODE, cd.CART_ID, cd.PRD_QUANTITY, cd.CREATED_DATE, (SELECT offer_value FROM prd_offers WHERE offer_id=cd.offer_id) OfferValue, (SELECT prd_image.IMAGE FROM prd_image WHERE prd_image.PRD_CODE = cd.PRD_CODE) image, (SELECT prd_dtls.PRD_AMOUNT FROM prd_dtls WHERE prd_dtls.PRD_CODE = cd.PRD_CODE) amount , (SELECT prd_dtls.PRD_NAME FROM prd_dtls WHERE prd_dtls.PRD_CODE = cd.PRD_CODE) productName FROM cart_details cd WHERE cd.USER_ID='"+CustomerContext.getInstance().getMOBILE()+"' AND cd.status   =1";
		OpenCartDAO dao = new OpenCartDAO();
		model = dao.execute(sql_stmnt);
		return model;
	}
}
