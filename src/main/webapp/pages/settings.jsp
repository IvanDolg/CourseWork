<%--
  Created by IntelliJ IDEA.
  User: vvvvv
  Date: 24.09.2023
  Time: 22:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Settings</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
</head>
<body>
<jsp:include page="_header.jsp"/>
<div class="container">
    <div class="row justify-content-center">
        <form class="mt-5 w-25" action="/settings" method="post" enctype="multipart/form-data">

            <div class="form-floating mb-3">
                <input type="text" name="name" class="form-control" id="name" placeholder="name@example.com">
                <label for="name">First name</label>
            </div>

            <div class="form-floating mb-3">
                <input type="text" name="surname" class="form-control" id="surname" placeholder="name2@example.com">
                <label for="surname">Second name</label>
            </div>

            <div class="form-floating mb-3">
                <input type="email" name="email" class="form-control" id="email" placeholder="name4@example.com">
                <label for="email">Email address</label>
            </div>

            <div class="mb-3">
                <label for = "country" class="form-label"></label>
                <select class="form-select" id = "country" name = "country" aria-label="Default select example">
                    <option selected>Country</option>
                    <c:forEach var="country" items="${countries}">
                        <option value="${country.getId()}">${country.getName()}</option>
                    </c:forEach>
                </select>
            </div>

            <div class="mb-3" >
                <label class="form-label" for="photo"></label>
                <input type="file" name="photo" class="form-control" id="photo" >
            </div>


            <div class="form-floating mb-3">
                <input type="text" name="userName" class="form-control" id="username" placeholder="name3@example.com">
                <label for="username">User name</label>
            </div>

            <div class="form-floating mb-3">
                <input type="password"  name="password" class="form-control" id="password" placeholder="Password">
                <label for="password">Password</label>
            </div>

            <select name="role" class="form-select mb-3" aria-label="Default select example">
                <option selected>Role</option>
                <option value="ADMIN">Admin</option>
                <option value="USER">User</option>
            </select>

            <div class="d-grid gap-2 col-6 mx-auto">
                <button class="btn btn-dark" type="submit">Save changes</button>
            </div>
        </form>
    </div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
        crossorigin="anonymous"></script>
</body>
</html>
