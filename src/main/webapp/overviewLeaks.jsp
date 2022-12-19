<!DOCTYPE html>
<html lang="en">

<jsp:include page="head.jsp">
    <jsp:param name="title" value="Home"/>
</jsp:include>

<body class="text-center bg-dark text-white">

<div class="cover-container d-flex h-100 p-3 mx-auto flex-column ">
    <jsp:include page="header.jsp">
        <jsp:param name="actual" value="Home"/>
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
                                            <table class="table table-dark mb-0">
                                                <thead style="background-color: #393939;">
                                                <tr class="text-uppercase">
                                                    <th class="text-left" scope="col">ID</th>
                                                    <th class="text-left" scope="col">Location</th>
                                                    <th class="text-left" scope="col">Priority</th>
                                                </tr>
                                                </thead>
                                                <tbody>
                                                <tr>
                                                    <td class="text-left">1</td>
                                                    <td class="text-left">leuvenStraat 24 3000 Leuven</td>
                                                    <td class="text-left">High</td>
                                                </tr>
                                                <tr>
                                                    <td class="text-left">2</td>
                                                    <td class="text-left">MechelBaan 97 2800 Mechelen</td>
                                                    <td class="text-left">Low</td>
                                                </tr>
                                                <tr>
                                                    <td class="text-left">3</td>
                                                    <td class="text-left">BrusselBrug 43 1000 Brussel</td>
                                                    <td class="text-left">Medium</td>
                                                </tr>
                                                <tr>
                                                    <td class="text-left">4</td>
                                                    <td class="text-left">OostWeg 364 8400 Oostende</td>
                                                    <td class="text-left">High</td>
                                                </tr>
                                                </tbody>
                                            </table>
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

    <footer class="mastfoot mt-auto">
        <div class="inner">
            <p>Devy Leskens, Jelle Michiels, Sander Doggen</a>.</p>
        </div>
    </footer>
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