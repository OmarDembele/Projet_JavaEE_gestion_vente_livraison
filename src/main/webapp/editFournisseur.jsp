<%@ page import="sn.esmt.models.Produit" %>
<%@ page import="sn.esmt.models.ProduitDao" %>
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
		color: white;
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
                        <li class="nav-item"><a class="nav-link" href="navigateurFournisseur.jsp#ajoutProduit">Ajout Produits</a></li>
                        <li class="nav-item"><a class="nav-link" href="navigateurFournisseur.jsp#ajoutProduit#achatProduit">Liste Produits</a></li>
                        <li class="nav-item"><a class="nav-link" href="navigateurFournisseur.jsp#ajoutProduit#contact">Commande</a></li>
                        <li class="nav-item"><a class="nav-link" href="panier.jsp">Livraison</a></li>
                        <li class="nav-item"><a class="nav-link" href="authentification.jsp">Deconnexion</a></li>                  
                    </ul>
                </div>
            </div>
        </nav>
        <header class="masthead">
            <div class="container">
                <div class="masthead-subheading">Welcome To Our Studio!</div>
                <div class="masthead-heading text-uppercase">It's Nice To Meet You</div>
                <a class="btn btn-primary btn-xl text-uppercase" href="#service">Tell Me More</a>
            </div>
        </header>
        <section class="page-section" id="ajoutProduit">
            <div class="container">
                <div class="text-center">
                    <h2 class="section-heading text-uppercase">Modifier des produits</h2>
                    <h3 class="section-subheading text-muted">Vous pouvez modifier des produits à travers ce formulaire.</h3>
                </div>
                <!-- * * * * * * * * * * * * * * *-->
                <!-- * * SB Forms Contact Form * *-->
                <!-- * * * * * * * * * * * * * * *-->
                <!-- This form is pre-integrated with SB Forms.-->
                <!-- To make this form functional, sign up at-->
                <!-- https://startbootstrap.com/solution/contact-forms-->
                <!-- to get an API token!-->
                <form id="contactForm" action="ServeletProduit" method="POST" >
                 <%
					int id = Integer.parseInt(request.getParameter("idProd"));
					Produit product = ProduitDao.getProduitById(id);
				 %>
                    <div class="row align-items-stretch mb-5">
                        <div class="col-md-6">
                            <div class="form-group mb-2">
                                <!-- Name input-->
                                <input class="form-control" id="codeProd" name="codeProd" type="number" value="<%= product.getCodeProd() %>" data-sb-validations="required" />
                            </div>
                            <div class="form-group mb-2">
                                <!-- Email address input-->
                                <input class="form-control" id="nomProd" name="nomProd" type="text"value="<%= product.getNomProd() %>" data-sb-validations="required,nomProd" />
                                
                            </div>
                            <div class="form-group md-0 mb-2">
                                <!-- Phone number input-->
                                <input class="form-control" name="categorieProd" id="categorieProd" type="text" value="<%= product.getCategorieProd() %>" data-sb-validations="required" />
                            </div>
                            <div class="form-group md-0 mb-2">
                                <!-- Phone number input-->
                                <input class="form-control" name="qtiteProd" id="qtiteProd" type="number" value="<%= product.getQtiteProd() %>" data-sb-validations="required" />
                        </div>
                        </div>
                        <div class="col-md-6">
                            <div class="form-group form-group-textarea mb-md-0 mb-2">
                                <!-- Message input-->
                                <div class="form-group md-0 mb-2">
                                <!-- Phone number input-->
                                	<input class="form-control" name="prixUnitaire" id="prixUnitaire" type="number" value="<%= product.getPrixUnitaire() %>" data-sb-validations="required" />
                        		</div>
                        		<div class="form-group md-0 mb-2">
                                <!-- Phone number input-->
                                	<input class="form-control" name="dateFab" id="dateFab" type="Date" value="<%= product.getDateFab() %>" data-sb-validations="required" />
                        		</div>
                        		<div class="form-group md-0 mb-2">
                                <!-- Phone number input-->
                                	<input class="form-control" name="dateExp" id="dateExp" type="Date" value="<%= product.getDateExp() %>" data-sb-validations="required" />
                        		</div>
                            </div>
                        </div>
                    </div>
                    <!-- Submit Button-->
                    <div class="text-center"><button class="btn btn-primary btn-xl text-uppercase" id="submitButton" >Modifier</button></div>
                </form>
            </div>  	               
    </section>
</body>
</html>