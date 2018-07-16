package com.example.service;

import com.example.model.Privilege;
import com.example.model.Role;

import java.util.List;
import java.util.Optional;

/**
 * The interface Privilege service.
 */
public interface PrivilegeService {

    /**
     * List all list.
     *
     * @return the list
     */
    public List<Privilege> listAll();

    /**
     * Find role by id optional.
     *
     * @param id the id
     * @return the optional
     */
    public Optional<Privilege> findRoleByID(Integer id);

    /**
     * Save privilege.
     *
     * @param user the user
     */
    public void savePrivilege(Privilege user);

}
