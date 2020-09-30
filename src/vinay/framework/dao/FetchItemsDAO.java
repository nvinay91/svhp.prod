package vinay.framework.dao;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.Base64OutputStream;

import vinay.framework.constants.GenericModel;
import vinay.services.model.Items;

public class FetchItemsDAO {
	public List<Items> execute(String sql_stmnt) {
		List<Items> list = new ArrayList<Items>();
		Connection conn = GenericModel.getConn();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql_stmnt);

			synchronized (pstmt) {
				rs = pstmt.executeQuery();
				while(rs.next()){
					Items i = new Items();
					i.setPRD_CODE(rs.getString(1));
					i.setPRD_NAME(rs.getString(2));
					i.setPRD_CTGRY(rs.getString(3));
					i.setPRD_AMOUNT(rs.getString(4));
					i.setIMAGE(rs.getBlob(5));
					
//					byte barr[]=i.getIMAGE().getBytes(1,(int)i.getIMAGE().length());
					InputStream inputStream = rs.getBlob(5).getBinaryStream();
					ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
					byte[] buffer = new byte[4096];
					int bytesRead = -1;
					 
					while ((bytesRead = inputStream.read(buffer)) != -1) {
					    outputStream.write(buffer, 0, bytesRead);
					}
					 
					byte[] imageBytes = outputStream.toByteArray();
					String base64Image = Base64.encodeBase64String(imageBytes);
					i.setBase64Image(base64Image);
					i.setOFFER_VALUE(rs.getString(6));
					list.add(i);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
}
