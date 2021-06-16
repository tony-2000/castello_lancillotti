<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="model.Data" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="it">
<head>
    <script src="JS/JavaScriptLib.js"></script>
    <script src="JS/jquery-3.6.0.min.js"></script>
    <jsp:include page="../Partials/head.jsp"/>
    <title>Gestisci Date Evento</title>
</head>
<body onload="control(${control})">

<jsp:include page="../Partials/Header.jsp"/><br><br>
<h1 style="text-align: center; font-size: 170% "> Gestisci Date Evento</h1>
<%!ArrayList<Data> temp=new ArrayList<Data>();%> <%temp= (ArrayList<Data>) request.getAttribute("date");%>

<div class="adminAggiungi">
    <fieldset>
<form action="AdminAddData" method="get">
    <input type="hidden" name="idEvento" value="${evento.idEvento}">
    <label id="newData"> Aggiungi nuova data:
    <input type="date" required name="newData" id="dataEvento">
    </label>
    <button type="submit">Aggiungi</button>
</form>
    </fieldset>
</div>

<div class="adminAggiungi" <%if (temp.size()==0){%> style="display: none" <%}%>>
    <fieldset>
<form action="AdminDeleteData" method="get">
    <input type="hidden" name="idEvento" value="${evento.idEvento}">
        <label id="data1">Seleziona data da eliminare:
            <select required name="data1" id="dates" onchange="showButton1()">
                <option selected disabled >Seleziona Data</option>
                <c:forEach var="date" items="${date}">
                    <option value="${date.data}"> ${date.data} </option>
                </c:forEach>
            </select>
        </label>
        <button type="submit" style="display: none" id="button1">Elimina</button>
</form>
        </fieldset>
</div>



<h1 style="text-align: center; font-size: 170% "> Gestisci Orari Evento</h1>


        <div class="adminAggiungi" <%if (temp.size()==0){%> style="display: none" <%}%>>
            <label id="data" style="font-size: 115%">Seleziona data:
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
    <label id="newHour"> Aggiungi un nuovo orario:
        <input type="time" step="1" required name="newHour" id="oraEvento">
    </label><br><br>
    <label id="biglietti">Seleziona quantità biglietti:
        <input type="number" min="1" required name="biglietti">
    </label>
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
