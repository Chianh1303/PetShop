package org.example.petshop.service;

import org.example.petshop.ConnectJDBC;
import org.example.petshop.model.Product;
import org.example.petshop.model.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class UserServiceIpl implements UserService {
    @Override
    public User login(HttpServletRequest req, String userName, String password) {
        String query = "SELECT * FROM user WHERE LOWER(userName) = LOWER(?) AND password = ?";
        try (Connection connection = ConnectJDBC.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, userName);
            preparedStatement.setString(2, password);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                int userID = rs.getInt("userID");
                String username = rs.getString("userName");
                String role = rs.getString("role");
                String address = rs.getString("address");
                String phoneNumber = rs.getString("phoneNumber");
                String state = rs.getString("state");
                String email = rs.getString("email");
                User user = new User(userID, username, password, state, phoneNumber, email, address, role);
                HttpSession session = req.getSession(true);
                session.setAttribute("loggedInUser", user);
                switch (role) {
                    case "admin":
                        session.setAttribute("Admin", true);
                        break;
                    case "user":
                        session.setAttribute("User", true);
                        break;
                }
                return user;
            }
            return null;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    @Override
    public void register(User user) {
        String query = "INSERT INTO user (userName, password,state, email, phoneNumber, address, role) values (?,?,?,?,?,?,?)";
        try (Connection conn = ConnectJDBC.getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(query);) {
            preparedStatement.setString(1, user.getUserName());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setString(3, user.getState());
            preparedStatement.setString(4, user.getPhoneNumber());
            preparedStatement.setString(5, user.getEmail());
            preparedStatement.setString(6, user.getAddress());
            preparedStatement.setString(7, user.getRole());
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void addProductToCart(Product product) {
        String sql = "insert into Cart (productId, productName, quantity, description ,price, image) value (?,?,?,?,?,?)";
        try {
            Connection connection = ConnectJDBC.getConnection();
            PreparedStatement pstm = connection.prepareStatement(sql);
            pstm.setInt(1, product.getProductId());
            pstm.setString(2, product.getProductName());
            pstm.setInt(3, product.getQuantity());
            pstm.setString(4, product.getDescription());
            pstm.setDouble(5, product.getPrice());
            pstm.setString(6, product.getImage());
            pstm.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
    @Override
    public void addUser(Product product) {
        String sql = "insert into pet (productName, quantity, description ,price, image) value (?,?,?,?,?)";
        try {
            Connection connection = ConnectJDBC.getConnection();
            PreparedStatement pstm = connection.prepareStatement(sql);
            pstm.setString(1, product.getProductName());
            pstm.setInt(2, product.getQuantity());
            pstm.setString(3, product.getDescription());
            pstm.setDouble(4, product.getPrice());
            pstm.setString(5, product.getImage());
            pstm.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public Product getUserById(int productId) {
        String sql = "select * from pet where productId = ?";
        Product product = null;
        try {
            Connection connection = ConnectJDBC.getConnection();
            PreparedStatement pstm = connection.prepareStatement(sql);
            pstm.setInt(1, productId);
            try {
                ResultSet rs = pstm.executeQuery();
                {
                    if (rs.next()) {
                        String productName = rs.getString("productName");
                        int quantity = rs.getInt("quantity");
                        String description = rs.getString("description");
                        double price = rs.getDouble("price");
                        String image = rs.getString("image");
                        product = new Product(productId,productName, quantity, description, price, image);
                    }
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return product;
    }

    @Override
    public void updateProduct(Product product) {
        String sql = "UPDATE pet SET productName = ?, quantity = ?, description = ?, price = ?, image = ? WHERE productId = ?";
        try (Connection connection = ConnectJDBC.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, product.getProductName());
            pstmt.setInt(2, product.getQuantity());
            pstmt.setString(3, product.getDescription());
            pstmt.setDouble(4, product.getPrice());
            pstmt.setString(5, product.getImage());
            pstmt.setInt(6, product.getProductId());
            pstmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public List<Product> getAllProducts() {
        List<Product> products = new ArrayList<>();
        try (Connection conn = ConnectJDBC.getConnection()) {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Pet");
            while (rs.next()) {
                int productId = rs.getInt("productId");
                String productName = rs.getString("productName");
                int quantity = rs.getInt("quantity");
                String description = rs.getString("description");
                double price = rs.getDouble("price");
                String image = rs.getString("image");
                Product product = new Product(productId, productName, quantity, description, price, image);
                products.add(product);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return products;
    }
    public List<Product> getAllProductItems() {
        List<Product> productList = new ArrayList<>();
        String query = "SELECT * FROM Pet";

        try (Connection conn = ConnectJDBC.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet resultSet = stmt.executeQuery(query)) {

            while (resultSet.next()) {
                int productId = resultSet.getInt("productId");
                String productName = resultSet.getString("productName");
                String description = resultSet.getString("description");
                int quantity = resultSet.getInt("quantity");
                double price = resultSet.getDouble("price");
                String image = resultSet.getString("image");
                System.out.println("productId: " + productId + ", productName: " + productName + ", quantity: " + quantity + ", description: " + description + ", price: " + price + ", image: " + image);
                Product product = new Product(productId, productName, quantity, description, price, image);

                productList.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return productList;
    }
    public List<Product> searchProductsByName(String name) {
    List<Product> productList = new ArrayList<>();
    String query = "SELECT * FROM Pet WHERE productName LIKE ?";

    try (Connection conn = ConnectJDBC.getConnection();
    PreparedStatement stmt = conn.prepareStatement(query)) {

        stmt.setString(1, "%" + name + "%");
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            int productId = rs.getInt("productId");
            String productName = rs.getString("productName");
            String description = rs.getString("description");
            int quantity = rs.getInt("quantity");
            double price = rs.getDouble("price");
            String image = rs.getString("image");
            System.out.println("productId: " + productId + ", productName: " + productName + ", quantity: " + quantity + ", description: " + description + ", price: " + price + ", image: " + image);
            Product product = new Product(productId, productName, quantity, description, price, image);

            productList.add(product);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }

    return productList;
}
}
