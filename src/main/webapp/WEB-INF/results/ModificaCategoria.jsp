<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="it">
<head>
    <jsp:include page="../Partials/head.jsp"/>
    <title>Modifica dati Categoria</title>
</head>
<body>
<jsp:include page="../Partials/Header.jsp"/><br><br>
<h1 style="text-align: center; font-size: 250% ">Modifica Dati Categoria</h1>
<div class="adminAggiungi">
<img alt="immagine Categoria" src="${categoria.linkImmagine}" style="width:30%;height:auto;" ><br><br>
<form action="ModificaCategoria" method="post" enctype="multipart/form-data">
    <input type="hidden" name="idCategoria" value="${categoria.idCategoria}">
    <input type="hidden" name="link" value="${categoria.linkImmagine}">
    <label id="image"> Inserisci nuova Immagine:
        <input type="file" accept="image/*" name="image">

    </label>
    <br><br>
    <label id="nome">Inserisci nuovo nome:
        <input type="text" name="nome" required minlength="4" maxlength="30" value="${categoria.nome}">
    </label>
    <br><br>
    <button type="submit">Modifica</button>
</form>
</div>
</body>
</html>
