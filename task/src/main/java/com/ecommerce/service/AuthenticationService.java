package com.ecommerce.service;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

public class AuthenticationService {
    private Map<String, String> userCredentials = new HashMap<>(); // Simulated user database

    public void registerUser(String username, String password) {
        userCredentials.put(username, password);
    }

    public boolean authenticateUser(String username, String password) {
        return userCredentials.containsKey(username) && userCredentials.get(username).equals(password);
    }
}
