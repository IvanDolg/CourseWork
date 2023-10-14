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
    <form class="mt-5 w-25" action="/reg" method="post">

      <div class="col">
        <label for="name" class="form-label">Name</label>
        <input name="name" type="text" class="form-control" id="name">
      </div>

      <div class="mb-3">
        <div class="col">
          <label for="surname" class="form-label">Surname</label>
          <input name="surname" type="text" class="form-control" id="surname" required pattern="(^[A-Za-z]{3,16})">
        </div>
      </div>

      <div class="mb-3">
        <label for="email" class="form-label">Email address</label>
        <input name="email" type="email" class="form-control" id="email" required pattern="^[\w-\.]+@([\w-]+\.)+[\w-]{2,4}$">
      </div>

      <div class="mb-3">
        <label for="country" class="form-label">Country</label>
        <select class="form-select" id="country" name="country">
          <c:forEach var="country" items="${countries}">
            <option value="${country.getId()}">${country.getName()}</option>
          </c:forEach>
        </select>
      </div>

      <div class="mb-3" >
        <label class="form-label" for="photo">Photo</label>
        <input type="file" class="form-control" id="photo" name="photo" >
      </div>

      <div class="mb-3">
        <label for="username" class="form-label">Username</label>
        <input type="text" name="userName" class="form-control" id="username" aria-describedby="emailHelp2">
        <div id="emailHelp2" class="form-text">We'll never share your email with anyone else.</div>
      </div>

      <div class="mb-3">
        <label for="password" class="form-label">Password</label>
        <input type="password" name="password" class="form-control" id="password">
      </div>

      <select name="role" class="form-select mb-3" aria-label="Default select example">
        <option value="USER">User</option>
        <option value="ADMIN">Administrator</option>
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
