<%@ page import="model.Evento" %>
<%@ page import="model.Categoria" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="../Partials/head.jsp"/>
    <title>Modifica Evento</title>
</head>
<body>

<jsp:include page="../Partials/Header.jsp"/><br><br>
<img alt="img" src="${evento.linkImmagine}" style="width:45px;height:45px;" >
<form action="ModificaEvento" method="get">
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
    <label id="image"> Inserisci nuova Immagine:
        <input type="file" accept="image/*" name="linkImmagine">
    </label>
    <br><br>
    <label id="nome">Inserisci nuovo nome:
        <input type="text" name="nome" minlength="2" maxlength="30" value="${evento.nome}">
    </label>
    <br><br>
    <label id="descrizione">Inserisci nuova Descrizione:
        <input type="text" name="descrizione" minlength="1"  maxlength="500" value="${evento.descrizione}">
    </label>
    <br><br>
    <label id="prezzo">Inserisci nuovo prezzo:
        <input type="number" step="0.01" name="prezzo" min="0" value="${evento.prezzo}">
    </label>
    <br><br>
    <label id="Posti">Inserisci nuovi posti disponibili:
        <input type="number" name="postiDisponibili" min="1" value="${evento.postiDisponibili}">
    </label>
    <br><br>
    <button type="submit">Modifica</button>
</form>

</body>
</html>
