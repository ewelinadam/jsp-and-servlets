<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>

<html>
<head>
    <link href="webjars/bootstrap/3.4.0/css/bootstrap.min-jsf.css" rel="stylesheet">
    <title>Login</title>
</head>
<body>

<form action="/login" method="post">
    <div class="form-group">
        <label for="login">Login:</label>
        <input type="login" class="form-control" name="login" id="login">
    </div>
    <div class="form-group">
        <label for="pwd">Password:</label>
        <input type="password" class="form-control" name="password" id="pwd">
    </div>

    <button type="submit" class="btn btn-default">Log in</button>
</form>

<c:if test="${invalidLogin}">
    <div class="danger">
        <p>Błąd logowania!</p>
    </div>
</c:if>

<script src="webjars/jquery/3.4.1/jquery.min.js"/>
<script src="webjars/bootstrap/3.4.0/js/bootstrap.min.js"/>

</body>
</html>
