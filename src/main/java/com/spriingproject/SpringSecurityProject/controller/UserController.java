package com.spriingproject.SpringSecurityProject.controller;

import org.springframework.web.bind.annotation.RestController;

import com.spriingproject.SpringSecurityProject.model.Users;
import com.spriingproject.SpringSecurityProject.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Controller class handling user authentication operations.
 * This controller provides endpoints for user registration and login.
 *
 * @author BrijKishor
 * @version 1.0
 * @since 2025-09-14
 */
@RestController
public class UserController {

    /** Service for handling user-related operations */
    @Autowired
    private UserService userService;

    /**
     * Handles user registration requests.
     * Creates a new user account in the system.
     *
     * @param user The user object containing registration details
     * @return The registered user object
     */
    @PostMapping("/register")
    public Users register(@RequestBody Users user) {
        return userService.register(user);
    }

    /**
     * Handles user login requests.
     * Authenticates user credentials and returns a JWT token if valid.
     *
     * @param user The user object containing login credentials
     * @return JWT token if authentication is successful
     */
    @PostMapping("/login")
    public String login(@RequestBody Users user) {
        return userService.verify(user);
    }
    
}
