<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css">
    <link rel="stylesheet" href="/CSS/Style.css">
    <title>Mordern Login Page</title>
</head>
<body>

<div class="container" id="container">
    <div class="form-container sign-up">
        <form method="post" action="login">
            <h1>Tạo tài khoản</h1>
            <input type="text" name="userName" placeholder="Username" required pattern="^[a-zA-Z0-9]{3,10}$" title="Tên người dùng phải từ 3 đến 10 ký tự và chỉ chứa ký tự chữ và số.">
            <input type="text" name="phoneNumber" placeholder="PhoneNumber" required pattern="^0\d{9}$" title="Số điện thoại phải có độ dài 10 số và bắt đầu bằng s 0.">
            <input type="email" name="email" placeholder="Email" required pattern="^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$" title="Địa chỉ email không hợp lệ.">
            <input type="text" name="address" placeholder="Address" required>
            <input type="password" name="password" placeholder="Password" required >
            <input type="password" name="confirmPassword" placeholder="Confirm Password" required>
            <input type="hidden" name="action" value="register">
            <button>Đăng ký</button>
        </form>
    </div>

    <div class="form-container sign-in">
        <form method="post" action="login">
            <h1>Đăng nhập</h1>

            <input type="text" name="userName" placeholder="Username">

            <input type="password" name="password" placeholder="Password">
            <input type="hidden" name="action" value="login">
            <button type="submit">Đăng nhập</button>
        </form>

    </div>
    <div class="toggle-container">
        <div class="toggle">
            <div class="toggle-panel toggle-left">
                <h1>Đăng ký thôi nào!!</h1>
                <p>Nhớ nhập đầy đủ thông tin</p>
                <p>Và đừng để sót bạn nhé !!!</p>
                <button class="hidden" id="login">Đăng nhập</button>
            </div>
            <div class="toggle-panel toggle-right">
                <h1>PetShop xin chào</h1>
                <p>Bạn chưa có tài khoản ư ? </p>
                <p>Đừng lo chúng tôi có thể giúp bạn</p>
                <button class="hidden" id="register">Đăng ký</button>
            </div>
        </div>
    </div>
</div>

<script src="/JS/java.js"></script>
</body>
</html>