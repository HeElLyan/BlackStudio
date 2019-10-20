<%--
  Created by IntelliJ IDEA.
  User: heel
  Date: 12.10.2019
  Time: 12:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>SignUp</title>
    </head>
    <link href="${pageContext.request.contextPath}/css/styles.css" rel="stylesheet" type="text/css">
    <body>
        <div class="form-style-2">
            <div class="form-style-2-heading">
                Please, sign up!
            </div>
            <form action="${pageContext.request.contextPath}/signUp" method="POST">
                <label for="username">Username
                    <input class="input-field" placeholder="!!!!" type="text" id="username" name="username" required>
                </label>
                <label for="name">Name
                    <input class="input-field" placeholder="!!!!" type="text" id="name" name="name" required>
                </label>
                <label for="password">Password
                    <input class="input-field" placeholder="!!!!" type="password" id="password" name="password" required>
                </label>
                <label for="email">Email
                    <input class="input-field" placeholder="!!!!" type="email" id="email" name="email" required>
                </label>
                <label for="phone">Phone
                    <input class="input-field" placeholder="example:89-660-81-67-95" type="tel" id="phone" name="phone"
                           pattern="[7-9]{2}-[0-9]{3}-[0-9]{2}-[0-9]{2}-[0-9]{2}" required>
                </label>
                <label for="birth_date">Birthday
                    <input class="input-field" placeholder="!!!!" type="date" id="birth_date" name="birth_date" required>
                </label>
                <label for="city">City
                    <input class="input-field" placeholder="!!!!" type="text" id="city" name="city" required>
                </label>
                <label for="session">Session
                    <input class="input-field" placeholder="!!!!" type="datetime-local" id="session" name="session" required>
                </label>
                <label for="time_sign_up">Time Sign Up
                    <input class="input-field" placeholder="!!!!" type="datetime-local" id="time_sign_up" name="time_sign_up" required>
                </label>
                <label for="stars">Stars
                    <input class="input-field" type="number" id="stars" name="stars">
                </label>
                <input class="color-input-field" type="submit" value="Sign Up">
            </form>
        </div>
    </body>
</html>