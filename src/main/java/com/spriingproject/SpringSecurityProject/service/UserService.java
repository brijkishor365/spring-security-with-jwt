package com.spriingproject.SpringSecurityProject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.spriingproject.SpringSecurityProject.model.Users;
import com.spriingproject.SpringSecurityProject.repo.UserRepo;

/**
 * Service class handling user registration and authentication operations.
 * This service provides methods for user registration with password encryption
 * and user authentication with JWT token generation.
 *
 * @author BrijKishor
 * @version 1.0
 * @since 2025-09-14
 */
@Service
public class UserService {

    /** Repository for user data access */
    @Autowired
    private UserRepo repo;
    
    /** Password encoder for secure password storage */
    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder(12);
    
    /** Authentication manager for handling user authentication */
    @Autowired
    private AuthenticationManager authManager;

    /** Service for JWT operations */
    @Autowired
    private JWTService jwtService;

    /**
     * Registers a new user in the system.
     * Encrypts the user's password before saving to the database.
     *
     * @param user The user object containing registration details
     * @return The registered user object with encrypted password
     */
    public Users register(Users user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return repo.save(user);
    }

    /**
     * Verifies user credentials and generates a JWT token upon successful authentication.
     *
     * @param user The user object containing login credentials
     * @return JWT token if authentication is successful, "Failed" otherwise
     */
    public String verify(Users user) {
        Authentication authentication = authManager
                .authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));

        if(authentication.isAuthenticated())
            return jwtService.generateToken(user.getUsername());
        return "Failed";
    }
}
