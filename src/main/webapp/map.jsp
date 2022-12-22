<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Lek Locaties</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="style/deWaterGroepStyle.css"/>
    <link rel="stylesheet"
          href="https://unpkg.com/leaflet@1.9.3/dist/leaflet.css"
          integrity="sha256-kLaT2GOSpHechhsozzB+flnD+zUyjE2LlfWPgU04xyI="
          crossorigin=""/>
    <script src="https://unpkg.com/leaflet@1.9.3/dist/leaflet.js"
            integrity="sha256-WBkoXOwTeyKclOHuWtc+i2uENFpDZ9YPdf5Hf+D7ewM="
            crossorigin=""></script>
</head>
<body class="bg-wglightblue">
<jsp:include page="header.jsp">
    <jsp:param name="actual" value="Home"/>
</jsp:include>
<div class="cover-container d-flex h-100 mx-auto flex-column text-center">
</div>
<main role="main" class="inner cover">
    <section class="vh-100">
        <div class="container h-100">
            <div class="row d-flex justify-content-center align-items-center h-100">
                <div class="col-lg-12 col-xl-11">
                    <div class="card text-black mt-5" style="border-radius: 25px;">
                        <div class="card-body p-md-5">
                            <div class="row justify-content-center">
                                <div class="card">
                                    <select name="address-selector" id="address-selector" onchange="markerLoader()">
                                        <option value="overviewSO">Overview Service Opdrachten</option>
                                        <option value="overviewLekken">Overview Lekken</option>
                                        <option value disabled>-------------------</option>
                                        <c:forEach var="so" items="${services}">
                                            <option value="${so.street}, ${so.postalCode} ${so.city}">
                                                SO: ${so.street}, ${so.postalCode} ${so.city}
                                            </option>
                                        </c:forEach>
                                        <option value disabled>-------------------</option>
                                        <c:forEach var="leak" items="${leaks}">
                                            <option value="${leak.street}, ${leak.postalCode} ${leak.city}">
                                                Lek: ${leak.street}, ${leak.postalCode} ${leak.city}
                                            </option>
                                        </c:forEach>
                                    </select>
<%--                                    width:100%; max-height: 800px; max-width: 800px;--%>
                                    <div style="height: 70vh; width: 70vh; max-width: 100%; max-height: 100%;" id="map">
                                    </div>
                                    <script>
                                        var map = L.map('map').setView([50.886515, 4.701637], 11);

                                        L.tileLayer('https://tile.openstreetmap.org/{z}/{x}/{y}.png', {
                                            maxZoom: 19,
                                            attribution: '&copy; <a href="http://www.openstreetmap.org/copyright">OpenStreetMap</a>'
                                        }).addTo(map);

                                        var markersLayer = L.layerGroup().addTo(map);

                                        async function loadMarkers(address) {
                                            let res;
                                            try {
                                                res = await $.ajax({
                                                    url: location.protocol + '//nominatim.openstreetmap.org/search?format=json&q=' + address,
                                                    type: 'GET'
                                                }).then((data) => {
                                                    var av1 = (parseFloat(data[0].boundingbox[0]) +
                                                        parseFloat(data[0].boundingbox[1])) / 2;
                                                    var av2 = (parseFloat(data[0].boundingbox[2]) +
                                                        parseFloat(data[0].boundingbox[3])) / 2;
                                                    var marker3 = L.marker([av1, av2]).addTo(markersLayer);
                                                });
                                                return res;
                                            } catch (error) {
                                                console.error(error)
                                            }
                                        }

                                        <c:forEach var="so" items="${services}">
                                        loadMarkers("${so.street}, ${so.postalCode} ${so.city}");
                                        </c:forEach>

                                        function markerLoader() {
                                            var value = document.getElementById("address-selector").value;
                                            markersLayer.clearLayers();
                                            if (value === "overviewSO") {
                                                <c:forEach var="so" items="${services}">
                                                loadMarkers("${so.street}, ${so.postalCode} ${so.city}");
                                                </c:forEach>
                                            } else if (value === "overviewLekken") {
                                                <c:forEach var="leak" items="${leaks}">
                                                loadMarkers("${leak.street}, ${leak.postalCode} ${leak.city}");
                                                </c:forEach>
                                            } else {
                                                loadMarkers(value);
                                            }
                                        }
                                    </script>
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
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.7/dist/umd/popper.min.js"
        integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/js/bootstrap.min.js"
        integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
        crossorigin="anonymous"></script>
</body>
</html>