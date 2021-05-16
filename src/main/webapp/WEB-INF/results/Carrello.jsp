<%@ page import="java.util.ArrayList" %>
<%@ page import="model.Partecipare" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
<jsp:include page="../Partials/head.jsp"/>
    <title>Title</title>
</head>
<body>
<jsp:include page="../Partials/Header.jsp"/><br><br>


<ul>
    <c:forEach items="${carrello}" var="lista">

        <img src="${lista.link}" name="imgEvento" style="width:45px;height:45px;" alt="img">

        ${lista.nome} ${lista.quantitaBiglietti}  ${lista.dataPartecipazione}
        ${lista.orarioPartecipazione} ${lista.prezzo} ${lista.idEvento}
        <br>

        <form action="RimuoviDalCarrello">
            <input type="hidden" name="id_evento" value="${lista.idEvento}">
            <input type="submit" value="Rimuovi dal Carrello">
        </form>
        <br><br><br>

    </c:forEach>
</ul>



</body>
</html>
