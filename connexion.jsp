<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="fr">
<head>
<link rel="stylesheet" type="text/css" href="./css/ConnexionStyle.css">
<link href="css/normalize.css" rel="stylesheet">
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

        <div id="FormSize">
                <h2>Connexion</h2>
                <div id="connform">
                    <form method="POST" action="LoginServlet">
                        <input id="identifiant" name="mail" placeholder="Adresse email" >
                        <input id="motdepasse" name="mdp" type="password" placeholder="Mot de Passe">
                        <div id="ResterCo">
                            <input type="checkbox" id="ButCo" name="Rester connecté ?">
                            <label for="ResterCo">Rester connecté</label>
                        </div>
                        <input type="submit" id="SeCo" value="Se connecter">
                        <a href="#" id="mdpforg"><u>Mot de passe oublié ?</u></a>
                    </form>  
                </div>
                
            <div id="pasInscrit">
                <a href="./inscription.jsp" id="insc"><u>Pas encore inscrit ?</u></a>
            </div>
        </div>


    </body>
    <footer></footer>
</html>