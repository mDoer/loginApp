package com.example.service;

import com.example.model.Privilege;
import com.example.model.Role;

import java.util.List;
import java.util.Optional;

public interface PrivilegeService {

    public List<Privilege> listAll();
    public Optional<Privilege> findRoleByID(Integer id);
    public void savePrivilege(Privilege user);

}
