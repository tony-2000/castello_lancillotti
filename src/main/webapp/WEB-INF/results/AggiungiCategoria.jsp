<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="it">
<head>
    <jsp:include page="../Partials/head.jsp"/>
    <title>Aggiungi Categoria</title>
</head>
<body>
<jsp:include page="../Partials/Header.jsp"/><br><br>

<form action="doAggiungiCategoria" method="get">
    <label id="image"> Immagine:
        <input type="file" accept="image/*">
    </label>
    <br><br>
    <label id="nome">Nome:
        <input type="text" name="nome" minlength="2" maxlength="30">
    </label>
    <button type="submit">Aggiungi</button>
</form>

</body>
</html>
