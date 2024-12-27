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

@WebServlet("/user")
public class UserServlet extends HttpServlet {

    private final UserService userService = new UserServiceIpl();
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");

        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "search":
                searchProductAction(req, resp);
                break;

        }
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) action = "default";
        switch (action) {
            case "showAll":
                showAllProductAction(req, resp);
                break;
            case "default":
                List<Product> foodList = userService.getAllProductItems();
                req.setAttribute("product", foodList);
                req.getRequestDispatcher("/HTML/Userlist.jsp").forward(req, resp);
                break;
        }
    }
    private void showAllProductAction(HttpServletRequest request, HttpServletResponse response) throws
            ServletException {
        try {
            List<Product> productList = userService.getAllProductItems();
            request.setAttribute("product", productList);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/HTML/Userlist.jsp");
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    private void searchProductAction(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String searchQuery = req.getParameter("searchQuery");
        List<Product> products = userService.searchProductsByName(searchQuery);
        System.out.println("Search query: " + searchQuery);

        if (products.isEmpty()) {
            req.setAttribute("message", "Không tìm thấy sản phẩm nào phù hợp!");
        }
        req.setAttribute("product", products);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/HTML/Userlist.jsp");
        dispatcher.forward(req, resp);

    }

}
