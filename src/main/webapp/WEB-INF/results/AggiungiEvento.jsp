<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="it">
<head>
    <jsp:include page="../Partials/head.jsp"/><%-- CSS 1042 --%>
    <title>Aggiungi Evento</title>
</head>
<body>
<jsp:include page="../Partials/Header.jsp"/><br><br>
<h1 class="titleAdmin"> Aggiungi Evento</h1>
<a href="AreaAmministratore" class="linkBack">Area Amministratore</a><br><br>
<div class="adminAggiungi">
<form action="doAggiungiEvento" method="post" enctype="multipart/form-data" >
    <label for="categoria">Categoria:
    <select id="categoria" name="categorie">
        <c:forEach items="${categorie}" var="categorie" >
            <option value="${categorie.idCategoria}"> ${categorie.nome} </option>
        </c:forEach>
    </select>
    </label>
    <br><br>
    <label for="imageEvento"> Immagine:<br class="space480"><br class="space480">
    <input type="file" name="image" id="imageEvento" required accept="image/*">
    </label>
    <br><br>
    <label for="nome">Nome:
        <input type="text" name="nome" id="nome" required minlength="6" maxlength="30">
    </label>
    <br><br>
    <label for="descrizione">Descrizione:<br>
        <textarea name="descrizione" id="descrizione" class="adminAgg" required minlength="20" maxlength="500" rows="4"></textarea>
    </label>
    <br><br>
    <label for="prezzo">Prezzo:
        <input type="number" step="0.01" id="prezzo" required name="prezzo" min="0">
    </label>
    <br><br>
    <button type="submit">Aggiungi</button>
</form>
</div>

</body>
</html>
