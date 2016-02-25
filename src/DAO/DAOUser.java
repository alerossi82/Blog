package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beans.User;

public class DAOUser {

	private Connection conn;
	private String url = "jdbc:sqlserver://localhost;databaseName=BLOG";
	private String DBuser = "alerossi82";
	private String DBpassword = "telecono";
	private String selectUser = "Select * FROM [dbo].[User] WHERE Email=?";
	private String insertUser = "INSERT INTO [dbo].[User] (Email, Password) VALUES (?, ?)";
	private String selectAllUsers = "Select Email FROM [dbo].[User]";

	// create connection in the constructor
	public DAOUser() throws SQLException {
		try {
			// connette il jdbc
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url, DBuser, DBpassword);
			System.out.println("connessione al DB effettuata");
		} catch (ClassNotFoundException e) {
			System.out.println("non si connette al DB");
			e.printStackTrace();
		}
	}

	// return all emails from table User
	public List<User> selectAllEmails() throws SQLException {
		PreparedStatement stmt = conn.prepareStatement(selectAllUsers);
		ResultSet rs = stmt.executeQuery();
		List<User> listUsers = new ArrayList<User>();
		while (rs.next()) {
			User user1 = new User();
			user1.setEmail(rs.getString("Email"));
			listUsers.add(user1);
		}
		return listUsers;
	}

	// insert new User in DB
	public void insertUser(String email, String password) throws SQLException {
		PreparedStatement stmt = conn.prepareStatement(insertUser);
		// set params and execute query
		stmt.setString(1, email);
		stmt.setString(2, password);
		stmt.executeUpdate();
	}

	// return user details for a given email
	public User returnUser(String email) throws SQLException {
		PreparedStatement stmt;
		User user1 = new User();
			stmt = conn.prepareStatement(selectUser);
			stmt.setString(1, email);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				user1.setEmail(rs.getString("Email"));
				user1.setPassword(rs.getString("Password"));
			}
		return user1;
	}
}