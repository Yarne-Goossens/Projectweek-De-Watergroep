<!DOCTYPE html>
<html lang="en">
<jsp:include page="headbootstrap.jsp">
    <jsp:param name="title" value="Overview"/>
</jsp:include>
<head>
    <style>html,
    body,
    .intro {
        height: 100%;
    }

    table td,
    table th {
        text-overflow: ellipsis;
        white-space: nowrap;
        overflow: hidden;
    }

    .table-scroll {
        border-radius: .5rem;
    }

    thead {
        top: 0;
        position: sticky;
    }</style>
    <title></title></head>
<body class="text-center bg-dark text-white">

<div class="cover-container d-flex h-100 p-3 mx-auto flex-column ">
    <header class="masthead mb-auto text-center">
        <div class="inner">
            <h3 class="masthead-brand">Bootstrap Spike</h3>
            <nav class="nav nav-masthead justify-content-center">
                <a class="nav-link active" href="Controller?command=OverviewBootstrap">HomeBootstrap</a>
                <a class="nav-link" href="Controller?command=RegisterUser">Register</a>
                <a class="nav-link" href="Controller?command=Login">Login</a>
                <a class="nav-link" href="Controller?command=Home">Home</a>
            </nav>
        </div>
    </header>

    <main role="main" class="inner cover">
        <h1 class="cover-heading">Overview page.</h1>
        <p class="lead">Here you can place elements to create a nice overview page.<br>
            As an example we have a table of all created employee accounts.</p>

        <section class="intro">
            <div class="bg-image h-100">
                <div class="mask d-flex align-items-center h-100">
                    <div class="container">
                        <div class="row justify-content-center">
                            <div class="col-12">
                                <div>
                                    <div class="card-body p-0">
                                        <div class="table-responsive table-scroll"
                                             style="position: relative; height: 700px">
                                            <table class="table table-dark mb-0">
                                                <thead style="background-color: #393939;">
                                                <tr class="text-uppercase">
                                                    <th scope="col">ID</th>
                                                    <th scope="col">Firstname</th>
                                                    <th scope="col">Lastname</th>
                                                    <th scope="col">Email</th>
                                                </tr>
                                                </thead>
                                                <tbody>
                                                <tr>
                                                    <td>1</td>
                                                    <td>Devy</td>
                                                    <td>Leskens</td>
                                                    <td>devy.leskens@student.ucll.be</td>
                                                </tr>
                                                <tr>
                                                    <td>2</td>
                                                    <td>Jelle</td>
                                                    <td>Michiels</td>
                                                    <td>jelle.michiels1@student.ucll.be</td>
                                                </tr>
                                                <tr>
                                                    <td>3</td>
                                                    <td>Sander</td>
                                                    <td>Doggen</td>
                                                    <td>sander.doggen@student.ucll.be</td>
                                                </tr>
                                                <tr>
                                                    <td>4</td>
                                                    <td>Elias</td>
                                                    <td>Van den Broeck</td>
                                                    <td>eliasvdb@gmail.com</td>
                                                </tr>
                                                <tr>
                                                    <td>5</td>
                                                    <td>Wout</td>
                                                    <td>Van Aert</td>
                                                    <td>woutvaneart@gmail.com</td>
                                                </tr>
                                                <tr>
                                                    <td>6</td>
                                                    <td>Lars</td>
                                                    <td>Prudhomme</td>
                                                    <td>larsprudhomme@gmail.com</td>
                                                </tr>
                                                <tr>
                                                    <td>7</td>
                                                    <td>Yves</td>
                                                    <td>Lampaert</td>
                                                    <td>yveslampaert@gmail.com</td>
                                                </tr>
                                                <tr>
                                                    <td>8</td>
                                                    <td>Remco</td>
                                                    <td>Evenepoel</td>
                                                    <td>remcoevenepoel@gmail.com</td>
                                                </tr>
                                                <tr>
                                                    <td>9</td>
                                                    <td>Mathieu</td>
                                                    <td>Van der Poel</td>
                                                    <td>matthieuvdp@gmail.com</td>
                                                </tr>
                                                <tr>
                                                    <td>10</td>
                                                    <td>Tom</td>
                                                    <td>Boonen</td>
                                                    <td>tomboonen@gmail.com</td>
                                                </tr>
                                                <tr>
                                                    <td>11</td>
                                                    <td>Greg</td>
                                                    <td>Van Avermaet</td>
                                                    <td>gregvam@gmail.com</td>
                                                </tr>
                                                <tr>
                                                    <td>12</td>
                                                    <td>Tim</td>
                                                    <td>Wellens</td>
                                                    <td>timwellens@gmail.com</td>
                                                </tr>
                                                <tr>
                                                    <td>13</td>
                                                    <td>Michael</td>
                                                    <td>Valgren</td>
                                                    <td>michaelvalgren@gmail.com</td>
                                                </tr>
                                                <tr>
                                                    <td>14</td>
                                                    <td>Michael</td>
                                                    <td>Morkov</td>
                                                    <td>michaelmorkov@gmail.com</td>
                                                </tr>
                                                <tr>
                                                    <td>15</td>
                                                    <td>Philippe</td>
                                                    <td>Gilbert</td>
                                                    <td>philippegilbert@gmail.com</td>
                                                </tr>
                                                <tr>
                                                    <td>16</td>
                                                    <td>Greg</td>
                                                    <td>Van Avermaet</td>
                                                    <td>gregvanavermaet@gmail.com</td>
                                                </tr>
                                                <tr>
                                                    <td>17</td>
                                                    <td>Tim</td>
                                                    <td>Wellens</td>
                                                    <td>timwellens@gmail.com</td>
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