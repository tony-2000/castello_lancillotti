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


<ul>
    <c:forEach items="${carrello}" var="lista">

        <img src="${lista.link}" alt="immagine Evento" style="width:45px;height:45px;">

        ${lista.nome} ${lista.quantitaBiglietti}  ${lista.dataPartecipazione}
        ${lista.orarioPartecipazione} ${lista.prezzo} ${lista.idEvento}
        <br>

        <form action="RimuoviDalCarrello">
            <input type="hidden" name="id_evento" value="${lista.idEvento}">
            <input type="hidden" name="data" value="${lista.dataPartecipazione}">
            <input type="hidden" name="ora" value="${lista.orarioPartecipazione}">
            <button type="submit"> Rimuovi dal Carrello</button>
        </form>
        <br><br><br>

    </c:forEach>
</ul>



<form action="Acquista" method="get" <%if (session.getAttribute("utenteSessione")==null){%>
      style="display: none"  <%;}%>>
    <button type="submit">Acquista</button>
</form>

</body>
</html>
