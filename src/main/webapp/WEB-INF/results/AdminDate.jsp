<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="model.Data" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="it">
<head>
    <script src="JS/JavaScriptLib.js"></script> <%-- CSS 1042 --%>
    <script src="JS/jquery-3.6.0.min.js"></script>
    <jsp:include page="../Partials/head.jsp"/>
    <title>Gestisci Date Evento</title>
</head>
<body onload="control(${control})">

<jsp:include page="../Partials/Header.jsp"/><br><br>
<h1 class="titleAdmin"> Gestisci Date Evento</h1>
<a href="AreaAmministratore" class="linkBack">Area Amministratore</a><br><br>
<%!ArrayList<Data> temp=new ArrayList<Data>();%> <%temp= (ArrayList<Data>) request.getAttribute("date");%>

<div class="adminAggiungi">
    <fieldset>
<form action="AdminAddData" method="get">
    <input type="hidden" name="idEvento" value="${evento.idEvento}">
    <label id="newData"> Aggiungi nuova data:<br class="space600"><br class="space600">
    <input type="date" required name="newData" id="dataEvento">
    </label><br class="space480"><br class="space480">
    <button type="submit">Aggiungi</button>
</form>
    </fieldset>
</div>

<div class="adminAggiungi" <%if (temp.size()==0){%> style="display: none" <%}%>>
    <fieldset>
<form action="AdminDeleteData" method="get">
    <input type="hidden" name="idEvento" value="${evento.idEvento}">
        <label for="dates">Seleziona data da eliminare:<br class="space600"><br class="space600">
            <select required name="data1" id="dates" onchange="showButton1()">
                <option selected disabled >Seleziona Data</option>
                <c:forEach var="date" items="${date}">
                    <option value="${date.data}"> ${date.data} </option>
                </c:forEach>
            </select>
        </label><br class="space480"><br class="space480">
        <button type="submit" style="display: none" id="button1">Elimina</button>
</form>
        </fieldset>
</div>



<h1 class="titleAdmin"> Gestisci Orari Evento</h1>


        <div class="adminAggiungi" <%if (temp.size()==0){%> style="display: none" <%}%>>
            <label for="date" style="font-size: 115%">Seleziona data:
                <select required onchange="loadHours(this.value,${evento.idEvento})" name="data" id="date">
                    <option value="seleziona" selected disabled>Seleziona Data</option>
                    <c:forEach var="date" items="${date}">
                        <option value="${date.data}"> ${date.data} </option>
                    </c:forEach>
                </select>
            </label>
        </div>


<div class="adminAggiungi" id="aggiungiOra" style="display: none">
    <fieldset>
<form action="AdminAddTime" method="get">
    <input type="hidden" name="idEvento" value="${evento.idEvento}">
    <input type="hidden" name="dataEvento" id="dataEv" value="">
      <label for="oraEvento"> Aggiungi un nuovo orario:<br class="space480"> <br class="space480">
        <input type="time" step="1" required name="newHour" id="oraEvento">
    </label><br><br>
    <label for="big">Seleziona quantità biglietti:<br class="space768"><br class="space768">
        <input type="number" min="1" required name="biglietti" id="big">
    </label><br class="space480"><br class="space480">
    <button type="submit">Aggiungi</button>
</form>
    </fieldset>
</div>


<div class="adminAggiungi">
<form action="AdminDeleteTime" method="get">
    <input type="hidden" name="idEvento" value="${evento.idEvento}">
    <input type="hidden" id="dataEliminazione" name="dataEl" value="">
<span id="eliminaOra"></span>
</form>
</div>

</body>
</html>
