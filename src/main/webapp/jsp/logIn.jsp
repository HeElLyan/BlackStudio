<%--
  Created by IntelliJ IDEA.
  User: heel
  Date: 12.10.2019
  Time: 12:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>LogIn</title>
</head>
<link href="${pageContext.request.contextPath}/css/styles.css" rel="stylesheet" type="text/css">
<body>
    <div class="form-style-2">
        <div class="form-style-2-heading">
            Please, Log In!
        </div>
        <form action="${pageContext.request.contextPath}/logIn" method="POST">
            <label for="username">Username
                <input class="input-field" type="text" id="username" name="username">
            </label>
            <label for="password">Password
                <input class="input-field" type="password" id="password" name="password">
            </label>
            <input class="color-input-field" type="submit" value="Sign Up">
        </form>
    </div>
</body>
</html>
