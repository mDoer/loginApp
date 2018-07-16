package com.example.service;

import com.example.model.Role;
import com.example.model.User;

import java.util.List;
import java.util.Optional;

/**
 * The interface Role service.
 */
public interface RoleService {

    /**
     * List all list.
     *
     * @return the list
     */
    public List<Role> listAll();

    /**
     * Find role by id optional.
     *
     * @param id the id
     * @return the optional
     */
    public Optional<Role> findRoleByID(Integer id);

    /**
     * Save role.
     *
     * @param user the user
     */
    public void saveRole(Role user);
}