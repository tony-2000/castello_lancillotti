<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="../Partials/head.jsp"/>
    <title>Title</title>
</head>
<body>
<jsp:include page="../Partials/Header.jsp"/><br><br>

<ul>
    <c:forEach items="${listaEventi}" var="evento" >
        <li>
            <form  method="get" action="MostraEvento">
                <input type="image" name="img" src="${evento.linkImmagine}" style="width:45px;height:45px;">
                <input type="hidden" name="idEvento" value="${evento.idEvento}">
            </form>$ ${evento.nome} ${evento.descrizione} &nbsp; ${evento.prezzo} &nbsp; ${evento.postiDisponibili}
        </li><br><br>
        <br><br>
    </c:forEach>
</ul>

</body>
</html>
