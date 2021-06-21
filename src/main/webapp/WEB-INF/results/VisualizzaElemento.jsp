<%@ page import="java.sql.Date" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="model.Data" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="it">
<head>
    <jsp:include page="../Partials/head.jsp"/><%-- CSS 559 --%>
    <script src="/JS/JavaScriptLib.js"></script>
    <title>Visualizza Elemento</title>
</head>
<body>
<jsp:include page="../Partials/Header.jsp"/><br><br>

<h1 class="titleEvent">${evento.nome}</h1>

<div class="containerElemento">
        <p><img src="${evento.linkImmagine}" alt="immagine Evento"><br class="space768"><br class="space768"> ${evento.descrizione}</p>
        <br><p style="text-align: right; float: bottom"> Prezzo: ${evento.prezzo} € (a persona)</p>
</div>
<div class="scegliElemento">

    <form action="AggiungiAlCarrello">
        <input type="hidden" name="id_evento" id="idEventoInput" value="${evento.idEvento}">
        <input type="hidden" name="prezzo" value="${evento.prezzo}">
        <%!ArrayList<Data> temp=new ArrayList<Data>();%> <%temp= (ArrayList<Data>) request.getAttribute("date");%>

        <div <%if (temp.size()==0){%> style="display: none" <%}%>>

            <hr id="hrElemento"><br><br>

            <label id="data">Seleziona data:
                <select required onchange="loadTimes(this.value,${evento.idEvento})" name="data" id="date">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    <option value="seleziona" selected disabled>Seleziona Data</option>
                    <c:forEach var="date" items="${date}">
                        <option value="${date.data}"> ${date.data} </option>
                    </c:forEach>
                </select>
            </label>
            <span id="testo"></span>
            <span id="Spanticket"></span>
        </div>
    </form>
</div>

<%if (temp.size()==0){%> <br><hr><br><%}%>

<p style="<%if (temp.size()!=0){%> display: none;<%}%> margin-right: 5%; text-align: center"> Non sono disponibili date per questo evento.</p><br>


<div class="recensioni">
<fieldset name="Recensioni" style=" border-radius: 5%; margin-bottom: 2%;margin-right: 2%;margin-left: 2%">
    <legend style="font-size: 200%"> Recensioni</legend>


    <form action="AggiungiRecensione" method="get" <%if(((boolean) request.getAttribute("checkRecensione"))){%>hidden<%}%>>
        <input type="hidden" name="idEvento" value="${evento.idEvento}">
        <label id="commento">La tua recensione:<br>
            <textarea name="commento" required maxlength="200" rows="3" style="resize: none;  width:80%"></textarea>
        </label><br>
        <label id="valutazione">Valutazione:
            <input type="number" required name="valutazione" step="1" min="1" max="5"style="margin-right: 3%">
        </label><br class="space480"><br class="space480">
        <button type="submit" style="margin-right: 2%"> Aggiungi Recensione </button><br><br>
    </form>

    <form action="EliminaRecensione"  method="get" <%if(!((boolean) request.getAttribute("checkRecensione"))){%> hidden<%}%>>
        <input type="hidden" name="idEvento" value="${evento.idEvento}">
        <button type="submit" style="float:right"> Elimina Recensione </button>
    </form><br class="space480"><br class="space480">

    <form action="ToModificaRecensione" method="get" <%if(!((boolean) request.getAttribute("checkRecensione"))){%> hidden<%}%>>
        <input type="hidden" name="idEvento" value="${evento.idEvento}">
        <button type="submit" style="float:right"> Modifica Recensione </button><br><br>
    </form>


    <c:forEach items="${recensioni}" var="recensioni" >
    <fieldset name="Recensioni" style=" border-radius: 5%;">
        <legend style="font-size: 120%">${recensioni.nome} </legend>
        <div style="width: 98%; margin-right: 1%; margin-left: 1%">
            <textarea rows="3" readonly style="resize: none; width:80%">${recensioni.commento}</textarea>
            &nbsp;&nbsp;&nbsp;&nbsp;<br><br>Valutazione:&nbsp;${recensioni.valutazione}/5&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <br class="space600"><br class="space600"> Data:&nbsp;${recensioni.dataRecensione}&nbsp;&nbsp;<br class="space350"><br class="space350"> alle:&nbsp;${recensioni.orarioRecensione}
        </div>
    </fieldset>
    <br><br>
    </c:forEach>
</fieldset>
</div>
</body>
</html>



