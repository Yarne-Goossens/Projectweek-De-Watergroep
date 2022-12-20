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
        <div class="card text-black" style="border-radius: 25px;">
            <p class="text-center h1 fw-bold mb-5 mx-1 mx-md-4 mt-4">Service Opdracht Aanmaken</p>
            <div class="mx-1 mx-md-4">
                <form>
                <div class="d-flex flex-row align-items-center mb-4">
                    <div class="form-outline flex-fill mb-0">
                        <label class="form-label" for="Plaats">Plaats: </label>
                        <input type="text" id="Plaats" class="form-control" value="${plaatsPrevious}"/>
                    </div>
                </div>
                <div class="d-flex flex-row align-items-center mb-4">
                    <div class="form-outline flex-fill mb-0">
                        <label class="form-label" for="Postcode">Postcode: </label>
                        <input type="text" id="Postcode" class="form-control" value="${postcodePrevious}"/>
                    </div>
                </div>
                <div class="d-flex flex-row align-items-center mb-4">
                    <div class="form-outline flex-fill mb-0">
                        <label class="form-label" for="Straat">Straat: </label>
                        <input type="text" id="Straat" class="form-control" value="${straatPrevious}"/>
                    </div>
                </div>
                <div class="d-flex flex-row align-items-center mb-4">
                    <div class="form-outline flex-fill mb-0">
                        <label class="form-label" for="HuisNummer">Huis nummer: </label>
                        <input type="text" id="HuisNummer" class="form-control" value="${huisnrPrevious}"/>
                    </div>
                </div>
                <div class="d-flex flex-row align-items-center mb-4">
                    <div class="form-outline flex-fill mb-0">
                        <label class="form-label" for="type">Type: </label>
                        <select id="type" name="type" class="form-control">
                            <option hidden disabled selected value="">Selecteer het type</option>
                            <option value="LEKHERSTEL">Lekherstel</option>
                            <option value="EVALUATIE">Evaluatie</option>
                        </select>
                    </div>
                </div>
                <div class="d-flex flex-row align-items-center mb-4">
                    <div class="form-outline flex-fill mb-0">
                        <label class="form-label" for="Commentaar">Commentaar:</label>
                        <textarea type="text" id="Commentaar" class="form-control"
                                  value="${commentPrevious}"></textarea>
                    </div>
                </div>
                <div class="form-outline flex-fill mb-4">
                    <button type="submit" class="btn btn-primary btn-lg">Stuur in</button>
                </div>
                </form>
            </div>
        </div>
    </div>
</body>
</html>
