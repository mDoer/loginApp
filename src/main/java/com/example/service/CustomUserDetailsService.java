package com.example.service;

import com.example.security.model.CustomUserPrincipal;
import com.example.security.model.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

/**
 * The interface User service.
 */
public interface CustomUserDetailsService extends UserDetailsService {
    /**
     * Find user by email user.
     *
     * @param email the email
     * @return the user
     */
    public CustomUserPrincipal loadUserPrincipalByEmail(String email);

    /**
     * Find user by id optional.
     *
     * @param id the id
     * @return the optional
     */
    public CustomUserPrincipal loadUserPrincipalByID(Integer id);


    public CustomUserPrincipal loadUserByUsername(String username);

}