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
import java.util.List;

@WebServlet("/product")
public class ProductURDServlet extends HttpServlet {
    public static final UserService userService = new UserServiceIpl();

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");

        String action = req.getParameter("action");
        System.out.println(action + 1111);
        if (action == null) {
            action = " ";
        }
        switch (action) {

            case "edit":
                editProductAction(req, resp);
                break;
            case "add":
                addUserAction(req, resp);
                break;
        }
    }

    private void showAllUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            List<Product> products = userService.getAllProducts();
            req.setAttribute("products", products);
            RequestDispatcher dispatcher = req.getRequestDispatcher("/HTML/HomeAdmin.jsp");
            dispatcher.forward(req, resp);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private void editProductAction(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int productId = Integer.parseInt(req.getParameter("productId"));
        String productName = req.getParameter("productName");
        int quantity = Integer.parseInt(req.getParameter("quantity"));
        String description = req.getParameter("description");
        double price = Double.parseDouble(req.getParameter("price"));
        String image = req.getParameter("image");
        System.out.println("id  " + productId + "    tên   " + productName + "mô tả" + description + price + image);
        Product updatedProduct = new Product(productId, productName, quantity, description, price, image);
        userService.updateProduct(updatedProduct);
        showAllUser(req, resp);
    }

    private void addUserAction(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String productName = req.getParameter("productName");
        int quantity = Integer.parseInt(req.getParameter("quantity"));
        String description = req.getParameter("description");
        double price = Double.parseDouble(req.getParameter("price"));
        String image = req.getParameter("image");
        Product product = new Product(productName, quantity, description, price, image);
        userService.addUser(product);
        showAllUser(req,resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");
        String action = req.getParameter("action");
        System.out.println(action + 1111);

        if (action == null) {
            action = "";
        }
//        if (req.getSession(false) != null) {
//            req.getSession().invalidate();
//        }

        switch (action) {
            case "showAll":
                showAllProductAction(req, resp);
                break;
            case "showEdit":
                showEditProduct(req, resp);
                break;
            default:
                showAllUser(req, resp);
                break;
        }
    }
    private void showAllProductAction(HttpServletRequest request, HttpServletResponse response) throws
            ServletException {
        try {
            List<Product> foodList = userService.getAllProductItems();
            request.setAttribute("product", foodList);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/HTML/Userlist.jsp");
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    private void showEditProduct(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int productId = Integer.parseInt(req.getParameter("productID"));
        System.out.println(productId);
        Product product = userService.getUserById(productId);
        req.setAttribute("product", product);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/HTML/edit_product.jsp");
        dispatcher.forward(req, resp);
    }

}
