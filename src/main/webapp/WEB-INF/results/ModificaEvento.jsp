<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="it">
<head>
    <jsp:include page="../Partials/head.jsp"/><%-- CSS 1042 --%>
    <title>Modifica Dati Evento</title>
</head>
<body>
<jsp:include page="../Partials/Header.jsp"/><br><br>
<h1 class="titleAdmin"> Modifica Dati Evento</h1>
<a href="AreaAmministratore" class="linkBack">Area Amministratore</a><br><br>
<div class="adminAggiungi">
<img alt="immagine Evento" src="${evento.linkImmagine}" ><br><br>
<form action="ModificaEvento" method="post" enctype="multipart/form-data">
    <input type="hidden" name="idEvento" value="${evento.idEvento}">
    <input type="hidden" name="link" value="${evento.linkImmagine}">
    <label id="cate"> Categoria:
        <select id="cat" name="cate" >
            <c:forEach items="${categorie}" var="categoria" >
                <option value="${categoria.idCategoria}"> ${categoria.nome} </option>
            </c:forEach>
        </select>
    </label>
    <br><br>
    <label id="image"> Inserisci nuova Immagine:<br class="space768"><br class="space768">
        <input type="file" accept="image/*" name="image">
    </label>
    <br><br>
    <label id="nome">Inserisci nuovo nome:<br class="space480"><br class="space480">
        <input type="text" name="nome" required minlength="6" maxlength="30" value="${evento.nome}">
    </label>
    <br><br>
    <label id="descrizione">Inserisci nuova Descrizione:<br>
        <textarea name="descrizione" class="adminAgg" required minlength="20"  maxlength="500" rows="4">${evento.descrizione}</textarea>
    </label>
    <br><br>
    <label id="prezzo">Inserisci nuovo prezzo:<br class="space480"><br class="space480">
        <input type="number" step="0.01" required name="prezzo" min="0" value="${evento.prezzo}">
    </label>
    <br><br>
    <button type="submit">Modifica</button>
</form>
</div>


<div class="adminAggiungi">
<form action="AdminModDate" method="get">
    <input type="hidden" name="idEvento" value="${evento.idEvento}">
    <label id="gestisci" style="font-size: 130%"> Gestisci Date e Orari:<br class="space400"><br class="space400">
    <button type="submit" name="gestisci">Gestisci</button>
    </label>
</form>
</div>

</body>
</html>
