package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beans.Cucina;
import varie.ConnectionManager;

public class DAOCucina {
	
	private Connection conn;
	private String select = "SELECT * FROM [BLOG].[dbo].[Cucina] ORDER BY Nome";
	
	public DAOCucina() {
		conn=ConnectionManager.getConnection();
	}
	
	//create an object for each line in the Cucina table and adds it to a list
	public List<Cucina> getCucina() throws SQLException{
		PreparedStatement st=conn.prepareStatement(select);
		ResultSet rs=st.executeQuery();
		List <Cucina> listaCucine= new ArrayList<Cucina>();
		while (rs.next()){
			Cucina cucina1=new Cucina();
			cucina1.setID(rs.getInt("ID"));
			cucina1.setNome(rs.getString("Nome"));
			listaCucine.add(cucina1);
		}
		return listaCucine;
		
	}

}
