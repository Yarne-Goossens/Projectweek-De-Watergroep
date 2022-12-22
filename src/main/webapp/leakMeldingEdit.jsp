<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<jsp:include page="head.jsp">
    <jsp:param name="title" value="Lek melden"/>
</jsp:include>
<body class="bg-wglightblue">
<div id="container" class="cover-container d-flex h-100 p-3 mx-auto flex-column">
    <jsp:include page="header.jsp">
        <jsp:param name="actual" value="SignalLeak"/>
    </jsp:include>

    <main role="main" class="inner cover">
        <div class="row d-flex justify-content-center align-items-center h-100 container-fluid">
            <div class="card text-black mb-5 mt-5 w-70" style="border-radius: 25px; width: 80%;">
                <p class="text-center h1 fw-bold mb-5 mx-1 mx-md-4 mt-4 text-wggreen" >Pas lek met id : ${editedLeak.id}</p>
                <c:if test="${not empty errors}">
                    <div id="error" class="alert alert-danger">
                        <c:forEach items="${errors}" var="error">
                            <ul style="list-style: none;">
                                <li>${error}</li>
                            </ul>
                        </c:forEach>
                    </div>
                </c:if>
                <div class="mx-1 mx-md-4">
                    <form name="formulier" method="POST" action="Controller?command=LeakSubmissionFormProcessing">
                        <div class="d-flex flex-row align-items-center mb-4">
                            <div class="form-outline flex-fill mb-0">
                                <label class="form-label" for="naam">Voornaam:</label>
                                <input name="naam" type="text" id="naam" class="form-control"
                                       value="${editedLeak.firstName}"/>
                            </div>
                        </div>
                        <div class="d-flex flex-row align-items-center mb-4">
                            <div class="form-outline flex-fill mb-0">
                                <label class="form-label" for="voornaam">Achternaam:</label>
                                <input name="voornaam" type="text" id="voornaam" class="form-control"
                                       value="${editedLeak.lastName}"/>
                            </div>
                        </div>
                        <div class="d-flex flex-row align-items-center mb-4">
                            <div class="form-outline flex-fill mb-0">
                                <label class="form-label" for="email">Email: </label>
                                <input name="email" type="text" id="email" class="form-control"
                                       value="${editedLeak.email}"/>
                            </div>
                        </div>
                        <div class="d-flex flex-row align-items-center mb-4">
                            <div class="form-outline flex-fill mb-0">
                                <label class="form-label" for="Plaats">Plaats: </label>
                                <input name="Plaats" type="text" id="Plaats" class="form-control"
                                       value="${editedLeak.city}"/>
                            </div>
                        </div>
                        <div class="d-flex flex-row align-items-center mb-4">
                            <div class="form-outline flex-fill mb-0">
                                <label class="form-label" for="Postcode">Postcode: </label>
                                <input name="Postcode" type="text" id="Postcode" class="form-control"
                                       value="${editedLeak.postalCode}"/>
                            </div>
                        </div>
                        <div class="d-flex flex-row align-items-center mb-4">
                            <div class="form-outline flex-fill mb-0">
                                <label class="form-label" for="Straat">Straat: </label>
                                <input name="Straat" type="text" id="Straat" class="form-control"
                                       value="${editedLeak.street}"/>
                            </div>
                        </div>
                        <div class="d-flex flex-row align-items-center mb-4">
                            <div class="form-outline flex-fill mb-0">
                                <label class="form-label" for="HuisNummer">Huis nummer: </label>
                                <input name="HuisNummer" type="text" id="HuisNummer" class="form-control"
                                       value="${editedLeak.houseNumber}"/>
                            </div>
                        </div>
                        <div class="d-flex flex-row align-items-center mb-4">
                            <div class="form-outline flex-fill mb-0">
                                <label class="form-label" for="Commentaar">Commentaar:</label>
                                <textarea name="Commentaar" type="text" id="Commentaar" class="form-control">${editedLeak.comment}</textarea>
                            </div>
                        </div>
                        <div class="d-flex flex-row align-items-center mb-4">
                            <button type="submit" class="btn btn-wg btn-lg">Verander</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </main>
</div>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.7/dist/umd/popper.min.js"
        integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/js/bootstrap.min.js"
        integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
        crossorigin="anonymous"></script>
</body>
</html>