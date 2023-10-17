<%--
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

        <div class="row mb-3">
            <label for="name" class="col-sm-2 col-form-label">Name</label>
            <div class="col-sm-5">
                <input type="text" class="form-control" id="name" placeholder="col-form-label">
            </div>
        </div>

        <div class="row mb-3">
            <label for="surname" class="col-sm-2 col-form-label">Surname</label>
            <div class="col-sm-5">
                <input type="text" class="form-control" id="surname" placeholder="col-form-label">
            </div>
        </div>

        <div class="row mb-3">
            <label for="username" class="col-sm-2 col-form-label">Username</label>
            <div class="col-sm-5">
                <input type="text" class="form-control" id="username" placeholder="col-form-label">
            </div>
        </div>

        <div class="row mb-3">
            <label for="photo" class="col-sm-2 col-form-label">Photo</label>
            <div class="col-sm-5">
                <input type="file" class="form-control" id="photo" placeholder="col-form-label">
            </div>
        </div>

        <div class="row mb-3">
            <label for="email" class="col-sm-2 col-form-label">Email</label>
            <div class="col-sm-5">
                <input type="email" class="form-control" id="email" placeholder="col-form-label">
            </div>
        </div>

        <div class="row mb-3">
            <label for="password" class="col-sm-2 col-form-label">Password</label>
            <div class="col-sm-5">
                <input type="password" class="form-control" id="password" placeholder="col-form-label">
            </div>
        </div>

        <div class="row mb-3">
            <label for="role" class="col-sm-2 col-form-label">Role</label>
            <div class="col-sm-5">
                <input type="text" class="form-control" id="role" placeholder="col-form-label">
            </div>
        </div>

        <div class="row mb-3">
            <label for="country" class="col-sm-2 col-form-label">Country</label>
            <div class="col-sm-5">
                <input type="text" class="form-control" id="country" placeholder="col-form-label">
            </div>
        </div>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>


</body>
</html>
