<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="it">
<head>
    <script src="JS/JavaScriptLib.js"></script>
    <style>
        body {
            background-image: url('Images/BackgroundModProfilo.jpg');
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
    <label for="nome"  class="checkForm"> Nome:<br>
    <input type="text" name="nome" id="nome" required minlength="2" maxlength="20" value="${sessionScope.utenteSessione.nome}">
        <span class="checkFormText">Inserisci un nome con lunghezza 2-20 caratteri.</span>
    </label><br>
    <label for="cognome" class="checkForm" >Cognome:<br>
    <input type="text" name="cognome" id="cognome" required minlength="2" maxlength="30" value="${sessionScope.utenteSessione.cognome}">
        <span class="checkFormText">Inserisci un cognome con lunghezza 2-30 caratteri.</span>
    </label><br>
    <label for="mail" class="checkForm">Mail:<br>
    <input type="email" name="mail" id="mail" required minlength="6" maxlength="40" readonly value="${sessionScope.utenteSessione.mail}">
        <span class="checkFormText">Mail non modificabile</span>
    </label><br>
    <label for="telefono" class="checkForm">Telefono:<br>
        <input type="tel" name="telefono" id="telefono" required  pattern="[0-9]{10}" minlength="10" maxlength="10" value="${sessionScope.utenteSessione.telefono}">
        <span class="checkFormText">Inserisci un numero di telefono di 10 cifre.</span>
    </label><br>
    <label for="nomeUtente" class="checkForm">Nome Utente:<br>
    <input type="text" name="nomeUtente" id="nomeUtente" required minlength="4" maxlength="20" readonly value="${sessionScope.utenteSessione.nomeUtente}">
        <span class="checkFormText">Nome Utente non modificabile</span>
    </label><br>
    <label for="passwordID" class="checkForm">Password:<br>
    <input type="text" name="password" id="passwordID" required minlength="8" maxlength="16" pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?=.*\W)(?!.*\s).{8,16}">
        <span class="checkFormText">Inserisci una password con queste caratteristiche:<br>-lunghezza: 8-16 caratteri<br>-almeno un carattere speciale<br>-almeno una lettera maiuscola<br>-almeno una lettera minuscola<br>-almeno una cifra</span>
    </label><br>
    <label for="passwordCheckID" class="checkForm">Conferma Password:<br>
    <input type="text" name="passwordCheck" required id="passwordCheckID" minlength="8" maxlength="16"  pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?=.*\W)(?!.*\s).{8,16}">
        <span class="checkFormText">Le due password devono coincidere</span>
    </label><br><br>
    <button type="submit" onclick="return checkPassword()">Salva Modifiche</button>
</form>
</div>
</body>
</html>














