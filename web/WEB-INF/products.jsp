<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: JMJ
  Date: 7/14/2019
  Time: 14:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Products list</title>
</head>
<body>

<table border="1">

        <tr><td>ID</td><td>Product Name</td></tr>
    <c:forEach items="${requestScope.products}" var="product">
        <tr>
            <td>${product.id}</td>
            <td><c:out value="${product.name}"/></td>
            <td>
                <a href="delete?id=${product.id}">delete</a>
            </td>
        </tr>
    </c:forEach>
</table>

<table border="1">
    <tr>Add Product</tr>
    <form action="/add" method="post">

        <tr>
            <td colspan="2">
                <input name="name" type="text">
            </td>
            <td>
                <input type="submit">
            </td>

        </tr>
    </form>

</table>

</body>
</html>
