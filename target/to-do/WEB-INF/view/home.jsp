<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="webjars/bootstrap/3.4.0/css/bootstrap.min-jsf.css" rel="stylesheet">
    <title>Home</title>
</head>
<body>

<form action="/to-do/logout" method="get">
    <button type="submit" class="btn btn-success" name="logout">Logout</button>
</form>

<div class="container">

    <table class="table table-striped">
        <thead>
        <tr>
            <th></th>
            <th>Title</th>
            <th>Category</th>
            <th>Creation Date</th>
            <th>Deadline</th>
            <th>Description</th>
            <th></th>
        </tr>
        </thead>
        <tbody>
        <c:set var="i" value="1"/>
        <c:forEach items="${toDoList}" var="todo">

        <tr <c:if test="${todo.done}"> style="background-color: greenyellow" </c:if>>

            <td>${i}</td>
            <td>${todo.name}</td>
            <td>${todo.category}</td>
            <td>${todo.creationDate}</td>
            <td>${todo.deadline}</td>
            <td>${todo.description}</td>
            <td>
                <form action="/to-do/markAsDone" method="post">
                    <button type="submit" class="btn btn-success" name="toDoId" value="${todo.id}">done</button>
                </form>
            </td>
            <td>
                <button type="button" class="btn btn-success">Edit</button>
            </td>
            <td>
                <button type="button" class="btn btn-success">Remove</button>
            </td>
            <c:set var="i" value="${i+1}"/>
            </c:forEach>
        </tr>

        </tbody>
    </table>
    <form action="/to-do/addToDo" method="post">
        <div>
            <label for="titleId">Title:</label>>
            <input type="text" id="titleId" name="title">
        </div>

        <div>
            <label for="category">Category:</label>
            <select id="category" name="category">
                <c:forEach items="${categories}" var="category">
                    <option value="${category}">${category}</option>
                </c:forEach>
            </select>
        </div>

        <div>
            <label for="deadline">Deadline:</label>
            <input type="datetime-local" id="deadline" name="deadline">
        </div>

        <div>
            <label for="desc">Description:</label>
            <input type="text" id="desc" name="desc">
        </div>

        <div>
            <button type="submit" class="btn btn-success">Save</button>
        </div>
    </form>

</div>

<script src="webjars/jquery/3.4.1/jquery.min.js"/>
<script src="webjars/bootstrap/3.4.0/js/bootstrap.min.js"/>
</body>
</html>
