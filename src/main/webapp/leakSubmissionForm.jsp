<%--
  Created by IntelliJ IDEA.
  User: caspe
  Date: 19/12/2022
  Time: 14:05
  To change this template use File | Settings | File Templates.
--%>
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
<p class="text-center h1 fw-bold mb-5 mx-1 mx-md-4 mt-4">Lek melden</p>

<div class="mx-1 mx-md-4">

    <div class="d-flex flex-row align-items-center mb-4">
        <div class="form-outline flex-fill mb-0">
            <label class="form-label" for="naam">Naam:</label>
            <input type="text" id="naam" class="form-control"
                   placeholder="Joske"/>
        </div>
    </div>

    <div class="d-flex flex-row align-items-center mb-4">
        <div class="form-outline flex-fill mb-0">
            <label class="form-label" for="voornaam">Voornaam:</label>
            <input type="text" id="voornaam" class="form-control"
                   placeholder="Vermeiren"/>
        </div>
    </div>

    <div class="d-flex flex-row align-items-center mb-4">
        <div class="form-outline flex-fill mb-0">
            <label class="form-label" for="email">Email: </label>
            <input type="email" id="email" class="form-control"
                   placeholder="joske.vermeiren@skynet.be"/>
        </div>
    </div>


    <div class="d-flex flex-row align-items-center mb-4">
        <div class="form-outline flex-fill mb-0">
            <label class="form-label" for="Plaats">Plaats: </label>
            <input type="text" id="Plaats" class="form-control"
                   placeholder="Tielt-Winge" />
        </div>
    </div>

    <div class="d-flex flex-row align-items-center mb-4">
        <div class="form-outline flex-fill mb-0">
            <label class="form-label" for="Postcode">Postcode: </label>
            <input type="text" id="Postcode" class="form-control"
                   placeholder="3390" />
        </div>
    </div>

    <div class="d-flex flex-row align-items-center mb-4">
        <div class="form-outline flex-fill mb-0">
            <label class="form-label" for="Straat">Straat: </label>
            <input type="text" id="Straat" class="form-control"
                   placeholder="Dorpstraat" />
        </div>
    </div>

    <div class="d-flex flex-row align-items-center mb-4">
        <div class="form-outline flex-fill mb-0">
            <label class="form-label" for="HuisNummer">Huis nummer: </label>
            <input type="text" id="HuisNummer" class="form-control"
                   placeholder="69" />
        </div>
    </div>

    <div class="d-flex flex-row align-items-center mb-4">
        <div class="form-outline flex-fill mb-0">
            <label class="form-label" for="Commentaar">Commentaar:</label>
            <textarea type="text" id="Commentaar" class="form-control"
                   placeholder=""></textarea>
        </div>
    </div>

    <div class="d-flex flex-row align-items-center mb-4">
        <div class="form-outline flex-fill mb-0">
            <label class="form-label" for="img">foto:</label>
            <input type="file" id="img" name="img" accept="image/*">
        </div>
    </div>
    <div class="form-outline flex-fill mb-0">
        <button type="button" class="btn btn-primary btn-lg">Stuur in</button>
    </div>

</form>
</div>
</body>
</html>
