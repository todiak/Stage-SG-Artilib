package controllers;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import site_interface.Model;

@WebServlet("/InscriptionServlet")
public class InscriptionServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, java.io.IOException {
		String nom = request.getParameter("nomUser");
		String prenom = request.getParameter("prenomUser");
		String mail = request.getParameter("mail");
		String mdp = request.getParameter("mdp");
		int tel = Integer.parseInt(request.getParameter("tel"));
		int cp = Integer.parseInt(request.getParameter("cp"));
		String ville = request.getParameter("ville");
		String adresse = request.getParameter("adresse");
		
		HttpSession session = request.getSession(true);
		
		try {
			Class.forName("models.ModelData");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		boolean user = Model.getInstance().existUser(mail);
		
		if (user == true) {
			
			session.setAttribute("existUser", user);
			
			response.sendRedirect(request.getContextPath()+"/inscription.jsp"); //Page d'accueil pour bibliothecaire 

		}
		else {
			Model.getInstance().addUser("part", nom, prenom, mdp, mail, tel,cp, ville, adresse);
			
			response.sendRedirect(request.getContextPath()+"/index.jsp");
		}
	}
}
