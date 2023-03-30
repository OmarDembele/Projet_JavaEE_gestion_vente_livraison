package sn.esmt.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
import sn.esmt.models.Produit;
import sn.esmt.models.Commande;
import sn.esmt.models.ProduitDao;
import sn.esmt.models.CommandeDao;
import sn.esmt.models.PanierDao;

/**
 * Servlet implementation class ServeletPanier
 */
@WebServlet("/ServeletPanier")
public class ServeletPanier extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		
		Commande e1 = new Commande();
		Produit e = new Produit();
		
		String idProd=request.getParameter("idProd"); 
		int id=Integer.parseInt(idProd);
		
		
		Produit list=ProduitDao.getProduitById(id);
		e.setCodeProd(list.getCodeProd());
		e.setNomProd(list.getNomProd());
		e.setCategorieProd(list.getCategorieProd());
		e.setQtiteProd(list.getQtiteProd());
		e.setPrixUnitaire(list.getPrixUnitaire());
		e.setDateFab(list.getDateFab());
		e.setDateExp(list.getDateExp());
		
		Random random = new Random();
		int nb = random.nextInt(5000);
		String s= "En attente";
		
		
		Produit list1=ProduitDao.getProduitById(id);
		
		e1.setCodeProd(list1.getCodeProd()); 
		e1.setNomProd(list1.getNomProd());
		e1.setCategorieProd(list1.getCategorieProd());
		e1.setQtiteProd(list1.getQtiteProd());
		e1.setPrixUnitaire(list1.getPrixUnitaire());
		e1.setDateFab(list1.getDateFab());
		e1.setDateExp(list1.getDateExp());
		
		
		e1.setCodeCmd(nb);
		e1.setTypeCmd(s);
		e1.setDateCmd(list1.getDateExp());
		
		int status=PanierDao.save(e); 
		int status1 = CommandeDao.save(e1);
		if(status>0){
			if(status1>0 ){
			response.sendRedirect("panier.jsp");
		}
		else{ 
			out.println("Sorry! Commande non acceptée"); 
		} 
		out.close(); 
		}
	}
}

