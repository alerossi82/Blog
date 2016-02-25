package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import beans.Articolo;
import beans.ArticoloRM;

public class DAOArticoloRM {
	//variables for connection
	private Connection conn;
	private String url = "jdbc:sqlserver://localhost;databaseName=BLOG";
	private String user = "alerossi82";
	private String password = "telecono";
	//SQL queries
	private String getArticolo = "SELECT Articolo.ID, Articolo.Ristorante, Area.Nome AS Area, Cucina.Nome AS Cucina, Prezzo.Nome AS Prezzo, Articolo.Data, Articolo.Articolo, Voto.Nome AS Voto, Articolo.Foto " 
			 + "FROM [BLOG].[dbo].[Articolo] INNER JOIN [BLOG].[dbo].[Cucina] "
			 + "ON Articolo.IDCucina=Cucina.ID INNER JOIN [BLOG].[dbo].[Area] "
			 + "ON Articolo.IDArea=Area.ID INNER JOIN [BLOG].[dbo].[Prezzo] "
			 + "ON Articolo.IDPrezzo=Prezzo.ID INNER JOIN [BLOG].[dbo].[Voto] " 
			 + "ON Articolo.IDVoto=Voto.ID "
			 + "WHERE Articolo.ID=?";
	private String selectCount = "SELECT COUNT(*) FROM dbo.Articolo";
	private String selectIDandRistorante = "SELECT ID,Ristorante FROM [dbo].[Articolo] ORDER BY ID DESC";
	// take all fields from ? rows in Articoli, skipping previous ? rows
	// table Articoli is joined with tables Cucina, Area, Prezzo and Voto
	private String selectWithJoin = "SELECT Articolo.ID, Articolo.Ristorante, Area.Nome AS Area, Cucina.Nome AS Cucina, Prezzo.Nome AS Prezzo, Articolo.Data, Articolo.Articolo, Voto.Nome AS Voto, Articolo.Foto "
			+ "FROM [dbo].[Articolo] INNER JOIN [dbo].[Cucina] "
			+ "ON Articolo.IDCucina=Cucina.ID INNER JOIN [dbo].[Area] "
			+ "ON Articolo.IDArea=Area.ID INNER JOIN [dbo].[Prezzo] "
			+ "ON Articolo.IDPrezzo=Prezzo.ID INNER JOIN [dbo].[Voto] " 
			+ "ON Articolo.IDVoto=Voto.ID "
			+ "ORDER BY Articolo.ID DESC " 
			+ "OFFSET ? ROWS FETCH NEXT ? ROWS ONLY";

	// connection to DB is set inside the constructor
	public DAOArticoloRM() throws SQLException {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url, user, password);
			System.out.println("connected to DB");
		} catch (ClassNotFoundException e) {
			System.out.println("non si connette al DB");
			e.printStackTrace();
		}
	}

	// return all fields for an article
	public ArticoloRM getSingleArticolo(int ID) throws SQLException {
		ArticoloRM art = new ArticoloRM();
		PreparedStatement stmt = conn.prepareStatement(getArticolo);
		stmt.setInt(1, ID);
		ResultSet rs = stmt.executeQuery();
		while (rs.next()) {
			art.setId(rs.getInt("ID"));
			art.setData(rs.getString("Data"));
			art.setArticolo(rs.getString("Articolo"));
			art.setRistorante(rs.getString("Ristorante"));
			art.setArea(rs.getString("Area"));
			art.setCucina(rs.getString("Cucina"));
			art.setPrezzo(rs.getString("Prezzo"));
			art.setVoto(rs.getInt("Voto"));
			art.setFoto(rs.getString("Foto"));
		}
		return art;
	}

	// return number of all items in table Articolo
	public int getTotalCount() throws SQLException {
		int totalCount = 0;
		PreparedStatement stmt = conn.prepareStatement(selectCount);
		ResultSet rs = stmt.executeQuery();
		while (rs.next()) {
			totalCount = rs.getInt(1);
		}
		return totalCount;
	}

	// return list of all fields ID and Ristorante from table Articoli
	public List<ArticoloRM> getAllIDandRistorante() throws SQLException {
		PreparedStatement statement = conn.prepareStatement(selectIDandRistorante);
		ResultSet rs = statement.executeQuery();
		List<ArticoloRM> list = new ArrayList<ArticoloRM>();
		while (rs.next()) {
			ArticoloRM art = new ArticoloRM();
			art.setId(rs.getInt("ID"));
			art.setRistorante(rs.getString("Ristorante"));
			list.add(art);
		}
		return list;
	}

	// returns a list of ArticoloRM objects using the selectWithJoin query
	// skip/take define how many rows will be skipped and how many will be taken
	public List<ArticoloRM> selectWithJoin(int skip, int take) throws SQLException {
		// set and execute query
		PreparedStatement statement = conn.prepareStatement(selectWithJoin);
		statement.setInt(1, skip);
		statement.setInt(2, take);
		ResultSet rs = statement.executeQuery();
		// create an ArticoloRM object for each selected row, set the attributes
		// and add it to List<ArticoloRM>
		List<ArticoloRM> listaArticoliRM = new ArrayList<ArticoloRM>();
		while (rs.next()) {
			ArticoloRM art = new ArticoloRM();
			art.setId(rs.getInt("ID"));
			art.setData(rs.getString("Data"));
			art.setArticolo(rs.getString("Articolo"));
			art.setRistorante(rs.getString("Ristorante"));
			art.setArea(rs.getString("Area"));
			art.setCucina(rs.getString("Cucina"));
			art.setPrezzo(rs.getString("Prezzo"));
			art.setVoto(rs.getInt("Voto"));
			art.setFoto(rs.getString("Foto"));
			listaArticoliRM.add(art);
		}
		return listaArticoliRM;
	}
}
