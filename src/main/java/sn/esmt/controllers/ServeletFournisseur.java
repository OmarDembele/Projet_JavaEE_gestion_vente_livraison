package sn.esmt.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import sn.esmt.models.Fournisseur;
import sn.esmt.models.FournisseurDao;
import sn.esmt.models.Utilisateur;
import sn.esmt.models.UtilisateurDao;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class ServeletFournisseur
 */
@WebServlet("/ServeletFournisseur")
public class ServeletFournisseur extends HttpServlet {
	private static final long serialVersionUID = 1L;
	  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html"); 
		PrintWriter out=response.getWriter(); 
		String login=request.getParameter("login"); 
		String password=request.getParameter("password");
		String profil=request.getParameter("profil");
		int codeFour = Integer.parseInt(request.getParameter("codeFour"));
		String nomFour=request.getParameter("nomFour"); 
		String adresseFour=request.getParameter("adresseFour");
		String nationalityFour=request.getParameter("nationalityFour"); 
		Fournisseur e=new Fournisseur();
		Utilisateur e1 = new Utilisateur();
		e.setCodeFour(codeFour);
		e.setNomFour(nomFour);
		e.setAdresseFour(adresseFour);
		e.setNationalityFour(nationalityFour);
		e.setLogin(login); 
		e.setPassword(password); 
		e.setProfil(profil);
		
		e1.setLogin(login);
		e1.setPassword(password);
		e1.setProfil(profil);
			 
		int status=FournisseurDao.save1(e);
		int status1=UtilisateurDao.save2(e1);
		if(status>0 && status1>0){ 
			out.print("<p>Record saved successfully!</p>"); 
			request.getRequestDispatcher("formulaireFournisseur.jsp").include(request, response); 
		}
		else{ 
			out.println("Sorry! unable to save record"); 
		} 
		out.close(); 
	} 

}
