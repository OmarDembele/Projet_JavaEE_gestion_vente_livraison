<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="formulaire.css">
<style>
	body{
	background-image: url("https://p7.hiclipart.com/preview/191/801/230/online-shopping-shopping-cart-software-e-commerce-sold-out-thumbnail.jpg");
}
	#b1{
      background-color: rgb(70, 76, 189);
    text-align: center;
}

	#b2{
    background-color:rgb(211, 65, 65);
    text-align: center;
}
</style>
<title>Formulaire fournisseur</title>
</head>
<body>
	<div class="contenant">
        <div>
            <h1>Formulaire d'inscription des Fournisseurs</h1>
        </div>
        
        <form action="ServeletFournisseur" method="post">
            <div>
                <label for="codeFour">Code Fournisseur :</label>
                <input type="number" name="codeFour">
            </div>
            <div>
                <label for="nomFour">Nom Complet Fournisseur:</label>
                <input type="text" name="nomFour">
            </div>
            <div>
                <label for="adresseFour">Adresse Fournisseur:</label>
                <input type="text" name="adresseFour">
            </div>
            <div>
                <label for="nationalityFour">Nationalite Fournisseur:</label>
                <input type="text" name="nationalityFour">
            </div>
            <div>
                <label for="login">Login :</label>
                <input type="text" name="login">
            </div>
            <div>
                <label for="password">Password :</label>
                <input type="password" name="password">
            </div>
            <div>
                <label for="profil">Profil :</label>
                <input type="text" name="profil">
            </div>
            <div>
                <button id="b1">S'inscrire</button>
                <button id="b2">Annuler</button>
            </div>
        </form>
    </div>
    <script src="index.js"></script>
</body>
</html>