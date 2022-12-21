<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<jsp:include page="head.jsp">
    <jsp:param name="title" value="Assignment Service"/>
</jsp:include>
<body class="bg-dark">
<div id="container">
    <jsp:include page="header.jsp">
        <jsp:param name="actual" value="AssignmentService"/>
    </jsp:include>

    <div class="container-fluid">
        <div class="row d-flex justify-content-center align-items-center h-100">
            <div class="card text-black mt-5 mb-5" style="border-radius: 25px;">
                <p class="text-center h1 fw-bold mb-5 mx-1 mx-md-4 mt-4">Service Opdracht Aanmaken voor
                    id: ${editedLeak.id}</p>
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
                    <form action="Controller" method="post">
                        <div class="d-flex flex-row align-items-center mb-4">
                            <div class="form-outline flex-fill mb-0">
                                <label class="form-label" for="firstname">Voornaam</label>
                                <input id="firstname" class="form-control" value="${editedLeak.firstName}" disabled
                                       type="text">
                            </div>
                        </div>
                        <div class="d-flex flex-row align-items-center mb-4">
                            <div class="form-outline flex-fill mb-0">
                                <label class="form-label" for="lastname">Achternaam</label>
                                <input id="lastname" class="form-control" value="${editedLeak.lastName}" disabled
                                       type="text">
                            </div>
                        </div>
                        <div class="d-flex flex-row align-items-center mb-4">
                            <div class="form-outline flex-fill mb-0">
                                <label class="form-label" for="email">Email</label>
                                <input id="email" class="form-control" value="${editedLeak.email}" disabled type="text">
                            </div>
                        </div>
                        <div class="d-flex flex-row align-items-center mb-4">
                            <div class="form-outline flex-fill mb-0">
                                <label class="form-label" for="plaats">Plaats: </label>
                                <input type="text" id="plaats" name="plaats" class="form-control"
                                       value="${plaatsPrevious}"/>
                            </div>
                        </div>
                        <div class="d-flex flex-row align-items-center mb-4">
                            <div class="form-outline flex-fill mb-0">
                                <label class="form-label" for="postcode">Postcode: </label>
                                <input type="text" id="postcode" name="postcode" class="form-control"
                                       value="${postcodePrevious}"/>
                            </div>
                        </div>
                        <div class="d-flex flex-row align-items-center mb-4">
                            <div class="form-outline flex-fill mb-0">
                                <label class="form-label" for="straat">Straat: </label>
                                <input type="text" id="straat" name="straat" class="form-control"
                                       value="${straatPrevious}"/>
                            </div>
                        </div>
                        <div class="d-flex flex-row align-items-center mb-4">
                            <div class="form-outline flex-fill mb-0">
                                <label class="form-label" for="huisnr">Huis nummer: </label>
                                <input type="text" id="huisnr" name="huisnr" class="form-control"
                                       value="${huisnrPrevious}"/>
                            </div>
                        </div>
                        <div class="d-flex flex-row align-items-center mb-4">
                            <div class="form-outline flex-fill mb-0">
                                <label class="form-label" for="type">Type: </label>
                                <select id="type" name="type" class="form-control">
                                    <%--                                <option hidden disabled selected value="">Selecteer het type</option>--%>
                                    <option selected value="EVALUATIE">Evaluatie</option>
                                    <option value="LEKHERSTEL">Lekherstel</option>
                                </select>
                            </div>
                        </div>
                        <div class="d-flex flex-row align-items-center mb-4">
                            <div class="form-outline flex-fill mb-0">
                                <label class="form-label" for="comment">Commentaar:</label>
                                <textarea type="text" id="comment" name="comment"
                                          class="form-control">${commentPrevious}</textarea>
                            </div>
                        </div>
                        <input type="hidden" name="id" value="${editedLeak.id}">
                        <input type="hidden" name="command" value="CreateServiceAssignment">
                        <div class="form-outline flex-fill mb-4">
                            <button type="submit" class="btn btn-primary btn-lg">Maak aan</button>
                        </div>
                    </form>
                            <form action="Controller" method="get">
                                <input type="hidden" name="id" value="${editedLeak.id}">
                                <div class="form-outline flex-fill mb-4">
                                    <button type="submit" class="btn btn-primary btn-lg">Wijs toe</button>
                                </div>
                            </form>
                </div>
            </div>
        </div>


    </div>
</div>

</body>
</html>
