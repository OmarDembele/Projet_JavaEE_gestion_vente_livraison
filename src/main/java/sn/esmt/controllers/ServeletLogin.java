package sn.esmt.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import sn.esmt.models.Utilisateur;
import sn.esmt.models.UtilisateurDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * Servlet implementation class ServeletLoggin
 */
@WebServlet("/ServeletLogin")
public class ServeletLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html"); 
		PrintWriter out=response.getWriter();
		String login=request.getParameter("login"); 
		String password=request.getParameter("password");
		UtilisateurDao dataSourceUser = new UtilisateurDao();
		
		List<Utilisateur> log=dataSourceUser.getAllUtilisateurs(); 
		for(Utilisateur l: log) {
			if(login.equals(l.getLogin()) && password.equals(l.getPassword())) {
				if(l.getProfil().equals("Client")) {
					response.sendRedirect("navigateurClient.jsp");
		 
		}
			else if( l.getProfil().equals("Fournisseur")){
				response.sendRedirect("navigateurFournisseur.jsp");
			}
			else {
				out.println("Sorry! Authentification failed");
			}
		}
	}
	}
}
