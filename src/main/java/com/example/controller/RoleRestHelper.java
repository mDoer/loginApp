package com.example.controller;

import com.example.model.Privilege;
import com.example.model.Role;
import com.example.model.RolePrivilege;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class RoleRestHelper {


    /* return list of RolePrivileges */
    public static List<RolePrivilege> mapRolePrivileges(Role role, List<Privilege> privilegeList) {
        List<RolePrivilege> rolePrivilegeList = new ArrayList<>();
        AtomicInteger id = new AtomicInteger(1);

        privilegeList.forEach(privilege -> {
            rolePrivilegeList.add(new RolePrivilege(id.get(), role, privilege, role.getPrivileges().contains(privilege)));
            id.getAndIncrement();
        });
        return rolePrivilegeList;
    }
}
