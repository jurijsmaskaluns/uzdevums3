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
<p>Products List</p>
<table border="1">
    <tr>
        <td>ID</td>
        <td>Product Name</td>
        <td>Product Type</td>
        <td>Day</td>
        <td>Product Status</td>
    </tr>
    <c:forEach items="${requestScope.products}" var="product"> <%-- cikls forEach, kurš aizpilda tabulu ar datiem. --%>
        <tr>
            <td>${product.id}</td>
            <td><c:out value="${product.name}"/></td>
            <td><c:out value="${product.productType}"/></td>
            <td><c:out value="${product.created}"/></td>
            <td><c:out value="${product.status}"/></td>
            <td>
                <a href="delete?id=${product.id}">delete</a>
            </td>
            <td>
                <a href="confirm?id=${product.id}">confirm</a>
            </td>
            <td>
                <a href="reject?id=${product.id}">reject</a>
            </td>
        </tr>
    </c:forEach>
</table>
<table border="1">
    <tr><p>Add Product</p></tr>
    <form action="/add" method="post">
        <tr>
            <td>Product Name</td>
            <td>
                <select name="name">
                    <option disabled>Select Product</option>
                    <option value="Motherboard">Motherboard</option>
                    <option value="CPU">CPU</option>
                    <option value="GPU">GPU</option>
                    <option value="RAM">RAM</option>
                    <option value="Mouse">Mouse</option>
                </select>
            </td>
            <td>Product Type</td>
            <td>
                <input name="type" type="text">
            </td>
            <td>
                <input type="submit">
            </td>
        </tr>
    </form>
</table>
</body>
</html>
