package org.example.petshop.controlle;

import org.example.petshop.model.Product;
import org.example.petshop.service.CartService;
import org.example.petshop.service.UserService;
import org.example.petshop.service.UserServiceIpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/cart")
public class CartServlet extends HttpServlet {
    private final CartService cartService = new CartService();
    private final UserService userService = new UserServiceIpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");

        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action.trim().toLowerCase()) {
            case "add":
                addToCart(req, resp);
                break;
            default:
                showCart(req, resp);
                break;
        }
    }

    private void showAllProductAction(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            List<Product> products = userService.getAllProducts();
            req.setAttribute("products", products);
            RequestDispatcher dispatcher = req.getRequestDispatcher("/HTML/cart.jsp");
            dispatcher.forward(req, resp);
        } catch (Exception e) {
            e.printStackTrace();
            req.setAttribute("error", "Không thể tải sản phẩm.");
            req.getRequestDispatcher("/HTML/error.jsp").forward(req, resp);
        }
    }

    private void showCart(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Product> cart = CartService.getCart(req.getSession());
        req.setAttribute("cart", cart);
        req.setAttribute("totalPrice", cartService.getTotalPrice(req.getSession()));
        req.getRequestDispatcher("/HTML/cart.jsp").forward(req, resp);
    }

    private void addToCart(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            int productId = Integer.parseInt(req.getParameter("productId"));



            Product product = userService.getUserById(productId);
            CartService.addToCart(req.getSession(), product);
            showCart(req, resp);
            resp.sendRedirect(req.getContextPath() + "/cart");
        } catch (NumberFormatException e) {
            req.setAttribute("error", "Dữ liệu nhập không hợp lệ.");
            req.getRequestDispatcher("/HTML/error.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");

        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            default:
                showAllProductAction(req, resp);
                break;
        }
    }


}
