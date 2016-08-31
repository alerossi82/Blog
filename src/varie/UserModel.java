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
	public boolean validate(String email, String password) {
		if (email == "" || password == "") {
			message = "email or password not provided";
			return false;
		}

		if (!email.matches("\\w+@+\\w+\\.+\\w+") && !email.matches("\\w+\\.+\\w+@+\\w+\\.+\\w+")) {
			message = "Invalid email address";
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

	// check that the email from view newAccount.jsp does not exists already in
	// the DB
	public boolean checkEmail(String email) throws SQLException {
		boolean bool = true;
		List<Users> list = dao.selectAllEmails();
		for (Users u : list) {
			String user = u.getEmail();
			if (user.equals(email)) {
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
	public void insertUser(String email, String password) throws SQLException {
		dao.insertUser(email, password);
		message = "new user " + email + " was created";
	}

	// check new user details and if check is ok, create new user in DB
	public void newUser(String email, String password) throws SQLException {
		if (validate(email, password)) {
			if (checkEmail(email)) {
				insertUser(email, password);
			}
		}
	}

	// check if login details from view login.jsp are valid in DB
	public boolean login(String email, String password) throws SQLException {
		user1 = dao.returnUser(email);
		String emailInDB = user1.getEmail();
		String passwordInDB = user1.getPassword();
		if (emailInDB == null) {
			message = "Invalid email address";
			return false;
		} else if (passwordInDB != null && passwordInDB.equals(password)) {
			message = "Logged in with user " + email;
			return true;
		} else {
			message = "invalid password for user " + email;
			return false;
		}
	}

}
