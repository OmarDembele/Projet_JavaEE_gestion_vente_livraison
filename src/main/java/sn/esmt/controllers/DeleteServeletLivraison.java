package sn.esmt.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import sn.esmt.models.LivraisonDao;

import java.io.IOException;

/**
 * Servlet implementation class DeleteServeletLivraison
 */
@WebServlet("/DeleteServeletLivraison")
public class DeleteServeletLivraison extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { 
			 String idLiv=request.getParameter("idLiv"); 
			 int id=Integer.parseInt(idLiv); 
			 int status = LivraisonDao.delete(id);
			 if(status>0) {
				 response.sendRedirect("Livraison.jsp"); 
			 } 
	}
}
