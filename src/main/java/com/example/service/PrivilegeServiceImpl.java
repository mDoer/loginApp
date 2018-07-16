package com.example.service;

import com.example.model.Privilege;
import com.example.repo.PrivilegeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PrivilegeServiceImpl implements PrivilegeService{

    @Autowired
    private PrivilegeRepository privilegeRepository;

    @Override
    public List<Privilege> listAll() {
        return privilegeRepository.getAll();
    }

    @Override
    public Optional<Privilege> findRoleByID(Integer id) {
        return Optional.empty();
    }

    @Override
    public void savePrivilege(Privilege user) {

    }
}
