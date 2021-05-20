<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <jsp:include page="../Partials/head.jsp"/>
    <title>Title</title>
</head>
<body>
<jsp:include page="../Partials/Header.jsp"/><br><br>

<img src="${evento.linkImmagine}" name="imgEvento" style="width:45px;height:45px;">

${evento.nome} ${evento.descrizione} &nbsp; ${evento.prezzo}




<form action="AggiungiAlCarrello">
    <input type="hidden" name="id_evento" value="${evento.idEvento}">
    <input type="hidden" name="prezzo" value="${evento.prezzo}">
    <input type="date" name="data" >
    <input type="time" step="1" name="orario" >
    <input type="number" name="quantita_biglietti" step="1">
    <button type="submit" >Aggiungi </button>
</form>



<fieldset name="Recensioni">
    <legend> Recensioni</legend>
    <form action="AggiungiRecensione" method="get" <%if(((boolean) request.getAttribute("checkRecensione"))){%>hidden<%}%>>
        <input type="hidden" name="idEvento" value="${evento.idEvento}">
        <input type="number" name="valutazione" step="1" min="1" max="5">
        <input type="text" name="commento" maxlength="500">
        <button type="submit"> Aggiungi Commento </button>
    </form>

    <form action="ToModificaRecensione" method="get" <%if(!((boolean) request.getAttribute("checkRecensione"))){%> hidden<%}%>>
        <input type="hidden" name="idEvento" value="${evento.idEvento}">
        <button type="submit"> Modifica Commento </button>
    </form>

    <form action="EliminaRecensione" method="get" <%if(!((boolean) request.getAttribute("checkRecensione"))){%> hidden<%}%>>
        <input type="hidden" name="idEvento" value="${evento.idEvento}">
        <button type="submit"> Elimina Commento </button>
    </form>

    <c:forEach items="${recensioni}" var="recensioni" >
        <li>${recensioni.nome} ${recensioni.valutazione} ${recensioni.commento} ${recensioni.dataRecensione} ${recensioni.orarioRecensione}</li>
    <br><br>
    </c:forEach>
</fieldset>





</body>
</html>



