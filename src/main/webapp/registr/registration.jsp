<%--
  Created by IntelliJ IDEA.
  User: Алина
  Date: 27.10.2019
  Time: 17:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head><meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
    <title>registration</title>
    <link rel="stylesheet" href="assets_registration/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="assets_registration/css_registration/styles.min.css">
</head>
<body>
<div class="register-photo">
    <div class="form-container"><div class="image-holder" style="background-image: url('assets_registration/img_registration/second.jpg');margin-left: 0px;font-size: 16px;width: 284px;"></div>
        <form method="post">
            <h2 class="text-center"><strong>Create</strong> an account.</h2>
            <div class="form-group"><input class="form-control" type="email" name="nikename" placeholder="Nickname"><input class="form-control" type="password" name="password" placeholder="Password"><input class="form-control" type="email" name="password" placeholder="Name">
                <input
                        class="form-control" type="email" name="city" placeholder="Email"><input class="form-control" type="email" name="phone" placeholder="Phone"><input class="form-control" type="email" placeholder="Birthday"></div>
            <div class="form-group">
                <div class="form-check"><label class="form-check-label"><input class="form-check-input" type="checkbox">I agree to the license terms.</label></div>
            </div>
            <div class="form-group"><button class="btn btn-primary btn-block" type="submit">Sign Up</button></div><a class="already" href="#">You already have an account? Login here.</a></form>
    </div>
</div>
<script src="assets_registration/js_registration/jquery.min.js"></script>
<script src="assets_registration/bootstrap/js/bootstrap.min.js"></script>

</body>
</html>
