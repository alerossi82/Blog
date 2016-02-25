package DAO;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import beans.Articolo;
import beans.ArticoloRM;

public class DAOArticolo {

	private Connection conn;
	private String url = "jdbc:sqlserver://localhost;databaseName=BLOG";
	private String user = "alerossi82";
	private String password = "telecono";

	// SQL query to SELECT all data from a single row in table Articoli
	private String select = "SELECT * FROM dbo.Articolo WHERE ID=?";
	//SQL query to SELECT all data from top ? rows in table Articoli
	private String selectTop = "SELECT TOP (?) * FROM dbo.Articolo ORDER BY ID desc";
	// SQL query to INSERT new row in table Articoli
	private String insert = "INSERT INTO [dbo].[Articolo] VALUES (?, ?, ?, ?, ?, ?,?,?)";
	//SQL query to UPDATE a row in table Articoli
	private String update = " UPDATE [dbo].[Articolo] SET Ristorante=?, IDArea=?, IDCucina=?, IDPrezzo=?, Data=?, Articolo=?, IDVoto=?, Foto=? WHERE ID=?";
	//SQL query to DELETE a row in table Articoli
	private String delete="DELETE FROM [dbo].[Articolo] WHERE ID=?";
	
	//create connection to DB in the constructor
	public DAOArticolo() throws SQLException{
		try {
			// jdbc
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url, user, password);
			System.out.println("connected to DB");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("non si connette al DB");
			e.printStackTrace();
		}
	}

	// this method returns a new Article for a given ID using the SELECT query
	// it is called in the servlet ControllerHome
	public Articolo select(int ID) throws SQLException {
		// set and call the query
		PreparedStatement statement = conn.prepareStatement(select);
		statement.setInt(1, ID);
		ResultSet rs = statement.executeQuery();
		// create new Articolo and set attributes
		Articolo art = new Articolo();
		while (rs.next()) {
			art.setId(rs.getInt("ID"));
			art.setData(rs.getString("Data"));
			art.setArticolo(rs.getString("Articolo"));
			art.setRistorante(rs.getString("Ristorante"));
			art.setIDArea(rs.getInt("IDArea"));
			art.setIDCucina(rs.getInt("IDCucina"));
			art.setIDPrezzo(rs.getInt("IDPrezzo"));
			art.setIDVoto(rs.getInt("IDVoto"));
			art.setFoto(rs.getString("foto"));
		}
		return art;
	}
	
	//returns a List of Articoli using the selectTop query
	//it is called in the ControllerHome servlet
	public List<Articolo> selectTop(int fetch) throws SQLException{
		//set and execute the query
		PreparedStatement statement = conn.prepareStatement(selectTop);
		statement.setInt(1, fetch);
		ResultSet rs=statement.executeQuery();
		List<Articolo> listArticoli=new ArrayList<Articolo>();
		//create a new Articolo for each row selected and add it to listArticoli
		while(rs.next()){
			Articolo art=new Articolo();
			art.setId(rs.getInt("ID"));
			art.setData(rs.getString("Data"));
			art.setArticolo(rs.getString("Articolo"));
			art.setRistorante(rs.getString("Ristorante"));
			art.setIDArea(rs.getInt("IDArea"));
			art.setIDCucina(rs.getInt("IDCucina"));
			art.setIDPrezzo(rs.getInt("IDPrezzo"));
			art.setIDVoto(rs.getInt("IDVoto"));
			art.setFoto(rs.getString("foto"));
			listArticoli.add(art);
		}
		return listArticoli;
	}
	
	// inserisce nel DB i dati inviati dalla View newEditArticolo.jsp
	public void insert(Articolo art) throws SQLException {
		// call connect method
		// imposto query INSERT
		PreparedStatement statement = conn.prepareStatement(insert);
		// imposto parametri di INSERT utilizzando i getter del bean articolo
		statement.setString(1, art.getRistorante());
		statement.setInt(2, art.getIDArea());
		statement.setInt(3, art.getIDCucina());
		statement.setInt(4, art.getIDPrezzo());
		statement.setString(5, art.getData());
		statement.setString(6, art.getArticolo());
		statement.setInt(7, art.getIDVoto());
		statement.setString(8, art.getFoto());
		// execute query
		statement.executeUpdate();
	}

	// the UPDATE query is called in the servlet ControllerEdit
	public void update(Articolo art) throws SQLException {

		PreparedStatement stmt = conn.prepareStatement(update);

		stmt.setString(1, art.getRistorante());
		stmt.setInt(2, art.getIDArea());
		stmt.setInt(3, art.getIDCucina());
		stmt.setInt(4, art.getIDPrezzo());
		stmt.setString(5, art.getData());
		stmt.setString(6, art.getArticolo());
		stmt.setInt(7, art.getIDVoto());
		stmt.setString(8, art.getFoto());
		stmt.setInt(9, art.getId());

		stmt.executeUpdate();
	}
	
	//method to delete an article in the DB
	public void delete (Articolo art) throws SQLException{
		PreparedStatement stmt = conn.prepareStatement(delete);
		stmt.setInt(1, art.getId());
		stmt.executeUpdate();
	}

}

/*
 * 1. crrea u9n cosruttre di calsse e sposai la logica di creazione della
 * connessione. Usa una variabile di classe privata persalvarti la connessione.
 * crea nuovi bean: Area, Cucina, Voto, NewEditArticolo crea nuovi DAO per Area,
 * Cucina e Voto per creare lista di tutte le linee nel DB 
 * 2. creaa unmetodo UPDATE sempre con un Ariticolo in ingressp 
 * 3. ok che hai il get, ma passagli l'ID 
 * 4. crea, se vuoi un metodo search, con in ingrsso un po' di parametri ad
 * esempio: searchString, rowsToFetch, areaid. restituira una lista di articoli
 */