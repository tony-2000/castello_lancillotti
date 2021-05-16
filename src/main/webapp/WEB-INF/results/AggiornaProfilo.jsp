
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="../Partials/head.jsp"/>
    <title>Aggiorna Profilo</title>
</head>
<body>
<jsp:include page="../Partials/Header.jsp"/><br><br>

<h1> Modifica dati personali</h1>
<form action="AggiornaProfilo" method="post">
    <input type="hidden" name="id" value="${sessionScope.utenteSessione.idUtente}">
    <input type="text" name="nome" value="${sessionScope.utenteSessione.nome}">
    <input type="text" name="cognome" value="${sessionScope.utenteSessione.cognome}">
    <input type="text" name="telefono" value="${sessionScope.utenteSessione.telefono}">
    <input type="text" name="mail" value="${sessionScope.utenteSessione.mail}">
    <input type="text" name="nomeUtente" value="${sessionScope.utenteSessione.nomeUtente}">
    <input type="submit" value="Salva Modifica"></form>
<br>
</body>
</html>
