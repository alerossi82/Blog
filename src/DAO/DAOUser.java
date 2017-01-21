package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import beans.Users;
import varie.ConnectionManager;

public class DAOUser {

	private Connection conn;
	
	private String selectUser = "Select * FROM [dbo].[Users] WHERE username=?";
	private String insertUser = "INSERT INTO [dbo].[Users] (username, password) VALUES (?, ?)";
	private String selectAllUsers = "Select username FROM [dbo].[Users]";

	// create connection in the constructor
	public DAOUser() {
		conn=ConnectionManager.getConnection();
	}

	// return all emails from table User
	public List<Users> selectAllEmails() throws SQLException {
		PreparedStatement stmt = conn.prepareStatement(selectAllUsers);
		ResultSet rs = stmt.executeQuery();
		List<Users> listUsers = new ArrayList<Users>();
		while (rs.next()) {
			Users user1 = new Users();
			user1.setUsername(rs.getString("username"));
			listUsers.add(user1);
		}
		return listUsers;
	}

	// insert new User in DB
	public void insertUser(String username, String password) throws SQLException {
		PreparedStatement stmt = conn.prepareStatement(insertUser);
		// set params and execute query
		stmt.setString(1, username);
		stmt.setString(2, password);
		stmt.executeUpdate();
	}

	// return user details for a given email
	public Users returnUser(String username) throws SQLException {
		PreparedStatement stmt;
		Users user1 = new Users();
			stmt = conn.prepareStatement(selectUser);
			stmt.setString(1, username);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				user1.setUsername(rs.getString("username"));
				user1.setPassword(rs.getString("Password"));
			}
		return user1;
	}
}