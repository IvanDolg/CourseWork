<%--
  Created by IntelliJ IDEA.
  User: vvvvv
  Date: 22.09.2023
  Time: 16:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
  <title>Reg</title>
</head>
<body>
<jsp:include page="_header.jsp"/>
<div class="container">
  <div class="row justify-content-center">
    <form class="mt-5 w-25" action="/reg" method="post" enctype="multipart/form-data">

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
        <c:forEach var="role" items="${role}">
          <option value="${user.getId}">${user.getRole}</option>
        </c:forEach>
      </select>

      <div class="d-grid gap-2 col-6 mx-auto">
        <button class="btn btn-dark" type="submit">Sign In</button>
      </div>

      <p class="fs-6"></p>

      <p class="text-body-secondary">
        Already have an account? <a href="/login">Log in</a>
      </p>
    </form>
  </div>
</div>
</body>
</html>
