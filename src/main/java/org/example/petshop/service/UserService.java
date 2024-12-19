package org.example.petshop.service;

import org.example.petshop.model.Product;
import org.example.petshop.model.User;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.util.List;

public interface UserService {
   User login(HttpServletRequest req, String email, String password);

   void register(User user);


   public void addUser(Product product);

   Product getUserById(int id);

    boolean updateProduct(Product updatedProduct);
}
