<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="it">
<head>
    <jsp:include page="../Partials/head.jsp"/>
    <title>Aggiungi Evento</title>
</head>
<body>
<jsp:include page="../Partials/Header.jsp"/><br><br>
<h1 style="text-align: center; font-size: 250% "> Aggiungi Evento</h1>
<div class="adminAggiungi">
<form action="doAggiungiEvento" method="post" enctype="multipart/form-data" >
    <label id="categorie">Categoria:
    <select id="categoria" name="categorie">
        <c:forEach items="${categorie}" var="categorie" >
            <option value="${categorie.idCategoria}"> ${categorie.nome} </option>
        </c:forEach>
    </select>
    </label>
    <br><br>
    <label id="image"> Immagine:
    <input type="file" name="image" required accept="image/*">
    </label>
    <br><br>
    <label id="nome">Nome:
        <input type="text" name="nome" required minlength="6" maxlength="30">
    </label>
    <br><br>
    <label id="descrizione">Descrizione:<br>
        <textarea name="descrizione" required minlength="20" maxlength="500" rows="3" style="width: 60%;resize: none"></textarea>
    </label>
    <br><br>
    <label id="prezzo">Prezzo:
        <input type="number" step="0.01" required name="prezzo" min="0">
    </label>
    <br><br>
    <button type="submit">Aggiungi</button>
</form>
</div>

</body>
</html>
