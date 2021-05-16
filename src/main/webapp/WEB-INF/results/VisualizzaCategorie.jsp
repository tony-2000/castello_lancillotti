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
    <c:forEach items="${listaCategorie}" var="lista" >
        <li>
            <form  method="get" action="ShowAllEvents">
                <input type="image" name="img" src="${lista.linkImmagine}" style="width:45px;height:45px;">
                <input type="hidden" name="idCategoria" value="${lista.idCategoria}">
            </form> ${lista.nome}
        </li><br><br>
        <br><br>
    </c:forEach>
</ul>

</body>
</html>
