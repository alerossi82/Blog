package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.DAOArticolo;
import beans.Articolo;
import varie.HomeViewModel;
import varie.NewEditArticolo;

/**
 * Servlet implementation class ControllerHome
 * Create model for HOME.JSP
 */
@WebServlet("/ControllerHome")
public class ControllerHome extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ControllerHome() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());

		
		// get parameter page from view home.jsp and parse to int
		// if first page, set value to 1
		String param = request.getParameter("page");
		Integer page = (param == null) ? 1 : Integer.parseInt(param);
		
		// get parameter showListOfAllArticles from view home.jsp
		String showListOfAllArticles = request.getParameter("showListOfAllArticles");
		
		// create HomeViewModel for the selected page, and pass it to HOME.JSP
		try {
			HomeViewModel hvm = new HomeViewModel();
			hvm.generateListaAllArticoli();
			
			//generate list of articles to display based for the specific page
			hvm.generateListaArticoliRM(page);
			
			// set showListOfAllArticles true if link "more" was clicked in home.jsp
			if (showListOfAllArticles != null) {
				hvm.setShowListOfAllArticles(true);
			}
			request.setAttribute("hvm", hvm);
			request.getRequestDispatcher("/home.jsp").forward(request, response);

		} catch (SQLException e) {
			System.out.println("creazione HomeViewModel fallita");
			e.printStackTrace();
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}