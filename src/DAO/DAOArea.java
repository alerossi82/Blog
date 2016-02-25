package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import beans.Area;

public class DAOArea {
	
	private Connection conn;
	private String url = "jdbc:sqlserver://localhost;databaseName=BLOG";
	private String user = "alerossi82";
	private String password = "telecono";
	//SQL query to retrive all data from table Area
	private String select = "SELECT * FROM [BLOG].[dbo].[Area] ORDER BY ID";
	
	//create connection in the constructor
	public DAOArea() throws SQLException{
		try {
			// connette il jdbc
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("non si connette al DB");
			e.printStackTrace();
		}
	}

	
	//returns a List of all lines in the SQL table Area 
	public List<Area> getArea() throws SQLException {
		
		PreparedStatement st = conn.prepareStatement(select);
		ResultSet rs = st.executeQuery();
		List<Area> listaAree = new ArrayList<Area>();
		while (rs.next()) {
			Area area1 = new Area();
			area1.setID(rs.getInt("ID"));
			area1.setNome(rs.getString("Nome"));
			listaAree.add(area1);
		}
		return listaAree;
	}
}