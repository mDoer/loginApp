package com.example.service;

import com.example.security.model.User;
import com.example.security.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

/**
 * The type User service.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;


    @Override
    public User loadUserByID(Integer id) {
        return this.userRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public User loadUserByUsername(String username) {
        return this.userRepository.findByUsername(username);
    }

    @Override
    public void saveUser(User user) {
        this.userRepository.save(user);
    }

    @Override
    public List<User> listAll() {
        return new ArrayList<>(this.userRepository.findAll());
    }

}
