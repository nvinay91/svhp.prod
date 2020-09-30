package vinay.framework.adapter;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;

import vinay.framework.constants.GenericModel;
import vinay.servlets.InitServletService;

public class UploadImage {

	public static void main(String[] args) throws SQLException, IOException{
		new InitServletService().connectDatabase();
		Connection con = GenericModel.getConn();
		PreparedStatement ps=con.prepareStatement("insert into PRD_IMAGE values(?,?,?,?)");
//		PreparedStatement ps=con.prepareStatement("update PRD_IMAGE set image =? where image_id=?");
		ps.setString(1,"3");  
		  
		FileInputStream fin=new FileInputStream("C:\\Users\\Vinay\\Desktop\\bg3.jpg");  
		ps.setBinaryStream(2,fin,fin.available());
		ps.setDate(3,new Date(new java.util.Date().getTime()));
		ps.setString(4,"103");
		int i=ps.executeUpdate();  
		System.out.println(i+" records affected");  
		          
		con.close();  
		
	}
}
