<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="authentification.css">
<script type="text/javascript"></script>
<title>Authentification</title>
<style>
	body{
		background-image: url("https://p7.hiclipart.com/preview/191/801/230/online-shopping-shopping-cart-software-e-commerce-sold-out-thumbnail.jpg");
	}
	
	blink{
		color: blue;
	}
</style>
</head>
<body>
	<div class="contenue">
		<blink>Gestion de vente</blink>
	</div>
	<div class="contenant">
        <div>
            <h1>Formulaire d'authentification</h1>
        </div>
        <form action="ServeletLogin" method="post">
            <div>
                <label for="login">Login :</label>
                <input type="text" name="login">
            </div>
            <div>
                <label for="password">Password :</label>
                <input type="password" name="password">
            </div>
           
            <div>
                <button id="b1">Se connecter</button>
            </div>
            <br>
            <br>
             <div>
                <h4>Cliquer <a href="choix.jsp">ici</a> pour vous inscrire</h4>
            </div>
        </form>
    </div>
</body>
</html>