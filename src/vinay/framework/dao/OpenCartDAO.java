package vinay.framework.dao;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.codec.binary.Base64;

import vinay.framework.constants.GenericModel;
import vinay.services.model.CartModel;
import vinay.services.model.Items;
import vinay.services.model.OpenCartModel;

public class OpenCartDAO {

	public OpenCartModel execute(String sql_stmnt){
		OpenCartModel objOpenCartModel = new OpenCartModel();
		List<CartModel> list = new ArrayList<CartModel>();
		
		Connection conn = GenericModel.getConn();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql_stmnt);

			synchronized (pstmt) {
				rs = pstmt.executeQuery();
				while(rs.next()){
					CartModel j = new CartModel();
					Items i = new Items();

					i.setPRD_CODE(rs.getString(1));
					j.setCartId(rs.getString(2));
					if(rs.getString(3).equalsIgnoreCase("3")){
						j.setProductQuantity("0.25");
					}else if(rs.getString(3).equalsIgnoreCase("2")){
						j.setProductQuantity("0.5");
					}else {
						j.setProductQuantity(rs.getString(3));
					}
					j.setCreatedDate(rs.getDate(4));
					i.setOFFER_VALUE(rs.getString(5));
					i.setIMAGE(rs.getBlob(6));
					i.setPRD_AMOUNT(rs.getString(7));
					i.setPRD_NAME(rs.getString(8));
					
					InputStream inputStream = rs.getBlob(6).getBinaryStream();
					ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
					byte[] buffer = new byte[4096];
					int bytesRead = -1;
					 
					while ((bytesRead = inputStream.read(buffer)) != -1) {
					    outputStream.write(buffer, 0, bytesRead);
					}
					 
					byte[] imageBytes = outputStream.toByteArray();
					String base64Image = Base64.encodeBase64String(imageBytes);
					i.setBase64Image(base64Image);
					
					
					j.setItem(i);
					
					list.add(j);
				}
			}
			
			objOpenCartModel.setCartList(list);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return objOpenCartModel;
	}
}
