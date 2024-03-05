package com.ecommerce;

import com.ecommerce.Entity.Order;
import com.ecommerce.Entity.Product;
import com.ecommerce.Service.AuthenticationService;
import com.ecommerce.Service.OrderProcessingService;
import com.ecommerce.Service.ProductManagementService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

public class TaskApplication {

	public static void main(String[] args) {
		// Instantiate services
		AuthenticationService authService = new AuthenticationService();
		ProductManagementService productService = new ProductManagementService();
		OrderProcessingService orderService = new OrderProcessingService();

		// Register a user
		authService.registerUser("user1", "password");

		// Authenticate the user
		boolean isAuthenticated = authService.authenticateUser("user1", "password");
		System.out.println("User authenticated: " + isAuthenticated);

		// Add a product
		Product product = new Product("1", "Product A", 10.99);
		productService.updateProduct(product);

		// Place an order
		Order order = new Order("1", "1", "user1", 2, 21.98);
		orderService.placeOrder(order);

		// Get user's orders
		List<Order> userOrders = orderService.getUserOrders("user1");
		System.out.println("User's orders:");
		for (Order orders : userOrders) {
			System.out.println(orders);
		}

}}
