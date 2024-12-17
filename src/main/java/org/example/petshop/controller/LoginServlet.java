//package org.example.petshop.controller;
//
//import org.example.petshop.ConnectJDBC;
//import org.example.petshop.model.Login;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import java.io.IOException;
//
//@WebServlet(urlPatterns = "/login")
//public  class LoginServlet extends HttpServlet {
//@Override
//    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws ServletException, IOException {
//    request.getRequestDispatcher("/HTML/Login.jsp").forward(request, response);
//    response.setContentType("text/html; charset=UTF-8");
//
//    String username = request.getParameter("username");
//    String password = request.getParameter("password");
//   try{
//       Class.forName("com.mysql.cj.jdbc.Driver");
//       ConnectJDBC connectJDBC = new ConnectJDBC();
//    } catch (ClassNotFoundException e) {
//       throw new RuntimeException(e);
//   }
//
//}
//}
