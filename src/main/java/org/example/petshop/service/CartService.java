package org.example.petshop.service;

import org.example.petshop.model.Product;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

public class CartService {
    private static final String CART_SESSION_KEY = "cart";
    public static List<Product> getCart(HttpSession session) {
        @SuppressWarnings("unchecked")
        List<Product> cart = (List<Product>) session.getAttribute(CART_SESSION_KEY);
        if (cart == null) {
            cart = new ArrayList<>();
            session.setAttribute(CART_SESSION_KEY, cart);
        }
        return cart;
    }
    public static void addToCart(HttpSession session, Product product) {
        List<Product> cart = getCart(session);
        cart.add(product);
        session.setAttribute(CART_SESSION_KEY, cart);
    }
    public double getTotalPrice(HttpSession session) {
        List<Product> cart = getCart(session);
        return cart.stream()
                .mapToDouble(product -> product.getPrice() * product.getQuantity())
                .sum();
    }

}
