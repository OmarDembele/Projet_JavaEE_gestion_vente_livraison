<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="formulaire.css">
<style type="text/css">
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
<title>Forulaire Client</title>
</head>
<body>
	<div class="contenant">
        <div>
            <h1>Formulaire d'inscription des clients</h1>
        </div>
        
        <form action="ServeletClient" method="post">
            <div>
                <label for="nomClient">Nom complet Client:</label>
                <input type="text" name="nomClient">
            </div>
            <div>
                <label for="typeClient">Type Client:</label>
                <select name="typeClient" id="typeClient">
                    <option value="">Selectionnez</option>
                    <option value="entreprise">Entrprise</option>
                    <option value="personne">Personne Physique</option>
                </select>
            </div>
                 <div>
                <label for="adresseClient">Adresse Client :</label>
                <input type="text" name="adresseClient">
            </div>
            <div>
                <label for="specialiteClient">Specialite Client:</label>
                <input type="text" name="specialiteClient">
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