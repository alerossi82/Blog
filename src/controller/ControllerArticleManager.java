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
import varie.NewEditArticolo;

/**
 * Servlet implementation class ControllerEdit
 */
@WebServlet("/ControllerArticleManager")
public class ControllerArticleManager extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ControllerArticleManager() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

	// open an article in view ArticleMananager
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());

		// get email attribute from session to check login
		Object email = request.getSession().getAttribute("email");

		// if logged in, get ID articolo from view ADMIN and parse it to int
		if (email != null) {
			String param = request.getParameter("IDarticolo");
			Integer IDArticolo = Integer.parseInt(param);

			// create object NewEditArticolo and forward to view ARTICLE MANAGER
			try {
				NewEditArticolo nea = new NewEditArticolo(IDArticolo);
				request.setAttribute("nea", nea);
				request.getRequestDispatcher("/ArticleManager.jsp").forward(request, response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		//if not logged in, forward to view LOGIN
		else{
			System.out.println("You must login to view this page");
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		// get parameters from view ArticleManager.jsp
		String submit = request.getParameter("submit");

		String ID = request.getParameter("ID");
		int id = Integer.parseInt(ID);

		String ristorante = request.getParameter("restaurant");
		int IDArea = Integer.parseInt(request.getParameter("location"));
		int IDCucina = Integer.parseInt(request.getParameter("cucina"));
		int IDPrezzo = Integer.parseInt(request.getParameter("prezzo"));
		String data = request.getParameter("data");
		String Articolo = request.getParameter("recensione");
		int IDVoto = Integer.parseInt(request.getParameter("voto"));
		String foto = request.getParameter("foto");

		// create object Articolo and set attributes
		Articolo art = new Articolo();
		art.setRistorante(ristorante);
		art.setIDArea(IDArea);
		art.setIDCucina(IDCucina);
		art.setIDPrezzo(IDPrezzo);
		art.setData(data);
		art.setArticolo(Articolo);
		art.setIDVoto(IDVoto);
		art.setFoto(foto);

		// create DAO to send data to DB
		DAOArticolo DAO = null;
		try {
			DAO = new DAOArticolo();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		// INSERT new article in DB
		if (submit.equals("SUBMIT")) {
			if (id == 0) {
				try {
					DAO.insert(art);
					System.out.println("INSERT was succesfull");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					System.out.println("INSERT failed");
					e.printStackTrace();
				}

				// UPDATE article in DB
			} else {
				try {
					art.setId(id);
					DAO.update(art);
					System.out.println("UPDATE was succesfull");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					System.out.println("UPDATE failed");
					e.printStackTrace();
				}
			}
		}
		// DELETE article
		else if (submit.equals("DELETE ARTICLE")) {
			try {
				art.setId(id);
				DAO.delete(art);
				System.out.println("article was deleted");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("delete article failed");
				e.printStackTrace();
			}
		}
		
		//after submitting the changes, update view Admin
		request.getRequestDispatcher("/ControllerAdmin").forward(request, response);
	}
}
