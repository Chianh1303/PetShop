<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="org.example.petshop.controlle.ProductURDServlet" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ page import="org.example.petshop.model.Product" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Christmas User Page</title>
    <link rel="stylesheet" href="CSS/User.css">
</head>
<title>PetShop</title>
<link rel="stylesheet" href="/CSS/User.css">
<script src="/JS/User.js"></script>

</head>

<body>
<header>
    <h1 class="title">🎅 Pet Shop 🎄</h1>
    <nav>
        <a href="/user">Home</a>
        <a href="#">Profile</a>
        <a href="#">Settings</a>
        <a href="/user?action=logout" class="logout-btn">Logout</a>
    </nav>
</header>
<div>

    <div class="search-bar-container">
        <form method="post" action="/user?action=search" class="search-form">
            <input type="text" name="searchQuery" placeholder="Nhập tên sản phẩm..." required class="search-input">
            <button type="submit" class="search-button">Tìm kiếm</button>
        </form>
    </div>
    <c:if test="${not empty message}">
        <p>${message}</p>
    </c:if>
    <form method="get">
        <h1 style="text-align: center">Danh sách sản phẩm</h1>
        <div class="product-container">
            <c:forEach var="Product" items="${product}">
            <div class="product-card" onclick="toggleDescription('${Product.productId}')">
                <div class="product-card">
                    <img style="width: 250px;height: 280px" src="${Product.image}" alt="${Product.productName}">
                    <div class="product-info">
                        <div class="product-name">${Product.productName}</div>
                        <div class="product-price"><fmt:formatNumber value="${Product.price}" type="currency"
                                                                     currencySymbol="VND"></fmt:formatNumber></div>
                        <div class="product-description" id="desc-${Product.productId}" style="display: none;">
                            <div>Mô tả: ${Product.description}</div>
                            <div class="product-quantity">Số lượng: ${Product.quantity}</div>
                            <form class="cart-form" action="/cart" method="post">
                                <input type="hidden" name="productId" value="${Product.productId}">
                                <label for="quantity-${Product.productId}">Số lượng:</label>
                                <input type="number" id="quantity-${Product.productId}" name="quantity" min="1"
                                       value="1" required>
                                <button type="submit" class="add-to-cart-btn">Thêm vào giỏ hàng</button>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
            </c:forEach>

    </form>
</div>

<footer>
    <p style="text-align: center">© 2024 Merry Christmas! All rights reserved. 🎄</p>
</footer>

</body>
</html>
