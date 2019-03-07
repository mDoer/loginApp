package com.example.security.repo;

import com.example.security.model.Privilege;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * The interface Privilege repository.
 */
@Repository("privilegeRepository")
public interface PrivilegeRepository extends JpaRepository<Privilege, Integer>{

    /**
     * Gets all.
     *
     * @return the all
     */
    public List<Privilege> findAll();

}
