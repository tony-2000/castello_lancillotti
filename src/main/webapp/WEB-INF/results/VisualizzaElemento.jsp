<%@ page import="java.sql.Date" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="model.Data" %>
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

<%!ArrayList<Data> temp=new ArrayList<Data>();%> <%temp= (ArrayList<Data>) request.getAttribute("date");%>
           <div <%if (temp.size()==0){%> style="display: none" <%}%>>
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


</form>
    </div>

</div>

<p style="<%if (temp.size()!=0){%> display: none;<%}%> margin-right: 5%; text-align: center"> Non sono disponibili date per questo evento.</p>





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

<script>
    {
        function loadTimes(x, y) {
            var xmlhttp = new XMLHttpRequest();
            xmlhttp.onreadystatechange = function () {
                if (this.readyState == 4 && this.status == 200) {
                    myFunctionDate(this);
                }
            };
            xmlhttp.open("GET", "JSONTimes?data=" + x + "&id=" + y, true);
            xmlhttp.send();
        }

        function myFunctionDate(xmlhttp) {
            var data = JSON.parse(xmlhttp.responseText);
            JSON.parse(xmlhttp.responseText);
            let text = "<label id=\"orario\">Seleziona orario:</label> <select required id=\"selOr\" name=\"orario\" onchange=\"loadTickets(this.value)\"> <option value=\"seleziona\" selected disabled>Seleziona Ora</option>"

            for (let x in data)
            {
                text += "<option class=\"op\" value='" + data[x].ora + "'> " + data[x].ora + "</option> ";
            }
            text+=" </select>"
            document.getElementById("testo").innerHTML = text;
        }






        function loadTickets(ora)
        {
            var giorno=document.getElementById("date").value;
            var id=${evento.idEvento};
            var xmlhttp = new XMLHttpRequest();
            xmlhttp.onreadystatechange = function () {
                if (this.readyState == 4 && this.status == 200)
                {
                    myFunctionTicket(this);
                }
            };


            xmlhttp.open("GET", "JSONTickets?data=" + giorno + "&id="+id+"&ora="+ora, true);
            xmlhttp.send();
        }


        function myFunctionTicket(xmlhttp)
        {
            var tic = JSON.parse(xmlhttp.responseText);
            JSON.parse(xmlhttp.responseText);
            let text = "<input required type='number' id='selQuantity' name='quantity' min='1' max='"+tic.ticket+"'>";
            text+=" </input> <label id='quantity'>Biglietti disponibili: "+tic.ticket+"</label> <button type=\"submit\" id=\"selBut\">Aggiungi al Carrello </button>"
            document.getElementById("Spanticket").innerHTML = text;
        }
    }
</script>




</body>
</html>



