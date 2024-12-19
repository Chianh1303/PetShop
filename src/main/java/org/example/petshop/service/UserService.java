package org.example.petshop.service;

import org.example.petshop.model.Product;
import org.example.petshop.model.User;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface UserService {
   User login(HttpServletRequest req, String email, String password);
   List<Product> getProductList();
   void register(User user);

   public void updatePet(int productID, String productName, int quantity, String description, double price, String image);

}
