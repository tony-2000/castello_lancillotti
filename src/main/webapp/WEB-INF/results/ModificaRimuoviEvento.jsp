<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="../Partials/head.jsp"/>
    <title>Modifica o rimuovi evento</title>
</head>
<body>
<jsp:include page="../Partials/Header.jsp"/><br><br>

<ul>
    <c:forEach items="${eventi}" var="evento" >
        <li>
            <img alt="img" src="${evento.linkImmagine}" style="width:45px;height:45px;">
            <form  method="get" action="ToModificaEvento">
                <input type="hidden" name="idEvento" value="${evento.idEvento}">
                <button type="submit">Modifica</button>
            </form>
            <form  method="get" action="EliminaEvento">
                <input type="hidden" name="idEvento" value="${evento.idEvento}">
                <button type="submit">Elimina</button>
            </form>${evento.nome}
        </li><br><br>
        <br><br>
    </c:forEach>
</ul>

</body>
</html>
