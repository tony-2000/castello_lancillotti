<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="../Partials/head.jsp"/><%-- CSS 706 --%>
    <title>Modifica Recensione</title>
</head>
<body>
<jsp:include page="../Partials/Header.jsp"/><br><br>

<h1 class="titleRec">Modifica la tua recensione</h1><br><br>
<div class="modRec">
<form action="ModificaRecensione" method="get">
    <input type="hidden" name="idEvento" value="${idEvento}">
    <label id="commento">La tua recensione:<br>
        <textarea name="commento" id="textRec" required minlength="5" maxlength="200" cols="100" rows="4">${recensione.commento}</textarea>
    </label><br><br>
    <label id="valutazione">Valutazione:
        <input type="number" id="inputRec" required name="valutazione" step="1" min="1" max="5" value="${recensione.valutazione}">
    </label><br class="space530alt"><br class="space530alt">
    <button type="submit"> Modifica Recensione </button>
</form>
</div>
</body>
</html>
