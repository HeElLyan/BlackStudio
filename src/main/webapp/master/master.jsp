<%--@elvariable id="masterId" type=""--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--@elvariable id="master" type="ru.itis.blackstudio.models.Master"--%>
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
    <link rel="stylesheet" href="${pageContext.request.contextPath}/master/assets_Margo/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Lato:300,400,700">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/master/assets_Margo/fonts/ionicons.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/pikaday/1.6.1/css/pikaday.min.css">
</head>
<body>
<%--<nav class="navbar navbar-dark navbar-expand-lg fixed-top bg-white portfolio-navbar gradient" style="background-color: rgb(0,0,0);background-image: url(${pageContext.request.contextPath}/masterMargo/assets_Margo/img/s1200.jpg);">--%>
<%--    <div class="container"><a class="navbar-brand logo" href="#">Black Studio</a><button data-toggle="collapse" class="navbar-toggler" data-target="#navbarNav"><span class="sr-only">Toggle navigation</span><span class="navbar-toggler-icon"></span></button>--%>
<%--        <div class="collapse navbar-collapse"--%>
<%--             id="navbarNav">--%>
<%--            <ul class="nav navbar-nav ml-auto">--%>
<%--                <li class="nav-item" role="presentation"><a class="nav-link" href="${pageContext.request.contextPath}/main">Главная страница</a></li>--%>
<%--                <li class="nav-item" role="presentation"><a class="nav-link" href="${pageContext.request.contextPath}/service">Услуги</a></li>--%>
<%--                <li class="nav-item" role="presentation"><a class="nav-link" href="${pageContext.request.contextPath}/review">Отзывы</a></li>--%>
<%--&lt;%&ndash;                <li class="nav-item" role="presentation"><a class="nav-link" href="${pageContext.request.contextPath}/review/${masterId}">Отзывы</a></li>&ndash;%&gt;--%>
<%--            </ul>--%>
<%--        </div>--%>
<%--    </div>--%>
<%--</nav>--%>
<%@ include file="../jsp/header.jsp" %>
<main class="page lanidng-page">
    <section class="master_Margo">
        <div class="container">
<%--            <div class="avatar"><img src="${pageContext.request.contextPath}/masterMargo${master.urlPhoto}" style="background-image: url('${pageContext.request.contextPath}/masterMargo${master.urlPhoto}');" alt="">--%>
                <h3 style="color: #383d41; size: A3">Master's name:${master.name}</h3>
                <h3 style="color: #383d41; size: A3">Working style: ${master.workingStyle}</h3>
<%--            </div>--%>
        </div>
    </section>
    <section class="portfolio-block photography">
        <div class="container">
            <div class="row no-gutters">
                <%--@elvariable id="works" type="java.util.List"--%>
                <c:forEach var="work" items="${works}">
                   <div class="col-md-6 col-lg-4 item zoom-on-hover"><a href="#"><img class="img-fluid image" src="${pageContext.request.contextPath}${work.urlWork}" style="background-image: url('${pageContext.request.contextPath}/masterMargo/assets_Margo/img/7d9e8a7afee615b2e47886ed4b3d7fed.jpg');" alt=""></a></div>
                </c:forEach>
            </div>
        </div>
    </section><section class="portfolio-block call-to-action border-bottom">
    <div class="container">
        <div class="d-flex justify-content-center align-items-center content"></div>
    </div>
</section></main>
<%@ include file="../jsp/footer.jsp" %>
<script src="${pageContext.request.contextPath}/master/assets_Margo/js/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/master/assets_Margo/bootstrap/js/bootstrap.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/pikaday/1.6.1/pikaday.min.js"></script>
<script src="${pageContext.request.contextPath}/master/assets_Margo/js/script.min.js"></script>
</body>
</html>
