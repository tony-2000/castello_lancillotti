<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="it">
<head>
    <jsp:include page="../Partials/head.jsp"/>
    <title>Area Admin</title>
</head>
<body>
<jsp:include page="../Partials/Header.jsp"/><br><br>
<h1 style="text-align: center; font-size: 250% "> Area Admin</h1>

    <div class="modAddCat">
        <div class="adminElementCat">
<h3>Area Categoria:</h3>
<form action="AggiungiCategoria">
    <button type="submit"style="margin-bottom: 3%;" > Aggiungi</button>
</form>
<form action="ModificaRimuoviCategoria">
    <button type="submit" > Modifica</button>
</form>
    </div>

        <div class="adminElementCat">
            <h3>Area Eventi:</h3>
            <form action="AggiungiEvento">
                <button type="submit" style="margin-bottom: 3%;" > Aggiungi</button>
            </form>
            <form action="ModificaRimuoviEvento">
                <button type="submit" > Modifica o Rimuovi</button>
            </form>
        </div>

        <div class="adminElementCat">
<h3>Area Utenti:</h3>
<form action="ModificaUtenti">
    <button type="submit" > Modifica</button>
</form>
    </div>
</div>

</body>
</html>

