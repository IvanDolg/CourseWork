<%--
  Created by IntelliJ IDEA.
  User: ivand
  Date: 04.12.2023
  Time: 15:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
          rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
          crossorigin="anonymous">
    <title>Password recovery</title>

</head>
<body>
<div class="container">
    <div class="row">
        <div class="row justify-content-center">
            <div class="col-md-6 mt-3">
                <form action="/sendEmail" method="post">

                    <div class="form-floating mb-3">
                        <input type="email" name="email" class="form-control" id="email" placeholder="name4@example.com" required pattern="^[\w-\.]+@([\w-]+\.)+[\w-]{2,4}$">
                        <label for="email">Email</label>
                    </div>

                    <div class="d-grid gap-2 col-6 mx-auto">
                        <button class="btn btn-dark" type="submit">Send email</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>


<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
        crossorigin="anonymous"></script>
</body>
</html>
