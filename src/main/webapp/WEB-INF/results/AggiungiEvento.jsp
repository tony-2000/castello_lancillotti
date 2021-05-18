<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="../Partials/head.jsp"/>
    <title>Aggiungi Evento</title>
</head>
<body>
<jsp:include page="../Partials/Header.jsp"/><br><br>

<form action="doAggiungiEvento" method="get">
    <label id="categorie">Categoria:
    <select id="categoria" name="categorie" >
        <c:forEach items="${categorie}" var="categorie" >
            <option value="${categorie.idCategoria}"> ${categorie.nome} </option>
        </c:forEach>
    </select>
    </label>
    <br><br>
    <label id="image"> Immagine:
    <input type="file" accept="image/*">
    </label>
    <br><br>
    <label id="nome">Nome:
        <input type="text" name="nome" minlength="2" maxlength="30">
    </label>
    <br><br>
    <label id="descrizione">Descrizione:
        <input type="text" name="descrizione" minlength="1" maxlength="500">
    </label>
    <br><br>
    <label id="prezzo">Prezzo:
        <input type="number" step="0.01" name="prezzo" min="0">
    </label>
    <br><br>
    <label id="Posti">Posti Disponibili:
        <input type="number" name="posti" min="1">
    </label>
    <br><br>
    <button type="submit">Aggiungi</button>
</form>
</body>
</html>
