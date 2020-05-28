<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

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
        
        <div id="nb-res">Nombre de résultat:</div>
        
        <div id="resultat">
            <a href="" class="resume-art">
                <img class="img-res" src="./images/instagram.png">
                <ul>
                    <li>aa</li>
                    <li>aa</li>
                </ul>
            </a>
            <a href="" class="resume-art">
                <img class="img-res" src="./images/instagram.png">
                <ul>
                    <li>aa</li>
                    <li>aa</li>
                </ul>
            </a>
            <a href="" class="resume-art">
                <img class="img-res" src="./images/instagram.png">
                <ul>
                    <li>aa</li>
                    <li>aa</li>
                </ul>
            </a>
        </div>
    </body>
    <footer></footer>
</html>