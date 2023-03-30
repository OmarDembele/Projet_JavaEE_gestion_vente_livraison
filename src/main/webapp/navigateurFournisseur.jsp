<%@ page import="sn.esmt.models.Commande" %>
<%@ page import="sn.esmt.models.CommandeDao" %>
<%@ page import="java.util.Date" %>
<%@ page import="sn.esmt.models.Produit" %>
<%@ page import="sn.esmt.models.ProduitDao" %>
<%@ page import="sn.esmt.models.Contact" %>
<%@ page import="sn.esmt.models.ContactDao" %>
<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<meta name="description" content="" />
<meta name="author" content="" />
<title>Navigateur Fournisseur</title>
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
		body{
			background-color: #333;
		}
		section{
			background-color: #333;
		}
		
		#bouton{
			background-color: blue;
		}
		td{
			justify-content: center;
			text-align: center;
			margin-left: 5px;
		}
		
	.contenant{
    text-align: center;
    margin: 2% 30% 5% 30%;
    float: right;
    border: 2px solid black;
    padding: 0px;
    background-color: rgb(240, 231, 219);
    border-radius: 20px;
	}
	
	.titleProd{
		font-size: 22px;
	}
	
	.titreProd{
		text-align: center;
		color: #333;
	}
	
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
                    <li class="nav-item"><a class="nav-link" href="#service">Services</a></li>
                        <li class="nav-item"><a class="nav-link" href="#ajoutProduit">Ajout Produits</a></li>
                        <li class="nav-item"><a class="nav-link" href="#listeProduit">Liste Produits</a></li>
                        <li class="nav-item"><a class="nav-link" href="#commande">Commande</a></li>
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
                <a class="btn btn-primary btn-xl text-uppercase" href="#service">Voir plus</a>
            </div>
        </header>
        <section class="page-section" id="service">
            <div class="container">
                <div class="text-center">
                    <h2 class="section-heading text-uppercase">Services</h2>
                    <h3 class="section-subheading text-muted">VENTE EN LIGNE <br>Cette application est un projet de gestion de vente en ligne accessible à toutes les personnes qui ont des produits à vendre. Ces personnes peuvent ajouter les produits qui pourra etre consulté ou aheté si besoin par les utilisateurs. </h3>
                </div>
                <div class="row text-center justify-content-center">
                    <div class="col-md-4">
                        <span class="fa-stack fa-4x">
                            <i class="fas fa-circle fa-stack-2x text-primary"></i>
                            <i class="fas fa-shopping-cart fa-stack-1x fa-inverse"></i>
                        </span>
                        <h4 class="my-3">E-Commerce</h4>
                        <p class="text-muted">Pour définir le terme e-commerce, nous pouvons dire qu'il représente les différentes transactions commerciales qui se font à distance sur internet. Nous avons ici les differentes produits se trouvent actuellement dans notre structure.</p>
                    </div>
                </div>
            </div>
        </section>
        <section class="page-section" id="ajoutProduit">
            <div class="container">
                <div class="text-center">
                    <h2 class="section-heading text-uppercase">Ajouter des produits</h2>
                    <h3 class="section-subheading text-muted">Vous pouvez ajouter des produits à travers ce formulaire.</h3>
                </div>
                <!-- * * * * * * * * * * * * * * *-->
                <!-- * * SB Forms Contact Form * *-->
                <!-- * * * * * * * * * * * * * * *-->
                <!-- This form is pre-integrated with SB Forms.-->
                <!-- To make this form functional, sign up at-->
                <!-- https://startbootstrap.com/solution/contact-forms-->
                <!-- to get an API token!-->
                <form id="contactForm" action="ServeletProduit" method="POST" >
                    <div class="row align-items-stretch mb-5">
                        <div class="col-md-6">
                            <div class="form-group mb-2">
                                <!-- Name input-->
                                <input class="form-control" id="codeProd" name="codeProd" type="number" placeholder="Code produit*" data-sb-validations="required" />
                            </div>
                            <div class="form-group mb-2">
                                <!-- Email address input-->
                                <input class="form-control" id="nomProd" name="nomProd" type="text" placeholder="Nom Produit *" data-sb-validations="required,nomProd" />
                                
                            </div>
                            <div class="form-group md-0 mb-2">
                                <!-- Phone number input-->
                                <input class="form-control" name="categorieProd" id="categorieProd" type="text" placeholder="Categorie Produit *" data-sb-validations="required" />
                            </div>
                            <div class="form-group md-0 mb-2">
                                <!-- Phone number input-->
                                <input class="form-control" name="qtiteProd" id="qtiteProd" type="number" placeholder="Quantite Produit *" data-sb-validations="required" />
                        </div>
                        </div>
                        <div class="col-md-6">
                            <div class="form-group form-group-textarea mb-md-0 mb-2">
                                <!-- Message input-->
                                <div class="form-group md-0 mb-2">
                                <!-- Phone number input-->
                                	<input class="form-control" name="prixUnitaire" id="prixUnitaire" type="number" placeholder="Prix Unitaire *" data-sb-validations="required" />
                        		</div>
                        		<div class="form-group md-0 mb-2">
                                <!-- Phone number input-->
                                	<input class="form-control" name="dateFab" id="dateFab" type="Date" placeholder="Date Fabriquation *" data-sb-validations="required" />
                        		</div>
                        		<div class="form-group md-0 mb-2">
                                <!-- Phone number input-->
                                	<input class="form-control" name="dateExp" id="dateExp" type="Date" placeholder="Date Expiration *" data-sb-validations="required" />
                        		</div>
                            </div>
                        </div>
                    </div>
                    <!-- Submit Button-->
                    <div class="text-center"><button class="btn btn-primary btn-xl text-uppercase" id="submitButton" >Valider</button></div>
                </form>
            </div>  	               
    </section>
    <section class="page-section bg-white" id="listeProduit">
    	<div class="container">
    	<article class="">
    	 	<div class="titreProd">
    	 		<h2>Liste des produits ajoutées</h2> 
    	 	</div>
    	 	<div>
    	 		<table>
    	 			<tr>
    	 				<td>Code Produit</td>
    	 				<td>Code Produit</td>
    	 				<td>Nom Produit</td>
    	 				<td>Categorie</td>
    	 				<td>Quantite</td>
    	 				<td>Prix Unitaire</td>
    	 				<td>Date Fab</td>
    	 				<td>Date Exp</td>
    	 				<td>Edit</td>
    	 				<td>Supprimer</td>
    	 			</tr>
    	 			 <%
    	 				List<Produit> list=ProduitDao.getAllProduits();
    	 				for (Produit prod : list) { %>
    	 			<tr>
	    	 				<td><%= prod.getIdProd() %></td>
	    	 				<td><%= prod.getCodeProd() %></td>
	    	 				<td><%= prod.getNomProd() %></td>
	    	 				<td><%= prod.getCategorieProd() %></td>
	    	 				<td><%= prod.getQtiteProd() %></td>
	    	 				<td><%= prod.getPrixUnitaire() %></td>
	    	 				<td><%= prod.getDateFab() %></td>
	    	 				<td><%= prod.getDateExp() %></td>
	    	 				<td> <a href='editFournisseur.jsp?idProd=<%= prod.getIdProd() %>'>Edit</a></td>
	    	 				<td> <a href='DeleteServelet?idProd=<%= prod.getIdProd() %>'>delete</a></td>
    	            	</tr>
    	            	 <% } %>
    	 		</table>
    	 	</div>
    	 </article>
    	 </div>
    </section>
    <section class="page-section " id="commande">
    	<article>
    	 	<div class="container">
                <div class="text-center">
                    <h2 class="section-heading text-uppercase">Les Commandes faites par les differentes utilisateurs</h2>
                </div>
              </div> 
    	 	<div>
    	 		<table>
    	 			<tr>
    	 			<td>Id Commande</td>
    	 				<td>Code Commande</td>
    	 				<td>Nom Produit</td>
    	 				<td>Categorie</td>
    	 				<td>Quantite</td>
    	 				<td>Prix Unitaire</td>
    	 				<td>Detail de la commande</td>
    	 				<td>Type Commande</td>
    	 				<td>Supprimer</td>
    	 			</tr>
    	 			 <%
				    	List<Commande> list2=CommandeDao.getAllCommandes();
    	 			 Date date = new Date();
				    	for (Commande prod : list2) { %>
    	 			<tr>
    	 					<td><%= prod.getIdCmd() %></td>
	    	 				<td><%= prod.getCodeCmd() %></td>
	    	 				<td><%= prod.getNomProd() %></td>
	    	 				<td><%= prod.getCategorieProd() %></td>
	    	 				<td><%= prod.getQtiteProd() %></td>
	    	 				<td><%= prod.getPrixUnitaire() %></td>
	    	 				<td> Date de la commande : <%= date %> <br></td>
	    	 				<td class="contenus"> 
	    	 					<%= prod.getTypeCmd() %> <br>
	    	 					<a href='ServeletLivraison?idCmd=<%= prod.getIdCmd() %>'> Etat </a>
	    	 				</td>
	    	 				<td> <a href='DeleteServelet?idCmd=<%= prod.getIdCmd() %>'>delete</a></td>
    	            	</tr>
    	            	 <% } %>
    	 		</table>
    	 	</div>
    	 </article>               	                    
    </section>
    <section class="page-section " id="commande">
    	<article>
    	 	<div class="container">
                <div class="text-center">
                    <h2 class="section-heading text-uppercase">Les Reclamations des differentes Utilisateurs</h2>
                </div>
              </div> 
    	 	<div>
    	 		<table>
    	 			<tr>
    	 				<td>Nom</td>
    	 				<td>Email</td>
    	 				<td>Numero</td>
    	 				<td>Message</td>
    	 				<td>Supprimer</td>
    	 			</tr>
    	 			 <%
				    	List<Contact> list3=ContactDao.getAllContacts();
				    	for (Contact prod : list3) { %>
    	 			<tr>
    	 					<td><%= prod.getName() %></td>
	    	 				<td><%= prod.getEmail() %></td>
	    	 				<td><%= prod.getNumero() %></td>
	    	 				<td><%= prod.getMessage() %></td>
	    	 				<td> <a href='DeleteServeletContact?id=<%= prod.getId() %>'>delete</a></td>
    	            	</tr>
    	            	 <% } %>
    	 		</table>
    	 	</div>
    	 </article>               	                    
    </section>
</body>
</html>