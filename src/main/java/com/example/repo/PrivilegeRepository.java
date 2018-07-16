package com.example.repo;

import com.example.model.Privilege;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * The interface Privilege repository.
 */
@Repository
public interface PrivilegeRepository extends JpaRepository<Privilege, Integer>, PrivilegeRepositoryInterface {

}
