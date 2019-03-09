package com.example.service;

import com.example.security.model.User;

import java.util.List;

/**
 * The interface User service.
 */
public interface UserService {


    /**
     * Find user by id optional.
     *
     * @param id the id
     * @return the optional
     */
    public User loadUserByID(Integer id);


    /**
     * Load user by username user.
     *
     * @param username the username
     * @return the user
     */
    public User loadUserByUsername(String username);

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
