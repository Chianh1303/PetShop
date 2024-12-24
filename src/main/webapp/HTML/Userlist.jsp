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
    <title>PetShop</title>
    <link rel="stylesheet" href="CSS/User.css">
</head>
<style>
    .product-container {
        display: flex;
        flex-wrap: wrap;
        gap: 20px;
        justify-content: center;
    }
    .product-card {
        width: 250px;
        background-color: #fff;
        border-radius: 10px;
        box-shadow: 0 2px 8px rgba(0, 0, 0, 0.1);
        text-align: center;
        transition: transform 0.3s;
    }
    .product-card:hover {
        transform: translateY(-5px);
    }
    .product-card img {
        width: 100%;
        border-radius: 10px 10px 0 0;
    }
    .product-info {
        padding: 15px;
    }
    .product-name {
        font-size: 1rem;
        font-weight: bold;
    }
    .product-price {
        color: #e74c3c;
        font-size: 1.2rem;
        font-weight: bold;
    }
    .product-description {
        font-size: 0.9rem;
        color: #555;
        margin-top: 10px;
        transition: all 0.3s ease;
    }


</style>
<body>
<header>
    <h1>🎅 Pet Shop 🎄</h1>
    <nav>
        <a href="#">Home</a>
        <a href="#">Profile</a>
        <a href="#">Settings</a>
        <a href="/HTML/Login.jsp" class="logout-btn">Logout</a>
    </nav>
</header>

    <div class="search-bar-container">
    <form method="post" action="/product?action=search" class="search-form">
        <input type="text" name="searchQuery" placeholder="Nhập tên sản phẩm..." required class="search-input">
        <button type="submit" class="search-button">Tìm kiếm</button>
    </form>
</div>
<c:if test="${not empty message}">
    <p>${message}</p>
</c:if>

<div>
    <form method="get">
        <h1 style="text-align: center">Danh sách sản phẩm</h1>
        <div class="product-container">
            <c:forEach var="Product" items="${product}">
                <div class="product-card" onclick="toggleDescription('${Product.productId}')">
                <div class="product-card">
                <img style="width: 250px;height: 280px" src="${Product.image}" alt="${Product.productName}">
                <div class="product-info">
                    <div class="product-name">${Product.productName}</div>
                    <div class="product-price">${Product.price}vnđ</div>
                    <div class="product-description" id="desc-${Product.productId}" style="display: none;">
                            ${Product.description}
                </div>
                </div>
            </div>
            </div>
            </c:forEach>

    </form>
</div>

<footer>
    <p>© 2024 Merry Christmas! All rights reserved. 🎄</p>
</footer>
<script src="User.js"></script>

</body>
</html>
