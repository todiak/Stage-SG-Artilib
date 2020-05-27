package controllers;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import site_interface.Model;
import site_interface.Utilisateur;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet") 
public class LoginServlet extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, java.io.IOException {
		
		String mail = request.getParameter("mail");
		String mdp = request.getParameter("mdp");
		
		HttpSession session = request.getSession(true);
		
		session.setAttribute("mail", mail);
		session.setAttribute("mdp", mdp);
		
		
		try {
			Class.forName("models.ModelData");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		Utilisateur user = Model.getInstance().getUser(mail, mdp);
		
		if (user != null) {
			
			session.setAttribute("sessionUtilisateur", user);
			
			if(user.isArtisan()) {
				response.sendRedirect(request.getContextPath()+"/#"); //Page d'accueil pour un artisan
			}
			else {
				response.sendRedirect(request.getContextPath()+"/index.jsp"); //Page d'accueil pour un particulier   		
			}
		}
		else {
			session.setAttribute("erreurLogin", "1");
			response.sendRedirect(request.getContextPath()+"/#");
		}
		
		
	}
}