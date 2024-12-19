
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/product?action=edit&productId=${product.productId}"method="post">
    Tên sản phẩm: <input type="text" name="productName" value="${product.productName}" required><br>
    Số lượng: <input type="number" name="quantity" required value="${product.quantity}"><br>
    Mô tả: <textarea name="description"></textarea value="${product.description}"><br>
    Giá: <input type="number" step="0.01" name="price" required value="${product.price}"><br>
    Ảnh URL: <input type="text" name="image" value="${product.image}"><br>
    <button type="submit">Sửa</button>
</form>
</body>
</html>
