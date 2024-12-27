<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% Object product; %><%--
  Created by IntelliJ IDEA.
  User: macbook
  Date: 27/12/24
  Time: 10:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="/CSS/User.css">
</head>
<body>
<form action="/cart?action=infor&productId=${product.productId}" method="post">
    <img src="${product.image}" alt="hinhanh">
    <p>${product.productName}</p>
    <p>${product.description}</p>
    <p>${product.price}</p>
    <button>Add to cart</button>
</form>

</body>
</html>
