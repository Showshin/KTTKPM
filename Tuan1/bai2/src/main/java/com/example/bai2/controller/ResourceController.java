package com.example.bai2.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class ResourceController {

    // Public endpoint - không cần token
    @GetMapping("/public/hello")
    public String publicHello() {
        return "Hello! Đây là public endpoint.";
    }

    // Protected endpoint - cần JWT token
    @GetMapping("/protected/data")
    public Map<String, Object> protectedData(@AuthenticationPrincipal Jwt jwt) {
        Map<String, Object> response = new HashMap<>();
        response.put("message", "Đây là protected data!");
        response.put("subject", jwt.getSubject());
        response.put("claims", jwt.getClaims());
        return response;
    }
}
