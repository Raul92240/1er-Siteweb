<%-- 
    Document   : Déposer une annonce
    Created on : 23 nov. 2018, 13:37:49
    Author     : Joker
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<title>Déposer une annonce</title>
	<meta charset="utf-8">
	<link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
    
	<header>
		<div class="Bandeau">
	
	<ul> 
                <li class="btn-bandeau"><a href="Accueil.jsp">Le Coin Sport</a></li>
		<li class="btn-bandeau"><a href="Les offres.jsp">Annonces</a></li>
		<li class="btn-bandeau"><a href="Déposer une annonce.jsp">Déposer une annonce</a></li>
	</ul>

</div>
	</header>

    <form class="form_depot">
        <h1>Formulaire de dépot d'annonce</h1>
            
        Votre Pseudo : <input type="text" name="pseudo" id="pseudo" required>
	Votre Email : <input type="email" name="email" id="email" required>
         Titre de l'annonce :  <input type="text" name="titre_annonce" id="titre_annonce" required>  
         Description annonce :<br> <textarea name="descri_annonce" id="descri_annonce"></textarea><br><br>
        Photos annonce : <input type="file" name="file" id="file">
        Votre Région : <br> <select type="text" name="region" id="region" required><br>
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
        </select><br><br>
           
            <input type="submit" name="valider" id="valider" value="Valider">
	    <input type="submit" name="annuler" id="annuler" value="Annuler">

        
    </form>
    

<footer>
	<p>
		Copyright &copy; Freitas Raul all rights reserved
	</p>
</footer>
</body>
</html>