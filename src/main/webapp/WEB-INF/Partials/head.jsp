<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<meta charset="UTF-8">
<%@page session="true"%>
<meta name ="viewport" content="width=device-width,initial-scale=1,viewport-fit=cover">
<title>${param.title}</title>
<meta name ="description" content="Ecommerce Castello Lancellotti">
<link rel="icon" type="image/png" href="../../Images/logoBase.png">
<meta name="apple-mobile-web-app-capable" content="yes">
<meta name="format-detection" content="telephone-no">
<meta name="apple-mobile-web-app-title" content="Castello Lancellotti">
<meta name="apple-mobile-web-app-status-bar-style" content="default">
<link rel="apple-touch-icon" href="../../Images/logoBase.png">
<link rel="apple-touch-startup-image" href="../../Images/logoBase.png">
<meta name="theme-color" content="#000000">
<link href="${pageContext.request.contextPath}/CSS/reset.css" rel="stylesheet" type="text/css">
<link href="${pageContext.request.contextPath}/CSS/library.css" rel="stylesheet" type="text/css">
<c:if test="${not empty param.style}">
    <link rel="stylesheet" href="CSS/${param.style}" type="text/css">
</c:if>
<script src="../../JS/library.js" defer></script>
<c:if test="${not empty param.script}">
    <script src="JS/${param.script}" defer></script>
</c:if>