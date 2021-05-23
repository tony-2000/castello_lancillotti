<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="it">
<head>
    <jsp:include page="../Partials/head.jsp"/>
    <title>Aggiorna Profilo</title>
</head>
<body>
<jsp:include page="../Partials/Header.jsp"/><br><br>

<h1> Modifica dati personali</h1>
<form action="AggiornaProfilo" method="post">
    <label for="nome"> Nome:
    <input type="text" name="nome" id="nome" minlength="2" maxlength="30" value="${sessionScope.utenteSessione.nome}">
    </label><br>
    <label for="cognome">Cognome:
    <input type="text" name="cognome" id="cognome" minlength="2" maxlength="30" value="${sessionScope.utenteSessione.cognome}">
    </label><br>
    <label for="telefono">Telefono:
    <input type="text" name="telefono" id="telefono" minlength="9" maxlength="11" value="${sessionScope.utenteSessione.telefono}">
    </label><br>
    <label for="mail">Mail:
    <input type="email" name="mail" id="mail" minlength="6" maxlength="40" value="${sessionScope.utenteSessione.mail}">
    </label><br>
    <label for="nomeUtente">Nome Utente:
    <input type="text" name="nomeUtente" id="nomeUtente" minlength="4" maxlength="30" value="${sessionScope.utenteSessione.nomeUtente}">
    </label><br>
    <label for="password">Password:
    <input type="password" name="password" id="password" maxlength="16" minlength="8">
    </label><br>
    <label for="passwordCheck">Conferma Password:
    <input type="password" name="passwordCheck" id="passwordCheck" maxlength="16" minlength="8">
    </label><br>
    <button type="submit">Salva Modifiche</button>
</form>
<br>
</body>
</html>
