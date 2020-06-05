package controllers;

import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import site_interface.Model;
import site_interface.Utilisateur;

@WebServlet("/RechercheServlet")
public class RechercheServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, java.io.IOException {
		String localisation = request.getParameter("localisation");
		String search = request.getParameter("search");
		
		HttpSession session = request.getSession(true);
		
		try {
			Class.forName("models.ModelData");
		}
		catch(Exception e) {
			e.printStackTrace();
		} 
		
		List<Utilisateur> listeArti = Model.getInstance().rechercheArti(localisation,search);
			
		session.setAttribute("listeArti", listeArti);
		
		//session.setAttribute(localisation, localisation);
		//session.setAttribute(search, search);
		
		response.sendRedirect(request.getContextPath()+"/recherche.jsp"); //Page d'accueil pour bibliothecaire 

	}
}
