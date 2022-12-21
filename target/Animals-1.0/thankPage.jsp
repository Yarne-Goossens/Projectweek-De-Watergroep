<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<jsp:include page="head.jsp">
    <jsp:param name="title" value="Home"/>
</jsp:include>
<body class="bg-dark">
<div id="container">
    <main>
        <div class="row justify-content-center container-fluid">
            <div class="text-center col-8 card text-black mb-5 mt-5" style="border-radius: 25px; width: 80%;">
                <div class="card-body p-md-5">
                    <h2>Bedankt!</h2>
                    <p>
                        Bedankt voor het melden van een lek.
                        Onze techniekers komen zo snel mogelijk ter plaatse om het lek te onderzoeken.
                        Jouw bijdrage helpt om het waterverlies in Vlaanderen tegen te gaan.
                        Waarvoor onze dank.
                    </p>
                    <p class="font-weight-bold">Want elke druppel telt!</p>

                    <a class="btn btn-primary btn-xl text-uppercase" role="button" href="Controller?command=Home">Ga terug naar home</a>
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