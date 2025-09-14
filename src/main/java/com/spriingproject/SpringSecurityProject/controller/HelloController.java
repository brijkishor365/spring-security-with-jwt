package com.spriingproject.SpringSecurityProject.controller;

import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Controller class handling basic greeting and about page requests.
 * This controller demonstrates simple REST endpoints and session handling.
 *
 * @author BrijKishor
 * @version 1.0
 * @since 2025-09-14
 */
@RestController
public class HelloController {
    
    /**
     * Handles the root endpoint request and returns a greeting message
     * along with the session ID.
     *
     * @param request The HTTP request object containing session information
     * @return A greeting message with the session ID
     */
    @GetMapping("/")
    public String greet(HttpServletRequest request) {
        return "Welcome to Spring Security!" + request.getSession().getId();
    }

    /**
     * Handles requests to the about page endpoint.
     *
     * @return A simple about page message
     */
    @GetMapping("about")
    public String about() {
        return new String("About Page...");
    }
    
    
}
