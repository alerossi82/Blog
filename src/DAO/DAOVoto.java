package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beans.Voto;

public class DAOVoto {

	private Connection conn;
	private String url = "jdbc:sqlserver://localhost;databaseName=BLOG";
	private String user = "alerossi82";
	private String password = "telecono";
	private String select = "SELECT * FROM [BLOG].[dbo].[Voto] ORDER BY Nome";
	
	
	
	public DAOVoto() throws SQLException {
		try {
			// connette il jdbc
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			// creo connessione al DB Blog
			conn = DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("non si connette al DB");
			e.printStackTrace();
		}
	}
	
	//generates a list containing an object for each line in the Voto table
	public List<Voto> getVoto() throws SQLException{
		PreparedStatement st=conn.prepareStatement(select);
		ResultSet rs=st.executeQuery();
		List<Voto>listVoti=new ArrayList<Voto>();
		while(rs.next()){
			Voto voto1=new Voto();
			voto1.setID(rs.getInt("ID"));
			voto1.setNome(rs.getString("Nome"));
			listVoti.add(voto1);
		}
		return listVoti;
		
	}
	
}
