<!DOCTYPE html>
<html>
<jsp:include page="headbootstrap.jsp">
    <jsp:param name="title" value="Register user"/>
</jsp:include>
<body class=" bg-dark ">
<div class="cover-container d-flex h-100 p-3 mx-auto flex-column ">
    <header class="masthead mb-auto text-center text-white">
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
</div>
<section class="vh-100">
    <div class="container h-100">
        <div class="row d-flex justify-content-center align-items-center h-100">
            <div class="col-lg-12 col-xl-11">
                <div class="card text-black" style="border-radius: 25px;">
                    <div class="card-body p-md-5">
                        <div class="row justify-content-center">
                            <div class="col-md-10 col-lg-6 col-xl-5 order-2 order-lg-1">

                                <p class="text-center h1 fw-bold mb-5 mx-1 mx-md-4 mt-4">Sign up</p>

                                <form class="mx-1 mx-md-4">

                                    <div class="d-flex flex-row align-items-center mb-4">
                                        <div class="form-outline flex-fill mb-0">
                                            <label class="form-label" for="name">Your Firstname</label>
                                            <input type="text" id="name" class="form-control" placeholder="Enter your firstname"/>

                                        </div>
                                    </div>

                                    <div class="d-flex flex-row align-items-center mb-4">
                                        <div class="form-outline flex-fill mb-0">
                                            <label class="form-label" for="lastname">Your Lastname</label>
                                            <input type="text" id="lastname" class="form-control" placeholder="Enter your lastname"/>
                                        </div>
                                    </div>

                                    <div class="d-flex flex-row align-items-center mb-4">
                                        <div class="form-outline flex-fill mb-0">
                                            <label class="form-label" for="email">Your Email</label>
                                            <input type="email" id="email" class="form-control" placeholder="Enter your email"/>
                                        </div>
                                    </div>

                                    <div class="d-flex flex-row align-items-center mb-4">
                                        <div class="form-outline flex-fill mb-0">
                                            <label class="form-label" for="password">Password</label>
                                            <input type="password" id="password" class="form-control" placeholder="Enter your password"/>
                                        </div>
                                    </div>

                                    <div class="d-flex flex-row align-items-center mb-4">
                                        <div class="form-outline flex-fill mb-0">
                                            <label class="form-label" for="password2">Repeat your password</label>
                                            <input type="password" id="password2" class="form-control" placeholder="Enter your password"/>
                                        </div>
                                    </div>

                                    <div class="form-check d-flex justify-content-center mb-5">
                                        <div class="form-outline flex-fill mb-0">
                                            <p>Choose your preferred language</p>
                                            <input type="radio" id="english" name="fav_language" value="english">
                                            <label for="english">English</label><br>
                                            <input type="radio" id="dutch" name="fav_language" value="dutch">
                                            <label for="dutch">Dutch</label><br>
                                        </div>
                                    </div>

                                    <div class="d-flex justify-content-center mx-4 mb-3 mb-lg-4">
                                        <button type="button" class="btn btn-primary btn-lg">Register</button>
                                    </div>

                                </form>

                            </div>
                            <div class="col-md-10 col-lg-6 col-xl-7 d-flex align-items-center order-1 order-lg-2">

                                <img src="https://mdbcdn.b-cdn.net/img/Photos/new-templates/bootstrap-registration/draw1.webp"
                                     class="img-fluid" alt="Sample image">

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