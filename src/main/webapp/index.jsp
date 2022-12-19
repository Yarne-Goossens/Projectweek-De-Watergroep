<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>

<jsp:include page="head.jsp">
    <jsp:param name="title" value="Home"/>
</jsp:include>
<body>
<div id="container">
    <jsp:include page="header.jsp">
        <jsp:param name="actual" value="Home"/>
    </jsp:include>
        <main>
        <h2>Mijn liefste huisdieren</h2>
        <p>Maak kennis met mijn allerallerallerliefste huisdieren. Hoe heten ze, hoeveel
            eten ze, ... Ik noteer het hier allemaal.</p>
        <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Quia
            culpa esse. Delectus nemo similique reiciendis provident quas sunt
            fuga numquam neque quibusdam eum libero eius sit nam asperiores sequi
            voluptatum!
        </p><div class="container">
            <div class="row">
                <div class="col-sm-4">
                    <h3>Wie zijn wij</h3>
                    <p>Lorem ipsum dolor..</p>
                </div>
                <div class="col-sm-4">
                    <h3>Mail info over dieren</h3>
                    <p>Lorem ipsum dolor..</p>
                </div>
                <div class="col-sm-4">
                    <h3>Download de PDF</h3>
                    <p>Lorem ipsum dolor..</p>
                </div>
            </div>
        </div>

    </main>
    <jsp:include page="footer.jsp"/>
</div>
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.min.js" integrity="sha384-w1Q4orYjBQndcko6MimVbzY0tgp4pWB4lZ7lr30WKz0vr/aWKhXdBNmNb5D92v7s" crossorigin="anonymous"></script>
</body>
</html>