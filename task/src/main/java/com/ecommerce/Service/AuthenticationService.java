package com.ecommerce.Service;

import java.util.HashMap;
import java.util.Map;

public class AuthenticationService {
    private Map<String, String> users = new HashMap<>(); // Simulated user database

    public void registerUser(String username, String password) {
        users.put(username, password);
    }

    public boolean authenticateUser(String username, String password) {
        return users.containsKey(username) && users.get(username).equals(password);
    }
}
