<%--
  Created by IntelliJ IDEA.
  User: vvvvv
  Date: 22.09.2023
  Time: 16:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <title>Log in</title>
</head>
<body>
<jsp:include page="_header.jsp"/>
<div class="container">
  <div class="row justify-content-center">
    <form class="mt-5 w-25" action="/login" method="post">


        <div class="form-floating mb-3">
          <input type="text" name="userName" class="form-control" id="username" placeholder="name3@example.com">
          <label for="username">User name</label>
          <div id="username" class="form-text">We'll never share your email with anyone else.</div>

        <c:if test="${usernameStatus != null}">
          <div class="alert alert-danger" role="alert">
              ${usernameStatus}
          </div>
        </c:if>
      </div>

      <div class="form-floating mb-3">
        <input type="password"  name="password" class="form-control" id="password" placeholder="Password">
        <label for="password">Password</label>
        <c:if test="${passwordStatus != null}">
          <div class="alert alert-danger" role="alert">
              ${passwordStatus}
          </div>
        </c:if>
      </div>

      <div class="d-grid gap-2 col-6 mx-auto">
        <button class="btn btn-dark" type="submit">Sign In</button>
      </div>
      <c:if test="${message != null}">
        <div class="alert alert-warning mt-5" role="alert">
            ${message}
        </div>
      </c:if>

      <p class="fs-6"></p>

      <p class="text-body-secondary">
        Don`t have an account? <a href="/register">Sign up</a>
      </p>
    </form>
  </div>
</div>
</body>
</html>

