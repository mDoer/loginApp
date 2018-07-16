package com.example.service;

import com.example.model.User;

import java.util.List;
import java.util.Optional;

/**
 * The interface User service.
 */
public interface UserService {
    /**
     * Find user by email user.
     *
     * @param email the email
     * @return the user
     */
    public User findUserByEmail(String email);

    /**
     * Find user by id optional.
     *
     * @param id the id
     * @return the optional
     */
    public Optional<User> findUserByID(Integer id);

    /**
     * Find by username user.
     *
     * @param username the username
     * @return the user
     */
    User findByUsername(String username);

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