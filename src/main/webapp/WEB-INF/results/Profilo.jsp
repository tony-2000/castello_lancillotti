<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
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
    <label id="password">Per modificare i dati utente inserire la password:</label>
    <input type="password" name="password">
    <input type="submit" value="Modifica">
</form>

</body>
</html>
