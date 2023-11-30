<%@ page import="java.util.Properties" %><%--
  Created by IntelliJ IDEA.
  User: vvvvv
  Date: 17.10.2023
  Time: 3:59
  To change this template use File | Settings | File Templates.
--%>

<%
    Properties properties = (Properties) request.getAttribute("properties");
    String title = properties.getProperty("search.title");
    String username = properties.getProperty("search.username");
    String button = properties.getProperty("search.button");
%>

<html>
<head>
    <title><%=title%></title>
</head>
<body>

<form action="/search" method="post">
    <input type="text" name = "OtherUsername" placeholder=<%=username%>>
    <button><%=button%></button>

    <ul>
        <c:forEach var="user" items="${users}">

            <li> ${user.getUsername()} </li>

        </c:forEach>

    </ul>

</form>

<p>${message}</p>

</body>
</html>
