<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="model.Evento" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="it">
<head>
    <jsp:include page="../Partials/head.jsp"/>
    <title>Visualizza Visite</title>
</head>
<body>
<jsp:include page="../Partials/Header.jsp"/>

<div class="title"><h1 style="margin-bottom: 2%"> Visite</h1></div>
<div class="conteinerVisite">
    <c:forEach items="${listaVisite}" var="visita" >
        <form action="MostraEvento" >
                <div class="galleriaVisite" >
                    <button type="submit" style="border: 0; background: transparent" >
                        <img src="${visita.linkImmagine}" alt="Immagine Visita"/>
                         <input type="hidden" name="idEvento" value="${visita.idEvento}">
                        <div class="descVisite">  ${visita.nome} </div>
            </button>
            </div>

        </form>
    </c:forEach>
</div>
</body>
</html>

