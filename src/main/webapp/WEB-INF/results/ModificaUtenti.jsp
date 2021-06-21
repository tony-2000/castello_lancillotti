<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="it">
<head>
    <jsp:include page="../Partials/head.jsp"/><%-- CSS 1042 --%>
    <title>Modifica Utenti </title>
</head>
<body>
<jsp:include page="../Partials/Header.jsp"/><br><br>
<h1 class="titleAdmin">Modifica Utenti</h1>
<a href="AreaAmministratore" class="linkBack">Area Amministratore</a><br><br>
<div class="adminHome">
    <c:forEach items="${utenti}" var="utenti" >
        <div class="adminElementCat" style="font-size: 75%">
            <p>Nome: ${utenti.nome}</p>
            <p>Cognome: ${utenti.cognome}</p>
            <p>Mail: ${utenti.mail}</p>
            <p>Nome Utente: ${utenti.nomeUtente}</p>
            <p>Amministratore: ${utenti.amministratore}</p>
            <form  method="get" action="CambiaStatoAdmin">
                <input type="hidden" name="idUtente" value="${utenti.idUtente}">
                <button type="submit" style="margin-bottom: 3%">Cambia Stato Admin</button>
            </form>
                    <form  method="get" action="EliminaUtente">
                        <input type="hidden" name="idUtente" value="${utenti.idUtente}">
                        <button type="submit">Elimina Utente</button>
                    </form>
        </div>
    </c:forEach>
</div>

</body>
</html>
