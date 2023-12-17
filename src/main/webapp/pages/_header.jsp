<%@ page import="java.util.Properties" %><%--
  Created by IntelliJ IDEA.
  User: vvvvv
  Date: 16.10.2023
  Time: 16:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>

    <%
        Properties properties = (Properties) request.getAttribute("properties");
        String brand = properties.getProperty("header.brand");
        String home = properties.getProperty("header.home");
        String language = properties.getProperty("header.language");
        String register = properties.getProperty("header.register");
        String login = properties.getProperty("header.login");
        String logout = properties.getProperty("header.logout");
        String settings = properties.getProperty("header.settings");
        String profile = properties.getProperty("header.profile");
        String button = properties.getProperty("header.button");
    %>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
          crossorigin="anonymous">
    <title>Header</title>
</head>
<body>

<nav class="navbar navbar-expand-lg bg-dark justify-content-center sticky-top" data-bs-theme="dark">
    <div class="container-fluid">
        <a class="navbar-brand fst-italic fw-bolder fs-4"><%=brand%></a>

        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
                aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navbarSupportedContent">

            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <c:if test="${user == null}">
                    <li class="nav-item">
                        <a class="nav-link"  aria-current="page" href="/reg"><%=register%></a>
                    </li>

                    <li class="nav-item">
                        <a class="nav-link"  aria-current="page" href="/login"><%=login%></a>
                    </li>

                    <li class="nav-item">
                        <a class="nav-link" aria-current="page" href="/localization"><%=language%></a>
                    </li>
                </c:if>

                <c:if test="${user != null}">
                    <li class="nav-item">
                        <a class="nav-link" aria-current="page" href="/logout"><%=logout%></a>
                    </li>

                    <li class="nav-item">
                        <a class="nav-link" aria-current="page" href="/settings"><%=settings%></a>
                    </li>

                    <li class="nav-item">
                        <a class="nav-link" aria-current="page" href="/profile"><%=profile%></a>
                    </li>

                    <li class="nav-item">
                        <a class="nav-link" aria-current="page" href="/"><%=home%></a>
                    </li>

                    <li class="nav-item">
                        <a class="nav-link" aria-current="page" href="/localization"><%=language%></a>
                    </li>
                </c:if>

                <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                    <c:if test="${user.roles == '0'}">
                        <li class="nav-item">
                            <a class="nav-link" aria-current="page" href="/allUsers">AllUsers</a>
                        </li>
                    </c:if>
                </ul>
            </ul>

        </div>
    </div>
</nav>


<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
</body>
</html>
