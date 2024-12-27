<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="java.sql.*" %>
<%@ page import="org.example.petshop.ConnectJDBC" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Quản Lý Sản Phẩm</title>
    <link rel="stylesheet" href="/CSS/Admin.css">
</head>
<body>
<header>
    <h1>Trang Chủ Admin</h1>
    <div class="search-bar-containerAdmin">
        <form method="post" action="/product?action=search" class="search-formSearch">
            <input type="text" name="searchQuery" placeholder="Nhập tên sản phẩm..." required class="search-inputSearch">
            <button type="submit" class="search-buttonSearch">Tìm kiếm</button>
        </form>

    </div>
    <nav>

        <a href="index.jsp">Quản Lý Sản Phẩm</a>
        <a href="/HTML/add_product.jsp">Thêm Sản Phẩm</a>
        <a href="/product?action=logout">Logout</a>
    </nav>
</header>

<div class="container">
    <h2>Danh Sách Sản Phẩm</h2>
    <table border="1">
        <thead>
        <tr>
            <th>#</th>
            <th>Tên sản phẩm</th>
            <th>Mô tả</th>
            <th>Giá</th>
            <th>Số lượng</th>
            <th>Hình ảnh</th>
            <th>Hành động</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="product" items="${products}" varStatus="status">
            <tr>
                <td>${status.index+1}</td>
                <td>${product.productName}</td>
                <td>${product.description}</td>
                <td><fmt:formatNumber value="${product.price}" type="currency" currencySymbol="VND"></fmt:formatNumber></td>
                <td>
                    <c:choose>
                        <c:when test="${product.quantity == 0}">Hết hàng</c:when>
                        <c:otherwise>${product.quantity}</c:otherwise>
                    </c:choose>
                </td>
                <td><img src="${product.image}" alt="Hình ảnh" width="50" height="50"></td>
                <td>
                    <form method="post" style="display:inline;">
                        <input type="hidden" name="productId" value="${product.productId}">
                        <button type="submit" style="background-color: #ffc107; color: white; border: none; padding: 5px 10px; cursor: pointer;">
                            <a href="/product?action=showEdit&productID=${product.productId}" style="color: white; text-decoration: none;">Sửa</a>
                        </button>
                    </form>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
