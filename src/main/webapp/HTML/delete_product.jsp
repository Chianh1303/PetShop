<%@ page import="java.sql.*" %>
<%@ page import="org.example.petshop.ConnectJDBC" %>
<%
    int id = Integer.parseInt(request.getParameter("id"));
    Connection conn = ConnectJDBC.getConnection();
    PreparedStatement ps = conn.prepareStatement("DELETE FROM Pet WHERE id = ?");
    ps.setInt(1, id);
    ps.executeUpdate();
    conn.close();
    response.sendRedirect("index.jsp");
%>
