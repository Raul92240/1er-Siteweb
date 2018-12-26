<%-- 
    Document   : Football
    Created on : 4 déc. 2018, 11:07:00
    Author     : Joker
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.Vector, divers.*, metierMapping.*" %>
<!DOCTYPE html>

<%  Vector<Annonce> listeAnnonce =
        (Vector)session.getAttribute("listeAnnonces");
    Vector<Colonne> listeColonnes =
        (Vector)session.getAttribute("listeColonnes");
    Annonce annonce;
%>


<html>
<head>
	<title>Annonces</title>
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

  
    <div class="Categorie">
      <h4>Catégorie : Football </h4> 
        <ul>
            <li class="btn-categorie">Art Martiaux</li>
            <li class="btn-categorie">Athlétisme</li>
            <li class="btn-categorie">Badminton</li>
            <li class="btn-categorie">Baseball</li>
            <li class="btn-categorie">Basketball</li>
            <li class="btn-categorie">Boxe</li>
            <li class="btn-categorie">Football</li>
            <li class="btn-categorie">Golf</li>
            <li class="btn-categorie">Handball</li>
            <li class="btn-categorie">Musculation/Fitness</li>
            <li class="btn-categorie">Natation</li>
            <li class="btn-categorie">Rugby</li>
            <li class="btn-categorie">Ski</li>
            <li class="btn-categorie">Tennis</li>
            <li class="btn-categorie">Tir à l'arc</li>
        </ul>
        
       
    </div>
    
    
    <div class="AnnonceBDD">
    <table>
            <caption>LISTE DES ANNONCE FOOTBALL</caption>
            <thead>
                <tr>
                    <%
                        for (int i = 0; i < listeColonnes.size(); i++)
                        {
                            if (listeColonnes.elementAt(i).getLongueur() < 16)
                            {
                    %>
                    <th class="petitTitreColonne">
                        <%
                        }
                        else
                        {
                        %>
                    <th>
                        <%
                            }
                        %>
                        <%=listeColonnes.elementAt(i).getNom()%>
                    </th>
                    <%
                        }
                    %>
                </tr>
            </thead>

            <tbody>
                <%
                    for (int i = 0; i < listeAnnonce.size(); i++)
                    {
                        annonce = listeAnnonce.elementAt(i);
                %>
                <tr>
                    <td>
                        <%= annonce.getAnnonce_id()%>
                    </td>

                    <td>
                        <% if (annonce.getLibelle() != null)
                      {%>
                        <%= annonce.getLibelle()%>
                        <% } %>
                    </td>

                    <td>
                        <% if (annonce.getDate() != null)
                      {%>
                        <%= annonce.getDate()%>
                        <% } %>
                    </td>

                    <td>
                        <% if (annonce.getDescription() != null)
                      {%>
                        <%= annonce.getDescription() %>
                        <% } %>
                    </td>
                    
                    <td>
                        <% if (annonce.getImg() != null)
                      {%>
                        <%= annonce.getImg()%>
                        <% } %>
                    </td>
                    
                    <td>
                        <% if (annonce.getRegion() != null)
                      {%>
                        <%= annonce.getRegion()%>
                        <% } %>
                    </td>
                    
                    <td>
                        <% if (annonce.getMembre_id()!= null)
                      {%>
                        <%= annonce.getMembre_id()%>
                        <% } %>
                    </td>

                    <td>
                        <% if (annonce.getCategorie_id()!= null)
                      {%>
                        <%= annonce.getCategorie_id()%>
                        <% } %>
                    </td>

                    
                    
                </tr>
                <%
                    }
                %>
            </tbody>
        </table>
</div>
            
            <br><br><br><br><br><br><br><br><br>
<footer>
	<p>
		Copyright &copy; Freitas Raul all rights reserved
	</p>
</footer>
</body>
</html>