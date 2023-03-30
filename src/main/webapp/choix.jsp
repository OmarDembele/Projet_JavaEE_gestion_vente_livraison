<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Choix</title>
<style type="text/css">
	body{
		margin-top: 15%;
		background-image: url("https://p7.hiclipart.com/preview/191/801/230/online-shopping-shopping-cart-software-e-commerce-sold-out-thumbnail.jpg");
	}
		
	.contenant{
		text-align: center;
    	margin: 0% 30% 5% 30%;
    	float: center;
	}
	button{
    border: 2px solid rgb(18, 70, 123);
    border-radius: 4px;
    padding: 10px 20px;
    margin: 15px 105px 10px 111px;
    box-sizing: border-box;
    font-size: 20px;
    border-radius: 20px;
    display: block;
    width: 60%;
}
#b1{
    background-color: rgb(70, 76, 189);
    text-align: center;
}

</style>
</head>
<body>
	<div class="contenant">
		<form action="formulaireClient.jsp" method="post">
            <div>
                <button id="b1">Client</button>
            </div>
        </form>
    </div>
    <div class="contenant">    
        <form action="formulaireFournisseur.jsp" method="post">
            <div>
                 <button id="b2">Fornisseur</button>
            </div>
        </form>
   </div>
</body>
</html>

