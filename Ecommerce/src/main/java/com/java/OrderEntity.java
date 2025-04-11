package com.java;
import java.time.LocalDateTime;
public class OrderEntity {
	    private int orderId;
	    private int customerId;
	    private LocalDateTime orderDate;
	    private double totalPrice;
	    private String shippingAddress;

	    public Order() {}

	    public Order(int orderId, int customerId, LocalDateTime orderDate, double totalPrice, String shippingAddress) {
	        this.orderId = orderId;
	        this.customerId = customerId;
	        this.orderDate = orderDate;
	        this.totalPrice = totalPrice;
	        this.shippingAddress = shippingAddress;
	    }

	    // Getters and Setters
	    public int getOrderId() {
	        return orderId;
	    }

	    public void setOrderId(int orderId) {
	        this.orderId = orderId;
	    }

	    public int getCustomerId() {
	        return customerId;
	    }

	    public void setCustomerId(int customerId) {
	        this.customerId = customerId;
	    }

	    public LocalDateTime getOrderDate() {
	        return orderDate;
	    }

	    public void setOrderDate(LocalDateTime orderDate) {
	        this.orderDate = orderDate;
	    }

	    public double getTotalPrice() {
	        return totalPrice;
	    }

	    public void setTotalPrice(double totalPrice) {
	        this.totalPrice = totalPrice;
	    }

	    public String getShippingAddress() {
	        return shippingAddress;
	    }

	    public void setShippingAddress(String shippingAddress) {
	        this.shippingAddress = shippingAddress;
	    }
	}
