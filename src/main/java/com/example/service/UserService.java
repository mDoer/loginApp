package com.example.service;

import com.example.security.model.CustomUserPrincipal;
import com.example.security.model.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

/**
 * The interface User service.
 */
public interface UserService extends UserDetailsService {
    /**
     * Find user by email user.
     *
     * @param email the email
     * @return the user
     */
    public CustomUserPrincipal loadUserByEmail(String email);

    /**
     * Find user by id optional.
     *
     * @param id the id
     * @return the optional
     */
    public CustomUserPrincipal loadUserByID(Integer id);


    public CustomUserPrincipal loadUserByUsername(String username);


    /**
     * Save user.
     *
     * @param user the user
     */
    public void saveUser(User user);

    /**
     * List all list.
     *
     * @return the list
     */
    public List<User> listAll();

}