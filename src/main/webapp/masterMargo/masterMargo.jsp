<%--
  Created by IntelliJ IDEA.
  User: Алина
  Date: 27.10.2019
  Time: 17:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
    <title>Master_Margo</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/masterMargo/assets_Margo/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Lato:300,400,700">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/masterMargo/assets_Margo/fonts/ionicons.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/pikaday/1.6.1/css/pikaday.min.css">
</head>
<body>
<nav class="navbar navbar-dark navbar-expand-lg fixed-top bg-white portfolio-navbar gradient" style="background-color: rgb(0,0,0);background-image: url(${pageContext.request.contextPath}/masterMargo/assets_Margo/img/s1200.jpg);">
    <div class="container"><a class="navbar-brand logo" href="#">Black Studio</a><button data-toggle="collapse" class="navbar-toggler" data-target="#navbarNav"><span class="sr-only">Toggle navigation</span><span class="navbar-toggler-icon"></span></button>
        <div class="collapse navbar-collapse"
             id="navbarNav">
            <ul class="nav navbar-nav ml-auto">
                <li class="nav-item" role="presentation"><a class="nav-link" href="${pageContext.request.contextPath}/main">Главная страница</a></li>
                <li class="nav-item" role="presentation"><a class="nav-link" href="${pageContext.request.contextPath}/service">Услуги</a></li>
                <li class="nav-item" role="presentation"><a class="nav-link" href="${pageContext.request.contextPath}/review">Отзывы</a></li>
            </ul>
        </div>
    </div>
</nav>
<main class="page lanidng-page">
    <section class="master_Margo">
        <div class="container">
            <div class="avatar"><img src="${pageContext.request.contextPath}/masterMargo/assets_Margo/img/anzhelika-nalobina.png"></div>
                <p style="color: #383d41; size: A3">Hello! Lalaalalalalalala Стаж Стили</p>
        </div>
    </section>
    <section class="portfolio-block photography">
        <div class="container">
            <div class="row no-gutters">
                <div class="col-md-6 col-lg-4 item zoom-on-hover"><a href="#"><img class="img-fluid image" src="${pageContext.request.contextPath}/masterMargo/assets_Margo/img/ta.jpg"></a></div>
                <div class="col-md-6 col-lg-4 item zoom-on-hover"><a href="#"><img class="img-fluid image" src="${pageContext.request.contextPath}/masterMargo/assets_Margo/img/tat.jpg" style="background-image: url('assets_Margo/img/tat.jpg');"></a></div>
                <div class="col-md-6 col-lg-4 item zoom-on-hover"><a href="#"><img class="img-fluid image" src="${pageContext.request.contextPath}/masterMargo/assets_Margo/img/7d9e8a7afee615b2e47886ed4b3d7fed.jpg" style="background-image: url('${pageContext.request.contextPath}/masterMargo/assets_Margo/img/7d9e8a7afee615b2e47886ed4b3d7fed.jpg');"></a></div>
            </div>
        </div>
    </section><section class="portfolio-block call-to-action border-bottom">
    <div class="container">
        <div class="d-flex justify-content-center align-items-center content"></div>
    </div>
</section></main>
<script src="${pageContext.request.contextPath}/masterMargo/assets_Margo/js/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/masterMargo/assets_Margo/bootstrap/js/bootstrap.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/pikaday/1.6.1/pikaday.min.js"></script>
<script src="${pageContext.request.contextPath}/masterMargo/assets_Margo/js/script.min.js"></script>
</body>
</html>
