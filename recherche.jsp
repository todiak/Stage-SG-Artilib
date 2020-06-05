<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import ="site_interface.Utilisateur"%>
<%@ page import ="site_interface.Model"%>
<%@ page import ="java.util.ArrayList"%>
<%@ page import ="java.util.List"%>

<<<<<<< HEAD
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="fr">
    <head>
        <link rel="stylesheet" type="text/css" href="./css/recherche.css">
        <link rel="stylesheet" type="text/css" href="./css/normalize.css">
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <meta charset="UTF-8">
        
        <script> 
            $(function(){
                $("header").load("./header.jsp"); 
                $("footer").load("./footer.jsp"); 
            });
        </script>
    </head>
    <header></header>
    <body>
        <form action="/" id="recherche">
            <input class="premier" type="text" placeholder="Recherche" name="localisation">
            <input class="second" type="text" placeholder="Où ?" name="search">
            <button type="submit">Rechercher</button>
        </form>
        
        <% 
=======
<!DOCTYPE html>
<html lang="en">
<head>
      <meta charset="UTF-8">
      <meta name="viewport" content="width=device-width, initial-scale=1.0">
      <meta http-equiv="X-UA-Compatible" content="ie=edge">
      <title>Artilib | Home</title><!-- modifier le titre-->

      <!--  CSS  -->
      
      <link href="./css/recherche1.css" rel="stylesheet">
      
      <!--  Font awesome CSS  -->
     <link rel="stylesheet" href="./css/font-awesome/css/all.min.css">
     <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
     

      <!--  Jquery CDN-->
      <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
      <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

	  <script> 
        $(function(){
            $("header").load("./header.jsp"); 
            $("footer").load("./footer.jsp"); 
        });
    </script>
</head>
<body>
 <header></header>
 
  <div class="bandeau-recherche">
    <form action="RechercheServlet" method="post" id="recherche">
      <input class="premier" type="text" placeholder="Recherche" name="localisation">
      <input class="second" type="text" placeholder="Où ?" name="search">
      <button class="btn-search" type="submit">Rechercher</i></button>
    </form>
	
  </div>

      <div class="recherche-container">


		<% 
>>>>>>> 6715e862a4290f9a1ff25b586a21b9a6e49880f9
            List<Utilisateur> listeArti = new ArrayList<Utilisateur>();  
            listeArti = (ArrayList<Utilisateur>) session.getAttribute("listeArti");
            //listeArti = (ArrayList<Utilisateur>) Model.getInstance().rechercheArti((String)session.getAttribute("localisation"),(String)session.getAttribute("search"));

            for (Utilisateur u : listeArti) {
                int idUti = (int) u.data()[0];
<<<<<<< HEAD
                String denominationArti = (String) u.data()[9];
                int codePostaleUti = (int) u.data()[5];
                String villeUti = (String) u.data()[6];
                String adresseUti = (String) u.data()[7];

                %>
                <div id="resultat">
            
                    <a href="ProfilArtisan.jsp?idUti=<% out.println(idUti); %>" class="resume-art">
                        <img class="img-res" src="./images/<% out.println(denominationArti); %>.jpg">
                        <ul>
                            <li><% out.println(denominationArti); %></li>
                            <li><% out.println(adresseUti); %></li>
                            <li><% out.println(villeUti); %></li>
                            <li><% out.println(codePostaleUti); %></li>
                        </ul>
                    </a>
                </div>
                <%
            }
        %>
        
        
    </body>
    <footer></footer>
=======
                String denominationArti = (String) u.data()[9]; 
				String secteur = (String) u.data()[10];
                int codePostaleUti = (int) u.data()[5];
                String villeUti = (String) u.data()[6];
                String adresseUti = (String) u.data()[7];
				String description = (String) u.data()[12];
		%>
							
					  <div class="premier-rectangle">

						  <div class="sous-rectangle1">
							<div class="image"><img src="images/<% out.println(denominationArti); %>.jpg"></div>
							<div class="titre-profil">
							<h3><a href="ProfilArtisan.jsp?<% out.println(idUti); %>"><% out.println(denominationArti); %></a></h3>
							<p><% out.println(secteur); %></p><br>
							<p><% out.println(description); %></p>
						  </div>
						  </div>
						  <div class="trait"></div>
						  <div class="sous-rectangle2">
							
							
							 <div class="consultation">
							  <div class="logo">
							  <i  class="fas fa-video fa-lg "></i>
							</div>
							  <h3 style="color: #0596de;"class="consu">Consultation vidéo disponible</h3>
							</div>
							<div class="adresse">
							 <h3 class="titre-adresse">Adresse</h3> 
							 <p><% out.println(adresseUti); %><br><% out.println(villeUti); %></p> 
							</div> 
							

						  </div>

						  <div class="bouton">
							  <button class="btn-rdv" type="submit" onclick="window.location.href='./ProfilArtisan.jsp?'">PRENDRE RENDEZ-VOUS</button>
							</div>
					  </div>
                <%
            }
        %>

        
      </div>
      
     <footer></footer>
      
</body>
>>>>>>> 6715e862a4290f9a1ff25b586a21b9a6e49880f9
</html>