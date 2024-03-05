package com.ecommerce;

import com.ecommerce.Entity.Order;
import com.ecommerce.Entity.Product;
import com.ecommerce.Service.AuthenticationService;
import com.ecommerce.Service.OrderProcessingService;
import com.ecommerce.Service.ProductManagementService;

import java.util.Scanner;

public class TaskApplication {

	public static void main(String[] args) {
		// Instantiate services
		AuthenticationService authService = new AuthenticationService();
		ProductManagementService productService = new ProductManagementService();
		OrderProcessingService orderService = new OrderProcessingService();

		// Add products
		productService.updateProduct(new Product("1", "Product A", 10.99, 10));
		productService.updateProduct(new Product("2", "Product B", 42.99, 20));

		Scanner scanner = new Scanner(System.in);

		// Register users
		while (true) {
			System.out.print("Enter user ID to register (or type 'login' to proceed): ");
			String userID = scanner.nextLine();
			if (userID.equalsIgnoreCase("login")) {
				break;
			}
			System.out.print("Enter password: ");
			String password = scanner.nextLine();
			authService.registerUser(userID, password);
		}

		// Login
		System.out.print("Enter user ID: ");
		String userID = scanner.nextLine();
		System.out.print("Enter password: ");
		String password = scanner.nextLine();
		boolean isAuthenticated = authService.authenticateUser(userID, password);
		if (!isAuthenticated) {
			System.out.println("Authentication failed.");
			return;
		}

		// Show product list
		System.out.println("Product List:");
		System.out.println("ID\tName\t\tPrice\tQuantity");
		for (Product product : productService.getAllProducts()) {
			System.out.println(product.getId() + "\t" + product.getName() + "\t\t" + product.getPrice() + "\t" + product.getQuantity());
		}

		// Place order
		while (true) {
			System.out.print("Enter product ID to place order (or type 'exit' to stop): ");
			String productID = scanner.nextLine();
			if (productID.equalsIgnoreCase("exit")) {
				break;
			}
			Product product = productService.getProductById(productID);
			if (product == null) {
				System.out.println("Product not found.");
				continue;
			}
			System.out.print("Enter quantity: ");
			int quantity = scanner.nextInt();
			scanner.nextLine(); // consume the newline character
			if (quantity > product.getQuantity()) {
				System.out.println("Insufficient quantity available.");
				continue;
			}
			double totalPrice = product.getPrice() * quantity;
			System.out.println("Total price: " + totalPrice);
			System.out.print("Confirm order (yes/no): ");
			String confirmation = scanner.nextLine();
			if (confirmation.equalsIgnoreCase("yes")) {
				Order order = new Order(userID + "_" + productID, productID, userID, quantity, totalPrice);
				orderService.placeOrder(order);
				System.out.println("Order placed successfully.");
				// Update product quantity
				product.setQuantity(product.getQuantity() - quantity);
				productService.updateProduct(product);
			} else {
				System.out.println("Order cancelled.");
			}
		}
	}
}
