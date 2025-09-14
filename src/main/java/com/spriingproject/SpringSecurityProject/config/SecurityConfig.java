package com.spriingproject.SpringSecurityProject.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * Security configuration class for the application.
 * This class configures Spring Security settings including authentication,
 * authorization, session management, and security filters.
 *
 * @author BrijKishor
 * @version 1.0
 * @since 2025-09-14
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig {

    /** Service for loading user-specific data */
    @Autowired
    private UserDetailsService userDetailsService;

    /** Filter for handling JWT-based authentication */
    @Autowired
    private JwtFilter jwtFlter;

    /**
     * Configures the security filter chain for the application.
     * Sets up security rules, CSRF protection, session management,
     * and JWT filter integration.
     *
     * @param http The HttpSecurity to configure
     * @return The configured SecurityFilterChain
     * @throws Exception if an error occurs during configuration
     */
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .csrf(customizer -> customizer.disable())
                .authorizeHttpRequests(request -> request
                    .requestMatchers("register", "login")
                    .permitAll()
                    .anyRequest()
                    .authenticated())
                .httpBasic(Customizer.withDefaults())
                .sessionManagement(session -> session
                    .sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .addFilterBefore(jwtFlter, UsernamePasswordAuthenticationFilter.class)
                .build();
    }

    /**
     * Configures the authentication provider.
     * Sets up the password encoder and user details service.
     *
     * @return The configured authentication provider
     */
    /**
     * Configures the authentication provider.
     * Sets up the password encoder and user details service.
     *
     * @return The configured authentication provider
     */
    /**
     * Creates a password encoder bean for the application.
     *
     * @return The BCrypt password encoder
     */
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(12);
    }

    /**
     * Configures the authentication provider.
     * Sets up the password encoder and user details service.
     *
     * @return The configured authentication provider
     */
    /**
     * Configures the authentication provider.
     * Sets up the password encoder and user details service.
     *
     * Note: Using deprecated constructor due to API changes in Spring Security.
     * TODO: Update to use the latest recommended approach when upgrading Spring Security.
     *
     * @return The configured authentication provider
     */
    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setPasswordEncoder(passwordEncoder());
        provider.setUserDetailsService(userDetailsService);
        return provider;
    }

    /**
     * Creates the authentication manager bean.
     *
     * @param config The authentication configuration
     * @return The authentication manager
     * @throws Exception if an error occurs during creation
     */
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }

    // @Bean
    // public UserDetailsService userDetailsService() {
    //     UserDetails user1 = User
    //             .withDefaultPasswordEncoder()
    //             .username("vikas")
    //             .password("1234")
    //             .roles("USER")
    //             .build();

    //     UserDetails user2 = User
    //             .withDefaultPasswordEncoder()
    //             .username("amit")
    //             .password("123")
    //             .roles("ADMIN")
    //             .build();

    //     return new InMemoryUserDetailsManager(user1, user2);
    // }
}
