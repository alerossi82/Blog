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
	
	private String selectUser = "Select * FROM [dbo].[Users] WHERE Email=?";
	private String insertUser = "INSERT INTO [dbo].[Users] (Email, Password) VALUES (?, ?)";
	private String selectAllUsers = "Select Email FROM [dbo].[Users]";

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
	public Users returnUser(String email) throws SQLException {
		PreparedStatement stmt;
		Users user1 = new Users();
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