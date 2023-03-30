package sn.esmt.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import sn.esmt.models.ContactDao;

import java.io.IOException;

/**
 * Servlet implementation class DeleteServeletContact
 */
@WebServlet("/DeleteServeletContact")
public class DeleteServeletContact extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { 
			 String id=request.getParameter("id"); 
			 int id1=Integer.parseInt(id); 
			 int status = ContactDao.delete(id1); 
			 if(status>0) {
				 response.sendRedirect("navigateurFournisseur.jsp"); 
			 } 
	}
}
