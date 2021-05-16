<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        ul {
            list-style-type: none;
            margin: 0;
            padding: 0;
            overflow: hidden;
            background-color: #D9C6B0;
        }

        li {
            float: left;
        }

        li a {
            display: block;
            color: white;
            text-align: center;
            padding: 14px 16px;
            text-decoration: none;
        }

        li a:hover:not(.active) {
            background-color: #111;
        }

        .active {
            background-color: #4CAF50;
        }
    </style>
</head>
<body>


<ul>
    <li><img src="./Images/logoBase.png" alt="logo" style="width:45px;height:45px;"></li>
    <li><a class="active" href="./index.jsp">Home</a></li>
    <li><a href="ToSulCastello">Sul Castello</a></li>
    <li><a href="ShowAllVisits">Visite</a></li>
    <li><a href="ShowAllEvents">Eventi</a></li>
    <li><a href="ToLogin">Accedi</a></li>
    <li><a href="Carrello">Carrello</a></li>
    <li><a href="RiepilogoAcquisti">Riepilogo Acquisti</a></li>
    <li> <%if (session.getAttribute("utenteSessione")!=null){%>
        Ciao ${utenteSessione.nomeUtente} <%;}%></li>
</ul>

</body>
</html>
