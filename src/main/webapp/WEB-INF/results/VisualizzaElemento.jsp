<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="it">
<head>
    <jsp:include page="../Partials/head.jsp"/>
    <title>Visualizza Elemento</title>
</head>
<body>
<jsp:include page="../Partials/Header.jsp"/><br><br>

<div class="containerElemento">

    <h1 style="text-align: center; font-size: 250% ">${evento.nome}</h1>


        <img src="${evento.linkImmagine}" alt="immagine Evento">


    <div class="descrizioneElemento">
        ${evento.descrizione} &nbsp;
    <br><p style="text-align: right"> Prezzo: ${evento.prezzo} € (a persona)</p>
    </div>

    <div class="scegliElemento">
<form action="AggiungiAlCarrello">
    <input type="hidden" name="id_evento" value="${evento.idEvento}">
    <input type="hidden" name="prezzo" value="${evento.prezzo}">
    <label id="data">Seleziona data:
    <input type="date" required name="data" >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    </label>
    <label id="orario">Seleziona orario:
    <input type="time" required step="1" name="orario">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    </label>
    <label id="quantita_biglietti">Seleziona numero di biglietti:
    <input type="number" required name="quantita_biglietti" step="1">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    </label>
    <button type="submit" >Aggiungi al Carrello </button>
</form>
</div>

</div>


<div class="recensioni">
<fieldset name="Recensioni" style=" border-radius: 5%; margin-bottom: 2%;margin-right: 2%;margin-left: 2%">
    <legend style="font-size: 200%"> Recensioni</legend>


    <form action="AggiungiRecensione" method="get" <%if(((boolean) request.getAttribute("checkRecensione"))){%>hidden<%}%>>
        <input type="hidden" name="idEvento" value="${evento.idEvento}">
        <label id="commento">La tua recensione:<br>
            <textarea name="commento" required maxlength="200" cols="100" rows="2" style="resize: none"></textarea>
        </label><br>
        <label id="valutazione">Valutazione:
            <input type="number" required name="valutazione" step="1" min="1" max="5"style="margin-right: 3%">
        </label>
        <button type="submit" style="margin-right: 2%"> Aggiungi Recensione </button><br><br>
    </form>

    <form action="EliminaRecensione"  method="get" <%if(!((boolean) request.getAttribute("checkRecensione"))){%> hidden<%}%>>
        <input type="hidden" name="idEvento" value="${evento.idEvento}">
        <button type="submit" style="float:right"> Elimina Recensione </button>
    </form>

    <form action="ToModificaRecensione" method="get" <%if(!((boolean) request.getAttribute("checkRecensione"))){%> hidden<%}%>>
        <input type="hidden" name="idEvento" value="${evento.idEvento}">
        <button type="submit" style="float:right"> Modifica Recensione </button><br><br>
    </form>


    <c:forEach items="${recensioni}" var="recensioni" >
    <fieldset name="Recensioni" style=" border-radius: 5%;">
        <legend style="font-size: 120%">${recensioni.nome} </legend>
        <div class="commento">
        <li style="list-style-type: none; padding-left: 2%; padding-right: 2%">  ${recensioni.commento}&nbsp;&nbsp;&nbsp;&nbsp;<br><br>Valutazione:&nbsp;${recensioni.valutazione}/5&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                Data:&nbsp;${recensioni.dataRecensione}&nbsp;&nbsp;alle:&nbsp;${recensioni.orarioRecensione}</li>
        </div>
    </fieldset>
    <br><br>
    </c:forEach>
</fieldset>
</div>


</body>
</html>



