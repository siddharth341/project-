package com.examly.springapp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.HashMap;
import java.util.Map;

@RestController
public class RootController {
    
    @GetMapping("/")
    public Map<String, Object> home() {
        Map<String, Object> response = new HashMap<>();
        response.put("application", "Library Management System");
        response.put("version", "1.0.0");
        response.put("author", "Siddharth");
        response.put("port", 8080);
        response.put("status", "Running");
        
        Map<String, String> endpoints = new HashMap<>();
        endpoints.put("Book Categories", "/api/book-categories");
        endpoints.put("Books", "/api/books");
        endpoints.put("Members", "/api/members");
        endpoints.put("Borrows", "/api/borrows");
        endpoints.put("Fines", "/api/fines");
        endpoints.put("H2 Console", "/h2-console");
        
        response.put("endpoints", endpoints);
        return response;
    }
}