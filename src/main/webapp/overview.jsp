<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<jsp:include page="head.jsp">
    <jsp:param name="title" value="Bekijk alle dieren"/>
</jsp:include>
<body>
<div id="container">
    <jsp:include page="header.jsp">
        <jsp:param name="actual" value="Overzicht"/>
    </jsp:include>
    <main>
        <c:choose>
            <c:when test="${not empty animals}">
                <h2>Bekijk alle dieren</h2>

                <table class="table table-hover">
                    <thead>
                    <tr>
                        <th scope="col">#</th>
                        <th scope="col">Naam</th>
                        <th scope="col">Soort</th>
                        <th scope="col">Voedsel</th>
                    </thead>
                    <tbody>
                        <c:if test="$not empty animals"></c:if>
                    <c:forEach var="animal" items="${animals}">
                        <tr>
                            <th scope="row">${animal.id}</th>
                            <td>${animal.name}
                            </td>
                            <td>${animal.type}
                            </td>
                            <td>${animal.food}
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </c:when>
            <c:otherwise>
                <p>Er zijn geen dieren </p>
            </c:otherwise>
        </c:choose>
        <p>Het laatste dier dat je hebt toegevoegd heet ${last.name} </p>
        <p>Het laatste dier dat je hebt toegevoegd heet ${sessionScope.lastAddedAnimal.name} </p>

    </main>
    <jsp:include page="footer.jsp"/>
</div>
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.min.js" integrity="sha384-w1Q4orYjBQndcko6MimVbzY0tgp4pWB4lZ7lr30WKz0vr/aWKhXdBNmNb5D92v7s" crossorigin="anonymous"></script>
</body>
</html>