package com.spriingproject.SpringSecurityProject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Main Spring Boot application class for the Spring Security Project.
 * This class serves as the entry point for the application and initializes
 * the Spring Boot framework with all necessary configurations.
 * 
 * @author BrijKishor
 * @version 1.0
 * @since 2025-09-14
 */
@SpringBootApplication
public class SpringSecurityProjectApplication {

    /**
     * The main method which serves as the entry point for the Spring Boot application.
     * This method starts the Spring application context and runs the application.
     *
     * @param args Command line arguments passed to the application
     */
    public static void main(String[] args) {
        SpringApplication.run(SpringSecurityProjectApplication.class, args);
    }

}
