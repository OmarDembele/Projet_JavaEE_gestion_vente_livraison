package sn.esmt.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import sn.esmt.models.Contact;
import sn.esmt.models.ContactDao;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class ContactServelet
 */
@WebServlet("/ContactServelet")
public class ContactServelet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html"); 
		PrintWriter out=response.getWriter(); 
		String name=request.getParameter("name"); 
		String email=request.getParameter("email");
		int numero= Integer.parseInt(request.getParameter("numero"));
		String message = request.getParameter("message");
		Contact e=new Contact();
		e.setName(name);
		e.setEmail(email);
		e.setNumero(numero);
		e.setMessage(message);
		
		int status=ContactDao.save(e);
		if(status>0 ){ 
			response.sendRedirect("navigateurClient.jsp");
		}
		else{ 
			out.println("Sorry! unable to save record"); 
		} 
		out.close(); 
		}
	}
