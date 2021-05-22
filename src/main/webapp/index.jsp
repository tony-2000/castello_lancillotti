<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Home Page</title>
    <jsp:include page="WEB-INF/Partials/head.jsp">
        <jsp:param name="title" value="Castello Lancellotti home"/>
    </jsp:include>
</head>
<body>
<jsp:include page="WEB-INF/Partials/Header.jsp"/>
<div class="homeSlideshow">
    <img class="homeSlides" src="Images/SlideShow5.jpg" alt="homeSlide1">
    <img class="homeSlides" src="Images/SlideShow6.jpg" alt="homeSlide2">
    <img class="homeSlides" src="Images/SlideShow4.jpg" alt="homeSlide3">
    <img class="homeSlides" src="Images/SlideShow3.jpg" alt="homeSlide4">
    <img class="homeSlides" src="Images/SlideShow1.jpg" alt="homeSlide5">
    <img class="homeSlides" src="Images/SlideShow2.jpg" alt="homeSlide6">
</div>

<script>
    var myIndex = 0;
    carousel();

    function carousel() {
        var i;
        var x = document.getElementsByClassName("homeSlides");
        for (i = 0; i < x.length; i++) {
            x[i].style.display = "none";
        }
        myIndex++;
        if (myIndex > x.length) {myIndex = 1}
        x[myIndex-1].style.display = "block";
        setTimeout(carousel, 5000);
    }
</script>

<div class="container">
<div class="gallery" >
    <a href="SulCastello.jsp">
        <img src="Images/SulCastello.jpg" alt="SulCastello">
    </a>
    <div class="desc">Sul castello</div>
</div>

<div class="gallery">
    <a href="ShowAllVisits">
        <img src="Images/visita.jpg" alt="Visite">
    </a>
    <div class="desc">visite </div>
</div>

<div class="gallery">
    <a href="VisualizzaCategorie">
        <img src="Images/eventi.jpg" alt="Eventi">
    </a>
    <div class="desc">eventi</div>
</div>
</div>
</body>
</html>


