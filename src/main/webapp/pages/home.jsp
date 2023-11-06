<%@ page import="java.util.Properties" %><%--
  Created by IntelliJ IDEA.
  User: vvvvv
  Date: 22.09.2023
  Time: 2:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
  <%
    Properties properties = (Properties) request.getAttribute("properties");
    String button = properties.getProperty("home.text");
    String text = properties.getProperty("home.button");
  %>

  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">


  <title>Home</title>
</head>
<body>
  <jsp:include page="_header.jsp"/>
    <div class="container">
      <div class="row justify-content-center">
        <form class="mt-5 w-25" action="/" method="post">

          <div class="mb-3">
            <label for="exampleFormControlTextarea1" class="form-label"><%=text%></label>
            <textarea class="form-control" id="exampleFormControlTextarea1" rows="3"></textarea>
          </div>

          <div class="d-grid gap-2 col-6 mx-auto">
            <button class="btn btn-dark" type="submit"><%=button%></button>
          </div>
        </form>
      </div>
    </div>

  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>

</body>
</html>
