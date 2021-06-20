<%@ page import="model.Utente" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <script src="JS/JavaScriptLib.js"></script>
    <script type="text/javascript" src="JS/jquery-3.6.0.min.js"> </script>
    <title>Header</title>
</head>
<body>

<div class="responsiveBar">
        <div onclick="showNavbar()" class="responsiveDiv">
            <img src="./Images/logoBase.png" alt="logo" style="width:3em;height:3em; float: left">
        <p style="float: left; padding-left: 1em">Menu</p>
    </div>
    <p style="text-align: center">Castello Lancellotti</p>
</div>
<ul class="header" id="navbar" onmouseleave="closeNavbar()">
    <li class="header"><img class="close" src="./Images/closeNavbar.png" alt="logo" onclick="closeNavbar()"></li>
    <li class="header"><img class="logo" src="./Images/logoBase.png" alt="logo"></li>
    <li class="header"><a class="header" href="./index.jsp">Home</a></li>
    <li class="header"><a class="header" href="SulCastello.jsp">Sul Castello</a></li>
    <li class="header"><a class="header" href="ShowAllVisits">Visite</a></li>
    <li class="header"><a class="header" href="VisualizzaCategorie">Eventi</a></li>
    <li class="header" style="float:right"><a class="header" href="Carrello">Carrello</a></li>
    <li class="header"style="float:right"> <a class="header" href="Login.jsp" <%if (session.getAttribute("utenteSessione")!=null){%>
                                              style="display: none"  <%;}%>>Accedi</a></li>
    <li class="dropdown" ><a  class="dropbtn" <%if (session.getAttribute("utenteSessione")==null){%>
           style="display: none"<%;}%>> Ciao ${utenteSessione.nome}</a>
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

<script>
    window.addEventListener("resize", resetNavbar);
</script>

</ul>

<br><br>
</body>
</html>
