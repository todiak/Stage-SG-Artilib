package models;

import java.sql.Connection;
import java.sql.DriverManager;

public class AccesBD {
	
	private static String url_jdbc = "jdbc:mysql://localhost/artilib?useUnicode=yes&characterEncoding=UTF-8&autoReconnect=true&useSSL=false";
	private static String login = "root";
	private static String pwd = "";

	
	public static Connection connexionBD() throws Exception {
		
		Class.forName("com.mysql.jdbc.Driver");
		
		Connection conn = DriverManager.getConnection(url_jdbc, login, pwd);
		
		return conn;
	}
}
