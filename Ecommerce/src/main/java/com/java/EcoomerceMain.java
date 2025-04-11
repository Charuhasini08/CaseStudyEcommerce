package com.java;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EcoomerceMain {

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Project","root","Charu@0822");
			//System.out.println("Connected...");
			String cmd = "Select * from customers";
			PreparedStatement pst = connection.prepareStatement(cmd);
			ResultSet rs=pst.executeQuery();
			while(rs.next())
			{
				System.out.println("Customer ID:"+rs.getInt("customer_id"));
				System.out.println("First Name:"+rs.getString("name"));
				System.out.println("Email:"+rs.getString("email"));
				System.out.println("Password:"+rs.getString("password"));
				System.out.println("------------------------------------------");
			}
			System.out.println("    ");
			System.out.println("           Product Details            ");
			System.out.println("    ");
			String cm = "Select * from products";
			PreparedStatement ps = connection.prepareStatement(cm);
			ResultSet r=ps.executeQuery();
			while(r.next())
			{
				
				System.out.println("Name:"+r.getString("name"));
				System.out.println("Price:"+r.getInt("price"));
				System.out.println("Description:"+r.getString("description"));
				System.out.println("Stock Quantity:"+r.getInt("stockQuantity"));
				System.out.println("------------------------------------------");
			}
			System.out.println("    ");
			System.out.println("           Cart Details            ");
			System.out.println("    ");
			String cmds = "Select * from cart";
			PreparedStatement psd = connection.prepareStatement(cmds);
			ResultSet rd=psd.executeQuery();
			while(rd.next())
			{
				
				System.out.println("Customer Id:"+rd.getInt("customer_id"));
				System.out.println("Product Id:"+rd.getInt("product_id"));
				System.out.println("Quantity:"+rd.getInt("quantity"));
				System.out.println("------------------------------------------");
			}
			System.out.println("    ");
			System.out.println("           Order item Details            ");
			System.out.println("    ");
			String cms = "Select * from order_items";
			PreparedStatement sd = connection.prepareStatement(cms);
			ResultSet d=sd.executeQuery();
			while(d.next())
			{
				
				System.out.println("Order Id:"+d.getInt("order_id"));
				System.out.println("Product Id:"+d.getInt("product_id"));
				System.out.println("Quantity:"+d.getInt("quantity"));
				System.out.println("------------------------------------------");
			}
			System.out.println("    ");
			System.out.println("           Orders Details            ");
			System.out.println("    ");
			String cds = "Select * from orders";
			PreparedStatement pd = connection.prepareStatement(cds);
			ResultSet A=pd.executeQuery();
			while(A.next())
			{
				
				System.out.println("Customer Id:"+A.getInt("customer_id"));
				System.out.println("Order Date:"+A.getDate("order_date"));
				System.out.println("Total Price:"+A.getInt("total_price"));
				System.out.println("Shipping Address:"+A.getString("shipping_address"));
				System.out.println("------------------------------------------");
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
