<%@ page import="sn.esmt.models.Livraison" %>
<%@ page import="sn.esmt.models.LivraisonDao" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Date" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<meta name="description" content="" />
<meta name="author" content="" />
<title>Livraison</title>
        <!-- Favicon-->
<link rel="icon" type="image/x-icon" href="assets/favicon.ico" />
        <!-- Font Awesome icons (free version)-->
<script src="https://use.fontawesome.com/releases/v6.1.0/js/all.js"></script>
        <!-- Google fonts-->
<link href="https://fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet" type="text/css" />
<link href="https://fonts.googleapis.com/css?family=Roboto+Slab:400,100,300,700" rel="stylesheet" type="text/css" />
        <!-- Core theme CSS (includes Bootstrap)-->
<link href="css/styles.css" rel="stylesheet" />
<link href="achatProduit.css" rel="stylesheet" />
<style>
	
	table{
	    width: 85%;
	    margin: auto;
	    border-collapse: collapse;
	    background-color: bisque;
	}
	td,th{
	    border:1px solid royalblue;
	}
	tr:hover{
	    background-color: darkgray;
	}
	tr:nth-child(even){
	    background: #cccccc;
	}
	tr:nth-child(odd){
	    background: turquoise;
	}
	tr:nth-child(1){
	    background: moccasin;
	}	
</style>
</head>
<body id="page-top">
     <nav class="navbar navbar-expand-lg navbar-dark fixed-top" id="mainNav">
            <div class="container">
                <a class="navbar-brand" href="#page-top"><img src="https://img2.freepng.fr/20180406/zww/kisspng-logo-brand-e-commerce-company-cmyk-5ac77289b48205.7616565115230204257394.jpg" alt="..." width="100%" height="50%"/></a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
                    Menu
                    <i class="fas fa-bars ms-1"></i>
                </button>
                <div class="collapse navbar-collapse" id="navbarResponsive">
                    <ul class="navbar-nav text-uppercase ms-auto py-4 py-lg-0">
                    	<li class="nav-item"><a class="nav-link" href="navigateurFournisseur.jsp#service">Services</a></li>
                        <li class="nav-item"><a class="nav-link" href="navigateurFournisseur.jsp#ajoutProduit">Ajout Produits</a></li>
                        <li class="nav-item"><a class="nav-link" href="navigateurFournisseur.jsp#achatProduit">Liste Produits</a></li>
                        <li class="nav-item"><a class="nav-link" href="navigateurFournisseur.jsp#contact">Commande</a></li>
                        <li class="nav-item"><a class="nav-link" href="livraison.jsp">Livraison</a></li>
                        <li class="nav-item"><a class="nav-link" href="authentification.jsp">Deconnexion</a></li>                  
                    </ul>
                </div>
            </div>
        </nav>
        <header class="masthead">
            <div class="container">
                <div class="masthead-subheading">Bienvenue dans notre Studio!</div>
                <div class="masthead-heading text-uppercase">C’est un plaisir de vous rencontrer</div>
                <a class="btn btn-primary btn-xl text-uppercase" href="#service">Voir les livraison</a>
            </div>
        </header>
         <section class="page-section " id="commande">
    	<article>
    	 	<div class="container">
                <div class="text-center">
                    <h2 class="section-heading text-uppercase">La Liste des Livraisons </h2>
                </div>
              </div> 
    	 	<div>
    	 		<table>
    	 			<tr>
    	 				<td>Id Livraison</td>
    	 				<td>Code Commande</td>
    	 				<td>Code Livraison</td>
    	 				<td>Date Livraison</td>
    	 				<td>Supprimer</td>
    	 			</tr>
    	 			 <%
				    	List<Livraison> list2=LivraisonDao.getAllLivraisons();
    	 			 Date date = new Date();
				    	for (Livraison prod : list2) { %>
    	 			<tr>
    	 					<td><%= prod.getIdLiv() %></td>
	    	 				<td><%= prod.getCodeCmd() %></td>
	    	 				<td><%= prod.getCodeLiv() %></td>
	    	 				<td><%= date %></td>
	    	 				<td> <a href='DeleteServeletLivraison?idLiv=<%= prod.getIdLiv() %>'>delete</a></td>
    	            	</tr>
    	            	 <% } %>
    	 		</table>
    	 	</div>
    	 </article>               	                    
    </section>
</body>
</html>