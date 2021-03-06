package com.example.migration;

import com.example.security.model.Privilege;
import com.example.security.model.Role;
import com.example.security.model.User;
import com.example.security.repo.PrivilegeRepository;
import com.example.security.repo.RoleRepository;
import com.example.security.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.*;

@Component
public class SetupData {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PrivilegeRepository privilegeRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @PostConstruct

    public void ini() {
        initPrivileges();
        initRoles();
        initUsers();
    }

    private void initPrivileges() {
        Privilege privilege1 = new Privilege();
        privilege1.setPrivilege("INDEX_READ");
        privilegeRepository.save(privilege1);
        Privilege privilege2 = new Privilege();
        privilege2.setPrivilege("USERS_CREATE_PRIVILEGE");
        privilegeRepository.save(privilege2);
        Privilege privilege3 = new Privilege();
        privilege3.setPrivilege("USERS_EDIT_PRIVILEGE");
        privilegeRepository.save(privilege2);
    }

    private void initRoles() {
        Role roleAdmin = new Role();
        roleAdmin.setRole("ADMIN");
        roleAdmin.setPrivileges(new ArrayList<>());
        roleAdmin.getPrivileges().addAll(privilegeRepository.findAll());
        roleRepository.save(roleAdmin);
    }

    private void initUsers() {
        User superadmin = new User();
        superadmin.setEmail("super@admin.de");
        superadmin.setActive(1);
        superadmin.setLastName("admin");
        superadmin.setName("super");
        superadmin.setIsSuperAdmin(1);
        superadmin.setPassword(bCryptPasswordEncoder.encode("passlogsol"));
        superadmin.setUsername("superadmin");

        User user1 = new User();
        user1.setEmail("super@admin.de");
        user1.setActive(1);
        user1.setLastName("User1");
        user1.setName("User1");
        user1.setRoles(new HashSet<Role>(Collections.singletonList(roleRepository.findByRole("ADMIN"))));
        user1.setUsername("user1");
        user1.setPassword(bCryptPasswordEncoder.encode("passlogsol"));

        User user2 = new User();
        user2.setEmail("super@admin.de");
        user2.setActive(1);
        user2.setLastName("User1");
        user2.setName("User1");
        user2.setRoles(new HashSet<Role>());
        user2.setUsername("user2");
        user2.setPassword(bCryptPasswordEncoder.encode("passlogsol"));


        userRepository.save(superadmin);
        userRepository.save(user1);
        userRepository.save(user2);

    }


}
