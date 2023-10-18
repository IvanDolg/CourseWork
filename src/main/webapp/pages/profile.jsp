<%@ page import="domain.User" %><%--
  Created by IntelliJ IDEA.
  User: vvvvv
  Date: 16.10.2023
  Time: 13:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">

    <title>Profile</title>
</head>
<body>
<jsp:include page="_header.jsp"/>

<div class="container">
    <div class="row justify-content-center">
        <form class="mt-5 w-50" action="/profile" method="get" enctype="multipart/form-data">

            <div class="row mb-3">
                <div class="col-sm-5">
                    <img src="data:image/jpg;base64,${user.getPhoto()}" width="200" height="200" alt="..."/>
                </div>
            </div>

            <div class="row mb-3">
                <label for="name" class="col-sm-2 col-form-label">Name</label>
                <div class="col-sm-5">
                    <div class="row" id="name">
                        <h>${user.getName()}</h>
                    </div>
                </div>
            </div>

            <div class="row mb-3">
                <label for="surname" class="col-sm-2 col-form-label">Surname</label>
                    <div class="col-sm-5">
                        <div class="row" id="surname">
                            <p>${user.getSurname()}</p>
                        </div>
                    </div>
            </div>

            <div class="row mb-3">
                <label for="username" class="col-sm-2 col-form-label">Username</label>
                <div class="col-sm-5">
                    <div class="row" id="username">
                        <p>${user.getUserName()}</p>
                    </div>
                </div>
            </div>

            <div class="row mb-3">
                <label for="email" class="col-sm-2 col-form-label">Email</label>
                <div class="col-sm-5">
                    <div class="row" id="email">
                        <p>${user.getEmail()}</p>
                    </div>
                </div>
            </div>

            <div class="row mb-3">
                <label for="role" class="col-sm-2 col-form-label">Role</label>
                <div class="col-sm-5">
                    <div class="row" id="role">
                        <p>${user.getRole()}</p>
                    </div>
                </div>
            </div>

            <div class="row mb-3">
                <label for="country" class="col-sm-2 col-form-label">Country</label>
                <div class="col-sm-5">
                    <div class="row" id="country">
                        <p>${user.getCountry().getName()}</p>
                    </div>
                </div>
            </div>
        </form>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>


</body>
</html>
