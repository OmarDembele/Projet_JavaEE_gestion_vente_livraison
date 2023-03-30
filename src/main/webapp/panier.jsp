<%@ page import="sn.esmt.models.Produit" %>
<%@ page import="sn.esmt.models.PanierDao" %>
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
        <title>Navigateur Client</title>
        <!-- Favicon-->
        <link rel="icon" type="image/x-icon" href="assets/favicon.ico" />
        <!-- Font Awesome icons (free version)-->
        <script src="https://use.fontawesome.com/releases/v6.1.0/js/all.js" ></script>
        <!-- Google fonts-->
        <link href="https://fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet" type="text/css" />
        <link href="https://fonts.googleapis.com/css?family=Roboto+Slab:400,100,300,700" rel="stylesheet" type="text/css" />
        <!-- Core theme CSS (includes Bootstrap)-->
        <link href="css/styles.css" rel="stylesheet" />
         <link href="achatProduit.css" rel="stylesheet" />
<title>Mon Panier</title>
<style>
	body{
		background-color: #333;
	}
	.secteur1{
	    padding-top: 4px;
	    padding-bottom: 10px;
 	
	}
	
	.image{
			text-align: center;
			justify-content: center;
			margin-left: 45px;
			margin-right: 35px;
			padding-left: 5px;
		}
	
	div h4{
		
		text-align: center;
		margin-bottom: 5px;
		padding-bottom: 4px;
		color: antiquewhite;
		font-size: 24px;
	}
	
	h1{
		text-align: center;
		color: #267555;
		font-size: 25px;
	}
	
	.articl{
		 display: inline-block; 
	}
		
	.card {
		  box-shadow: 0 4px 4px 0 rgba(0, 0, 0, 0.2);
		  max-width: 250px;
		  margin: 1px 7px 2px 40px;
		  text-align: center;
		  font-family: arial;
		  padding: 1px 5px 5px 7px;
		  box-sizing: border-box;
		  background-color: white;
	}
	
	.price {
		  color: #267555;
		  font-size: 22px;
	}
	
	.card button:hover {
	 	 opacity: 0.7;
	}
	
	a{
		color: red;
		font-size: 20px;
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
                    <li class="nav-item"><a class="nav-link" href="navigateurClient.jsp#service">Services</a></li>
                        <li class="nav-item"><a class="nav-link" href="navigateurClient.jsp#achatProduit">Achat produits</a></li>
                        <li class="nav-item"><a class="nav-link" href="navigateurClient.jsp#contact">Contact</a></li>
                        <li class="nav-item"><a class="nav-link" href="#produit">Mon Panier</a></li>
                        <li class="nav-item"><a class="nav-link" href="authentification.jsp">Deconnexion</a></li>                  
                    </ul>
                </div>
            </div>
        </nav>
        <header class="masthead">
            <div class="container">
                <div class="masthead-subheading">Bienvenue dans notre Studio!</div>
                <div class="masthead-heading text-uppercase">C’est un plaisir de vous rencontrer</div>
                <a class="btn btn-primary btn-xl text-uppercase" href="#panier">Voir Mes Paniers</a>
            </div>
        </header>
	<section class="secteur" id="panier">
		<div>
			<h4>Liste des articles commandées</h4>
		</div>
		<article>
			<%
    		List<Produit> list=PanierDao.getAllPaniers();
    		for (Produit prod : list) { 
    			%>
				<article class="articl">
					<div class="conteneur">
						<div class="card">
			  				<img class="image" src="https://img2.freepng.fr/20180406/zww/kisspng-logo-brand-e-commerce-company-cmyk-5ac77289b48205.7616565115230204257394.jpg" alt="Chaussure" style="width:60%">
			  				<div class="container">
				    	 		<h1><b><%= prod.getNomProd() %></b></h1>
				    	 		<p>Categorie :<%= prod.getCategorieProd() %></p>
				    	 		<p class="price"><%= prod.getPrixUnitaire() %>FCFA</p>
				   				<p>Date Fab :<%= prod.getDateFab() %></p>
			 	 				<p>Date Exp :<%= prod.getDateExp() %></p>
				    			<p> <a href='DeletePanierServelet?idProd=<%= prod.getIdProd()%>'>Annuler</a></p>				
			    	       </div>
						</div>
					</div>
				</article>
				<% } %>
			</article>
		</section>
		<footer class="footer py-4 bg-white">
            <div class="container">
                <div class="row align-items-center">
                    <div class="col-lg-4 text-lg-start">Copyright &copy; Your Website 2023</div>
                    <div class="col-lg-4 my-3 my-lg-0">
                        <a class="btn btn-dark btn-social mx-2" href="#!" aria-label="Twitter"><i class="fab fa-twitter"></i></a>
                        <a class="btn btn-dark btn-social mx-2" href="https://www.linkedin.com/in/omar-dembele-418347198/" aria-label="LinkedIn"><i class="fab fa-linkedin-in"></i></a>
                    </div>
                    <div class="col-lg-4 text-lg-end">
                        <a class="link-dark text-decoration-none me-3" href="#!">Privacy Policy</a>
                        <a class="link-dark text-decoration-none" href="#!">Terms of Use</a>
                    </div>
                </div>
            </div>
        </footer>
	</body>
</html>