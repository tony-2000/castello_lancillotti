<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="it">
<head>
    <jsp:include page="../Partials/head.jsp"/>
    <title>Modifica dati Categoria</title>
</head>
<body>
<jsp:include page="../Partials/Header.jsp"/><br><br>

<img alt="immagine Categoria" src="${categoria.linkImmagine}" style="width:45px;height:45px;" >
<form action="ModificaCategoria" method="get">
    <input type="hidden" name="idCategoria" value="${categoria.idCategoria}">
    <input type="hidden" name="link" value="${categoria.linkImmagine}">

    <label id="image"> Inserisci nuova Immagine:
        <input type="file" accept="image/*" required name="linkImmagine">
    </label>
    <br><br>
    <label id="nome">Inserisci nuovo nome:
        <input type="text" name="nome" required minlength="2" maxlength="30" value="${categoria.nome}">
    </label>
    <br><br>
    <button type="submit">Modifica</button>
</form>

</body>
</html>
