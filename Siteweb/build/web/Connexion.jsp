<%-- 
    Document   : Connexion
    Created on : 23 nov. 2018, 13:34:55
    Author     : Joker
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<title>Connexion</title>
	<meta charset="utf-8">
	<link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
	<header>
		<div class="Bandeau">
	
	<ul> 
		<li class="btn-bandeau"><a href="Accueil.jsp">Le Coin Sport</a></li>
		<li class="btn-bandeau"><a name = "choixAction" value = "Annonce" href="ServletControleur?idEcran=1&choixAction=Annonce">Annonces</a></li>
		<li class="btn-bandeau"><a href="Inscription.jsp">Inscription</a></li>
		<li class="btn-bandeau"><a href="Connexion.jsp">Connexion</a></li>
	</ul>

</div>
	</header>

    <form class="form_connexion" action="PostConnexionUsers.jsp" method="post">
        Login:<input type="text" name="login"/><br/>
        Password:<input type="password" name="motDePasse"/><Br/>
        <input type="submit" value="Connexion"/>
    </form>
<p class="link_inscription">Si vous n'avez pas encore de compte : <a href="Inscription.jsp">Inscrivez-vous</a></p>

<footer>
	<p>
		Copyright &copy; Freitas Raul all rights reserved
	</p>
</footer>
</body>
</html>
