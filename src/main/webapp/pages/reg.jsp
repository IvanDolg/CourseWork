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
      <div class="mb-3">
        <label for="1" class="form-label">Name</label>
        <input type="text" name="name" class="form-control" id="1" aria-describedby="emailHelp">
        <div id="emailHelp" class="form-text">We'll never share your email with anyone else.</div>
      </div>
      <div class="mb-3">
        <label for="2" class="form-label">Username</label>
        <input type="text" name="userName" class="form-control" id="2" aria-describedby="emailHelp2">
        <div id="emailHelp2" class="form-text">We'll never share your email with anyone else.</div>
      </div>
      <div class="mb-3">
        <label for="3" class="form-label">Password</label>
        <input type="password" name="password" class="form-control" id="3">
      </div>
      <select name="role" class="form-select" aria-label="Default select example">
        <option value="USER">User</option>
        <option value="ADMIN">Administrator</option>
      </select>
      <button type="submit" class="btn btn-primary mt-5">Submit</button>
    </form>
  </div>
</div>
</body>
</html>
