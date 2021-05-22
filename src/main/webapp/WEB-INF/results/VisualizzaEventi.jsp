<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="../Partials/head.jsp"/>
    <title>Title</title>
</head>
<body>
<jsp:include page="../Partials/Header.jsp"/><br><br>

<div class="conteinerVisite">
    <c:forEach items="${listaEventi}" var="evento" >
        <form action="MostraEvento">
            <button type="submit" class="buttonEvent" style="border: 0; background: transparent">
                <div class="galleriaVisite" >
                    <img src="${evento.linkImmagine}" alt="submit"/>
                    <input type="hidden" name="idEvento" value="${evento.idEvento}">
                    <div class="descVisite">  ${evento.nome} </div>
                </div>
            </button>
        </form>
    </c:forEach>
</div>




</body>
</html>
