<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="it">
<head>
    <jsp:include page="../Partials/head.jsp"/><%-- CSS 1042 --%>
    <title>Modifica dati Categoria</title>
</head>
<body>
<jsp:include page="../Partials/Header.jsp"/><br><br>
<h1 class="titleAdmin">Modifica Dati Categoria</h1>
<a href="AreaAmministratore" class="linkBack">Area Amministratore</a><br><br>
<div class="adminAggiungi">
<img alt="immagine Categoria" src="${categoria.linkImmagine}" ><br><br>
<form action="ModificaCategoria" method="post" enctype="multipart/form-data">
    <input type="hidden" name="idCategoria" value="${categoria.idCategoria}">
    <input type="hidden" name="link" value="${categoria.linkImmagine}">
    <label id="image" for="imag"> Inserisci nuova Immagine:<br class="space768"><br class="space768">
        <input type="file" accept="image/*" name="image" id="imag">

    </label>
    <br><br>
    <label id="nome" for="name">Inserisci nuovo nome:<br class="space480"><br class="space480">
        <input type="text" name="nome" id="name" required minlength="4" maxlength="30" value="${categoria.nome}">
    </label>
    <br><br>
    <button type="submit">Modifica</button>
</form>
</div>
</body>
</html>
