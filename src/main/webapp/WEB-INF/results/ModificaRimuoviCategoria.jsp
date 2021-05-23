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

<p>ATTENZIONE. Eliminare una categoria comporterà automaticamente
    l'eliminazione di tutti gli eventi ad essa associati</p>
<ul>
    <c:forEach items="${categoria}" var="categoria" >
        <li>
            <img alt="Immagine Categoria" src="${categoria.linkImmagine}" style="width:45px;height:45px;">
            <form  method="get" action="ToModificaCategoria">
                <input type="hidden" name="idCategoria" value="${categoria.idCategoria}">
                <button type="submit">Modifica</button>
            </form>

            <form  method="get" action="EliminaCategoria">
                <input type="hidden" name="idCategoria" value="${categoria.idCategoria}">
                <button type="submit">Elimina</button>
            </form>${categoria.nome}
        </li><br><br>
        <br><br>
    </c:forEach>
</ul>

</body>
</html>
