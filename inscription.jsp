<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="fr">
    <head>
        <meta charset="utf-8" name="viewport" content="width=device-width">
        <title>Inscription</title>
        <link rel="stylesheet" href="css/inscription.css" type="text/css">
        <link href="css/normalize.css" rel="stylesheet">
        <!--  Jquery CDN-->
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

        <script> 
            $(function(){
                $("header").load("./header.jsp"); 
                $("footer").load("./footer.jsp"); 
            });
        </script>

    </head>

    <header></header>

    <body>

        <div class="form-inscription">

            <form class="inscrire" method="post" action="InscriptionServlet">
                <label id="title">Nouveau sur Artilib ?</label>
                
                <div class="saisi">
                    <label class="saisi-gauche"> <input type="text" name="nomUser" placeholder="Nom" > * </label>
                    <label class="saisi-droite"> <input type="text" name="prenomUser" placeholder="Prénom"> * </label>
                </div>
                
                <label> <input type="text" name="mail" placeholder="Adresse email"> * </label>
                <label> <input type="text" name="mdp" placeholder="Mot de passe"> * </label>
                <label> <input type="text" name="mdpC" placeholder="Confirmer le mot de passe"> </label>
                <label> <input type="text" name="tel" placeholder="Numéro de téléphone"> * </label>
                <div class="saisi">
                    <label class="saisi-gauche"> <input type="text" name="cp" placeholder="Code postale"> </label>
                    <label class="saisi-droite"> <input type="text" name="ville" placeholder="Ville" > </label>
                </div>
                <label> <input type="text" name="adresse" placeholder="Adresse"> </label>
                <label id="condition">
                    <input type="checkbox" name="a">
                    J'accepte les 
                    <a href="">conditions d'utilisation d'Artlib</a>
                </label>

                
                <input type="submit" id="sub" value="Valider">
                
                <label id=connecter>
                    Déjà Inscris? 
                    <a href="./connexion.jsp">Connnectez-vous.</a>
                </label>

                
                <label id="ps">* champs obligatoires</label>
                
            </form>
            
        </div>

    </body>
    
    <footer></footer>
</html>