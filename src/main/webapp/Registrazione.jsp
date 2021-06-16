<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="it">
<head>
    <jsp:include page="WEB-INF/Partials/head.jsp"/>
    <style>
    body {
    background-image: url("Images/registrazione-Background.jpg");
    background-repeat: no-repeat;
    background-size: cover;
        background-attachment: fixed;
        background-position: center center;
    }
    </style>
    <title>Registrazione</title>
</head>
<body>
<jsp:include page="WEB-INF/Partials/Header.jsp"/><br><br>

<div class="registrazione">
<h1> Registrazione</h1>
<form action="Registrazione" method="post" onsubmit="return checkRegistration()">

    <label for="nomeID"> Nome:<br>
    <input type="text" name="nome" required id="nomeID" minlength="2" maxlength="20">
    </label><br>

    <label for="cognomeID"> Cognome:<br>
    <input type="text" name="cognome" required id="cognomeID" minlength="2" maxlength="30">
    </label><br>

    <label for="mailID"> Mail:<br>
    <input type="email" name="mail" required id="mailID" minlength="6" maxlength="40">
    </label><br>

    <label for="telefonoID"> telefono:<br>
    <input type="text" name="telefono" required id="telefonoID" minlength="9" maxlength="11">
    </label><br>

    <label for="nome_utenteID"> Nome Utente:<br>
    <input type="text" name="nome_utente" required id="nome_utenteID" minlength="4" maxlength="20">
    </label><br>

    <label for="passwordID"> Password:<br>
    <input type="password" name="password" required id="passwordID" minlength="8" maxlength="16">
    </label><br>

    <label for="passwordCheckID"> Conferma Password:<br>
    <input type="password" name="passwordCheck" required id="passwordCheckID" minlength="8" maxlength="16">
    </label><br><br>

    <button type="submit">Registrati</button>
</form>
    </div>
</body>
</html>
