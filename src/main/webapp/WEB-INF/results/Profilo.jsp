<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="it">
<head>
    <style>
    body {
        background-image: url("Images/BackgroundProfilo.jpg");
        background-repeat: no-repeat;
        background-size: cover;
        background-attachment: fixed;
        background-position: center center;
    }
</style>
    <jsp:include page="../Partials/head.jsp"/>
    <title>Profilo</title>

</head>
<body>
<jsp:include page="../Partials/Header.jsp"/><br><br>


<div class="profilo">
    <h1>Profilo</h1>
    <p>Nome: ${sessionScope.utenteSessione.nome}</p>
    <p>Cognome: ${sessionScope.utenteSessione.cognome}</p>
    <p>Telefono: ${sessionScope.utenteSessione.telefono} </p>
    <p>Mail: ${sessionScope.utenteSessione.mail}</p>
    <p>Nome Utente: ${sessionScope.utenteSessione.nomeUtente}</p><br>

<form action="ToAggiornaProfilo" method="post">
    <label id="password">Per modificare i dati utente inserire la password:<br>
    <input type="password" required name="password" maxlength="16" minlength="8">
    </label>
    <button type="submit">Modifica</button>
</form>
</div>

</body>
</html>
