<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="it">
<head>
    <jsp:include page="WEB-INF/Partials/head.jsp"/>
    <script src="JS/JavaScriptLib.js"></script><%-- CSS 487 --%>
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
<body onload="datiPresenti(${datiPresenti})">
<jsp:include page="WEB-INF/Partials/Header.jsp"/><br><br>

<div class="registrazione">
<h1> Registrazione</h1>
<form action="Registrazione" method="post">

    <label for="nomeID" class="checkForm"> Nome:<br>
    <input type="text" name="nome" required id="nomeID" minlength="2" maxlength="20">
        <span class="checkFormText">Inserisci un nome con lunghezza 2-20 caratteri.</span>
    </label><br>

    <label for="cognomeID" class="checkForm"> Cognome:<br>
    <input type="text" name="cognome" required id="cognomeID" minlength="2" maxlength="30">
        <span class="checkFormText">Inserisci un cognome con lunghezza 2-30 caratteri.</span>
    </label><br>

    <label for="mailID" class="checkForm"> Mail:<br>
    <input type="email" name="mail" required id="mailID" minlength="6" maxlength="40">
        <span class="checkFormText">Inserisci una mail valida di 6-40 caratteri.<br>Non modificabile.</span>
    </label><br>

    <label for="telefonoID" class="checkForm"> Telefono:<br>
        <input type="tel" name="telefono" pattern="[0-9]{10}" required id="telefonoID"
               minlength="10" maxlength="10">
        <span class="checkFormText">Inserisci un numero di telefono di 10 cifre.</span>
    </label><br>

    <label for="nome_utenteID" class="checkForm"> Nome Utente:<br>
    <input type="text" name="nome_utente" required id="nome_utenteID" minlength="4" maxlength="20">
        <span class="checkFormText">Inserisci un nome utente di 4-20 caratteri.<br>Non modificabile.</span>
    </label><br>

    <label for="passwordID" class="checkForm"> Password:<br>
    <input type="password" name="password" required id="passwordID" minlength="8" maxlength="16" pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?=.*\W)(?!.*\s).{8,16}">
        <span class="checkFormText">Inserisci una password con queste caratteristiche:<br>-lunghezza: 8-16 caratteri<br>-almeno un carattere speciale<br>-almeno una lettera maiuscola<br>-almeno una lettera minuscola<br>-almeno una cifra</span>
    </label><br>

    <label for="passwordCheckID" class="checkForm"> Conferma Password:<br>
    <input type="password" name="passwordCheck" required id="passwordCheckID" minlength="8" maxlength="16" pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?=.*\W)(?!.*\s).{8,16}">
        <span class="checkFormText">Le due password devono coincidere</span>
    </label><br><br>

    <button type="submit" onclick="return checkPassword()">Registrati</button>
</form>
    </div>
</body>
</html>