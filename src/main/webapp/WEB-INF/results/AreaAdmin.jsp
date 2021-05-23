<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="it">
<head>
    <jsp:include page="../Partials/head.jsp"/>
    <title>Area Admin</title>
</head>
<body>
<jsp:include page="../Partials/Header.jsp"/><br><br>
<img src="${pageContext.request.contextPath}/Images/adminPic.png" class="adminPic" alt="immagine Admin 1" style="width:100px;height:100px;">
<h1> Area Eventi:</h1>
<br>
<form action="AggiungiEvento">
<button type="submit" > Aggiungi</button>
</form>
<br><br>
<form action="ModificaRimuoviEvento">
    <button type="submit" > Modifica o Rimuovi</button>
</form>
<br><br><br><br><br>

<img src="${pageContext.request.contextPath}/Images/adminPic.png"  class="adminPic" alt="immagine Admin 2" style="width:100px;height:100px;">
<h1> Area Categoria:</h1>
<form action="AggiungiCategoria">
    <button type="submit" > Aggiungi</button>
</form>
<form action="ModificaRimuoviCategoria">
    <button type="submit" > Modifica</button>
</form>
<br>
<br><br><br><br><br>

<img src="${pageContext.request.contextPath}/Images/adminPic.png" class="adminPic" alt="immagine Admin 3" style="width:100px;height:100px;">
<h1> Area Utenti:</h1>
<form action="ModificaUtenti">
    <button type="submit" > Modifica</button>
</form>
</body>
</html>

