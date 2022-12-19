<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<header>
    <h1>Mijn huisdieren</h1>
<<<<<<< HEAD
    <nav>
        <ul>
            <li ${param.actual eq 'Home'?"id = actual":""}>
                <a id="goHome"
                   href="Controller?command=Home">Home</a></li>
            <li ${param.actual eq 'voegToe'?"id = actual":""}>
                <a href="Controller?command=AddForm">Voeg Toe</a></li>
            <li ${param.actual eq 'Overzicht'?"id = actual":""}>
                <a href="Controller?command=Overview">Overzicht</a></li>
            <li ${param.actual eq 'sendEmail'?"id = actual":""}>
                <a href="Controller?command=SendEmailForm">Stuur mail</a></li>

        </ul>
=======
    <nav class="navbar navbar-expand-sm navbar-dark">
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#collapsibleNavbar">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse row" id="collapsibleNavbar">
            <ul class="navbar-nav container-fluid">
                <li class="nav-item" ${param.actual eq 'Home'?"id = actual":""}>
                    <a class="nav-link" id="goHome" href="Controller?command=Home">Home</a></li>
                <li class="nav-item" ${param.actual eq 'voegToe'?"id = actual":""}>
                    <a class="nav-link" href="Controller?command=AddForm">Voeg Toe</a></li>
                <li class="nav-item" ${param.actual eq 'Overzicht'?"id = actual":""}>
                    <a class="nav-link" href="Controller?command=Overview">Overzicht</a></li>
                <li class="nav-item" ${param.actual eq 'Verstuur Email' ? "id = actual":""}>
                    <a class="nav-link" href="Controller?command=SendEmailform">Verstuur Email</a></li>
                <li class="nav-item" ${param.actual eq 'ShowPDF' ? "id = actual":""}>
                    <a class="nav-link" href="Controller?command=CreatePDF"></a></li>
            </ul>
        </div>
>>>>>>> c68e839da430899194110bb59a962062be9fee4e
    </nav>
</header>