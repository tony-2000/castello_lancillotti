<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="it">
<head>
    <jsp:include page="../Partials/head.jsp"/>
    <title>Modifica o Rimuovi Categorie</title>
</head>
<body>
<jsp:include page="../Partials/Header.jsp"/><br><br>
<h1 style="text-align: center; font-size: 250% ">Modifica Categoria</h1>
<p>  ATTENZIONE. Eliminare una categoria comporterà automaticamente
    l'eliminazione di tutti gli eventi ad essa associati</p>
<div class="modAddCat">
    <c:forEach items="${categoria}" var="categoria" >
        <div class="adminElementCat">
            <img alt="Immagine Categoria" src="${categoria.linkImmagine}" style="width:60%;height:auto"><br>
            <p style="font-size: 150%">${categoria.nome}</p><br>
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
