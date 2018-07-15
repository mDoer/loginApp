package com.example.service;

import com.example.model.Role;
import com.example.model.User;
import com.example.repo.RoleRepository;
import com.example.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;

@Service("roleService")
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public Optional<Role> findRoleByID(Integer id) {
        return roleRepository.findById(id);
    }


    @Override
    public void saveRole(Role role) {

        roleRepository.save(role);
    }

    @Override
    public List<Role> listAll() {
        return new ArrayList<>(roleRepository.findAll());
    }

}