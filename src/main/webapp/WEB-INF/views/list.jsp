<%--
  Created by IntelliJ IDEA.
  User: Pavel
  Date: 08.04.2022
  Time: 12:12
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>${title}</h1>
    <p>Вот список объектов, доступных на сегодня</p>
    <ul>
      <c:forEach var = "premiere" items = "${premieres}">
          <li>${premiere.title} ${premiere.description}</li>
      </c:forEach>
    </ul>
</body>
</html>
