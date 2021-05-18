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
    <input type="text" name="nome" id="nomeID" minlength="2" maxlength="30">
    </label>

    <label for="cognomeID"> Cognome:
    <input type="text" name="cognome" id="cognomeID" minlength="2" maxlength="30">
    </label>

    <label for="mailID"> Mail:
    <input type="email" name="mail" id="mailID" minlength="6" maxlength="40">
    </label>

    <label for="telefonoID"> telefono:
    <input type="text" name="telefono" id="telefonoID" minlength="9" maxlength="12">
    </label>

    <label for="nome_utenteID"> Nome Utente:
    <input type="text" name="nome_utente" id="nome_utenteID" minlength="4" maxlength="20">
    </label>

    <label for="passwordID"> Password:
    <input type="password" name="password" id="passwordID" minlength="8" maxlength="16">
    </label>

    <label for="passwordCheckID"> Conferma Password:
    <input type="password" name="passwordCheck" id="passwordCheckID" minlength="8" maxlength="16">
    </label>

    <button type="submit" >Registrati</button>
</form></fieldset>
</body>
</html>
