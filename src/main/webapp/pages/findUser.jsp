<%@ page import="java.util.Properties" %><%--
  Created by IntelliJ IDEA.
  User: vvvvv
  Date: 17.12.2023
  Time: 5:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <%
        Properties properties = (Properties) request.getAttribute("properties");
        String id = properties.getProperty("allUsers.id");
        String name = properties.getProperty("allUsers.name");
        String surname = properties.getProperty("allUsers.surname");
        String email = properties.getProperty("allUsers.email");
        String username = properties.getProperty("allUsers.username");
        String password = properties.getProperty("allUsers.password");
    %>
    <title>FindUser</title>
</head>
<body>
<jsp:include page="_header.jsp"/>
<div class="container">
    <div class="row justify-content-center">

        <form class="mt-5 w-20">

            <c:forEach items="${userList}" var="user">

            <div class="container">
                <h1>Пользователь с никнеймом ${user.userName}</h1>
                <table class="table table-striped">
                    <thead>
                    <tr>
                        <th><%=id%></th>
                        <th><%=name%></th>
                        <th><%=surname%></th>
                        <th><%=username%></th>
                        <th><%=password%></th>
                        <th><%=email%></th>
                    </tr>
                    </thead>
                    <tbody>
                    <%-- Предположим, что у вас есть список пользователей, предоставляемый из сервлета или другого источника данных --%>
                    <c:forEach items="${userList}" var="user">
                        <tr>
                            <td>${user.id}</td>
                            <td>${user.name}</td>
                            <td>${user.surname}</td>
                            <td>${user.userName}</td>
                            <td>${user.password}</td>
                            <td>${user.email}</td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
            </c:forEach>
        </form>
    </div>
</div>


<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
        crossorigin="anonymous"></script>
</body>
</html>
