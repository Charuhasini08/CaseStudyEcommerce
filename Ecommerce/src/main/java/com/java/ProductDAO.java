package com.java;

import util.DBConnUtil;

import java.sql.*;

public class ProductDAO {
    private Connection conn;

    public ProductDAO(String configFile) {
        this.conn = DBConnUtil.getConnection(configFile);
    }

    public void addProduct(String name, String description, double price, int quantity) {
        String sql = "INSERT INTO products (name, description, price, quantity) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, name);
            stmt.setString(2, description);
            stmt.setDouble(3, price);
            stmt.setInt(4, quantity);
            stmt.executeUpdate();
            System.out.println("Product added.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteProduct(int id) {
        String sql = "DELETE FROM products WHERE id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            int rows = stmt.executeUpdate();
            System.out.println(rows > 0 ? "Product deleted." : "Product not found.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void listProducts() {
        String sql = "SELECT * FROM products";
        try (Statement stmt = conn.createStatement()) {
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                System.out.println(rs.getInt("id") + " | " + rs.getString("name") + 
                                   " | $" + rs.getDouble("price") + 
                                   " | Qty: " + rs.getInt("quantity"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
