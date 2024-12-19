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

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");
        String action = req.getParameter("action");
        if (action == null) {
            switch (action) {
                case "logout":
                    HttpSession session = req.getSession();
                    session.invalidate();

                    RequestDispatcher dispatcher = req.getRequestDispatcher("HTML/Login.jsp");
                    dispatcher.forward(req, resp);

                    break;
                default:
                    getProductList(req, resp);
                    break;
            }
        }
    }
    private void getProductList(HttpServletRequest request, HttpServletResponse response) {
        List<Product> products = this.userService.getProductList();
        request.setAttribute("products", products);

        RequestDispatcher dispatcher = request.getRequestDispatcher("HTML/User.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

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
            case "updatePet":
                updatePetAction(req, resp);
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

            RequestDispatcher dispatcher = req.getRequestDispatcher("HTML/Login.jsp");
            dispatcher.forward(req, resp);

        } else {
            System.out.println(user);
            session.setAttribute("user", user);
            System.out.println(user.getRole());
            switch (user.getRole()) {
                case "Admin":
                    req.getRequestDispatcher("HTML/HomeAdmin.jsp").forward(req, resp);
                    break;
                case "User":

                    req.getRequestDispatcher("HTML//HomeUser.jsp").forward(req, resp);

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
        String state = "Active";
        String role = "User";
        User user = new User(userName, password, state, email, phoneNumber, address, role);
        userService.register(user);
        RequestDispatcher dispatcher = req.getRequestDispatcher("HTML/Login.jsp");
        dispatcher.forward(req, resp);

    }


    private void updatePetAction(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        try {
            HttpSession session = req.getSession();
            Integer productID = (Integer) session.getAttribute("productID");

            if (productID == null) {
                throw new IllegalArgumentException("Product ID is missing from session.");
            }

            String productName = req.getParameter("productName");
            int quantity = Integer.parseInt(req.getParameter("quantity"));
            String description = req.getParameter("description");
            double price = Double.parseDouble(req.getParameter("price"));
            String image = req.getParameter("image");

            userService.updatePet(productID, productName, quantity, description, price, image);

            resp.sendRedirect(req.getContextPath() + "/HTML/HomeAdmin.jsp");
        } catch (Exception e) {
            e.printStackTrace();
            resp.sendRedirect(req.getContextPath() + "/HTML/errorUpadate.jsp");
        }
    }


}

