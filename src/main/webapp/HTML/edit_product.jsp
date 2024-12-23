<jsp:useBean id="Pet" scope="request" type="org.example.petshop.model.Product"/>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/product?action=edit&productId=${Pet.productId}"method="post">
    Tên sản phẩm: <input type="text" name="productName" value="${Pet.productName}" required><br>
    Số lượng: <input type="number" name="quantity" required value="${Pet.quantity}"><br>
    Mô tả: <textarea name="description"></textarea value="${Pet.description}"><br>
    Giá: <input type="number" step="0.01" name="price" required value="${Pet.price}"><br>
    Ảnh URL: <input type="text" name="image" value="${Pet.image}"><br>
    <button type="submit">Sửa</button>
</form>
</body>
</html>
