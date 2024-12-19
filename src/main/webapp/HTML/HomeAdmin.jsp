
<%@ page import="java.sql.*" %>
<%@ page import="org.example.petshop.ConnectJDBC" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Quản Lý Sản Phẩm</title>
    <link rel="stylesheet" href="CSS/Admin.css">
</head>
<body>
<header>
    <h1>Trang Chủ Admin</h1>
    <nav>
        <a href="index.jsp">Quản Lý Sản Phẩm</a>
        <a href="HTML/add_product.jsp">Thêm Sản Phẩm</a>
        <a href="HTML/Login.jsp">Logout</a>
    </nav>
</header>

<div class="container">
    <h2>Danh Sách Sản Phẩm</h2>
    <table>
        <thead>
        <tr>
            <th>ID</th>
            <th>Tên Sản Phẩm</th>
            <th>Mô Tả</th>
            <th>Giá</th>
            <th>Số Lượng</th>
            <th>Hình Ảnh</th>
            <th>Hành động</th>
        </tr>
        </thead>
        <tbody>
        <%
            try {
                Connection conn = ConnectJDBC.getConnection();
                if (conn != null) {
                    Statement stmt = conn.createStatement();
                    ResultSet rs = stmt.executeQuery("SELECT * FROM Pet");

                    while (rs.next()) {
        %>
        <tr>
            <td><%= rs.getInt("productId") %>
            </td>
            <td><%= rs.getString("productName") != null ? rs.getString("productName") : "N/A" %>
            </td>

            <td><%= rs.getInt("quantity") %></td>
            <td><%= rs.getString("description") != null ? rs.getString("description") : "N/A" %>
            <td >
                <%
                    double price = rs.getDouble("price");
                    if (!rs.wasNull()) { %>
                <%= price %>00VND
                <% } else { %>
                N/A
                <% } %>
            </td>
            </td>
            <td>
                <img src="<%= rs.getString("image") != null ? rs.getString("image") : "no_image.jpg" %>"
                     alt="Hình ảnh" width="50" height="50">
            </td>
            <td>
                <form action="/product?action=showEdit&id=${product.productId}" method="post" style="display:inline;">
                    <input type="hidden" name="productId" value="<%= rs.getInt("productId") %>">
                    <button type="submit"
                            style="background-color: #ffc107; color: white; border: none; padding: 5px 10px; cursor: pointer;">
                        Sửa
                    </button>
                </form>
                <form action="delete_product.jsp" method="post" style="display:inline;">
                    <input type="hidden" name="productId" value="<%= rs.getInt("productId") %>">
                    <button type="submit"
                            style="background-color: #dc3545; color: white; border: none; padding: 5px 10px; cursor: pointer;">
                        Xoá
                    </button>
                </form>
            </td>
        </tr>
        <%
                    }
                    conn.close();
                } else {
                    System.out.println("không thể kết nối");
                }
            } catch (Exception e) {
                e.printStackTrace();

                System.out.println("có lỗi: " + e.getMessage() + "</td></tr>");
            }
        %>
        </tbody>
    </table>
</div>

</body>
</html>
