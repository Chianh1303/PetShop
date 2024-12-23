<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="org.example.petshop.controlle.ProductURDServlet" %>

<%@ page import="org.example.petshop.model.Product" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Christmas User Page</title>
    <link rel="stylesheet" href="CSS/User.css">
</head>
<body>
<header>
    <h1>🎅 Christmas User Page 🎄</h1>
    <nav>
        <a href="#">Home</a>
        <a href="#">Profile</a>
        <a href="#">Settings</a>
        <a href="HTML/Login.jsp" class="logout-btn">Logout</a>
    </nav>
</header>

<div>
<form method="get">
    <table border="1">
        <tr>
            <td>#</td>
            <td>Tên sản phẩm</td>
            <td>Mô tả</td>
            <td>So Lượng</td>
            <td>Giá</td>
            <td>Ảnh</td>
        </tr>
        <c:forEach items="${product}" var="Product">

            <tr>
                <td>${Product.productId}</td>
                <td>${Product.productName}</td>
                <td>${Product.description}</td>
                <td>${Product.quantity}</td>
                <td>${Product.price}</td>
                <td><img style="width: 150px; height: 150px" src="${Product.image}"></td>
<%--                <td><a href="/user?action=edit&id=${Product.id}">Sua</a></td>--%>
<%--                <td><a href="/user?action=delete&id=${Product.id}">Xoa</a></td>--%>
            </tr>
        </c:forEach>
    </table>
</form>
</div>
<footer>
    <p>© 2024 Merry Christmas! All rights reserved. 🎄</p>
</footer>
</body>
</html>
