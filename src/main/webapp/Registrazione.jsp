<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="WEB-INF/Partials/head.jsp"/>
    <title>Title</title>
</head>
<body>
<jsp:include page="WEB-INF/Partials/Header.jsp"/><br><br>
<h1> Registrazione</h1>
    <fieldset>
<form action="Registrazione" method="post">

    <label for="nomeID"> Nome:
    <input type="text" name="nome" id="nomeID">
    </label>

    <label for="cognomeID"> Cognome:
    <input type="text" name="cognome" id="cognomeID">
    </label>

    <label for="mailID"> Mail:
    <input type="text" name="mail" id="mailID">
    </label>

    <label for="telefonoID"> telefono:
    <input type="text" name="telefono" id="telefonoID">
    </label>

    <label for="nome_utenteID"> Nome Utente:
    <input type="text" name="nome_utente" id="nome_utenteID">
    </label>

    <label for="passwordID"> Password:
    <input type="password" name="password" id="passwordID">
    </label>

    <label for="passwordCheckID"> Conferma Password:
    <input type="password" name="passwordCheck" id="passwordCheckID">
    </label>

    <button type="submit" >Registrati</button>
</form></fieldset>
</body>
</html>
