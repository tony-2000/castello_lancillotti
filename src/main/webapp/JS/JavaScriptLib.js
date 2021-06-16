
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



    function loadHours(x, y)
    {
        $("#aggiungiOra").show();
        $("#dataEv").val(x);
        $("#dataEliminazione").val(x);
        $.getJSON("JSONTimes?data=" + x + "&id=" + y, function myFunctionHours(data)
        {
            let text = "<fieldset><label id=\"orario\">Seleziona orario da eliminare:</label> <select required id=\"selOr\" " +
                "onchange=\"showButton2()\" name=\"orario\"><option value=\"sel\" selected disabled>Seleziona Orario</option>"

            for (let x in data) {
                text += "<option class=\"op\" value='" + data[x].ora + "'> " + data[x].ora + "</option> ";
            }
            text += " </select> <button id='button2' type='submit' style='display: none'>Elimina Orario</button></fieldset>"
            $("#eliminaOra").html(text);
        })
    }



    /*
    function loadHours(x, y) {
        document.getElementById("aggiungiOra").style.display="";
        document.getElementById("dataEv").value=x;
        document.getElementById("dataEliminazione").value=x;
        var xmlhttp = new XMLHttpRequest();
        xmlhttp.onreadystatechange = function () {
            if (this.readyState == 4 && this.status == 200) {
                myFunctionHours(this);
            }
        };
        xmlhttp.open("GET", "JSONTimes?data=" + x + "&id=" + y, true);
        xmlhttp.send();
    }

    function myFunctionHours(xmlhttp) {
        var data = JSON.parse(xmlhttp.responseText);
        JSON.parse(xmlhttp.responseText);
        let text = "<fieldset><label id=\"orario\">Seleziona orario da eliminare:</label> <select required id=\"selOr\" onchange=\"showButton2()\" name=\"orario\"><option value=\"sel\" selected disabled>Seleziona Orario</option>"

        for (let x in data)
        {
            text += "<option class=\"op\" value='" + data[x].ora + "'> " + data[x].ora + "</option> ";
        }
        text+=" </select> <button id='button2' type='submit' style='display: none'>Elimina Orario</button></fieldset>"
        document.getElementById("eliminaOra").innerHTML = text;
    }
    */



        function showButton1()
        {
          $("#button1").show();
        }

        function showButton2()
        {
           $("#button2").show();
        }

        function control(control) {
            switch (control) {
                case 1:
                    alert("Data aggiunta nel Database.");
                    break;
                case -1:
                    alert("Data già presente nel Database.\nNessuna modifica apportata.");
                    break;
                case 2:
                    alert("Data eliminata dal Database.");
                    break;
                case 3:
                    alert("Orario aggiunto nel Database.");
                    break;
                case -3:
                    alert("Orario già presente nel Database.\nNessuna modifica apportata.");
                    break;
                case 4:
                    alert("Orario eliminato dal Database.");
                    break;
            }
        }

        function errLogin(checkLogin)
        {
            if(checkLogin===true)
                alert("Nome utente o password errati.");
        }

        function checkRegistration()
        {
            var telefono = $("#telefonoID").val();
            var password = $("#passwordID").val();
            var passwordCheck = $("#passwordCheckID").val();
            var patTel = /[^0-9]/g;

            var telefonoRegex=telefono.match(patTel)
            if(telefonoRegex!=null)
            {
                alert("number error")
                return false;
            }

            return false;
        }

}
