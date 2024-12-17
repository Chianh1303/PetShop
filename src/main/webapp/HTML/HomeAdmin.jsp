
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Admin Dashboard</title>
    <link rel="stylesheet" href="CSS/Admin.css">
</head>
<body>
<!-- Header -->
<header class="header">
    <h1>Admin Dashboard</h1>
    <div class="logout">
        <a href="#">Đăng xuất</a>
    </div>
</header>

<!-- Sidebar -->
<aside class="sidebar">
    <nav>
        <ul>
            <li><a href="#">Trang chủ</a></li>
            <li><a href="#">Quản lý sản phẩm</a></li>
            <li><a href="#">Quản lý đơn hàng</a></li>
            <li><a href="#">Quản lý khách hàng</a></li>
            <li><a href="#">Thống kê doanh thu</a></li>
            <li><a href="#">Cài đặt</a></li>
        </ul>
    </nav>
</aside>

<!-- Main Content -->
<main class="main-content">
    <section class="dashboard-cards">
        <div class="card">
            <h3>Sản phẩm</h3>
            <p>120 sản phẩm</p>
        </div>
        <div class="card">
            <h3>Đơn hàng</h3>
            <p>45 đơn hàng mới</p>
        </div>
        <div class="card">
            <h3>Doanh thu</h3>
            <p>50,000,000 VND</p>
        </div>
        <div class="card">
            <h3>Khách hàng</h3>
            <p>30 khách hàng mới</p>
        </div>
    </section>
<%--sadkaldjadka--%>
    <section class="recent-orders">
        <h2>Đơn hàng gần đây</h2>
        <table>
            <thead>
            <tr>
                <th>ID</th>
                <th>Tên khách hàng</th>
                <th>Sản phẩm</th>
                <th>Ngày đặt</th>
                <th>Tổng tiền</th>
                <th>Trạng thái</th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <td>1</td>
                <td>Nguyễn Văn A</td>
                <td>Áo thun nam</td>
                <td>20/08/2024</td>
                <td>200,000 VND</td>
                <td>Đã xử lý</td>
            </tr>
            <tr>
                <td>2</td>
                <td>Trần Thị B</td>
                <td>Giày thể thao</td>
                <td>21/08/2024</td>
                <td>1,500,000 VND</td>
                <td>Chưa xử lý</td>
            </tr>
            </tbody>
        </table>
    </section>
</main>

<!-- Footer -->
<footer class="footer">
    <p>&copy; 2024 Admin Website Bán Hàng</p>
</footer>
</body>
</html>

