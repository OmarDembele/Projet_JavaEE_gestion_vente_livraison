package sn.esmt.controllers;

import java.sql.Date;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
import sn.esmt.models.Commande;
import sn.esmt.models.Livraison;
import sn.esmt.models.LivraisonDao;
import sn.esmt.models.CommandeDao;

/**
 * Servlet implementation class ServeletPanier
 */
@WebServlet("/ServeletLivraison")
public class ServeletLivraison extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		
		String idCmd=request.getParameter("idCmd"); 
		int id=Integer.parseInt(idCmd);
		
		Livraison e1 = new Livraison();
		Commande e = new Commande();
		e.setIdCmd(id);
		e.setTypeCmd("Livrer");
		
		
		Random random = new Random();
		int nb = random.nextInt(5000);
		
		
		
		Commande list1=CommandeDao.getCommandeById(id);
		
		e1.setCodeCmd(list1.getCodeProd());
		e1.setCodeLiv(nb); 
		Date date = new Date(nb);
		e1.setDateLiv(date);
		 
		int status1 = LivraisonDao.save(e1);
		int status2 = CommandeDao.update(e);
		if(status1>0 ){
			if(status2>0) {
			response.sendRedirect("livraison.jsp");
		}
		else{ 
			out.println("Sorry! Livraison non acceptée"); 
		} 
		out.close(); 
		}
	}
}
