package vinay.servlets;

import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import vinay.framework.constants.GenericModel;

public class InitServletService implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		System.out.println("Starting the Server...");
		connectDatabase();
		System.out.println("Connection Established...");
	}


	public void connectDatabase() {
		String URL = "jdbc:oracle:thin:@localhost:1521:orcl";
		String USER = "system";
		String PASS = "Spoorthi1994";
		try {
			DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
			GenericModel.setConn(DriverManager.getConnection(URL, USER, PASS));
			
		} catch (SQLException e) {
			e.printStackTrace();
		}		
	}

}
