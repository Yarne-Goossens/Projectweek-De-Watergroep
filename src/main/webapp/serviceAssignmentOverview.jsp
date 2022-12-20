<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">

<jsp:include page="head.jsp">
    <jsp:param name="title" value="serviceAssignmentOverview"/>
</jsp:include>

<body class="text-center bg-dark text-white">

<div class="cover-container d-flex h-100 p-3 mx-auto flex-column ">
    <jsp:include page="header.jsp">
        <jsp:param name="actual" value="serviceAssignmentOverview"/>
    </jsp:include>
    <main role="main" class="inner cover">
        <section class="intro">
            <div class="bg-image h-100">
                <div class="mask d-flex align-items-center h-100">
                    <div class="container">
                        <div class="row justify-content-center">
                            <div class="col-8">
                                <div>
                                    <div class="card-body p-0">
                                        <div class="table-responsive table-scroll"
                                             style="position: relative; height: 500px">
                                            <c:choose>
                                                <c:when test="${true}">
                                                    <table class="table table-dark mb-0">
                                                        <thead style="background-color: #393939;">
                                                        <tr class="text-uppercase">
                                                            <th class="text-left" scope="col">Technieker/Claim</th>
                                                            <th class="text-left" scope="col">Locatie</th>
                                                            <th class="text-left" scope="col">Prioriteit</th>
                                                        </tr>
                                                        </thead>
                                                        <tbody>
                                                            <tr data-toggle="collapse" data-target="#collapse1" class="accordion-toggle">
                                                                <td class="text-left">Arno</td>
                                                                <td class="text-left">straat</td>
                                                                <td class="text-left">hoog</td>
                                                            </tr>
                                                            <tr>
                                                                <td colspan="12" class="hiddenRow">
                                                                    <div id="collapse1" class="accordian-body collapse">
                                                                        <ul>
                                                                            <li>Hello</li>
                                                                        </ul>
                                                                    </div>
                                                                </td>
                                                            </tr>
                                                            <tr data-toggle="collapse" data-target="#collapse2" class="accordion-toggle">
                                                                <td class="text-left">Ferre</td>
                                                                <td class="text-left">straat</td>
                                                                <td class="text-left">hoog</td>
                                                            </tr>
                                                            <tr>
                                                                <td colspan="12" class="hiddenRow">
                                                                    <div id="collapse2" class="accordian-body collapse">
                                                                        <ul>
                                                                            class=text-left
                                                                            <li>Hello</li>
                                                                            <li>Fren</li>
                                                                        </ul>
                                                                    </div>
                                                                </td>
                                                            </tr>
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