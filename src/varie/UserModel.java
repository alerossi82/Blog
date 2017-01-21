package varie;

import java.sql.SQLException;
import java.util.List;
import DAO.DAOUser;
import beans.Users;

public class UserModel {
	Users user1;
	String message;
	DAOUser dao;

	// constructor
	public UserModel() throws SQLException {
		dao = new DAOUser();
	}

	// accessors for message
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	// validate new User
	public boolean validate(String username, String password) {
		if (username == "" || password == "") {
			message = "username or password not provided";
			return false;
		}

		if (!username.matches("\\w+@+\\w+\\.+\\w+") && !username.matches("\\w+\\.+\\w+@+\\w+\\.+\\w+")) {
			message = "Invalid username address";
			return false;
		}

		if (password.matches("\\w*\\s+\\w*")) {
			message = "Password can not contain spaces";
			return false;
		}

		if (password.length() < 8) {
			message = "Password must be at least 8 characters";
			return false;
		}

		else {
			return true;
		}
	}

	// check that the username from view newAccount.jsp does not exists already in
	// the DB
	public boolean checkUser(String username) throws SQLException {
		boolean bool = true;
		List<Users> list = dao.selectAllEmails();
		for (Users u : list) {
			String user = u.getUsername();
			if (user.equals(username)) {
				message = "a user with this name already exists";
				bool = false;
				break;
			} else {
				message = "this user is new";
			}
		}
		return bool;
	}

	// insert new user
	public void insertUser(String username, String password) throws SQLException {
		dao.insertUser(username, password);
		message = "new user " + username + " was created";
	}

	// check new user details and if check is ok, create new user in DB
	public void newUser(String username, String password) throws SQLException {
		if (validate(username, password)) {
			if (checkUser(username)) {
				insertUser(username, password);
			}
		}
	}

	// check if login details from view login.jsp are valid in DB
	public boolean login(String username, String password) throws SQLException {
		user1 = dao.returnUser(username);
		String emailInDB = user1.getUsername();
		String passwordInDB = user1.getPassword();
		if (emailInDB == null) {
			message = "Invalid username address";
			return false;
		} else if (passwordInDB != null && passwordInDB.equals(password)) {
			message = "Logged in with user " + username;
			return true;
		} else {
			message = "invalid password for user " + username;
			return false;
		}
	}

}
