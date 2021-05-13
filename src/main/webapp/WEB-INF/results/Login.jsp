
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<jsp:include page="../Partials/Header.jsp"/><br><br>


<form action="Login" method="post">
    Accesso

    <label for="nome_utenteID"> Nome Utente:</label>
    <input type="text" name="nome_utente" id="nome_utenteID">

    <label for="passwordID"> Password:</label>
    <input type="password" name="password" id="passwordID">

    <input type="submit" value="Accedi">
</form>


<form action="ToRegistrazione", method="get">
    Registrazione
    <input type="submit" value="Registrati">
</form>

</body>
</html>
