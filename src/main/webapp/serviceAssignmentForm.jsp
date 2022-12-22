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
                <div class="row d-flex justify-content-center align-items-center h-100">
                    <div class="card text-black mt-5 mb-5" style="border-radius: 25px;">
                        <p class="text-center h1 fw-bold mb-5 mx-1 mx-md-4 mt-4">Lek met id: ${editedLeak.id} toewijzen aan
                            bestaande SO</p>
                        <div class="mx-1 mx-md-4">
                            <form action="Controller" method="get">
                                <input type="hidden" name="id" value="${editedLeak.id}">
                                <div class="form-outline flex-fill mb-4">
                                    <button type="submit" class="btn btn-primary btn-lg">Wijs toe</button>
                                </div>
                            </form>
                            </form>
                            <div class="table-responsive table-scroll"
                                 style="position: relative; height: 500px">
                                <c:if test="${errors.size()!=0}">
                                    <ul>
                                        <c:forEach var="error" items="${errors}">
                                            <li>${error}</li>
                                        </c:forEach>
                                    </ul>
                                </c:if>
                                <c:choose>
                                    <c:when test="${serviceAssignments.size()!=0}">
                                        <table class="table table-dark mb-0">
                                            <thead style="background-color: #393939;">
                                            <tr class="text-uppercase">
                                                <th class="text-left" scope="col">Technieker/Opnemen</th>
                                                <th class="text-left" scope="col">Locatie</th>
                                            </tr>
                                            </thead>
                                            <tbody>
                                            <c:forEach var="service" items="${serviceAssignments}">
                                                <tr data-toggle="collapse" data-target="#collapse${service.id}" class="accordion-toggle">
                                                    <c:choose>
                                                        <c:when test="${service.technician==null}">
                                                            <td class="text-left">
                                                                <button type="button" class="btn btn-primary" onclick="location.href='Controller?command=ClaimServiceAssignment&claimId=${service.id}'" >SO Opnemen</button>
                                                            </td>
                                                        </c:when>
                                                        <c:otherwise>
                                                            <td class="text-left">${service.technician.name}</td>
                                                        </c:otherwise>
                                                    </c:choose>
                                                    <td class="text-left">${service.street} ${service.houseNumber}, ${service.postalCode} ${service.city}</td>

                                                    <c:if test="${sessionScope.employee.name eq service.technician && service.technician ne null}">
                                                        <td><a href="Controller?command=CloseAssignment&id=${service.id}"><button>Sluit Service</button></a></td>
                                                    </c:if>

                                                </tr>
                                                <tr>
                                                    <td colspan="12" class="p-0 text-left bg-secondary">
                                                        <div id="collapse${service.id}" class="accordian-body collapse">
                                                            <ul>
                                                                <li>Service Opdracht Id: ${service.id}</li>
                                                                <li>Start datum: ${service.startDate}</li>
                                                                <c:if test="${service.endDate!=null}">
                                                                    <li>Eind datum: ${service.endDate}</li>
                                                                </c:if>
                                                                <li>Type: ${service.type}</li>
                                                                <c:if test="${service.comment!=null}">
                                                                    <li>Opmerkingen: ${service.comment}</li>
                                                                </c:if>
                                                            </ul>
                                                        </div>
                                                    </td>
                                                </tr>
                                            </c:forEach>
                                            </tbody>
                                        </table>
                                    </c:when>
                                    <c:otherwise>
                                        <p>Er zijn geen service opdrachten</p>
                                    </c:otherwise>
                                </c:choose>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
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
