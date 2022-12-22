<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<jsp:include page="head.jsp">
  <jsp:param name="title" value="Lek melden"/>
</jsp:include>
<body class="bg-dark">
<div id="container">
  <jsp:include page="header.jsp">
    <jsp:param name="actual" value="NewService"/>
  </jsp:include>
  <main role="main" class="inner cover">
    <div class="row d-flex justify-content-center align-items-center h-100 container-fluid">
      <div class="card text-black mb-5 mt-5 w-70" style="border-radius: 25px; width: 80%;">
        <p class="text-center h1 fw-bold mb-5 mx-1 mx-md-4 mt-4">New OS Service</p>
        <c:if test="${not empty errors}">
          <div id="error" class="alert alert-danger">
            <c:forEach items="${errors}" var="error">
              <ul style="list-style: none;">
                <li>${error}</li>
              </ul>
            </c:forEach>
          </div>
        </c:if>

        <form method="POST" action="Controller?command=HandleNewAssignment">
            <div class="d-flex flex-row align-items-center mb-4">
              <div class="form-outline flex-fill mb-0">
                <label class="form-label" for="Plaats">Plaats: </label>
                <input name="city" type="text" id="Plaats" class="form-control"
                       placeholder="Tielt-Winge" value="${newAssignment.city}"/>
              </div>
            </div>
            <div class="d-flex flex-row align-items-center mb-4">
              <div class="form-outline flex-fill mb-0">
                <label class="form-label" for="Postcode">Postcode: </label>
                <input name="postal" type="text" id="Postcode" class="form-control"
                       placeholder="3390" value="${newAssignment.postalCode}"/>
              </div>
            </div>
            <div class="d-flex flex-row align-items-center mb-4">
              <div class="form-outline flex-fill mb-0">
                <label class="form-label" for="Straat">Straat: </label>
                <input name="street" type="text" id="Straat" class="form-control"
                       placeholder="Dorpstraat" value="${newAssignment.street}"/>
              </div>
            </div>
            <div class="d-flex flex-row align-items-center mb-4">
              <div class="form-outline flex-fill mb-0">
                <label class="form-label" for="HuisNummer">Huis nummer: </label>
                <input name="houseNumber" type="text" id="HuisNummer" class="form-control"
                       placeholder="124" value="${newAssignment.houseNumber}"/>
              </div>
            </div>
            <div class="d-flex flex-row align-items-center mb-4">
              <div class="form-outline flex-fill mb-0">
                <label class="form-label" for="Commentaar">Opmerkingen:</label>
                <textarea name="comment"  id="Commentaar" class="form-control" value="${newAssignment.comment}"></textarea>
              </div>
            </div>


        <div class="d-flex flex-row align-items-center mb-4">
          <div class="form-outline flex-fill mb-0">
            <label class="form-label" for="startDate">Start datum: </label>
            <input name="startDate" disabled id="startDate" class="form-control" value="${newAssignment.startDate}">
          </div>
        </div>

            <div class="d-flex flex-row align-items-center mb-4">
              <div class="form-outline flex-fill mb-0">
            <p class="form-group"><label for="type">Type</label>
              <select id="type" name="type">
                <option value="EVALUATIE">EVALUATIE</option>
                <option selected value="LEKHERSTEL">LEKHERSTEL</option>

              </select></p>
              </div>
            </div>

            <div class="d-flex flex-row align-items-center mb-4">
              <button type="submit" class="btn btn-primary btn-lg">Stuur in</button>
            </div>
          <input type="hidden" value="${newAssignment.id}" name="id">
          </form>
        </div>
      </div>

  </main>
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
