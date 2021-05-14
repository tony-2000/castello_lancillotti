<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="../Partials/head.jsp"/>
    <title>Title</title>
</head>
<body>
<jsp:include page="../Partials/Header.jsp"/><br><br>
<h1> Registrazione</h1>
    <fieldset>
<form action="Registrazione" method="post">

    <label for="nomeID"> Nome:</label>
    <input type="text" name="nome" id="nomeID">

    <label for="cognomeID"> Cognome:</label>
    <input type="text" name="cognome" id="cognomeID">

    <label for="mailID"> Mail:</label>
    <input type="text" name="mail" id="mailID">

    <label for="telefonoID"> telefono:</label>
    <input type="text" name="telefono" id="telefonoID">

    <label for="nome_utenteID"> Nome Utente:</label>
    <input type="text" name="nome_utente" id="nome_utenteID">

    <label for="passwordID"> Password:</label>
    <input type="password" name="password" id="passwordID">

    <label for="passwordCheckID"> Conferma Password:</label>
    <input type="password" name="passwordCheck" id="passwordCheckID">

    <input type="submit" value="Registrati"></form></fieldset>
</body>
</html>
