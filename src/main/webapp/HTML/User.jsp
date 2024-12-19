<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Simple Sales Page</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            box-sizing: border-box;
        }

        header {
            background-color: #333;
            color: white;
            padding: 1rem 2rem;
            text-align: center;
        }

        .search-bar {
            margin: 1rem 0;
            text-align: center;
        }

        .search-bar input[type="text"] {
            width: 60%;
            padding: 0.5rem;
            border: 1px solid #ddd;
            border-radius: 4px;
        }

        .search-bar button {
            padding: 0.5rem 1rem;
            border: none;
            background-color: #007bff;
            color: white;
            border-radius: 4px;
            cursor: pointer;
        }

        .search-bar button:hover {
            background-color: #0056b3;
        }

        .container {
            max-width: 1200px;
            margin: 0 auto;
            padding: 2rem;
        }

        .cart {
            text-align: right;
            margin-bottom: 1rem;
        }

        .cart button {
            background-color: #ffc107;
            color: black;
            border: none;
            padding: 0.5rem 1rem;
            border-radius: 4px;
            cursor: pointer;
        }

        .cart button:hover {
            background-color: #e0a800;
        }

        .products {
            display: flex;
            flex-wrap: wrap;
            gap: 2rem;
            justify-content: center;
        }

        .product {
            border: 1px solid #ddd;
            border-radius: 8px;
            padding: 1rem;
            text-align: center;
            width: calc(33.333% - 2rem);
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
        }

        .product img {
            max-width: 100%;
            height: auto;
            border-radius: 8px;
        }

        .product h3 {
            margin: 0.5rem 0;
        }

        .product p {
            color: #555;
        }

        .product button {
            background-color: #28a745;
            color: white;
            border: none;
            padding: 0.5rem 1rem;
            border-radius: 4px;
            cursor: pointer;
        }

        .product button:hover {
            background-color: #218838;
        }

        footer {
            background-color: #f8f9fa;
            text-align: center;
            padding: 1rem;
            border-top: 1px solid #ddd;
            margin-top: 2rem;
        }
    </style>
</head>
<body>
<header>
    <h1>Simple Sales Page</h1>
</header>

<div class="search-bar">
    <input type="text" placeholder="Search for products...">
    <button>Search</button>
</div>

<div class="container">
    <div class="cart">
        <button>View Cart</button>
    </div>

    <div class="products">
        <c:forEach var="product" items="${products}">
            <div class="product">
                <img src="${product.imageUrl}" alt="${product.name}">
                <h3>${product.name}</h3>
                <p>${product.price}</p>
                <button>Add to Cart</button>
            </div>
        </c:forEach>
    </div>
    </div>
</div>

<footer>
    <p>&copy; 2024 Simple Sales Page. All rights reserved.</p>
</footer>
</body>
</html>
