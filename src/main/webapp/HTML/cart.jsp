<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Giỏ Hàng</title>
    <link rel="stylesheet" href="/CSS/User.css">
</head>
<body>
<h1>Giỏ Hàng</h1>
<table border="1">
    <thead>
    <tr>
        <th>Tên Sản Phẩm</th>
        <th>Hình ảnh</th>
        <th>Số Lượng</th>
        <th>Mô tả</th>
        <th>Giá</th>
        <th>Tổng</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="Product" items="${cart}">
        <tr>
            <td>${Product.productName}</td>
            <td><img src="${Product.image}" alt="Hình ảnh" width="150" height="150"></td>
            <td><input type="number" min="1" value="1" max="${Product.quantity}"></td>
            <td>${Product.description}</td>
            <td><fmt:formatNumber value="${Product.price}" type="currency" currencySymbol="VND"></fmt:formatNumber> </td>
            <td><fmt:formatNumber value="${Product.price * Product.quantity}" type="currency" currencySymbol="VND"></fmt:formatNumber> </td>
<%--            <td>--%>
<%--                <form action="/cart" method="post">--%>
<%--                    <input type="hidden" name="action" value="remove">--%>
<%--                    <input type="hidden" name="productId" value="${Product.productId}">--%>
<%--                    <button type="submit">Xóa</button>--%>
<%--                </form>--%>
<%--            </td>--%>
        </tr>
    </c:forEach>
    </tbody>
</table>
<h3>Tổng tiền: ${total} VND</h3>
<a href="/HTML/Userlist.jsp">Thanh Toán</a>
</body>
</html>
