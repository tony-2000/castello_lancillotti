<%@ page import="model.Partecipare" %>
<%@ page import="java.util.ArrayList" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="it">
<head>
    <jsp:include page="../Partials/head.jsp"/>
    <title>Riepilogo Acquisti</title>
</head>
<body>
<jsp:include page="../Partials/Header.jsp"/><br><br>

<%! ArrayList<Partecipare> acquisti;%><%acquisti= (ArrayList<Partecipare>) request.getAttribute("lista");%>

<h1 class="titleBuy">Riepilogo Acquisti</h1>

<ul>
    <c:forEach items="${lista}" var="lista">
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
            <br class="space530"><br class="space530"><br class="space530">
        </div>
    </c:forEach>
</ul>

<img class="riepilogo" src="Images/riepilogoAcquistoVuoto.png" alt="Riepilogo Acquisti Vuoto" <%if (acquisti.size()!=0){%>
     style="display: none;  <%;}%>">

</body>
</html>
