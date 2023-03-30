package sn.esmt.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import sn.esmt.models.Produit;
import sn.esmt.models.ProduitDao;

/**
 * Servlet implementation class ServeletProduit
 */
@WebServlet("/ServeletProduit") 
public class ServeletProduit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html"); 
		PrintWriter out=response.getWriter(); 
		int codeProd = Integer.parseInt(request.getParameter("codeProd")); 
		String nomProd=request.getParameter("nomProd");
		String categorieProd=request.getParameter("categorieProd");
		int qtiteProd = Integer.parseInt(request.getParameter("qtiteProd"));
		double prixUnitaire=Double.parseDouble(request.getParameter("prixUnitaire")); 
		String dateFab=request.getParameter("dateFab");
		String dateExp=request.getParameter("dateExp");
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date date1=null;
		Date date2=null;
		try {
			java.util.Date utilDate = format.parse(dateFab);
			date1= new java.sql.Date(utilDate.getTime());
			
			java.util.Date utilDate1 = format.parse(dateExp);
			date2= new java.sql.Date(utilDate1.getTime());
		}
		catch (ParseException e) {
			e.printStackTrace();
		}
		
		Produit e = new Produit();
		e.setCodeProd(codeProd);
		e.setNomProd(nomProd);
		e.setCategorieProd(categorieProd);
		e.setQtiteProd(qtiteProd);
		e.setPrixUnitaire(prixUnitaire);
		e.setDateFab(date1);
		e.setDateExp(date2); 
		
		int status=ProduitDao.save(e); 
		if(status>0){ 
			request.getRequestDispatcher("navigateurFournisseur.jsp").include(request, response); 
		}
		else{ 
			out.println("Sorry! unable to save record"); 
		} 
		out.close(); 
		}
}

