Created by IntelliJ IDEA.
  User: vvvvv
  Date: 22.09.2023
  Time: 16:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.Properties" %>


<%
  Properties properties = (Properties) request.getAttribute("properties");
  String username = properties.getProperty("login.username");
  String password = properties.getProperty("login.password");
  String button = properties.getProperty("login.button");
  String button2 = properties.getProperty("login.button2");
  String description = properties.getProperty("login.description");
  String text = properties.getProperty("login.text");
%>

<html>
<head>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
        rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
        crossorigin="anonymous">
  <title>Log in</title>
</head>
<body>
<jsp:include page="_header.jsp"/>

<div class="container">
  <div class="row justify-content-center">
    <form class="mt-5 w-25" action="/login" method="post">


        <div class="form-floating mb-3">
          <input type="text" name="userName" class="form-control" id="username" placeholder="name3@example.com" required pattern="\w*">
          <label for="username"><%=username%></label>
          <div id="username" class="form-text">We'll never share your email with anyone else.</div>

        <c:if test="${usernameStatus != null}">
          <div class="alert alert-danger" role="alert">
              ${usernameStatus}
          </div>
        </c:if>
      </div>

      <div class="form-floating mb-3">
        <input type="password"  name="password" class="form-control" id="password" placeholder="Password" required pattern="^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[@$!%*?&])[A-Za-z\d@$!%*?&]{8,}$">
        <label for="password"><%=password%></label>
        <c:if test="${passwordStatus != null}">
          <div class="alert alert-danger" role="alert">
              ${passwordStatus}
          </div>
        </c:if>
      </div>

      <div class="d-grid gap-2 col-6 mx-auto">
        <button class="btn btn-dark" type="submit"><%=button2%></button>
      </div>
      <c:if test="${message != null}">
        <div class="alert alert-warning mt-5" role="alert">
            ${message}
        </div>
      </c:if>

      <p class="fs-6"></p>

      <p class="text-body-secondary">
        <%=description%> <a href="/reg"><%=button%></a>
      </p>
      <p class="text-body-secondary">
        Forget password ?<a href="/sendEmail"> Password Recovery</a>
      </p>
    </form>
  </div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
        crossorigin="anonymous"></script>

</body>
</html>

