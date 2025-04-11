package com.java;
import dao.*;

class EcommerceTest {
    OrderProcessorRepository repo = new OrderProcessorRepositoryImpl();

    @Test
    void testCreateProduct() {
        Product p = new Product(1, "Laptop", 50000, "Gaming", 10);
        assertTrue(repo.createProduct(p));
    }

    @Test
    void testAddToCart() {
        Customer c = new Customer(1, "John", "john@example.com", "1234");
        Product p = new Product(2, "Mouse", 500, "Wireless", 100);
        repo.createCustomer(c);
        repo.createProduct(p);
        assertTrue(repo.addToCart(c, p, 1));
    }

    @Test
    void testPlaceOrder() {
        // Setup...
        Customer c = new Customer(1, "John", "john@example.com", "1234");
        Map<Product, Integer> productMap = new HashMap<>();
        Product p = new Product(3, "Keyboard", 1500, "Mechanical", 20);
        productMap.put(p, 1);
        List<Map<Product, Integer>> productsList = new ArrayList<>();
        productsList.add(productMap);
        assertTrue(repo.placeOrder(c, productsList, "123 Street"));
    }

    @Test
    void testCustomerNotFoundException() {
        Exception exception = assertThrows(CustomerNotFoundException.class, () -> {
            repo.getOrdersByCustomer(999);
        });
        assertEquals("Customer ID not found!", exception.getMessage());
    }
}
