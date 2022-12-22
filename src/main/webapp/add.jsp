<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<jsp:include page="head.jsp">
    <jsp:param name="title" value="Voeg een huisdier toe"/>
</jsp:include>
<body class="bg-wglightblue">
<div id="container">
    <jsp:include page="header.jsp">
        <jsp:param name="actual" value="voegToe"/>
    </jsp:include>

    <main>
        <c:if test="${not empty errors}">
            <div class="alert alert-danger">
                <ul>
                    <c:forEach items="${errors}" var="error">
                        <li>${error}</li>
                    </c:forEach>
                </ul>
            </div>
        </c:if>
        <h2>Voeg je huisdier toe</h2>

        <form method="POST" action="Controller?command=Add" novalidate>

            <p class="form-group ${nameClass}">
                <label class="control-label" for="name">Naam:</label>
                <input id="name" name="name" type="text"
                       value="${namePreviousValue}" >
            </p>

            <p class="form-group ${typeClass}">
                <label class="control-label" for="type">Soort:</label>
                <input id="type" name="type" type="text"
                       value="${typePreviousValue}">
            </p>

            <p class="form-group ${foodClass}">
                <label for="food">Aantal keer eten per dag:</label>
                <input
                    id="food" name="food" type="number" class="error"
                    max="10" min="1" value="${foodPreviousValue}">
            </p>
            <p>
                <input id="submit" type="submit" value="Verstuur">
            </p>
        </form>
    </main>
    <jsp:include page="footer.jsp"/>
</div>
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.min.js" integrity="sha384-w1Q4orYjBQndcko6MimVbzY0tgp4pWB4lZ7lr30WKz0vr/aWKhXdBNmNb5D92v7s" crossorigin="anonymous"></script>
</body>
</html>