<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<jsp:include page="head.jsp">
    <jsp:param name="title" value="Home"/>
</jsp:include>
<body class="bg-dark">
<div id="container">
    <jsp:include page="header.jsp">
        <jsp:param name="actual" value="Home"/>
    </jsp:include>
    <main role="main" class="inner cover">

        <div class="row justify-content-center container-fluid">
            <div class="text-center col-8 card text-black mb-5 mt-5" style="border-radius: 25px; width: 80%;">
                <div class="card-body p-md-5">
                    <h2>Beste bezoeker</h2>
                    <p>
                        Wij zijn “De Watergroep”. Sinds 1913 staan wij in voor de watervoorziening in jouw buurt.
                        De infrastructuur bestaat uit een leidingennetwerk van meer dan 34.000 kilometer.
                    </p>
                    <p>
                        Natuurlijk brengt deze omvang veel onderhoud met zich mee en kunnen er door factoren van buitenaf lekken ontstaan.
                        Daarom zijn we begonnen met een initiatief om sneller te reageren op lekken.
                    </p>
                    <p>
                        Iedereen kan nu op een heel efficiënte manier een lek melden op onze site, zodat deze zo snel mogelijk hersteld kan worden.
                    </p>
                    <p>Help jij ons in de strijd tegen waterschaarste?</p>
                    <p class="font-weight-bold">Want elke druppel telt!</p>
                    <p>Je kan een lek melden via onderstaande knop</p>

                    <a class="btn btn-primary btn-xl text-uppercase" role="button" href="Controller?command=LeakSubmissionForm">Meld een water lek!</a>
                </div>
            </div>
        </div>
    </main>
    <jsp:include page="footer.jsp"/>
</div>
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
        integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"
        integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.min.js"
        integrity="sha384-w1Q4orYjBQndcko6MimVbzY0tgp4pWB4lZ7lr30WKz0vr/aWKhXdBNmNb5D92v7s"
        crossorigin="anonymous"></script>
</body>
</html>