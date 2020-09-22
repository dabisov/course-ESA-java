<%--
  Created by IntelliJ IDEA.
  User: kirill
  Date: 2020-09-22
  Time: 00:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Boxes</title>
</head>
<body>
<table>
    <thead>
    <tr>
        <td>id</td>
        <td>address</td>
        <td>name</td>
        <td>width</td>
        <td>height</td>
        <td>weight</td>
        <td>price</td>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${boxesList}" var="box">
        <tr>
            <td>${box.id}</td>
            <td>${box.address}</td>
            <td>${box.gift.name}</td>
            <td>${box.gift.width}</td>
            <td>${box.gift.height}</td>
            <td>${box.gift.weight}</td>
            <td>${box.gift.price}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
