<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<jsp:include page="head.jsp">
    <jsp:param name="title" value="Lek melden"/>
</jsp:include>

<body>
<div id="container">

    <jsp:include page="header.jsp">
        <jsp:param name="actual" value="SignalLeak"/>
    </jsp:include>

    <div>
        <c:if test="${not empty errors}">
        <div id="error" class="alert alert-danger">
            <ul>
                <c:forEach items="${errors}" var="error">
                    <li>${error}</li>
                </c:forEach>
            </ul>
            </c:if>
        </div>

        <p class="text-center h1 fw-bold mb-5 mx-1 mx-md-4 mt-4">Lek melden</p>
        <form name="formulier" method="POST" action="Controller?command=LeakSubmissionFormProcessing">
            <div class="mx-1 mx-md-4">

                <div class="d-flex flex-row align-items-center mb-4">
                    <div class="form-outline flex-fill mb-0">
                        <label class="form-label" for="naam">Voornaam:</label>
                        <input name="naam" type="text" id="naam" class="form-control" placeholder="Joske" value="${firstNamePreviousValue}"/>
                    </div>
                </div>

                <div class="d-flex flex-row align-items-center mb-4">
                    <div class="form-outline flex-fill mb-0">
                        <label class="form-label" for="voornaam">Achternaam:</label>
                        <input  name="voornaam" type="text" id="voornaam" class="form-control"
                               placeholder="Vermeiren" value="${lastNamePreviousValue}"/>
                    </div>
                </div>

                <div class="d-flex flex-row align-items-center mb-4">
                    <div class="form-outline flex-fill mb-0">
                        <label class="form-label" for="email">Email: </label>
                        <input name="email" type="text" id="email" class="form-control"
                               placeholder="joske.vermeiren@skynet.be" value="${emailPreviousValue}"/>
                    </div>
                </div>


                <div class="d-flex flex-row align-items-center mb-4">
                    <div class="form-outline flex-fill mb-0">
                        <label class="form-label" for="Plaats">Plaats: </label>
                        <input name="Plaats" type="text" id="Plaats" class="form-control"
                               placeholder="Tielt-Winge" value="${cityPreviousValue}"/>
                    </div>
                </div>

                <div class="d-flex flex-row align-items-center mb-4">
                    <div class="form-outline flex-fill mb-0">
                        <label class="form-label" for="Postcode">Postcode: </label>
                        <input name="Postcode" type="text" id="Postcode" class="form-control"
                               placeholder="3390" value="${postalPreviousValue}"/>
                    </div>
                </div>

                <div class="d-flex flex-row align-items-center mb-4">
                    <div class="form-outline flex-fill mb-0">
                        <label class="form-label" for="Straat">Straat: </label>
                        <input name="Straat" type="text" id="Straat" class="form-control"
                               placeholder="Dorpstraat" value="${streetPreviousValue}"/>
                    </div>
                </div>

                <div class="d-flex flex-row align-items-center mb-4">
                    <div class="form-outline flex-fill mb-0">
                        <label class="form-label" for="HuisNummer">Huis nummer: </label>
                        <input name="HuisNummer" type="text" id="HuisNummer" class="form-control"
                               placeholder="124" value="${houseNumberPreviousValue}"/>
                    </div>
                </div>

                <div class="d-flex flex-row align-items-center mb-4">
                    <div class="form-outline flex-fill mb-0">
                        <label class="form-label" for="Commentaar">Commentaar:</label>
                        <textarea name="Commentaar" type="text" id="Commentaar" class="form-control"
                                  placeholder="" value="${commentaryPreviousValue}"></textarea>
                    </div>
                </div>

                <div class="d-flex flex-row align-items-center mb-4">
                    <div class="form-outline flex-fill mb-0">
                        <label class="form-label" for="img">Foto:</label>
                        <input type="file" id="img" name="img" accept="image/*">
                    </div>
                </div>

                <div class="form-outline flex-fill mb-0">
                    <button type="submit" class="btn btn-primary btn-lg">Stuur in</button>
                </div>


            </div>
        </form>
</body>
</html>
