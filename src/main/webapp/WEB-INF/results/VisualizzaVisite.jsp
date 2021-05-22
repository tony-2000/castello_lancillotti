<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="model.Evento" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="../Partials/head.jsp"/>
    <title>Title</title>
</head>
<body>
<jsp:include page="../Partials/Header.jsp"/><br><br>
<div class="conteinerVisite">
    <c:forEach items="${listaVisite}" var="visita" >
        <form action="MostraEvento">
            <button type="submit" class="buttonEvent" style="border: 0; background: transparent">
                <div class="galleriaVisite" >
                <img src="${visita.linkImmagine}" alt="submit"/>
                    <input type="hidden" name="idEvento" value="${visita.idEvento}">
                    <div class="descVisite">  ${visita.nome} </div>
            </div>
            </button>
        </form>
    </c:forEach>
</div>


</body>
</html>

