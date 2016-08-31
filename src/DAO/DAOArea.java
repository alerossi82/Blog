package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import beans.Area;
import varie.ConnectionManager;

public class DAOArea {
	
	private Connection conn;

	//SQL query to retrive all data from table Area
	private String select = "SELECT * FROM [BLOG].[dbo].[Area] ORDER BY ID";
	
	
	
	
	//create connection in the constructor
	public DAOArea() {
		conn=ConnectionManager.getConnection();
	}

	
	//returns a List of all rows in the SQL table Area 
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