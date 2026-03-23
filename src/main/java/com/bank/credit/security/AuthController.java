package com.bank.credit.security;

import org.springframework.web.bind.annotation.*;
import com.bank.credit.security.JwtUtil;
import com.bank.credit.security.RegisterRequest;
import com.bank.credit.repository.UserRepository;
import com.bank.credit.entity.User;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
@RequestMapping("/auth")
public class AuthController {

    JwtUtil jwtUtil = new JwtUtil();

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/login")
    public String login(@RequestParam String username,
                        @RequestParam String password) {

        if(username.equals("admin") && password.equals("123")) {

            return jwtUtil.generateToken(username);
        }

        return "Invalid user";
    }

    @PostMapping("/register")
    public String register(@RequestBody RegisterRequest request) {
        // Validate input
        if (request.getUsername() == null || request.getPassword() == null || request.getEmail() == null) {
            return "Username, password, and email are required.";
        }
        // Check for existing user
        if (userRepository.existsByUsername(request.getUsername())) {
            return "Username already exists.";
        }
        if (userRepository.existsByEmail(request.getEmail())) {
            return "Email already exists.";
        }
        // Save new user
        User user = new User();
        user.setUsername(request.getUsername());
        user.setPassword(request.getPassword()); // In production, hash the password!
        user.setEmail(request.getEmail());
        user.setActive(true);
        userRepository.save(user);
        return "User registered successfully: " + request.getUsername();
    }
}