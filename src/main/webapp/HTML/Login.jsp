<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css">
    <link rel="stylesheet" href="CSS/Style.css">
    <title>Mordern Login Page</title>
</head>
<body>

<div class="container" id="container">
    <div class="form-container sign-up">
        <form>
            <h1>Tạo tài khoản</h1>
            <input type="text" placeholder="Username">
            <input type="text" placeholder="PhoneNumber">
            <input type="email" placeholder="Email">
            <input type="text" placeholder="Address">
            <input type="password" placeholder="Password">
            <input type="password" placeholder="Confirm Password">
            <button>Đăng ký</button>
        </form>
    </div>
    <div class="form-container sign-in">
        <form>
            <h1>Đăng nhập</h1>
            <input type="text" placeholder="Username">
            <input type="password" placeholder="Password">
            <button>Đăng nhập</button>
        </form>
    </div>
    <div class="toggle-container">
        <div class="toggle">
            <div class="toggle-panel toggle-left">
                <h1>Đăng ký thôi nào!!</h1>
                <p>Nhớ nhập đầy đủ thông tin</p>
                <p> Và đừng để sót bạn nhé !!!</p>
                <button class="hidden" id="login">Đăng nhập</button>
            </div>
            <div class="toggle-panel toggle-right">
                <h1>PetShop xin chào</h1>
                <p>Bạn chưa có tài khoản ư ? </p>
                <p> Đừng lo chúng tôi có thể giúp bạn</p>
                <button class="hidden" id="register">Đăng ký</button>
            </div>
        </div>
    </div>
</div>

<script src="js.js"></script>
</body>
</html>