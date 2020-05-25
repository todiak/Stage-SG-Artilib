package controllers;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet") 
public class LoginServlet extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, java.io.IOException {
		
		String login = request.getParameter("login");
		String password = request.getParameter("password");
		
		HttpSession session = request.getSession(true);
		
		session.setAttribute("login", login);
		session.setAttribute("password", password);
		
		try {
			Class.forName("persistantdata.MediathequeData");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		/*
		Utilisateur user = Mediatheque.getInstance().getUser(login, password);
		
		if (user != null) {
			
			session.setAttribute("sessionUtilisateur", user);
			
			
			if(user.isBibliothecaire()) {
				response.sendRedirect(request.getContextPath()+"/AccueilBibliothecaire.jsp"); //Page d'accueil pour bibliothecaire 
			}
			else {
				response.sendRedirect(request.getContextPath()+"/AccueilAbonne.jsp"); //Page d'accueil pour abonne    		
			}
		}
		else {
			session.setAttribute("erreurLogin", "1");
			response.sendRedirect(request.getContextPath()+"/Login.jsp"); // page d'erreur
		}
		*/
		
	}
}