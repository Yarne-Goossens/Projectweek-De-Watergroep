<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<jsp:include page="head.jsp">
    <jsp:param name="title" value="Login User"/>
</jsp:include>
<body class="bg-dark">
<div class="cover-container d-flex h-100 p-3 mx-auto flex-column ">
    <jsp:include page="header.jsp">
        <jsp:param name="actual" value="Login"/>
    </jsp:include>
</div>
<section class="vh-100">
    <div class="container h-100">
        <div class="row d-flex justify-content-center align-items-center h-100">
            <div class="col-lg-12 col-xl-11">
                <div class="card text-black" style="border-radius: 25px;">
                    <div class="card-body p-md-5">
                        <div class="row justify-content-center">
                            <div class="col-md-10 col-lg-6 col-xl-5 order-2 order-lg-1">
                                <p class="text-center h1 fw-bold mb-5 mx-1 mx-md-4 mt-4">Log in</p>
                                <c:forEach var="e" items="${errors}">
                                    <p class="alert">${e}</p>
                                </c:forEach>
                                <form class="mx-1 mx-md-4" action="Controller" method="post">
                                    <div class="d-flex flex-row align-items-center mb-4">
                                        <div class="form-outline flex-fill mb-0">
                                            <label class="form-label" for="email">E-mailadres</label>
                                            <input type="email" id="email" class="form-control" name="email"
                                                   placeholder="Vul je e-mail in"/>
                                        </div>
                                    </div>
                                    <div class="d-flex flex-row align-items-center mb-4">
                                        <div class="form-outline flex-fill mb-0">
                                            <label class="form-label" for="password">Paswoord</label>
                                            <input type="password" id="password" class="form-control" name="password"
                                                   placeholder="Vul je password in"/>
                                        </div>
                                    </div>
                                    <%--<div class="d-flex flex-row align-items-center mb-4">
                                        <div class="form-check">
                                            <input type="checkbox" class="form-check-input" id="keepLoggedIn" name="checkbox">
                                            <label class="form-check-label" for="keepLoggedIn">Hou mij
                                                ingelogd</label>
                                        </div>
                                    </div>--%>
                                    <input type="hidden" name="command" value="LogIn">
                                    <div class="form-outline flex-fill mb-0">
                                        <button type="submit" class="btn btn-primary btn-lg">Log in</button>
                                    </div>
                                </form>
                            </div>
                            <div class="col-md-10 col-lg-6 col-xl-7 d-flex align-items-center order-1 order-lg-2">
                                <img src="img/watergroep_logo_small.png" class="img-fluid" alt="watergroep logo">
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
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