package com.example.service;

import com.example.security.model.CustomUserPrincipal;
import com.example.security.model.User;
import com.example.security.repo.RoleRepository;
import com.example.security.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;


/**
 * The type Custom user details service.
 */
@Service
public class CustomUserDetailsServiceImpl implements CustomUserDetailsService, UserDetailsService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public CustomUserPrincipal loadUserPrincipalByEmail(String email) {
        User user = userRepository.findByEmail(email);
        if (user == null) {
            throw new UsernameNotFoundException(email);
        }
        return new CustomUserPrincipal(user);
    }

    @Override
    public CustomUserPrincipal loadUserPrincipalByID(Integer id) {
        User user = userRepository.findById(id).orElseThrow(EntityNotFoundException::new); // FIXME enhance exception message
        return new CustomUserPrincipal(user);
    }


    @Override
    public CustomUserPrincipal loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username); //FIXME Catch exceptions when multiple times same username
        if (user == null) {
            throw new UsernameNotFoundException(username);
        }
        return new CustomUserPrincipal(user);
    }


}