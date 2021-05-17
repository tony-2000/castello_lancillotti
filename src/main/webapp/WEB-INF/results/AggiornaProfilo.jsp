
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
    <label for="nome"> Nome:
    <input type="text" name="nome" id="nome" value="${sessionScope.utenteSessione.nome}">
    </label><br>
    <label for="cognome">Cognome:
    <input type="text" name="cognome" id="cognome" value="${sessionScope.utenteSessione.cognome}">
    </label><br>
    <label for="telefono">Telefono:
    <input type="text" name="telefono" id="telefono" value="${sessionScope.utenteSessione.telefono}">
    </label><br>
    <label for="mail">Mail:
    <input type="text" name="mail" id="mail" value="${sessionScope.utenteSessione.mail}">
    </label><br>
    <label for="nomeUtente">Nome Utente:
    <input type="text" name="nomeUtente" id="nomeUtente" value="${sessionScope.utenteSessione.nomeUtente}">
    </label><br>
    <label for="password">Password:
    <input type="password" name="password" id="password">
    </label><br>
    <label for="passwordCheck">Conferma Password:
    <input type="password" name="passwordCheck" id="passwordCheck">
    </label><br>
    <button type="submit">Salva Modifiche</button>
</form>
<br>
</body>
</html>
