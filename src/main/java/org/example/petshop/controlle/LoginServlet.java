package org.example.petshop.controlle;

import org.example.petshop.model.Product;
import org.example.petshop.model.User;
import org.example.petshop.service.UserService;
import org.example.petshop.service.UserServiceIpl;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private final UserService userService = new UserServiceIpl();
    private HttpServletRequest req;
    private HttpServletResponse resp;

//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        req.setCharacterEncoding("UTF-8");
//        resp.setCharacterEncoding("UTF-8");
//        resp.setContentType("text/html; charset=UTF-8");
//        req.setCharacterEncoding("UTF-8");
//        resp.setCharacterEncoding("UTF-8");
//        resp.setContentType("text/html; charset=UTF-8");
//        String action = req.getParameter("action");
//        if (action == null)
//            action = "";
//
//
//        switch (action) {
//            case "logout":
//                RequestDispatcher dispatcher = req.getRequestDispatcher("HTML/Login.jsp");
//                dispatcher.forward(req, resp);
//                break;
//        }
//    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");
        String action = req.getParameter("action");
        if (action == null) action = "default";
        switch (action) {
            case "login":
                loginAction(req, resp);
                break;
            case "register":
                registerAction(req, resp);
                break;

            default:
                RequestDispatcher dispatcher = req.getRequestDispatcher("HTML/Login.jsp");
                dispatcher.forward(req, resp);
                break;
        }
    }

    public final static UserService userService1 = new UserServiceIpl();

    private void loginAction(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userName = req.getParameter("userName");
        String password = req.getParameter("password");
        User user = userService.login(req, userName, password);
        System.out.println(user);
        HttpSession session = req.getSession();
        if (user == null) {
            session.setAttribute("errorMessage", "Sai mật khẩu hoặc tài khoản không tồn tại.");
            RequestDispatcher dispatcher = req.getRequestDispatcher("/HTML/Login.jsp");
            dispatcher.forward(req, resp);
        } else {
            System.out.println(user);
            session.setAttribute("user", user);
            System.out.println(user.getRole());
            switch (user.getRole()) {
                case "Admin":
                    resp.sendRedirect("/product");
                    break;
                case "User":
                    resp.sendRedirect("/user");
                    break;
            }
        }
    }

    private void registerAction(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String userName = req.getParameter("userName");
        String password = req.getParameter("password");
        String phoneNumber = req.getParameter("phoneNumber");
        String email = req.getParameter("email");
        String address = req.getParameter("address");

        if (!userName.matches("^[a-zA-Z0-9]{3,20}$")) {
            req.setAttribute("errorMessage", "Tên người dùng phải từ 3 đến 10 ký tự và chỉ chứa ký tự chữ và số.");
            forwardToRegisterPage(req, resp);
            return;
        }
        if (!phoneNumber.matches("^0\\d{9}$")) {
            req.setAttribute("errorMessage", "Số điện thoại phải có 10 số và bắt đầu bằng số 0.");
            forwardToRegisterPage(req, resp);
            return;
        }
        if (!email.matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$")) {
            req.setAttribute("errorMessage", "Địa chỉ email không hợp lệ.");
            forwardToRegisterPage(req, resp);
            return;
        }
        if (!password.matches("^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$")) {
            req.setAttribute("errorMessage", "Mật khẩu phải có ít nhất 8 ký tự, chứa ít nhất một chữ cái và một số.");
            forwardToRegisterPage(req, resp);
            return;
        }
        if (address == null || address.isEmpty()) {
            req.setAttribute("errorMessage", "Vui lòng nhập địa chỉ.");
            forwardToRegisterPage(req, resp);
            return;
        }

        String state = "Active";
        String role = "User";
        User user = new User(userName, password, state, email, phoneNumber, address, role);

        try {
            if (userService.isUserExists(userName, email)) {
                req.setAttribute("errorMessage", "Tên người dùng hoặc email đã tồn tại.");
                forwardToRegisterPage(req, resp);
                return;
            }

            userService.register(user);
            req.setAttribute("successMessage", "Đăng ký thành công. Vui lòng đăng nhập.");
            RequestDispatcher dispatcher = req.getRequestDispatcher("HTML/Login.jsp");
            dispatcher.forward(req, resp);
        } catch (Exception e) {
            req.setAttribute("errorMessage", "Có lỗi xảy ra. Vui lòng thử lại sau.");
            forwardToRegisterPage(req, resp);
        }
    }

    private void forwardToRegisterPage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("HTML/register.jsp");
        dispatcher.forward(req, resp);
    }

}

