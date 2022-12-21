<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<header>
    <nav class="navbar navbar-light navbar-expand-Ig bg-white clean-navbar ">
        <div class="container">
            <a href="Controller?command=Home"><img class="mt-2 mb-2" src="/img/watergroep_logo_small.png"
                                                   alt="De WaterGroep" width="120" height="100"></a>

                <div class="float-right">
                    <button class="navbar-toggler" type="button" data-toggle="collapse"
                            data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent"
                            aria-expanded="false" aria-label="Toggle navigation">
                        <span class="navbar-toggler-icon"></span>
                    </button>
                </div>
                <div class="container-fluid">

                    <div id="navbarSupportedContent" class="collapse navbar-collapse">

                        <ul class="navbar-nav">
                            <li class="nav-item" ${param.actual eq 'Home'?"id = actual":""}>
                                <a class="nav-link pt-5" style="font-size: 20px" id="goHome"
                                   href="Controller?command=Home">Home</a></li>
                            <li class="nav-item" ${param.actual eq 'Login' ? "id = actual":""}>
                                <a class="nav-link pt-5" style="font-size: 20px" href="Controller?command=LogInPage">Login</a>
                            </li>
                            <li class="nav-item"  ${param.actual eq 'voegToe'?"id = actual":""}>
                                <a class="nav-link pt-5" style="font-size: 20px"
                                   href="Controller?command=LeakSubmissionForm">Lek Melden</a></li>
                            <li class="nav-item" ${param.actual eq 'Overzicht'?"id = actual":""}>
                                <a class="nav-link pt-5" style="font-size: 20px"
                                   href="Controller?command=OverviewLeaks">Overzicht Lekken</a></li>
                            <li class="nav-item" ${param.actual eq 'Overzicht'?"id = actual":""}>
                                <a class="nav-link pt-5" style="font-size: 20px"
                                   href="Controller?command=OverviewServiceAssignments">Overzicht Service Opdrachten</a>
                            </li>
                            <%--                            <li class="nav-item" ${param.actual eq 'Verstuur Email' ? "id = actual":""}>--%>
                            <%--                                <a class="nav-link pt-5" style="font-size: 20px" href="Controller?command=SendEmailform">Verstuur Email</a></li>--%>
                            <%--                            <li class="nav-item" ${param.actual eq 'ShowPDF' ? "id = actual":""}>--%>
                            <%--                               a class="nav-link pt-5" style="font-size: 20px" href="Controller?command=CreatePDF">PDF maken</a></li>--%>
                        </ul>
                    </div>
                </div>
        </div>
    </nav>
</header>