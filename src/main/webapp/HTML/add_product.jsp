<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Thêm Sản Phẩm</title>
    <link rel="stylesheet" type="text/css" href="CSS/Add.css">
</head>
<body>
<div>
    <h2>Thêm Sản Phẩm</h2>
    <form action="/product?action=add" method="post">
        Tên sản phẩm: <input type="text" name="productName" required><br>
        Số lượng: <input type="number" name="quantity" required><br>
        Mô tả: <textarea name="description"></textarea><br>
        Giá: <input type="number" step="0.01" name="price" required><br>
        Ảnh URL: <input type="text" name="image"><br>
        <button type="submit">Thêm</button>
    </form>
</div>
</body>
</html>
