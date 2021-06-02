<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="it">
<head>
    <title>Home Page</title>
    <jsp:include page="WEB-INF/Partials/head.jsp">
        <jsp:param name="title" value="Castello Lancellotti home"/>
    </jsp:include>
</head>
<body>
<jsp:include page="WEB-INF/Partials/Header.jsp"/>
<div class="homeSlideshow">
    <div style="position: absolute; z-index: 1;  background-color: transparent; color: #d9c6b0; width: 100%; margin-top:0; padding-top:0;">
        <h1 style="font-family:'Century Schoolbook',serif; text-shadow: 5px 10px 10px rgba(0, 0, 0, 0.75), -3px 10px 12px rgba(0, 0, 0, 0.75);
        font-size:5em; text-align: center; color:#DCDCDC">Castello Lancellotti</h1></div>

    <img class="homeSlides" src="Images/SlideShow5.jpg" alt="home Slide 1">
    <img class="homeSlides" src="Images/SlideShow6.jpg" alt="home Slide 2">
    <img class="homeSlides" src="Images/SlideShow4.jpg" alt="home Slide 3">
    <img class="homeSlides" src="Images/SlideShow3.jpg" alt="home Slide 4">
    <img class="homeSlides" src="Images/SlideShow1.jpg" alt="home Slide 5">
    <img class="homeSlides" src="Images/SlideShow2.jpg" alt="home Slide 6">
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
        setTimeout(carousel, 10000);
    }
</script>

<div class="container">
<div class="gallery" >
    <a href="SulCastello.jsp" style="text-decoration: none">
        <img src="Images/SulCastello.jpg" alt="Immagine Sul Castello">
        <div class="desc">Sul castello</div>
    </a>
</div>

<div class="gallery" >
    <a href="ShowAllVisits" style="text-decoration: none">
        <img src="Images/visita.jpg" alt="Immagine Visite">
        <div class="desc">Visite </div>
    </a>
</div>

<div class="gallery">
    <a href="VisualizzaCategorie" style="text-decoration: none">
        <img src="Images/eventi.jpg" alt="Immagine Eventi">
        <div class="desc">Eventi</div>
    </a>
</div>
</div>
</body>
</html>


