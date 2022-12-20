<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Send email</title>
    <link rel="stylesheet" type="text/css" href="style/style.css"/>
</head>
<body>
<div id="container">
    <jsp:include page="header.jsp">
        <jsp:param name="actual" value="sendEmail"/>
    </jsp:include>

    <main>
        <c:if test="${not empty errors}">
            <div class="alert alert-danger">
                <ul>
                    <c:forEach items="${errors}" var="error">
                        <li>${error}</li>
                    </c:forEach>
                </ul>
            </div>
        </c:if>

        <c:if test="${param.email  eq 'true'}">
            <p class="succes">
                Mail verzonden
            </p>
        </c:if>
        <h2>Verstuur een mail</h2>

        <form method="POST" action="Controller?command=SendEmail" novalidate>

            <p>
                <label class="control-label" for="recipient">Ontvanger:</label>
                <input id="recipient" name="recipient" type="text"
                       value="${recipientPreviousValue}" >
            </p>

            <p>
                <label class="control-label" for="subject">Onderwerp:</label>
                <input id="subject" name="subject" type="text"
                       value="${subjectPreviousValue}" >
            </p>

            <p>
                <label class="control-label" for="message">Bericht:</label>
                <textarea id="message" name="message" rows="4" cols="50" ></textarea>
            </p>

            <p>
                <input id="submit" type="submit" value="Verstuur">
            </p>
        </form>
    </main>
    <jsp:include page="footer.jsp"/>
</div>
</body>
</html>