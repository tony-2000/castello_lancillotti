<%@ page import="model.Utente" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        ul {
            list-style-type: none;
            margin: 0;
            padding: 0;
            overflow: hidden;
            background-color: #D9C6B0;
        }

        li {
            display: block;
            color: white;
            text-align: center;
            text-decoration: none;
            float:left;
        }

        li a {
            display: block;
            color: white;
            text-align: center;
            padding: 14px 16px;
            text-decoration: none;
        }

        li a:hover:not(.active) {
            background-color: #111;
        }

        .active {
            background-color: #4CAF50;
        }

        li a, .dropbtn {
            display: inline-block;
            color: white;
            text-align: center;
            padding: 14px 16px;
            text-decoration: none;
        }

        li a:hover, .dropdown:hover .dropbtn {
            background-color: red;
        }

        li.dropdown {
            display: inline-block;
        }

        .dropdown-content {
            display: none;
            position: absolute;
            background-color: #f9f9f9;
            min-width: 160px;
            box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
            z-index: 1;
        }

        .dropdown-content a {
            color: black;
            padding: 12px 16px;
            text-decoration: none;
            display: block;
            text-align: left;
        }

        .dropdown-content a:hover {background-color: #f1f1f1;}

        .dropdown:hover .dropdown-content {
            display: block;
        }
    </style>
</head>
<body>


<ul>
    <li><img src="./Images/logoBase.png" alt="logo" style="width:45px;height:45px;"></li>
    <li><a class="active" href="./index.jsp">Home</a></li>
    <li><a href="SulCastello.jsp">Sul Castello</a></li>
    <li><a href="ShowAllVisits">Visite</a></li>
    <li><a href="VisualizzaCategorie">Eventi</a></li>
    <li><a href="RiepilogoAcquisti">Riepilogo Acquisti</a></li>
    <li style="float:right"><a href="Carrello">Carrello</a></li>
    <li class="dropdown" style="float:right"><a  class="dropbtn" <%if (session.getAttribute("utenteSessione")==null){%>
           style="display: none"  <%;}%>> Ciao ${utenteSessione.nome}</a>
        <div class="dropdown-content">
            <a href="ShowProfilo"> Profilo </a>
            <a href="Logout"> Logout</a>
            <a href="AreaAmministratore"
                    <%if(session.getAttribute("utenteSessione")!=null)
                    { Utente x= (Utente) session.getAttribute("utenteSessione");
                    if(x.isAmministratore()==false){%>
               style="display: none"  <%;}}%>> Area Amministratore</a>
        </div>
    </li>

    <li style="float:right"> <a href="Login.jsp" <%if (session.getAttribute("utenteSessione")!=null){%>
                                style="display: none"  <%;}%>>Accedi</a></li>


</ul>
</body>
</html>
