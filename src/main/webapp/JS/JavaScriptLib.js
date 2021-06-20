
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
        let text = "<br class='space600'><br class='space600'>  <label id=\"orario\">Seleziona orario:</label> <select required id=\"selOr\" name=\"orario\" onchange=\"loadTickets(this.value)\"> <option value=\"temp\" selected disabled>Seleziona Ora</option>"

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
        let text = "<br class='space850'> <br class='space850'> <input required type='number' id='selQuantity' name='quantity' min='1' max='"+tic.ticket+"'>";
        text+=" </input> <label id='quantity'>Biglietti disponibili: "+tic.ticket+"</label><br class='space1050'><br class='space1050'> <button type=\"submit\" id=\"selBut\">Aggiungi al Carrello </button>"
        document.getElementById("Spanticket").innerHTML = text;
    }



    function loadHours(x, y)
    {
        $("#aggiungiOra").show();
        $("#dataEv").val(x);
        $("#dataEliminazione").val(x);
        $.getJSON("JSONTimes?data=" + x + "&id=" + y, function myFunctionHours(data)
        {
            let text = "<fieldset><label id=\"orario\">Seleziona orario da eliminare:</label> <br class='space768'><br class='space768'><select required id=\"selOr\" " +
                "onchange=\"showButton2()\" name=\"orario\"><option value=\"sel\" selected disabled>Seleziona Orario</option>"

            for (let x in data) {
                text += "<option class=\"op\" value='" + data[x].ora + "'> " + data[x].ora + "</option> ";
            }
            text += " </select><br class='space480'><br class='space480'> <button id='button2' type='submit' style='display: none'>Elimina Orario</button></fieldset>"
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

        function showButton1(){
          $("#button1").show();
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

        function errPass(checkPass)
        {
            if(checkPass===true)
                alert("Password errata.");
        }

    function checkPassword()
    {
        var password=document.getElementById("passwordID").value;
        var passwordCheck=document.getElementById("passwordCheckID").value;

        if(password!==passwordCheck)
        {
            alert("Le password non combaciano")
            return false
        }

    }

    function showButton2()
    {
        $("#button2").show();
    }

    function datiPresenti(dati)
    {
        if(dati===-1)
            alert("Nome Utente già registrato in Database")
        if(dati===-2)
            alert("Mail già registrata in Database")
    }

    function showNavbar()
    {
        $("#navbar").show(300);
    }

    function closeNavbar()
    {
        var temp=$("#navbar").css("z-index")
        if(temp==100)
            $("#navbar").hide(300);
    }

    function resetNavbar() {
        var width = window.innerWidth;
        if (width > 1100)
            $("#navbar").show();
    }


}
