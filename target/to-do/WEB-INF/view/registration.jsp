<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>

<html>
<head>
    <link href="webjars/bootstrap/3.4.0/css/bootstrap.min-jsf.css" rel="stylesheet">
    <title>Registration</title>
</head>
<body>

<form action="/register" method="post">
    <div class="form-group">
        <label for="login">Login:</label>
        <input type="login" class="form-control" name="login" id="login">
    </div>
    <div class="form-group">
        <label for="pwd">Password:</label>
        <input type="password" class="form-control" name="password" id="pwd">
    </div>
    <div class="form-group">
        <label for="repeatpwd">Repeat password:</label>
        <input type="password" class="form-control" name="repeatedPassword" id="repeatpwd">
    </div>
    <div class="form-group">
        <label for="email">Email:</label>
        <input type="email" class="form-control" name="email" id="email">
    </div>

    <button type="submit" class="btn btn-default">Register</button>
</form>

<c:if test="${invalidForm}">
    <div class="danger">
        <p>Błąd rejestracji!</p>
    </div>
</c:if>

<script src="webjars/jquery/3.4.1/jquery.min.js"/>
<script src="webjars/bootstrap/3.4.0/js/bootstrap.min.js"/>

</body>
</html>
