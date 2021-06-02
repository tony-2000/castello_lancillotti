<%@ page import="java.util.ArrayList" %>
<%@ page import="model.Partecipare" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="it">
<head>
<jsp:include page="../Partials/head.jsp"/>
    <title>Carrello</title>
</head>
<body>
<jsp:include page="../Partials/Header.jsp"/><br><br>
<%! ArrayList <Partecipare> cart;%><%cart= (ArrayList<Partecipare>) request.getAttribute("carrello");%>

<h1 style="text-align: center; font-size: 250% ">Carrello</h1>

<ul>
    <c:forEach items="${carrello}" var="lista">
<div class="cart">
        <img src="${lista.link}" alt="immagine Evento">

        <ul>
        <li>Nome dell'Evento: ${lista.nome}</li>
        <li>Quantità biglietti: ${lista.quantitaBiglietti}</li>
        <li>Data: ${lista.dataPartecipazione}</li>
        <li>Orario: ${lista.orarioPartecipazione}</li>
        <li>Prezzo a persona: ${lista.prezzo}€</li>
        <br>
        </ul>

        <form action="RimuoviDalCarrello">
            <input type="hidden" name="id_evento" value="${lista.idEvento}">
            <input type="hidden" name="data" value="${lista.dataPartecipazione}">
            <input type="hidden" name="ora" value="${lista.orarioPartecipazione}">
            <button type="submit" style="float: right; margin-right: 2%"> Rimuovi dal Carrello</button>
        </form>
        <br><br><br>
</div>
    </c:forEach>
</ul>



<form action="Acquista" method="get" <%if (session.getAttribute("utenteSessione")==null || cart.size()==0){%>
      style="display: none"  <%;}%>>
    <p style="font-size:2em;float:left;margin-left: 6%; margin-top: 0%; width: 50%">Prezzo totale: ${prezzoTotale}€</p>
    <button type="submit" style="float: right;margin-right: 6%;margin-top:0%;margin-bottom: 2%; font-size: 2em">Acquista</button>
</form>

                <img class="carrello" src="Images/carrelloVuoto.png" alt="Carrello Vuoto" <%if (cart.size()!=0){%>
                     style="display: none;  <%;}%>">

</body>
</html>
