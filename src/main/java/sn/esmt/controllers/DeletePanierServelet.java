package sn.esmt.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import sn.esmt.models.PanierDao;

import java.io.IOException;

/**
 * Servlet implementation class DeletePanierServelet
 */
@WebServlet("/DeletePanierServelet")
public class DeletePanierServelet extends HttpServlet {

		private static final long serialVersionUID = 1L;
		
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { 
				 String idProd=request.getParameter("idProd"); 
				 int id=Integer.parseInt(idProd); 
				 int status = PanierDao.delete(id); 
				 if(status>0) {
					 response.sendRedirect("panier.jsp"); 
				 } 
		}
	}