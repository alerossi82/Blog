package varie;

import java.io.File;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DAO.DAOArea;
import DAO.DAOArticolo;
import DAO.DAOArticoloRM;
import DAO.DAOCucina;
import DAO.DAOPrezzo;
import DAO.DAOUser;
import DAO.DAOVoto;
import beans.Area;
import beans.Articolo;
import beans.ArticoloRM;
import beans.Cucina;
import beans.Prezzo;
import beans.Users;
import beans.Voto;

public class prova {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		/*
		 * DAOArticolo DAO=new DAOArticolo(); Articolo articolo1=DAO.getData(5);
		 * System.out.println(articolo1.getRistorante());
		 */

		/*
		 * DAOVoto DAO=new DAOVoto(); List <Voto> list=DAO.getVoto();
		 */

		/*
		 * for (Voto x:list){ System.out.println(x.getNome()); }
		 */

		/*
		 * NewEditArticolo nea=new NewEditArticolo(3);
		 * System.out.println(nea.getArticolo().getRistorante());
		 * 
		 * List<Area> ListArea=nea.getListaArea();
		 */

		/*
		 * for (Voto a:list){ System.out.println(a.getID());
		 * System.out.println(a.getNome()); }
		 */

		/*
		 * List<Voto> ListVoto=nea.getListaVoto();
		 * 
		 * for (Voto v:ListVoto){ System.out.println(v.getNome()); }
		 */

		/*
		 * NewEditArticolo nea= new NewEditArticolo(6); String
		 * s=nea.getArticolo().getArticolo(); System.out.println(s);
		 */

		/*
		 * DAOArticolo dao=new DAOArticolo(); List<Articolo>
		 * list=dao.selectTop(5); for (Articolo a: list){
		 * System.out.println(a.getRistorante()); }
		 */

		/*
		 * DAOArticoloRM dao=new DAOArticoloRM(); List<ArticoloRM>
		 * list=dao.selectIDandRistorante(); for (ArticoloRM art:list){
		 * System.out.println(art.getId());
		 * System.out.println(art.getRistorante()); }
		 * 
		 * HomeViewModel hvm=new HomeViewModel(1); int x=hvm.getTotPages();
		 * System.out.println(x);
		 */
		/*
		 * DAOUser dao=new DAOUser(); String email="alerossi82@hotmail.com";
		 * String password="telecono"; User user1=dao.returnUser(email);
		 * System.out.println(user1.getEmail());
		 * System.out.println(user1.getPassword());
		 */

		/*
		 * UserModel model=new UserModel(); model.login("lavoro",
		 * "alessandro.rossi@honeywell.com"); String message=model.getMessage();
		 * System.out.println(message);
		 */

		/*
		 * DAOUser dao=new DAOUser(); List<User>list= dao.selectAllEmails();
		 * for(User u:list){ System.out.println(u.getEmail()); }
		 */

		/*
		 * UserModel model=new UserModel(); model.newUser("alex.rossi@email.cz",
		 * "dddddddd"); String message=model.getMessage();
		 * System.out.println(message);
		 */

		/*
		 * DAOUser dao=new DAOUser(); User
		 * user1=dao.returnUser("alessao.rossi@honeywell.com");
		 * System.out.println(user1.getEmail());
		 * System.out.println(user1.getPassword());
		 */

		/*
		 * UserModel model=new UserModel(); model.login("", "");
		 * System.out.println(model.getMessage());
		 */

		/*
		 * DAOArticoloRM dao=new DAOArticoloRM(); int total=dao.getTotalCount();
		 * System.out.println(total);
		 */

		/*
		 * DAOArticoloRM dao=new DAOArticoloRM(); =dao.getAllIDandRistorante();
		 * for(ArticoloRM art:list){ System.out.println(art.getId());
		 * System.out.println(art.getRistorante()); }
		 */

		/*
		 * HomeViewModel hvm=new HomeViewModel();
		 * hvm.generateListaArticoliRM(0); List<ArticoloRM>
		 * list=hvm.getListaArticoliRM();
		 */

		// DAOArticoloRM dao=new DAOArticoloRM();
		/*NewEditArticolo nea = new NewEditArticolo(3);
		List<String> list= nea.getListaImg();
		for(String s:list){
			System.out.println(s);
		}*/
		
		//System.out.println(new File ("/BLOG/WebContent/img/pizzanuova.jpg").getName());
		
		//crea file contenente path del folder
		File folder=new File("C:/Users/Alessandro/workspace/BLOG/WebContent/img");
		//crea file[] contenente tutti gli oggetti nel folder
		File[] array=folder.listFiles();
		// crea file[] contenente solamente il nome
		List<String>list=new ArrayList<String>();
		for(File f:array){
			list.add(f.getName());
		}
		for(String f:list){
			System.out.println(f);
		}
	}
}
