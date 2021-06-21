<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="it">
<head>
    <jsp:include page="../Partials/head.jsp"/><%-- CSS 325 --%>
    <title>Visualizza Visite</title>
</head>
<body>
<jsp:include page="../Partials/Header.jsp"/>

<div class="title"><h1 style="margin-bottom: 2%"> Visite</h1></div>
<div class="containerVisite">
    <c:forEach items="${listaVisite}" var="visita" >
        <div class="cartolina">
        <form action="MostraEvento" >
                <div class="galleriaVisite" >
                    <button type="submit" style="border: 0; background: transparent" >
                        <img src="${visita.linkImmagine}" alt="Immagine Visita"/>
                         <input type="hidden" name="idEvento" value="${visita.idEvento}">
            </button>
            </div>
            <button type="submit" style="border: 0; width:100%; background: transparent" >
            <div class="descVisite">  ${visita.nome} </div></button>
        </form>
        </div>
    </c:forEach>
</div>
</body>
</html>

