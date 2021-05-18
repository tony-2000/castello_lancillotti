
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
<jsp:include page="WEB-INF/Partials/head.jsp"/>
    <title>Title</title>
</head>
<body>
<jsp:include page="WEB-INF/Partials/Header.jsp"/><br><br>


<form action="Login" method="post">
    Accesso

    <label for="nome_utenteID"> Nome Utente:
    <input type="text" name="nome_utente" id="nome_utenteID" maxlength="20" minlength="4">
    </label>

    <label for="passwordID"> Password:
    <input type="password" name="password" id="passwordID" minlength="8" maxlength="16">
    </label>

    <button type="submit" >Accedi </button>
</form>


<form action="Registrazione.jsp", method="get">
    Registrazione
    <button type="submit" >Registrati </button>
</form>

</body>
</html>
