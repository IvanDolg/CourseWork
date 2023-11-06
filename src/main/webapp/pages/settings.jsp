<%@ page import="java.util.Properties" %><%--
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
    <%
        Properties properties = (Properties) request.getAttribute("properties");
        String name = properties.getProperty("settings.name");
        String surname = properties.getProperty("settings.surname");
        String email = properties.getProperty("settings.email");
        String country = properties.getProperty("settings.country");
        String username = properties.getProperty("settings.username");
        String password = properties.getProperty("settings.password");
        String role = properties.getProperty("settings.role");
        String button = properties.getProperty("settings.button");
    %>


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
                <input type="text" name="name" class="form-control" id="name" placeholder="name@example.com" required pattern="(^[A-Za-z]{3,16})">
                <label for="name"><%=name%></label>
            </div>

            <div class="form-floating mb-3">
                <input type="text" name="surname" class="form-control" id="surname" placeholder="name2@example.com" required pattern="(^[A-Za-z]{3,16})">
                <label for="surname"><%=surname%></label>
            </div>

            <div class="form-floating mb-3">
                <input type="email" name="email" class="form-control" id="email" placeholder="name4@example.com" required pattern="^[\w-\.]+@([\w-]+\.)+[\w-]{2,4}$">
                <label for="email"><%=email%></label>
            </div>

            <div class="mb-3">
                <label for = "country" class="form-label"></label>
                <select class="form-select" id = "country" name = "country" aria-label="Default select example">
                    <option selected><%=country%></option>
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
                <input type="text" name="userName" class="form-control" id="username" placeholder="name3@example.com" required pattern="\w*">
                <label for="username"><%=username%></label>
            </div>

            <div class="form-floating mb-3">
                <input type="password"  name="password" class="form-control" id="password" placeholder="Password" required pattern="^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[@$!%*?&])[A-Za-z\d@$!%*?&]{8,}$">
                <label for="password"><%=password%></label>
            </div>

            <select name="role" class="form-select mb-3" aria-label="Default select example">
                <option selected><%=role%></option>
                <option value="ADMIN">Admin</option>
                <option value="USER">User</option>
            </select>

            <div class="d-grid gap-2 col-6 mx-auto">
                <button class="btn btn-dark" type="submit"><%=button%></button>
            </div>
        </form>
    </div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
        crossorigin="anonymous"></script>
</body>
</html>
