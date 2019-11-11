<%--
  Created by IntelliJ IDEA.
  User: Алина
  Date: 11.11.2019
  Time: 19:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
    <link rel="stylesheet" href="assets_profile/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Lato:300,400,700">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/pikaday/1.6.1/css/pikaday.min.css">
    <title>Profile</title>
    <link rel="stylesheet" href="assets_profile/css/styles.min.css">
</head>
<body>
<nav class="navbar navbar-light navbar-expand-lg fixed-top" id="mainNav">
    <div class="container"><a class="navbar-brand">Black studio</a><button data-toggle="collapse" data-target="#navbarResponsive" class="navbar-toggler" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation"><i class="fa fa-bars"></i></button>
        <div
                class="collapse navbar-collapse" id="navbarResponsive">
            <ul class="nav navbar-nav ml-auto">
                <li class="nav-item" role="presentation"><a class="nav-link" href="main_str/main_str.jsp">главная</a></li>
                <li class="nav-item" role="presentation"><a class="nav-link" href="about.html">наши мастера</a></li>
                <li class="nav-item" role="presentation"><a class="nav-link" href="contact.html">услуги&nbsp;</a></li>
                <li class="nav-item" role="presentation"><a class="nav-link" href="post.html">Вход</a></li>
                <li class="nav-item" role="presentation"><a class="nav-link" href="feedback.html">Регистрация</a></li>
            </ul>
        </div>
    </div>
</nav>
<header class="masthead">
    <div class="overlay"><img src="assets_profile/img/s1200.jpg"></div>
    <div class="container">
        <div class="row">
            <div class="col-md-10 col-lg-8 mx-auto" style="width: 918px;">
                <div class="site-heading" style="color: white; font-size: 60px">
                    <h1>Профиль</h1><span class="subheading">Здесь ты всегда можешь вспомнить как это было</span></div>
            </div>
        </div>
    </div>
</header>
<main class="page projects-page">
    <section class="portfolio-block projects-with-sidebar"><img class="rounded-circle img-fluid mb-3" src="assets_profile/img/tnBSRYWKo9k.jpg" style="width: 180px;height: 250px; " />
        <div class="container">
            <div class="heading">
                <h2></h2>
            </div>
            <div class="row">
                <div class="col-md-3">
                    <ul class="list-unstyled sidebar">
                        <li><a class="active" href="#">Мои данные</a></li>
                        <li><a href="#">AliSha</a></li>
                        <li><a href="#">Alina Sharonova</a></li>
                        <li><a href="#">ralina_sha@mail.ru</a></li>
                        <li><a href="#">8-965-604-89-40</a></li>
                        <li><a href="#">13.10.2000</a></li>
                    </ul>
                </div>
                <div class="col-md-9">
                    <div class="row">
                        <div class="col-md-6 col-lg-4 project-sidebar-card"><a href="#"><img class="img-fluid image scale-on-hover" src="assets_profile/img/MFRxoYbYlYQ.jpg" /></a></div>
                    </div>
                </div>
            </div>
        </div>
    </section>
</main>
<script src="assets_profile/js/jquery.min.js"></script>
<script src="assets_profile/bootstrap/js/bootstrap.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/pikaday/1.6.1/pikaday.min.js"></script>
<script src="assets_profile/js/script.min.js"></script>

</body>
</html>
