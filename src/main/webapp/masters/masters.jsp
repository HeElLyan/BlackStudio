<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Алина
  Date: 27.10.2019
  Time: 17:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
    <title>Masters</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/masters/assets_masters/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Lato:300,400,700,300italic,400italic,700italic">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Adamina">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/masters/assets_masters/css/styles.min.css">
</head>
<body>
<nav class="navbar navbar-light navbar-expand bg-light navigation-clean" style="color: rgb(0,0,0);">
    <div class="container"><a class="navbar-brand" href="#">Black Studio</a>
        <nav class="navbar navbar-light navbar-expand-md navigation-clean" style="background-color: rgb(248,249,250);">
            <div class="container"><button data-toggle="collapse" class="navbar-toggler" data-target="#navcol-1"><span class="sr-only">Toggle navigation</span><span class="navbar-toggler-icon"></span></button>
                <div class="collapse navbar-collapse" id="navcol-1">
                    <ul class="nav navbar-nav ml-auto">
                        <li class="nav-item" role="presentation"><a class="nav-link" href="${pageContext.request.contextPath}/main" style="color: rgb(0,0,0);">Главная страница</a></li>
                        <li class="nav-item" role="presentation"><a class="nav-link" href="${pageContext.request.contextPath}/service" style="color: rgb(0,0,0);">Услуги</a></li>
                        <li class="nav-item" role="presentation"><a class="nav-link" href="${pageContext.request.contextPath}/review" style="color: rgb(0,0,0);">Отзывы</a></li>
                    </ul>
                </div>
            </div>
        </nav><button class="navbar-toggler" data-toggle="collapse"></button></div>
</nav>
<header>
    <div class="overlay"><img src="${pageContext.request.contextPath}/masters/assets_masters/img/s1200.jpg"></div>
    <div class="container">
        <div class="row">
            <div class="col-xl-9 mx-auto">
                <h1 class="mb-5" style="color: rgb(74,15,11);">Наша профессиональная команда</h1>
            </div>
        </div>
    </div>
</header>
<section class="showcase"></section><section class="testimonials text-center bg-light">
    <div class="container">
        <h2 class="mb-5" style="color: rgb(116,39,94);font-family: Adamina, serif;">Разрешите представить</h2>
        <%--@elvariable id="masters" type="java.util.List"--%>

        <div class="row">
            <div class="col-lg-4">
                <div class="mx-auto testimonial-item mb-5 mb-lg-0">
                    <c:forEach var="master" items="${masters}">
                        <img class="rounded-circle img-fluid mb-3" src="${master.photo_url}" style="background-image: url('${master.photo_url}');" alt=""/>
                        <h5>${master.name}</h5>
                        <p class="font-weight-light mb-0">Блаблаблабла лалалалаалала<a href="${pageContext.request.contextPath}/profile">Профиль ${master.name}</a></p>
                    </c:forEach>
                </div>
            </div>
<%--            <div class="col-lg-4">--%>
<%--                <div class="mx-auto testimonial-item mb-5 mb-lg-0"><img class="rounded-circle img-fluid mb-3" src="${pageContext.request.contextPath}/masters/assets_masters/img/alexandr-kochemasov.png" style="background-image: url('${pageContext.request.contextPath}/masters/assets_masters/img/alexandr-kochemasov.png');" alt=""/>--%>
<%--&lt;%&ndash;                    <a href="/masterPage/${master.id}"> <h5>master.name</h5></a>&ndash;%&gt;--%>
<%--                    <p class="font-weight-light mb-0">блабла<a href="#">Профиль Фреда</a></p>--%>
<%--                </div>--%>
<%--            </div>--%>
<%--            <div class="col-lg-4">--%>
<%--                <div class="mx-auto testimonial-item mb-5 mb-lg-0"><img class="rounded-circle img-fluid mb-3" src="${pageContext.request.contextPath}/masters/assets_masters/img/ruslan-smo.png" style="background-image: url('${pageContext.request.contextPath}/masters/assets_masters/img/ruslan-smo.png');"  alt=""/>--%>
<%--&lt;%&ndash;                    <a href="/masterPage/${master.id}"> <h5>master.name</h5></a>&ndash;%&gt;--%>
<%--                    <p class="font-weight-light mb-0">Вжвжввжажжвжвжвжжжжжжжжжжжжж<a href="#">Профиль Тони</a></p>--%>
<%--                </div>--%>
<%--            </div>--%>
        </div>

    </div>
</section>
<script src="${pageContext.request.contextPath}/masters/assets_masters/js/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/masters/assets_masters/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>
