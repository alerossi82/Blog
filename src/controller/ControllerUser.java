package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.DAOUser;
import beans.User;
import varie.UserModel;

/**
 * Servlet implementation class ControllerUser
 */
@WebServlet("/ControllerUser")
public class ControllerUser extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ControllerUser() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		//get param action from masthead.tag
		String action = request.getParameter("action");
		
		switch (action) {
			case "logout":
				// set attribute email=null in session and forward to view login
				request.getSession().setAttribute("email", null);
				request.getRequestDispatcher("/home.jsp").forward(request, response);
			}

	}

	/*
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 * response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String action = request.getParameter("action");
		
		// create new user account
		try {
			UserModel model = new UserModel();
				
			//switch between login and newAccount
			switch (action) {
			
			case "login":
				// if login details are valid
				if (model.login(email, password)) {
					// set attribute email in session
					request.getSession().setAttribute("email", email);
					//forward to servlet ControllerAdmin
					request.getRequestDispatcher("/ControllerAdmin").forward(request, response);
				}
				// if login details are not valid 
				else {
					//set attribute message to return validation message 
					request.setAttribute("model", model);
					//forward to view login.jsp
					request.getRequestDispatcher("/login.jsp").forward(request, response);
				}
				break;

			case "newAccount":
				//call method to create new account
				model.newUser(email, password);
				// set attribute and forward to view newAccount.jsp
				request.setAttribute("model", model);
				request.getRequestDispatcher("/newAccount.jsp").forward(request, response);
				
				break;

			default: 
				System.out.println("unable to login or to create new account");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("exception in doGet");
		}
	}

}