<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="it">
<head><jsp:include page="../Partials/head.jsp"/>
    <title>Profilo</title>
</head>
<body>
<jsp:include page="../Partials/Header.jsp"/><br><br>

Dati Anagrafici:<br> ${sessionScope.utenteSessione.nome}  <br> ${sessionScope.utenteSessione.cognome} <br>
 ${sessionScope.utenteSessione.telefono}  <br> ${sessionScope.utenteSessione.mail} <br>
${sessionScope.utenteSessione.nomeUtente}
<br><br>


<form action="ToAggiornaProfilo" method="post">
    <label id="password">Per modificare i dati utente inserire la password:
    <input type="password" name="password" maxlength="16" minlength="8">
    </label>
    <button type="submit">Modifica </button>
</form>

</body>
</html>
