package com.example.service;

import com.example.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    public User findUserByEmail(String email);
    public Optional<User> findUserByID(Integer id);
    User findByUsername(String username);

    public void saveUser(User user);
    public List<User> listAll();
}