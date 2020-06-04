<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import ="site_interface.Utilisateur"%>
<%@ page import ="site_interface.Model"%>
<%@ page import ="java.util.ArrayList"%>
<%@ page import ="java.util.List"%>

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
            List<Utilisateur> listeArti = new ArrayList<Utilisateur>();  
            listeArti = (ArrayList<Utilisateur>) session.getAttribute("listeArti");
            //listeArti = (ArrayList<Utilisateur>) Model.getInstance().rechercheArti((String)session.getAttribute("localisation"),(String)session.getAttribute("search"));
            %>
            <div id="resultat">
                <%
                    for (Utilisateur u : listeArti) {
                        int idArti = (int) u.data()[8];
                        String denominationArti = (String) u.data()[9];
                        int codePostaleUti = (int) u.data()[5];
                        String villeUti = (String) u.data()[6];
                        String adresseUti = (String) u.data()[7];

                %>
                
            
                <a href="DetailProfilServlet?idArti=<% out.println(idArti); %>" class="resume-art">
                    <img class="img-res" src="./images/<% out.println(denominationArti); %>.jpg">
                    <ul>
                        <li><% out.println(denominationArti); %></li>
                        <li><% out.println(adresseUti); %></li>
                        <li><% out.println(villeUti); %></li>
                        <li><% out.println(codePostaleUti); %></li>
                    </ul>
                </a>
            

                <%
            }
        %>

        </div>
        
        
    </body>
    <footer></footer>
</html>