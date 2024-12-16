package org.example.petshop;

import java.net.URI;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectJDBC {
    private static final String URL ="jdbc:mysql://localhost:3306/PetShop";
    private static final String USERNAME ="root";
    private static final String PASSWORD ="linhnhi234";
    public static Connection getConnection() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (ClassNotFoundException e) {
            throw new SQLException("Không thể tải lớp trình điều khiển JDBC", e);
        }

    }
}
