package controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import site_interface.Model;
import site_interface.Service;
import site_interface.Utilisateur;

@WebServlet("/DetailProfilServlet")
public class DetailProfilServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@SuppressWarnings("unchecked")
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, java.io.IOException {
		int idArti = Integer.parseInt(request.getParameter("idArti"));
		
		HttpSession session = request.getSession(true);
		
		try {
			Class.forName("models.ModelData");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		List<Service> listeServiceArti = Model.getInstance().serviceArti(idArti);
		
		session.setAttribute("listeServiceArti", listeServiceArti);
		
		Object[] lesHorairesArti = Model.getInstance().horaireArti(idArti);
			
		
		session.setAttribute("lesHorairesArti", lesHorairesArti);
		
		List<Utilisateur> listeArti = new ArrayList<Utilisateur>();  
        listeArti = (ArrayList<Utilisateur>) session.getAttribute("listeArti");
        
        for (Utilisateur u : listeArti) {
        	if(u.data()[8].equals(idArti)) {
        		session.setAttribute("ArtiClick", u);
        		break;
        	}
        }
		
		//session.setAttribute(localisation, localisation);
		//session.setAttribute(search, search);
		
		response.sendRedirect(request.getContextPath()+"/ProfilArtisan.jsp"); //Page d'accueil pour bibliothecaire 
	}

}
