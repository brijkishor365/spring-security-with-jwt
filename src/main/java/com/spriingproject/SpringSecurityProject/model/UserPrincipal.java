package com.spriingproject.SpringSecurityProject.model;

import java.util.Collection;
import java.util.Collections;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * Implementation of Spring Security's UserDetails interface.
 * This class wraps the Users entity and provides the core user information
 * required by Spring Security framework.
 *
 * @author BrijKishor
 * @version 1.0
 * @since 2025-09-14
 */
public class UserPrincipal implements UserDetails {

    /** The user entity being wrapped */
    private Users user;

    /**
     * Constructs a new UserPrincipal with the specified user.
     *
     * @param user The Users entity to wrap
     */
    public UserPrincipal(Users user) {
        this.user = user;
    }

    /**
     * Returns the authorities granted to the user.
     * In this implementation, all users are granted the "USER" role.
     *
     * @return A collection containing the user's authorities
     */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singleton(new SimpleGrantedAuthority("USER"));
    }

    /**
     * Returns the password used to authenticate the user.
     *
     * @return The user's password
     */
    @Override
    public String getPassword() {
        return user.getPassword();
    }

    /**
     * Returns the username used to authenticate the user.
     *
     * @return The user's username
     */
    @Override
    public String getUsername() {
        return user.getUsername();
    }

    /**
     * Indicates whether the user's account has expired.
     *
     * @return true as all accounts are considered non-expired
     */
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    /**
     * Indicates whether the user is locked or unlocked.
     *
     * @return true as all accounts are considered non-locked
     */
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    /**
     * Indicates whether the user's credentials (password) has expired.
     *
     * @return true as all credentials are considered non-expired
     */
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    /**
     * Indicates whether the user is enabled or disabled.
     *
     * @return true as all users are considered enabled
     */
    @Override
    public boolean isEnabled() {
        return true;
    }
}
