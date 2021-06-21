<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="it">
<head>
    <jsp:include page="../Partials/head.jsp"/><%-- CSS 1042 --%>
    <title>Modifica o Rimuovi Categorie</title>
</head>
<body>
<jsp:include page="../Partials/Header.jsp"/><br><br>
<h1 class="titleAdmin">Modifica Categoria</h1>
<a href="AreaAmministratore" class="linkBack">Area Amministratore</a><br><br>
<p style="margin-left: 2%">  ATTENZIONE. Eliminare una categoria comporterà automaticamente
    l'eliminazione di tutti gli eventi ad essa associati</p>
<div class="adminHome">
    <c:forEach items="${categoria}" var="categoria" >
        <div class="adminElementCat" style="margin-top: 10% !important;">
            <img alt="Immagine Categoria" src="${categoria.linkImmagine}"  style="width:220px;height:124px;"><br>
            <p >${categoria.nome}</p><br>
            <form  method="get" action="ToModificaCategoria">
                <input type="hidden" name="idCategoria" value="${categoria.idCategoria}">
                <button type="submit" style="margin-bottom: 3%">Modifica</button>
            </form>

            <form  method="get" action="EliminaCategoria">
                <input type="hidden" name="idCategoria" value="${categoria.idCategoria}">
                <button type="submit" >Elimina</button>
            </form>

        </div>
    </c:forEach>

</div>
</body>
</html>
