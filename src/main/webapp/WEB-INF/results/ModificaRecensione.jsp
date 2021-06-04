<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="../Partials/head.jsp"/>
    <title>Modifica Recensione</title>
</head>
<body>
<jsp:include page="../Partials/Header.jsp"/><br><br>


<form action="ModificaRecensione" method="get" >
    <input type="hidden" name="idEvento" value="${idEvento}">
    <input type="number" name="valutazione" required step="1" min="1" max="5" value="${recensione.valutazione}">
    <input type="text" name="commento" required maxlength="500" value="${recensione.commento}">
    <button type="submit"> Modifica Recensione </button>
</form>

</body>
</html>
