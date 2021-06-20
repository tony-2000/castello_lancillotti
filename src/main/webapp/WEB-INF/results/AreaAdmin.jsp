<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="it">
<head>
    <jsp:include page="../Partials/head.jsp"/>
    <title>Area Admin</title>
</head>
<body>
<jsp:include page="../Partials/Header.jsp"/>
<br><br><h1 class="titleAdmin">Area Admin</h1>

    <div class="adminHome">

                <div class="adminElementCat">
                   <br><h3>Categorie:</h3>
                    <form action="AggiungiCategoria">
                        <button type="submit" class="buttonAdmin" > Aggiungi</button>
                    </form>
                    <form action="ModificaRimuoviCategoria">
                        <button type="submit" > Modifica</button>
                    </form>
                </div>

                <div class="adminElementCat">
                    <br><h3>Eventi:</h3>
                    <form action="AggiungiEvento">
                        <button type="submit" class="buttonAdmin" > Aggiungi</button>
                    </form>
                    <form action="ModificaRimuoviEvento">
                        <button type="submit" > Modifica</button>
                    </form>
                </div>

                <div class="adminElementCat">
                    <br><h3>Utenti:</h3>
                    <form action="ModificaUtenti">
                        <button type="submit" > Modifica</button>
                    </form>
                </div>
    </div>

</body>
</html>

