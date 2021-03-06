package com.example.security.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.security.model.User;

/**
 * The interface User repository.
 */
@Repository("userRepository")
public interface UserRepository extends JpaRepository<User, Integer> {
    /**
     * Find by email user.
     *
     * @param email the email
     * @return the user
     */
    User findByEmail(String email);

    /**
     * Find by username user.
     *
     * @param username the username
     * @return the user
     */
    User findByUsername(String username);
}