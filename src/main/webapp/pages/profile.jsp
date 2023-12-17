<%@ page import="entity.User" %>
<%@ page import="java.util.Properties" %><%--
  Created by IntelliJ IDEA.
  User: vvvvv
  Date: 16.10.2023
  Time: 13:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%
        Properties properties = (Properties) request.getAttribute("properties");
        String name = properties.getProperty("profile.name");
        String surname = properties.getProperty("profile.surname");
        String username = properties.getProperty("profile.username");
        String email = properties.getProperty("profile.email");
        String role = properties.getProperty("profile.role");
        String country = properties.getProperty("profile.country");
    %>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
          rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
          crossorigin="anonymous">
    <title>Profile</title>
</head>
<body>
<jsp:include page="_header.jsp"/>

<div class="container">
    <div class="row justify-content-center">
        <form class="mt-5 w-25" action="/profile" method="get" enctype="multipart/form-data">

            <div class="row mb-3">
                <div class="col-sm-6">
                    <img src="data:image/jpg;base64,${user.getPhoto()}" width="200" height="200" alt="..."/>
                </div>
            </div>

            <div class="row mb-3">
                <label for="name" class="col-sm-6"><b><h3><%=name%></h3></b></label>
                <div class="col-sm-5">
                    <div class="row" id="name">
                        <b><h3>${user.getName()}</h3></b>
                    </div>
                </div>
            </div>

            <div class="row mb-3">
                <label for="surname" class="col-sm-6"><b><h3><%=surname%></h3></b></label>
                    <div class="col-sm-5">
                        <div class="row" id="surname">
                            <b><h3>${user.getSurname()}</h3></b>
                        </div>
                    </div>
            </div>

            <div class="row mb-3">
                <label for="username" class="col-sm-6"><b><h3><%=username%></h3></b></label>
                <div class="col-sm-5">
                    <div class="row" id="username">
                        <b><h3>${user.getUserName()}</h3></b>
                    </div>
                </div>
            </div>

            <div class="row mb-3">
                <label for="email" class="col-sm-6"><b><h3><%=email%></h3></b></label>
                <div class="col-sm-5">
                    <div class="row" id="email">
                        <b><h3>${user.getEmail()}</h3></b>
                    </div>
                </div>
            </div>

            <div class="row mb-3">
                <label for="role" class="col-sm-6">
                    <b><h3><%=role%></h3></b>
                </label>
                <div class="col-sm-5">
                    <div class="row" id="role">
                        <b><h3>
                            ${user.getRoles() == 0 ? 'Admin' : 'User'}
                        </h3></b>
                    </div>
                </div>
            </div>

            <div class="row mb-3">
                <label for="country" class="col-sm-6"><b><h3><%=country%></h3></b></label>
                <div class="col-sm-5">
                    <div class="row" id="country">
                        <b><h3>${user.getCountry().getName()}</h3></b>
                    </div>
                </div>
            </div>
        </form>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
        crossorigin="anonymous"></script>
</body>
</html>
