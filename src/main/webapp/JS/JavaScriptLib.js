{
    function loadTimes(x, y) {
        document.getElementById("Spanticket").style.display="none";
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
        let text = "<label id=\"orario\">Seleziona orario:</label> <select required id=\"selOr\" name=\"orario\" onchange=\"loadTickets(this.value)\"> <option value=\"temp\" selected disabled>Seleziona Ora</option>"

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
        var id=document.getElementById("idEventoInput").value;
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
        document.getElementById("Spanticket").style.display="";
        let text = "<input required type='number' id='selQuantity' name='quantity' min='1' max='"+tic.ticket+"'>";
        text+=" </input> <label id='quantity'>Biglietti disponibili: "+tic.ticket+"</label> <button type=\"submit\" id=\"selBut\">Aggiungi al Carrello </button>"
        document.getElementById("Spanticket").innerHTML = text;
    }

}