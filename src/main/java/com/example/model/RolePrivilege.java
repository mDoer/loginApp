package com.example.model;


import com.example.jsonview.Views;
import com.fasterxml.jackson.annotation.JsonView;

/* Mapping class for roles to privileges */
public class RolePrivilege {

    @JsonView(Views.Public.class)
    private Role role;

    @JsonView(Views.Public.class)
    private Privilege privilege;

    @JsonView(Views.Public.class)
    private boolean isGranted;

    @JsonView(Views.Public.class)
    private final int id;


    public RolePrivilege(int id, Role role, Privilege privilege, boolean isGranted) {
        this.role = role;
        this.privilege = privilege;
        this.isGranted = isGranted;
        this.id = id;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Privilege getPrivilege() {
        return privilege;
    }

    public void setPrivilege(Privilege privilege) {
        this.privilege = privilege;
    }

    public boolean isGranted() {
        return isGranted;
    }

    public void setIsGranted(boolean isGranted) {
        this.isGranted = isGranted;
    }


    public int getId() {
        return id;
    }
}
