package com.example.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.model.Role;

/**
 * The interface Role repository.
 */
@Repository("roleRepository")
public interface RoleRepository extends JpaRepository<Role, Integer>{
    /**
     * Find by role role.
     *
     * @param role the role
     * @return the role
     */
    Role findByRole(String role);

}