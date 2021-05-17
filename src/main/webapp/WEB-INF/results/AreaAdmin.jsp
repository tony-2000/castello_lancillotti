
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="../Partials/head.jsp"/>
    <title>Area Admin</title>
</head>
<body>
<jsp:include page="../Partials/Header.jsp"/><br><br>
<h1> Area Eventi:</h1>
<br>
<form action="AggiungiEvento">
<button type="submit" > Aggiungi</button>
</form>
<br><br>
<form action="ModificaRimuoviEventi">
    <button type="submit" > Modifica o Rimuovi</button>
</form>

<br><br><br><br><br>

<h1> Area Categoria:</h1>
<form action="ModificaCategoria">
    <button type="submit" > Modifica</button>
</form>
<br>
<form action="AggiungiCategoria">
    <button type="submit" > Aggiungi</button>
</form>
<br><br><br><br><br>

<h1> Area Utenti:</h1>
<form action="ModificaUtenti">
    <button type="submit" > Modifica</button>
</form>
</body>
</html>

