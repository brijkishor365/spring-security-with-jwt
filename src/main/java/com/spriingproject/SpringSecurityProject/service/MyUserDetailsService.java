package com.spriingproject.SpringSecurityProject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.spriingproject.SpringSecurityProject.model.UserPrincipal;
import com.spriingproject.SpringSecurityProject.model.Users;
import com.spriingproject.SpringSecurityProject.repo.UserRepo;

/**
 * Custom implementation of Spring Security's UserDetailsService.
 * This service is responsible for loading user-specific data and
 * converting it into a format that Spring Security can understand.
 *
 * @author BrijKishor
 * @version 1.0
 * @since 2025-09-14
 */
@Service
public class MyUserDetailsService implements UserDetailsService {

    /** Repository for accessing user data */
    @Autowired
    private UserRepo repo;

    /**
     * Loads user-specific data by username.
     * This method is used by Spring Security to load user details during authentication.
     *
     * @param username The username to search for
     * @return UserDetails object containing the user's security information
     * @throws UsernameNotFoundException if the user is not found in the database
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users user = repo.findByUsername(username);

        if (user == null) {
            System.out.println("User not found!");
            throw new UsernameNotFoundException("User not found!");
        }

        return new UserPrincipal(user);
    }

}
