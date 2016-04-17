package varie;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {

	private static Connection conn;
	private static String driverName="com.microsoft.sqlserver.jdbc.SQLServerDriver"; //jdbc driver
	private static String url = "jdbc:sqlserver://localhost;databaseName=BLOG";
	private static String user = "alerossi82";
	private static String password = "telecono";
	
	//create a connection object to connect to DB
	public static Connection getConnection() {

		try {
			Class.forName(driverName);
			
			try {
				conn = DriverManager.getConnection(url, user, password);
			} catch (SQLException e) {
				System.out.println("failed to create DB connection");
				e.printStackTrace();
			}
			
		} catch (ClassNotFoundException e) {
			System.out.println("Driver not found");
			e.printStackTrace();
		}
		
		return conn;
	}
}
