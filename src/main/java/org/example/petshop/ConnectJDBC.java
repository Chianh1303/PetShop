package org.example.petshop;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ConnectJDBC {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/PetShop";
        String username = "root";
        String password = "root@123";

        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            System.out.println("Kết nối thành công!");

            connection.close();
        } catch (SQLException e) {
            System.out.println("Lỗi kết nối: " + e.getMessage());
        }
    }

    public PreparedStatement prepareStatement(String sql) {
        return null;
    }
}
