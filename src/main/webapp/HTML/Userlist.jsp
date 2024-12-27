<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ page import="org.example.petshop.model.Product" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>PetShop</title>
    <link rel="stylesheet" href="/CSS/User.css">
    <script src="/JS/java.js"></script>
</head>

<body>
<header>
    <h1 class="title">🎅 Pet Shop 🎄</h1>
    <nav class="main-nav">
        <a href="/user" class="nav-link">🏠 Home</a>
        <a href="/HTML/cart.jsp" class="nav-link icon-cart">🛒 Giỏ hàng</a>
        <a href="/HTML/Login.jsp" class="nav-link logout-btn">🚪 Đăng xuất</a>
    </nav>
</header>

    <div class="search-bar-container">
            <form method="post" action="/user?action=search" class="search-form">
                <input type="text" name="searchQuery" placeholder="Nhập tên sản phẩm..." required class="search-input">
                <button type="submit" class="search-button">🔍 Tìm kiếm</button>
            </form>
        </div>
<c:if test="${not empty message}">
    <p>${message}</p>
</c:if>
    <form method="get" >
        <h1 style="text-align: center">Danh sách sản phẩm</h1>
        <div class="product-container">
            <c:forEach var="Product" items="${product}">
                <div class="product-card">
                    <img style="width: 250px; height: 330px" src="${Product.image}" alt="${Product.productName}">
                    <div class="product-info">
                        <h3 class="product-name">${Product.productName}</h3>
                        <p class="product-price">
                            <fmt:formatNumber value="${Product.price}" type="currency" currencySymbol="VND"></fmt:formatNumber>
                        </p>

                        <form class="cart-form" action="/cart?action=add" method="post">
                            <input type="hidden" name="productId" value="${Product.productId}">

                            <input type="hidden" id="quantity-${Product.productId}" name="quantity" min="1" value="1" required>
                            <button style="text-align: center" type="submit" class="add-to-cart-btn">Thêm vào giỏ hàng</button>
                        </form>
                    </div>
                </div>
            </c:forEach>


        </div>
    </form>


<footer class="footer">
    <div class="footer-content">
        <div class="footer-section">
            <h4>Thông tin liên hệ</h4>
            <p>📧 Email: support@petshop.com</p>
            <p>📞 Hotline: 0123 456 789</p>
        </div>
        <div class="footer-section">
            <h4>Liên kết nhanh</h4>
            <a href="/user">🏠 Home</a>
            <a href="/HTML/cart.jsp">🛒 Giỏ hàng</a>
            <a href="#">⚙️ Cài đặt</a>
        </div>
    </div>
    <p style="text-align: center;">© 2024 Merry Christmas! All rights reserved. 🎄</p>
</footer>


</body>
</html>
