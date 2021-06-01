<%@ page import="model.Utente" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Header</title>
    <style>

        body {
            overflow-x: hidden; /* Hide horizontal scrollbar */
        }

        ul.header {
            list-style-type: none;
            padding: 0;
            background-color: #d9c6b0;
            position: fixed;
            height: 3.13em;
            width: 100%;
            margin: 0;
            z-index: 1;
        }

        li{
            font-size: 100%;
        }

        li.header, .dropdown{
            display: block;
            color: #8c7c68;
            text-align: center;
            text-decoration: none;
            float:left;
        }


        li a.header:hover, a.dropbtn:hover {
            animation-name: hover1;
            animation-duration: 0.3s;
            animation-fill-mode: forwards;
        }

        @keyframes hover1 {
            from{background-color: #d9c6b0}
            to {background-color: #b19d86
            }
        }

        li a.header, .dropbtn {
            display: inline-block;
            color: #595959;
            text-align: center;
            padding: 1em 1.3em;
            text-decoration: none;
            cursor: pointer;
        }


        li.dropdown {
            display: inline-block;
        }

        .dropdown-content {
            display: none;
            position: absolute;
            background-color: #e9e2db;
            min-width: 10em;
            box-shadow: 0em 0.5em 1em 0em rgba(0,0,0,0.2);
            z-index:1;
        }

        li a:hover.hover2 {
            animation-name: hover2;
            animation-duration: 0.3s;
            animation-fill-mode: forwards;
        }

        @keyframes hover2 {
            from{background-color: #e9e2db}
            to {background-color: #bcad9d
            }
        }


        .dropdown-content {
            animation-name: fadeIn;
            animation-duration: 0.3s;
            animation-fill-mode: forwards;
        }

        @keyframes fadeIn {
            from{opacity: 0}
            to {opacity: 1}
        }


        .dropdown-content a {
            color: #595959;
            padding: 0.8em 1em;
            text-decoration:none;
            display: block;
            text-align: left;
        }


        .dropdown:hover .dropdown-content {
            display: block;
        }

    </style>
</head>
<body>


<ul class="header">
    <li class="header"><img src="./Images/logoBase.png" alt="logo" style="width:3em;height:3em;"></li>
    <li class="header"><a class="header" href="./index.jsp">Home</a></li>
    <li class="header"><a class="header" href="SulCastello.jsp">Sul Castello</a></li>
    <li class="header"><a class="header" href="ShowAllVisits">Visite</a></li>
    <li class="header"><a class="header" href="VisualizzaCategorie">Eventi</a></li>
    <li class="header" style="float:right"><a class="header" href="Carrello">Carrello</a></li>
    <li class="dropdown" style="float:right"><a  class="dropbtn" <%if (session.getAttribute("utenteSessione")==null){%>
           style="display: none"  <%;}%>> Ciao ${utenteSessione.nome}</a>
        <div class="dropdown-content">
            <a class="hover2" href="ShowProfilo"> Profilo </a>
            <a class="hover2" href="RiepilogoAcquisti">Riepilogo Acquisti</a>
            <a class="hover2" href="Logout"> Logout</a>
            <a class="hover2" href="AreaAmministratore"
                    <%if(session.getAttribute("utenteSessione")!=null)
                    { Utente x= (Utente) session.getAttribute("utenteSessione");
                    if(x.isAmministratore()==false){%>
               style="display: none"  <%;}}%>> Area Amministratore</a>
        </div>
    </li>

    <li class="header"style="float:right"> <a class="header" href="Login.jsp" <%if (session.getAttribute("utenteSessione")!=null){%>
                                style="display: none"  <%;}%>>Accedi</a></li>


</ul>
<br><br>
</body>
</html>
