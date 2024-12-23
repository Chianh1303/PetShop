<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Thêm Sản Phẩm</title>
    <link rel="stylesheet" type="text/css" href="/CSS/Add.css">
</head>
<body>
<div class="container">
    <h2>Thêm Sản Phẩm</h2>
    <form action="/product?action=add" method="post" class="form-add-product">
        <div class="form-group">
            <label for="productName">Tên sản phẩm:</label>
            <input type="text" id="productName" name="productName" required>
        </div>
        <div class="form-group">
            <label for="quantity">Số lượng:</label>
            <input type="number" id="quantity" name="quantity" required>
        </div>
        <div class="form-group">
            <label for="description">Mô tả:</label>
            <input id="description" name="description">
        </div>
        <div class="form-group">
            <label for="price">Giá:</label>
            <input type="number" id="price" step="0.01" name="price" required>
        </div>
        <div class="form-group">
            <label for="image">Ảnh URL:</label>
            <input type="text" id="image" name="image">
        </div>
        <button type="submit" class="btn-submit">Thêm</button>
    </form>
</div>
</body>
</html>
