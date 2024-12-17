package org.example.petshop.service;

import org.example.petshop.model.User;

import javax.servlet.http.HttpServletRequest;

public interface UserService {
   User login(HttpServletRequest req, String email, String password);

   void register(User user);

}
