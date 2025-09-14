package com.spriingproject.SpringSecurityProject.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spriingproject.SpringSecurityProject.model.Users;

/**
 * Repository interface for User entity operations.
 * Extends JpaRepository to provide standard CRUD operations and
 * custom finder methods for User entities.
 *
 * @author BrijKishor
 * @version 1.0
 * @since 2025-09-14
 */
@Repository
public interface UserRepo extends JpaRepository<Users, Integer> {
    
    /**
     * Finds a user by their username.
     *
     * @param username The username to search for
     * @return The user with the specified username, or null if not found
     */
    Users findByUsername(String username);
}
