<%@ page import="java.sql.*" %>
<%@ page import="java.util.*" %>
<%@ page import="org.example.petshop.ConnectJDBC" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Quản Lý Sản Phẩm</title>
    <link rel="stylesheet" href="CSS/Pet.css">
</head>
<body>
<header>
    <h1>Quản Lý Sản Phẩm</h1>
</header>
<div class="container">
    <a href="add_product.jsp"><button>Thêm Sản Phẩm</button></a>
    <table>
        <thead>
        <tr>
            <th>ID</th>
            <th>Tên Sản Phẩm</th>
            <th>Mô Tả</th>
            <th>Giá</th>
            <th>Số Lượng</th>
            <th>Hình Ảnh</th>
            <th>Hành Động</th>
        </tr>
        </thead>
        <tbody>
        <%
            Connection conn = ConnectJDBC.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Pet");

            while (rs.next()) {
        %>
        <tr>
            <td><%= rs.getInt("id") %></td>
            <td><%= rs.getString("name") %></td>
            <td><%= rs.getString("description") %></td>
            <td><%= rs.getDouble("price") %></td>
            <td><%= rs.getInt("quantity") %></td>
            <td><img src="<%= rs.getString("image_url") %>" alt="Image" width="50"></td>
            <td>
                <a href="edit_product.jsp?id=<%= rs.getInt("id") %>">Sửa</a> |
                <a href="delete_product.jsp?id=<%= rs.getInt("id") %>">Xóa</a>
            </td>
        </tr>
        <%
            }
            conn.close();
        %>
        </tbody>
    </table>
</div>
</body>
</html>
