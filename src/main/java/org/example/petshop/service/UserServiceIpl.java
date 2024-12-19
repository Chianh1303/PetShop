package org.example.petshop.service;

import org.example.petshop.ConnectJDBC;
import org.example.petshop.model.Product;
import org.example.petshop.model.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
        try(Connection conn = ConnectJDBC.getConnection();
            PreparedStatement preparedStatement = conn.prepareStatement(query);){
            preparedStatement.setString(1,user.getUserName());
            preparedStatement.setString(2,user.getPassword());
            preparedStatement.setString(3,user.getState());
            preparedStatement.setString(4,user.getPhoneNumber());
            preparedStatement.setString(5,user.getEmail());
            preparedStatement.setString(6,user.getAddress());
            preparedStatement.setString(7,user.getRole());
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
//    @Override
//    public void getPetById(int productID) {
//        String query = "SELECT * FROM Pet WHERE productID = ?";
//        try(Connection conn = ConnectJDBC.getConnection();
//            PreparedStatement preparedStatement = conn.prepareStatement(query);){
//            preparedStatement.setInt(1,productID);
//            ResultSet rs = preparedStatement.executeQuery();
//            while (rs.next()){
//                return new ;
//
//            }
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//
//    }


private static final String UPDATE_Pet_SQL = "UPDATE Pet SET productName = ?, quantity = ?, description = ?, price = ?, image = ? WHERE productID = ? ";
public void updatePet(int productID, String productName, int quantity, String description, double price, String image) {
    boolean rowUpdated;
    try (Connection connection = ConnectJDBC.getConnection();
         PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_Pet_SQL)) {
        preparedStatement.setString(1, productName);
        preparedStatement.setInt(2, quantity);
        preparedStatement.setString(3, description);
        preparedStatement.setDouble(4, price);
        preparedStatement.setString(5, image);
        preparedStatement.setInt(6, productID);
        rowUpdated = preparedStatement.executeUpdate() > 0;
    } catch (SQLException e) {
        throw new RuntimeException(e);
    }
}
    public List<Product> getProductList() {
        List<Product> productList = new ArrayList<>();
        String query = "SELECT * FROM product";
        try (Connection connection = ConnectJDBC.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int productID = rs.getInt("productID");
                String productName = rs.getString("productName");
                int quantity = rs.getInt("quantity");
                String description = rs.getString("description");
                double price = rs.getDouble("price");
                String image = rs.getString("image");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return productList;
    }
}



