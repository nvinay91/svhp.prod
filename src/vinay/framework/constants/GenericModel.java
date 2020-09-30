package vinay.framework.constants;

import java.io.Serializable;
import java.sql.Connection;

public class GenericModel implements Serializable {

	private static Connection conn = null;
	private static String SINGLE_QUOTES = "'";
	public static String IMAGE_UPLOAD_FILE_PATH="D:\\Automation\\E-Commerce_jsp\\WebContent\\images\\dynamicImage";
	private static String cartNumber = "0";
	

	public static String getCartNumber() {
		return cartNumber;
	}

	public static void setCartNumber(String cartNumber) {
		GenericModel.cartNumber = cartNumber;
	}

	public static String getSINGLE_QUOTES() {
		return SINGLE_QUOTES;
	}

	public static void setSINGLE_QUOTES(String sINGLE_QUOTES) {
		SINGLE_QUOTES = sINGLE_QUOTES;
	}

	public static Connection getConn() {
		return conn;
	}

	public static void setConn(Connection conn) {
		GenericModel.conn = conn;
	}

}
