<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
      <meta charset="UTF-8">
      <meta name="viewport" content="width=device-width, initial-scale=1.0">
      <meta http-equiv="X-UA-Compatible" content="ie=edge">
      <title>Artilib | Home</title><!-- modifier le titre-->

      <!--  CSS  -->
      
      <link href="css/style.css" rel="stylesheet">
      
      <!--  Font awesome CSS  -->
     <link rel="stylesheet" href="./css/font-awesome/css/all.min.css">
     <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

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

      

      <div id="hero">


                  <div class="texture"></div>

                  <video loop muted autoplay preload="auto">
                        <source src="images/backgroundvideo.mp4" type="video/mp4">
                        Your browser does not support the video tag.  
                  </video>



                  <div class="caption">

                        <div class="banner">
		
                              <div class="content">
                                    <h2>Prenez un rendez-vous en consultation physique ou consultation vidéo</h2>
                                    <form action="RechercheServlet" method="post">
                                    <input class="premier" type="text" placeholder="Recherche" name="localisation">
                                    <input class="second" type="text" placeholder="Où ?" name="search">
                                    <button type="submit">Rechercher</button>
                                    </form>
                              </div>
                        </div>
                  </div>

      </div>

       <div class="container">
		<div class="fullbox">
			<h1 class="info-covid">INFORMATIONS COVID-19 </h1>
			<p>
				En cas de consultation physique, veuillez suivre les recommandations officielles et les consignes de sécurité.
			</p>
		</div>
		<div class="box b1">
                  <i class="flaticon-washing-hands"><img class="" src="images/hands.png"></i>
                  
			<p>
				<span>1. </span>
				Se laver souvent les mains. Utiliser du savon et ‎de l’eau, ou une solution hydroalcoolique.
			</p>
		</div>
		<div class="box b2">
			<i class="flaticon-sneeze"><img class="" src="images/sneeze.png"></i>
			<p>
				<span>2. </span>
				En cas de toux ou d’éternuement, couvrez-vous ‎la bouche et le nez avec le pli du coude ou avec un ‎mouchoir.
			</p>
		</div>
		<div class="box b3">
			<i class="flaticon-distance"><img class="" src="images/contact.png"></i>
			<p>
				<span>3. </span>
				Rester à distance de toute personne qui tousse ‎ou éternue. ‎ ‎
			</p>
		</div>
		<div class="box b4">
			<i class="flaticon-stay-at-home"><img class="" src="images/stayhome.png"></i>
			<p>
				<span>4. </span>
				Restez chez vous si vous ne vous sentez pas ‎bien.
			</p>
            </div>
                  
            </div>
            <center>
                  <p class="corona"> Voir plus d'informations sur <a href="https://www.gouvernement.fr/info-coronavirus">GOUVERNEMENT.FR/INFO-CORONAVIRUS</a></p>
                 </center>

            
                 
 
      <script src="js/object-fit-videos.js"></script>
      <script src="js/app.js"></script>
      
</body>
<footer></footer>
</html>