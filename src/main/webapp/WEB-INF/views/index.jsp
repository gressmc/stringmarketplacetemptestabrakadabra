<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>SpringLesson</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
    <h3>User List</h3>
    <h1>Message : ${message}</h1>
    <form class="form-inline" role="form" action="/user/search" method="post">
        <input type="text" class="form-control" name="pattern" placeholder="Search">
        <input type="submit" class="btn btn-default" value="Search">
    </form>

    <table class="table table-striped">
        <thead>
        <tr>
            <td><b>Id</b></td>
            <td><b>Login</b></td>
            <td><b>Full Name</b></td>
            <td><b>Password</b></td>
            <td><b>Email</b></td>
            <td><b>Address</b></td>
            <td><b>Action</b></td>
        </tr>
        </thead>
        <c:forEach items="${user}" var="user">
            <tr>
                <td>${user.id}</td>
                <td>${user.login}</td>
                <td>${user.fullName}</td>
                <td>${user.password}</td>
                <td>${user.email}</td>
                <td>${user.billingAddress}</td>
                <td><a href="/user/delete?id=${user.id}">Delete</a></td>
            </tr>
        </c:forEach>
    </table>

    <form class="form-inline" role="form" action="/user/add_user" method="post">
        <input type="submit" class="btn btn-default" value="Add new">
    </form>
</div>
</body>
</html>