<%-- 
    Document   : Inscription
    Created on : 23 nov. 2018, 13:36:25
    Author     : Joker
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<title>Inscription</title>
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

	
<form class="form_inscription">

	Votre Pseudo : <input type="text" name="pseudo" id="pseudo" required>
	Votre Mot De Passe : <input type="text" name="mdp" id="mdp" required>
	Confirmez votre Mot De Passe : <input type="text" name="cmdp" id="cmdp" required>
	Votre Email : <input type="email" name="email" id="email" required>
	Votre Région : <select type="text" name="region" id="region" required><br>
            <option value="">Séléctionnez Région</option>
            <option value="Alsace">Alsace</option>
            <option value="Aquitaine">Aquitaine</option>
            <option value="Auvergne">Auvergne</option>
            <option value="Basse-Normandie">Basse-Normandie</option>
            <option value="Bourgogne">Bourgogne</option>
            <option value="Bretagne">Bretagne</option>
            <option value="Centre">Centre</option>
            <option value="Champagne-Ardenne">Champagne-Ardenne</option>
            <option value="Corse">Corse</option>
            <option value="Franche-Comté">Franche-Comté</option>
            <option value="Haute-Normandie">Haute-Normandie</option>
            <option value="Ile-De-France">Ile-De-France</option>
            <option value="Languedoc-Roussillon">Languedoc-Roussillon</option>
            <option value="Limousin">Limousin</option>
            <option value="Lorraine">Lorraine</option>
            <option value="Midi-Pyrenées">Midi-Pyrenées</option>
            <option value="Nord-Pas-De-Calais">Nord-Pas-De-Calais</option>
            <option value="Pays de la loire">Pays de la loire</option>
            <option value="Picardie">Picardie</option>
            <option value="Poitou-Charentes">Poitou-Charentes</option>
            <option value="Provence-Alpes-Côte d'Azur">Provence-Alpes-Côte d'Azur</option>
            <option value="Rhône-Alpes">Rhône-Alpes</option>
          
	<input type="submit" name="valider" id="valider" value="Valider">
	<input type="submit" name="annuler" id="annuler" value="Annuler">

</form>


	<p class="link_connexion">Si vous avez déjâ un compte : <a href="Connexion.jsp">Connectez-vous</a></p>




<footer>
	<p>
		Copyright &copy; Freitas Raul all rights reserved
	</p>
</footer>
</body>
</html>