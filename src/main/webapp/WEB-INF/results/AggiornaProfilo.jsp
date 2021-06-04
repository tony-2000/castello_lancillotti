<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="it">
<head>
    <style>
        body {
            background-image: url("Images/BackgroundModProfilo.jpg");
            background-repeat: no-repeat;
            background-size: cover;
            background-attachment: fixed;
            background-position: center center;
        }
    </style>
    <jsp:include page="../Partials/head.jsp"/>
    <title>Aggiorna Profilo</title>
</head>
<body>
<jsp:include page="../Partials/Header.jsp"/><br><br>

<div class="registrazione">
<h1>Modifica dati</h1>
<form action="AggiornaProfilo" method="post">
    <label for="nome"> Nome:<br>
    <input type="text" name="nome" id="nome" required minlength="2" maxlength="20" value="${sessionScope.utenteSessione.nome}">
    </label><br>
    <label for="cognome">Cognome:<br>
    <input type="text" name="cognome" id="cognome" required minlength="2" maxlength="30" value="${sessionScope.utenteSessione.cognome}">
    </label><br>
    <label for="telefono">Telefono:<br>
    <input type="text" name="telefono" id="telefono" required minlength="9" maxlength="11" value="${sessionScope.utenteSessione.telefono}">
    </label><br>
    <label for="mail">Mail:<br>
    <input type="email" name="mail" id="mail" required minlength="6" maxlength="40" value="${sessionScope.utenteSessione.mail}">
    </label><br>
    <label for="nomeUtente">Nome Utente:<br>
    <input type="text" name="nomeUtente" id="nomeUtente" required minlength="4" maxlength="30" value="${sessionScope.utenteSessione.nomeUtente}">
    </label><br>
    <label for="password">Password:<br>
    <input type="password" name="password" id="password" required maxlength="16" minlength="8">
    </label><br>
    <label for="passwordCheck">Conferma Password:<br>
    <input type="password" name="passwordCheck" required id="passwordCheck" maxlength="16" minlength="8">
    </label><br><br>
    <button type="submit">Salva Modifiche</button>
</form>
</div>

</body>
</html>
