package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.DAOArticolo;
import DAO.DAOArticoloRM;
import beans.Articolo;
import beans.ArticoloRM;
import varie.NewEditArticolo;

/**
 * Servlet implementation class ControllerNuovoArticolo
 */
@WebServlet("/ControllerAdmin")
public class ControllerAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ControllerAdmin() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		// get attribute email from session
		Object email = request.getSession().getAttribute("email");
		// if logged in, create a list of all ID and Ristorante in the DB
		if (email != null) {
			try {
				DAOArticoloRM dao = new DAOArticoloRM();
				List<ArticoloRM> listIDRistorante = dao.getAllIDandRistorante();
				request.setAttribute("listIDRistorante", listIDRistorante);
				request.getRequestDispatcher("/admin.jsp").forward(request, response);
				;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//if not logged in, forward to login view
		else{
			System.out.println("You must login to access this page");
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
