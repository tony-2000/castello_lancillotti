<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="../Partials/head.jsp"/>
    <title>Modifica Utenti </title>
</head>
<body>
<jsp:include page="../Partials/Header.jsp"/><br><br>


<ul>
    <c:forEach items="${utenti}" var="utenti" >
        <li>
                ${utenti.nome} ${utenti.cognome} &nbsp; ${utenti.mail} &nbsp; ${utenti.nomeUtente} Amministratore:${utenti.amministratore}
            <form  method="get" action="CambiaStatoAdmin">
                <input type="hidden" name="idUtente" value="${utenti.idUtente}">
                <button type="submit">Cambia Stato Admin</button>
            </form>
                    <form  method="get" action="EliminaUtente">
                        <input type="hidden" name="idUtente" value="${utenti.idUtente}">
                        <button type="submit">Elimina Utente</button>
                    </form>
        </li><br><br>
        <br><br>
    </c:forEach>
</ul>

</body>
</html>
