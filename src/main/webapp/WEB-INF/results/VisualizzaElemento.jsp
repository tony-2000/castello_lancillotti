<html>
<head>
    <jsp:include page="../Partials/head.jsp"/>
    <title>Title</title>
</head>
<body>
<jsp:include page="../Partials/Header.jsp"/><br><br>

<img src="${evento.linkImmagine}" name="imgEvento" style="width:45px;height:45px;">

${evento.nome} ${evento.descrizione} &nbsp; ${evento.prezzo} &nbsp; ${evento.postiDisponibili}
</body>
</html>
