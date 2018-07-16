package com.example.repo;

import com.example.model.Privilege;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class PrivilegeRepositoryImpl implements PrivilegeRepositoryInterface {


    @PersistenceContext
    private
    EntityManager entityManager;


    @Override
    public List<Privilege> getAll() {
        Query query = entityManager.createNativeQuery("SELECT privilege.* FROM  privilege ", Privilege.class);
        return  query.getResultList();
    }
}
