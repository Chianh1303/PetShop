<%@ page import="java.sql.*" %>
<%@ page import="org.example.petshop.ConnectJDBC" %>
<%
    if (request.getMethod().equalsIgnoreCase("POST")) {
        String name = request.getParameter("name");
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        String description = request.getParameter("description");
        double price = Double.parseDouble(request.getParameter("price"));
        String imageUrl = request.getParameter("image");

        Connection conn = ConnectJDBC.getConnection();
        PreparedStatement ps = conn.prepareStatement("INSERT INTO Pet (name, quantity, description,price, image) VALUES (?, ?, ?, ?, ?)");
        ps.setString(1, name);
        ps.setInt(2, quantity);
        ps.setString(3, description);
        ps.setDouble(4, price);
        ps.setString(5, imageUrl);
        ps.executeUpdate();
        conn.close();
        response.sendRedirect("index.jsp");
    }
%>
<!DOCTYPE html>
<html>
<head>
    <title>Thêm Sản Phẩm</title>
</head>
<body>
<h2>Thêm Sản Phẩm</h2>
<form method="POST">
    Tên sản phẩm: <input type="text" name="name" required><br>
    Số lượng: <input type="number" name="quantity" required><br>
    Mô tả: <textarea name="description"></textarea><br>
    Giá: <input type="number" step="0.01" name="price" required><br>
    Ảnh URL: <input type="text" name="image"><br>
    <button type="submit">Thêm</button>
</form>
</body>
</html>
