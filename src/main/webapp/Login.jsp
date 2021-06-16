<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="it">
<head>
    <script src="JS/JavaScriptLib.js"></script>
    <style>
    body {
    background-image: url("Images/LoginBackground.jpg");
    background-repeat: no-repeat;
        background-size: cover;
        background-attachment: fixed;
        background-position: center center;
    }
    </style>
<jsp:include page="WEB-INF/Partials/head.jsp"/>
    <title>Login</title>
</head>
<body onload="errLogin(${logError})">
<jsp:include page="WEB-INF/Partials/Header.jsp"/><br><br>
<div class="login">
<form action="Login" method="post">
    <h1>Login</h1>
    <label for="nome_utenteID"> Nome Utente:
      <br>
    <input type="text" required name="nome_utente" id="nome_utenteID" maxlength="20" minlength="4">
    </label>
            <br><br>
    <label for="passwordID"> Password:
        <br>
        <input type="password" required name="password" id="passwordID" minlength="8" maxlength="16">
    </label><br><br>

    <button type="submit" >Accedi </button><br><br>
</form>
    <p>Non sei registrato?</p>
    <a href="Registrazione.jsp">Registrati </a>
</div>

</body>
</html>
