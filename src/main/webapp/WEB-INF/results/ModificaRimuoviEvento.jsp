<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="it">
<head>
    <jsp:include page="../Partials/head.jsp"/>
    <title>Modifica o rimuovi evento</title>
</head>
<body>
<jsp:include page="../Partials/Header.jsp"/><br><br>
<h1 class="titleAdmin">Modifica Evento</h1>
<div class="adminHome">
    <c:forEach items="${eventi}" var="evento" >
        <div class="adminElementCat" style="margin-top: 10% !important;">
            <img alt="Immagine Evento" src="${evento.linkImmagine}" style="width:220px;height:124px;">
            <p>${evento.nome}</p><br>
            <form  method="get" action="ToModificaEvento">
                <input type="hidden" name="idEvento" value="${evento.idEvento}">
                <button type="submit" style="margin-bottom: 3%">Modifica</button>
            </form>
            <form  method="get" action="EliminaEvento">
                <input type="hidden" name="idEvento" value="${evento.idEvento}">
                <button type="submit">Elimina</button>
            </form>
        </div>
    </c:forEach>
</div>
</body>
</html>
