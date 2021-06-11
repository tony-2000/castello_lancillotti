<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="../Partials/head.jsp"/>
    <title>Modifica Recensione</title>
</head>
<body>
<jsp:include page="../Partials/Header.jsp"/><br><br>

<h1 style="text-align: center; font-size: 250% ">Modifica la tua recensione</h1><br><br>
<div style="margin-left: 5%">
<form action="ModificaRecensione" method="get" >
    <input type="hidden" name="idEvento" value="${idEvento}">
    <label id="commento">La tua recensione:<br>
        <textarea name="commento" required maxlength="200" cols="100" rows="3" style="resize: none; width:60%">${recensione.commento}</textarea>
    </label><br><br>
    <label id="valutazione">Valutazione:
        <input type="number" required name="valutazione" step="1" min="1" max="5"style="margin-right: 3%" value="${recensione.valutazione}">
    </label>
    <button type="submit"> Modifica Recensione </button>
</form>
</div>
</body>
</html>
