
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Chỉnh sửa sản phẩm</title>
    <link rel="stylesheet" href="/CSS/edit.css">
</head>
<body>
<div class="snowflake">❄</div>
<div class="snowflake">❅</div>
<div class="snowflake">❆</div>
<div class="snowflake">❄</div>
<div class="snowflake">❅</div>
<div class="snowflake">❆</div>
<form action="/product?action=edit&productId=${product.productId}" method="post">
    <h1>Chỉnh sửa sản phẩm</h1>
    <div class="form-group">
        <label for="productName">Tên sản phẩm:</label>
        <input type="text" id="productName" name="productName" value="${product.productName}" required>
    </div>
    <div class="form-group">
        <label for="quantity">Số lượng:</label>
        <input type="number" id="quantity" name="quantity" required value="${product.quantity}">
    </div>
    <div class="form-group">
        <label for="description">Mô tả:</label>
        <input type="text" id="description" name="description" value="${product.description}">
    </div>
    <div class="form-group">
        <label for="price">Giá:</label>
        <input type="number" id="price" step="0.01" name="price" required value="${product.price}" max="10000000">
    </div>
    <div class="form-group">
        <label for="image">Ảnh URL:</label>
        <input type="text" id="image" name="image" value="${product.image}">
    </div>

    <button type="submit">Sửa</button>
</form>
</body>
</html>
