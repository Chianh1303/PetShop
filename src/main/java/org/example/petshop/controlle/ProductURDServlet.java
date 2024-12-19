package org.example.petshop.controlle;

import org.example.petshop.model.Product;
import org.example.petshop.service.UserService;
import org.example.petshop.service.UserServiceIpl;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/product")
public class ProductURDServlet extends HttpServlet {
    public static final UserService userService = new UserServiceIpl();

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");

        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "edit":
                editProductAction(req, resp);
                break;
            case "add":
                addUserAction(req, resp);
                break;
            default:
                resp.sendRedirect("HTML/HomeAdmin.jsp");
                break;
        }
    }
    private void editProductAction(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int productId = Integer.parseInt(req.getParameter("productId"));

        String productName = req.getParameter("productName");
        int quantity = Integer.parseInt(req.getParameter("quantity"));
        String description = req.getParameter("description");
        double price = Double.parseDouble(req.getParameter("price"));
        String image = req.getParameter("image");
        Product updatedProduct = new Product(productId, productName, quantity, description, price, image);
        boolean isUpdated = userService.updateProduct(updatedProduct);
        if (isUpdated) {
            resp.sendRedirect("/product?action=showEdit&id=productId" + productId);
        } else {
            req.setAttribute("error", "Không thể sửa sản phẩm.");
            req.setAttribute("product", updatedProduct);
            RequestDispatcher dispatcher = req.getRequestDispatcher("HTML/edit_product.jsp");
            dispatcher.forward(req, resp);
        }
    }
    private void addUserAction(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String productName = req.getParameter("productName");
        int quantity = Integer.parseInt(req.getParameter("quantity"));
        String description = req.getParameter("description");
        double price = Double.parseDouble(req.getParameter("price"));
        String image = req.getParameter("image");
        Product product = new Product(productName, quantity, description, price, image);
        userService.addUser(product);
        RequestDispatcher dispatcher = req.getRequestDispatcher("HTML/HomeAdmin.jsp");
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
            case "showEdit":
                showEditProduct(req, resp);
                break;
            case "edit":
                updateProduct(req, resp);
                break;
            default:
                resp.sendRedirect("HTML/HomeAdmin.jsp");
                break;
        }
    }
    private void showEditProduct(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int productId = Integer.parseInt(req.getParameter("productId"));
        Product product = userService.getUserById(productId);
        req.setAttribute("product", product);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/HTML/edit_product.jsp");
        dispatcher.forward(req, resp);
    }
    private void updateProduct(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
