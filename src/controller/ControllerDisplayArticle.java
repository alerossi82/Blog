package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.ArticoloRM;
import varie.HomeViewModel;

/**
 * Servlet implementation class ControllerDisplayArticle
 */
@WebServlet("/ControllerDisplayArticle")
public class ControllerDisplayArticle extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerDisplayArticle() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		//get param ID from view SIDEBAR.TAG and parse to int
		String id=request.getParameter("ID");
		int ID=Integer.parseInt(id); 
		
		//generate hvm object for the specific article and pass it to viewArticle.jsp
		try {
			HomeViewModel hvm=new HomeViewModel();
			hvm.generateArticolo(ID);
			hvm.generateListaAllArticoli();
			request.setAttribute("hvm", hvm);
			request.getRequestDispatcher("/viewArticle.jsp").forward(request, response);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
