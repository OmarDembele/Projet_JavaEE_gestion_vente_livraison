package sn.esmt.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import sn.esmt.models.Client;
import sn.esmt.models.ClientDao;
import sn.esmt.models.Utilisateur;
import sn.esmt.models.UtilisateurDao;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet("/ServeletClient")
public class ServeletClient extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html"); 
		PrintWriter out=response.getWriter(); 
		String login=request.getParameter("login"); 
		String password=request.getParameter("password");
		String profil=request.getParameter("profil");
		String nomClient = request.getParameter("nomClient");
		String typeClient=request.getParameter("typeClient"); 
		String adresseClient=request.getParameter("adresseClient");
		String specialiteClient=request.getParameter("specialiteClient"); 
		Client e=new Client();
		Utilisateur e1 = new Utilisateur();
		e.setNomClient(nomClient);
		e.setTypeClient(typeClient);
		e.setAdresseClient(adresseClient);
		e.setSpecialiteClient(specialiteClient);
		e.setLogin(login); 
		e.setPassword(password); 
		e.setProfil(profil);
		
		e1.setLogin(login);
		e1.setPassword(password);
		e1.setProfil(profil);
			 
		int status=ClientDao.save(e);
		int status1=UtilisateurDao.save2(e1);
		if(status>0 && status1>0){ 
			out.print("<p>Record saved successfully!</p>"); 
			request.getRequestDispatcher("formulaireClient.jsp").include(request, response);
		}
		else{ 
			out.println("Sorry! unable to save record"); 
		} 
		out.close(); 
		}
	}

