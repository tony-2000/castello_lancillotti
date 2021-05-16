<html>
<head>
    <jsp:include page="../Partials/head.jsp"/>
    <title>Title</title>
</head>
<body>
<jsp:include page="../Partials/Header.jsp"/><br><br>

<img src="${evento.linkImmagine}" name="imgEvento" style="width:45px;height:45px;">

${evento.nome} ${evento.descrizione} &nbsp; ${evento.prezzo} &nbsp; ${evento.postiDisponibili}


<form action="AggiungiAlCarrello">
    <input type="hidden" name="id_evento" value="${evento.idEvento}">
    <input type="hidden" name="prezzo" value="${evento.prezzo}">
    <input type="text" name="quantita_biglietti">
    <input type="date" name="data" >
    <input type="time" step="1" name="orario" >
    <input type="submit" value="Aggiungi">
</form>

</body>
</html>
