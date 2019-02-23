package com.example.service;

import com.example.security.model.Privilege;

import java.util.List;

/**
 * The interface Privilege service.
 */
public interface PrivilegeService {

    /**
     * List all list.
     *
     * @return the list
     */
    public List<Privilege> findAll();


    /**
     * Save privilege.
     *
     * @param user the user
     */
    public void savePrivilege(Privilege user);

}
