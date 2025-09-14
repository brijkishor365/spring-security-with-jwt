package com.spriingproject.SpringSecurityProject.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

/**
 * Entity class representing a user in the system.
 * This class maps to the users table in the database and contains
 * basic user information including id, username, and password.
 *
 * @author BrijKishor
 * @version 1.0
 * @since 2025-09-14
 */
@Entity
public class Users {
    /** The unique identifier for the user */
    @Id
    private int id;
    
    /** The username of the user */
    private String username;
    
    /** The password of the user (should be encrypted) */
    private String password;
    
    /**
     * Gets the user's ID.
     *
     * @return The user's unique identifier
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the user's ID.
     *
     * @param id The unique identifier to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gets the username.
     *
     * @return The user's username
     */
    public String getUsername() {
        return username;
    }

    /**
     * Sets the username.
     *
     * @param username The username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Gets the password.
     *
     * @return The user's password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the password.
     *
     * @param password The password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Returns a string representation of the Users object.
     *
     * @return A string containing the user's id, username, and password
     */
    @Override
    public String toString() {
        return "Users [id=" + id + ", username=" + username + ", password=" + password + "]";
    }
}
