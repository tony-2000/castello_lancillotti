<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="it">
<head>
    <jsp:include page="../Partials/head.jsp"/>
    <title>Aggiungi Categoria</title>
</head>
<body>
<jsp:include page="../Partials/Header.jsp"/><br><br>
<h1 class="titleAdmin"> Aggiungi Categoria</h1>

<div class="adminAggiungi">
<form action="doAggiungiCategoria" method="post" enctype="multipart/form-data">
    <label for="imageID"> Immagine:<br class="space480"><br class="space480">
        <input type="file" name="image" id="imageID" required accept="image/*">
    </label>
    <br><br>
    <label id="nome">Nome:
        <input type="text" required name="nome" minlength="2" maxlength="30">
    </label><br><br>
    <button type="submit">Aggiungi</button>
</form>
</div>

</body>
</html>