<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="it">
<head>
    <jsp:include page="../Partials/head.jsp"/>
    <title>Visualizza Categorie</title>
</head>
<body>
<jsp:include page="../Partials/Header.jsp"/>
<div class="title"><h1 style="margin-bottom: 2%"> Categorie di Eventi</h1></div>
<div class="conteinerVisite">
    <c:forEach items="${listaCategorie}" var="lista" >
            <form  method="get" action="ShowAllEvents" >
                <div class="galleriaVisite" >
                <button type="submit" style="border: 0; background: transparent">
                        <img src="${lista.linkImmagine}" alt="Immagine Categoria"/>
                            <input type="hidden" name="idCategoria" value="${lista.idCategoria}">
                            <div class="descVisite">  ${lista.nome} </div>
                </button>
                </div>
            </form>
    </c:forEach>
</div>











</body>
</html>
