package org.example.petshop.service;

import org.example.petshop.ConnectJDBC;
import org.example.petshop.model.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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




}



