<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import ="site_interface.Utilisateur"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Header</title>

    <!--  CSS  -->
    <link href="css/normalize.css" rel="stylesheet">
    <link rel="stylesheet" href="./css/header.css">

    <!--  Font awesome CSS  -->
    <link rel="stylesheet" href="./css/font-awesome/css/all.min.css">

    <!--  Jquery CDN-->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>

    <%
        Utilisateur user = (Utilisateur)session.getAttribute("sessionUtilisateur");
    %>

    <header role="header">
        <nav class="menu" role="navigation">

            <div class="inner">
                <div class="menu-toggle">
                    <span class="menu-toggle-icon"></span>
                </div>
                <div class="menu-left">
                    <h1><a href="./index.jsp" class="menu-logo">Artilib</a></h1>
                </div>

                <div class="menu-user">
                    <ul class="menu-user-ul">
                        
                        <%
                        if(user == null) {                        
                        %>
                            <li class="menu-user-li-login"><a href="./connexion.jsp" class="menu-link"><i class="fas fa-sign-in-alt"></i> Se connecter</a></li>
                        <%
                        }
                        else {
                            String nom = (String) user.data()[9];
                            String prenom = (String) user.data()[10];
                        %>
                        <li id="menu-user-li-profile"><a href="#" class="dropdown-menu-head"><i class="fas fa-user"></i> <% out.print(nom); %> <% out.print(prenom); %></a>
                            <ul class="dropdown-menu">
                                <li id="menu-user-li"><a href="#" class="dropdown-menu-link"><i class="far fa-address-card"></i> Mon compte</a></li>
                                <li id="menu-user-li"><a href="#" class="dropdown-menu-link"><i class="fas fa-sign-out-alt"></i> Se déconnecter</a></li>
                            </ul>
                        </li>
                        <%
                        }
                        %>
                    </ul>
                </div>

                <div class="menu-right">
                    <ul>
                        <li id="menu-user-li"><a href="./index.jsp" class="menu-link"><i class="fas fa-home"></i> Accueil</a></li>

                        <%
                        if(user == null) {                        
                        %>
                            <li id="menu-user-li"><a href="./inscription_artisan.jsp" class="menu-link"><i class="fas fa-tools"></i> Vous êtes un artisan?</a></li>
                            <li id="menu-user-li"><a href="./inscription.jsp" class="menu-link"><i class="fas fa-user-plus"></i> S'inscrire</a></li>
                        <%
                        }
                        else {
                        %>
                            <li id="menu-user-li"><a href="#" class="menu-link"><i class="far fa-calendar-check"></i> Mes rendez-vous</a></li>
                        <%
                        }
                        %>
                    </ul>
                </div>
                
                
            </div>
            
        </nav>
    </header>
    
    <script src="./js/header.js" charset="UTF-8"></script>

