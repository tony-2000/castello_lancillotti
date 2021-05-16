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

<ul>
    <c:forEach items="${listaVisite}" var="visita" >
        <li>
            <form  method="get" action="MostraEvento">
                <input type="image" name="img" src="${visita.linkImmagine}" style="width:45px;height:45px;">
                <input type="hidden" name="idEvento" value="${visita.idEvento}">
            </form>${visita.nome} ${visita.descrizione} &nbsp; ${visita.prezzo} &nbsp; ${visita.postiDisponibili}
        </li><br><br>
        <br><br>
    </c:forEach>
</ul>



</body>
</html>
