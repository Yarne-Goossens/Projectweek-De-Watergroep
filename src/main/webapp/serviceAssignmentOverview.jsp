<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">

<jsp:include page="head.jsp">
    <jsp:param name="title" value="serviceAssignmentOverview"/>
</jsp:include>

<body class="bg-dark">
<jsp:include page="header.jsp">
    <jsp:param name="actual" value="serviceAssignmentOverview"/>
</jsp:include>
<div class="cover-container d-flex h-100 p-3 mx-auto flex-column text-center mb-0  text-white">
    <main role="main" class="inner cover">
        <section class="intro">
            <div class="bg-image h-100">
                <div class="mask d-flex align-items-center h-100">
                    <div class="container">
                        <div class="row justify-content-center mb-0">
                            <div class="col-8">
                                <div>
                                    <div class="card-body p-0">
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
                                                                <c:if test="${sessionScope.user.name eq service.technician.name && service.endDate == null}">
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
</section>
</main>
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