<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<jsp:include page="head.jsp">
    <jsp:param name="title" value="Lek melden"/>
</jsp:include>
<body>

<jsp:include page="header.jsp">
    <jsp:param name="actual" value="SignalLeak"/>
</jsp:include>


<main class="container">
    <h3>Pass leak met id  ${editedLeak.id}</h3>

    <p>
        <c:if test="${not empty errors}">
            <div class="alert alert-danger">
                <ul>
                    <c:forEach items="${errors}" var="error">
                        <li>${error}</li>
                    </c:forEach>
                </ul>
            </div>
        </c:if>

        <p class="text-center h1 fw-bold mb-5 mx-1 mx-md-4 mt-4">Pas leak met id : ${editedLeak.id}</p>
        <form name="formulier" method="POST" action="Controller">
            <p>
                <label for="firstname">Voornaam</label>
            </p>
            <p>
                <input id="firstname" value="${editedLeak.firstName}" disabled type="text">
            </p>
            <p>
                <label for="lastname">Achternaam</label>
            </p>
            <p >
                <input id="lastname" value="${editedLeak.lastName}" disabled type="text">
            </p>

            <p >
                <label for="email">Email</label>
            </p>
            <p>
                <input id="email"  value="${editedLeak.email}" disabled type="text">
            </p>

            <p>
                <label for="city">Stad</label>

            </p>
           <p>
                <input id="city" name="city" value="${editedLeak.city}" type="text">
            </p>

            <p>
                <label for="postalCode">Post code</label>
            </p>
            <p>
                <input id="postalCode" name="postalCode" value="${editedLeak.postalCode}" type="text">
            </p>

            <p>
                <label for="street">Straat</label>
                </p>
            <p>
                <input id="street" name="street" value="${editedLeak.street}" type="text">
            </p>

            <p>
                <label for="houseNumber">Huis nummer</label>
            </p>
            <p>

            <input id="houseNumber" name="houseNumber" value="${editedLeak.houseNumber}" type="text">
            </p>

            <input  name="id" value="${editedLeak.id}" type="hidden">

            <p>
                <label for="comment">Comment</label>
            <p>
            </p>
                <textarea id="comment" name="comment"> ${editedLeak.comment}</textarea>
            </p>
            <input type="hidden" name="command" value="LeakMeldingInfoEditConfirmation">
            <p>
                <button type="submit" class="btn btn-primary btn-lg">Stuur in</button>
            </p>
    </form>
</main>
</body>
</html>