<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="it">
<head>
    <jsp:include page="../Partials/head.jsp"/>
    <title>Riepilogo Acquisti</title>
</head>
<body>
<jsp:include page="../Partials/Header.jsp"/><br><br>

<ul>
    <c:forEach items="${lista}" var="lista">
        ${lista.nome} ${lista.quantitaBiglietti}  ${lista.dataPartecipazione}
        ${lista.orarioPartecipazione} ${lista.prezzo}
        <br>
    </c:forEach>
</ul>

</body>
</html>
