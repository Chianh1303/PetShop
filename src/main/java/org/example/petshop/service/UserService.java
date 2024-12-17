package org.example.petshop.service;

import org.example.petshop.model.User;

public interface UserService {
    boolean registerUser(User user); // Xử lý đăng ký người dùng
    boolean isEmailExist(String email); // Kiểm tra email đã tồn tại chưa
}
