<%--@elvariable id="Pet" type="org.example.petshop.model.Product"--%>
<%@ page import="org.example.petshop.model.Product" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    Product product = (Product) request.getAttribute("product");
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Sửa Sản Phẩm</title>
    <link rel="stylesheet" href="CSS/Admin.css">
</head>
<body>
<h1>Sửa Sản Phẩm</h1>
<form action="/login" method="post">
    <input type="hidden" name="action" value="updatePet">
    <label for="productName">Tên Sản Phẩm:</label>
    <input type="text" id="productName" name="productName" value="${Pet.productName} " required><br>

    <label for="description">Mô Tả:</label>
    <textarea id="description" name="description" required>${Pet.description}</textarea><br>

    <label for="price">Giá:</label>
    <input type="number" id="price" name="price" value="${Pet.price}" step="0.01" required><br>

    <label for="quantity">Số Lượng:</label>
    <input type="number" id="quantity" name="quantity" value="${Pet.quantity}" required><br>

    <label for="image">Hình Ảnh URL:</label>
    <input type="text" id="image" name="image" value="${Pet.image}" required><br>

    <button type="submit">Cập Nhật</button>

</form>
</body>
</html>
