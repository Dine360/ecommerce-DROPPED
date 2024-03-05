package com.ecommerce.Service;

import com.ecommerce.Entity.Order;

import java.util.ArrayList;
import java.util.List;

public class OrderProcessingService {
    private List<Order> orders = new ArrayList<>(); // Simulated order database

    public void placeOrder(Order order) {
        // Calculate total price, update inventory, etc.
        orders.add(order);
    }

    public List<Order> getUserOrders(String userId) {
        List<Order> userOrders = new ArrayList<>();
        for (Order order : orders) {
            if (order.getUserId().equals(userId)) {
                userOrders.add(order);
            }
        }
        return userOrders;
    }
}
