package org.example.petshop.service;

import org.example.petshop.model.User;

public interface UserDao {
    boolean addUser(User user); // Thêm user vào cơ sở dữ liệu
    boolean checkEmailExists(String email);
}
