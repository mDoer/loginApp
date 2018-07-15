package com.example.service;

import com.example.model.Role;
import com.example.model.User;

import java.util.List;
import java.util.Optional;

public interface RoleService {

    public List<Role> listAll();
    public Optional<Role> findRoleByID(Integer id);
    public void saveRole(Role user);
}