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
<title>Navigateur Client</title>
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
		.image{
			text-align: center;
			justify-content: center;
			margin-left: 45px;
			margin-right: 35px;
			padding-left: 5px;
		}
		body{
			background-color: #333;
		}
		section{
			background-color: #333;
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
                        <li class="nav-item"><a class="nav-link" href="#achatProduit">Achat produits</a></li>
                        <li class="nav-item"><a class="nav-link" href="#contact">Contact</a></li>
                        <li class="nav-item"><a class="nav-link" href="panier.jsp">Mon Panier</a></li>
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
                    <h3 class="section-subheading text-muted">VENTE EN LIGNE <br> Nous avons en ce moment un service limitée qui sera agrandit dans les temps à venir</h3>
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
        
        <section class="page-section bg-light" id="achatProduit">
            <div class="container">
                <div class="text-center">
                    <h2 class="section-heading text-uppercase">Produits</h2>
                    <h3 class="section-subheading text-muted">Voici actuellement nos produits. Vous pouvez commander</h3>
                </div>
              </div>                
          <section class="secteur1">
			<%
	    	List<Produit> list=ProduitDao.getAllProduits();
	    	for (Produit prod : list) { %>
			<article class="articl ">
				<div class="conteneur">
					<div class="card ">
		  				<img class="image" src="https://img2.freepng.fr/20180406/zww/kisspng-logo-brand-e-commerce-company-cmyk-5ac77289b48205.7616565115230204257394.jpg" alt="Chaussure" style="width:60%">
		  				<div class="container">
			    	 		<h1><b><%= prod.getNomProd() %></b></h1>
			    	 		<p>Categorie :<%= prod.getCategorieProd() %></p>
			   				<p>Quantite :<%= prod.getQtiteProd() %></p>
			    	 		<p class="price"><%= prod.getPrixUnitaire() %>FCFA</p>
			   				<p>Date Fab :<%= prod.getDateFab() %></p>
		 	 				<p>Date Exp :<%= prod.getDateExp() %></p>
			    			<p> <a href='ServeletPanier?idProd=<%= prod.getIdProd()%>'>Commander</a></p>				
		    	       </div>
					</div>
				</div>
			</article>
			<% } %>
		</section>	                    
    </section>
    <section class="page-section bg-light" id="team">
            <div class="container">
                <div class="text-center">
                    <h2 class="section-heading text-uppercase">Our Amazing Team</h2>
                    <h3 class="section-subheading text-muted">L'equipe est composé d'une seule personne qui a travers ses competences acquis dans le cours à realiser ce site E-commerce.</h3>
                </div>
                <div class="row justify-content-center">
                    <div class="col-lg-4">
                        <div class="team-member">
                            <img class="mx-auto rounded-circle" src="assets/img/team/1.jpg" alt="..." />
                            <h4>Omar DEMBELE</h4>
                            <p class="text-muted">Junior Développeur web et mobile</p>
                            <a class="btn btn-dark btn-social mx-2" href="" aria-label="Omar DEMBELE Twitter Profile"><i class="fab fa-twitter"></i></a>
                            <a class="btn btn-dark btn-social mx-2" href="https://www.linkedin.com/in/omar-dembele-418347198/" aria-label="Omar DEMBELE LinkedIn Profile"><i class="fab fa-linkedin-in"></i></a>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-lg-8 mx-auto text-center"><p class="large text-muted">Je suis actuellement un etudiant en LTI3 DAR à l'ecole Superieur Multinationale et des telecommunications. Ce projet nous a été donné pour développer nos competences en Java EE</p></div>
                </div>
            </div>
        </section>
        <!-- Clients-->
        <div class="py-5">
            <div class="container">
                <div class="row align-items-center">
                    <div class="col-md-3 col-sm-6 my-3">
                        <a href="#!"><img class="img-fluid img-brand d-block mx-auto" src="assets/img/logos/microsoft.svg" alt="..." aria-label="Microsoft Logo" /></a>
                    </div>
                    <div class="col-md-3 col-sm-6 my-3">
                        <a href="#!"><img class="img-fluid img-brand d-block mx-auto" src="assets/img/logos/google.svg" alt="..." aria-label="Google Logo" /></a>
                    </div>
                    <div class="col-md-3 col-sm-6 my-3">
                        <a href="#!"><img class="img-fluid img-brand d-block mx-auto" src="assets/img/logos/facebook.svg" alt="..." aria-label="Facebook Logo" /></a>
                    </div>
                    <div class="col-md-3 col-sm-6 my-3">
                        <a href="#!"><img class="img-fluid img-brand d-block mx-auto" src="assets/img/logos/ibm.svg" alt="..." aria-label="IBM Logo" /></a>
                    </div>
                </div>
            </div>
        </div>
        <!-- Contact-->
        <section class="page-section" id="contact">
            <div class="container">
                <div class="text-center">
                    <h2 class="section-heading text-uppercase">Contact Us</h2>
                    <h3 class="section-subheading text-muted">Vous pouvez nous contacter pour toutes informations ou relamations de votre part.</h3>
                </div>
                <!-- * * * * * * * * * * * * * * *-->
                <!-- * * SB Forms Contact Form * *-->
                <!-- * * * * * * * * * * * * * * *-->
                <!-- This form is pre-integrated with SB Forms.-->
                <!-- To make this form functional, sign up at-->
                <!-- https://startbootstrap.com/solution/contact-forms-->
                <!-- to get an API token!-->
                <form id="contactForm" action="ContactServelet" method="POST" >
                    <div class="row align-items-stretch mb-5">
                        <div class="col-md-6">
                            <div class="form-group">
                                <!-- Name input-->
                                <input class="form-control" id="name" name="name" type="text" placeholder="Your Name *" data-sb-validations="required" />
                                <div class="invalid-feedback" data-sb-feedback="name:required">A name is required.</div>
                            </div>
                            <div class="form-group">
                                <!-- Email address input-->
                                <input class="form-control" id="email" name="email" type="email" placeholder="Your Email *" data-sb-validations="required,email" />
                                <div class="invalid-feedback" data-sb-feedback="email:required">An email is required.</div>
                                <div class="invalid-feedback" data-sb-feedback="email:email">Email is not valid.</div>
                            </div>
                            <div class="form-group mb-md-0">
                                <!-- Phone number input-->
                                <input class="form-control" name="numero" id="phone" type="tel" placeholder="Your Phone *" data-sb-validations="required" />
                                <div class="invalid-feedback" data-sb-feedback="phone:required">A phone number is required.</div>
                            </div>
                        </div>
                        <div class="col-md-6">
                            <div class="form-group form-group-textarea mb-md-0">
                                <!-- Message input-->
                                <textarea class="form-control" id="message" name="message" placeholder="Your Message *" data-sb-validations="required"></textarea>
                                <div class="invalid-feedback" data-sb-feedback="message:required">A message is required.</div>
                            </div>
                        </div>
                    </div>
                    <!-- Submit Button-->
                    <div class="text-center"><button class="btn btn-primary btn-xl text-uppercase" id="submitButton" >Send Message</button></div>
                </form>
            </div>
        </section>
        <footer class="footer py-4 bg-white">
            <div class="container">
                <div class="row align-items-center">
                    <div class="col-lg-4 text-lg-start">Copyright &copy; Your Website 2022</div>
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