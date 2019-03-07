package com.example.model;


import com.example.jsonview.Views;
import com.example.security.model.Privilege;
import com.example.security.model.Role;
import com.fasterxml.jackson.annotation.JsonView;

/**
 * The type Role privilege.
 */
/* Mapping class for roles to privileges */
public class RolePrivilege {

    @JsonView(Views.Public.class)
    private Role role;

    @JsonView(Views.Public.class)
    private Privilege privilege;

    @JsonView(Views.Public.class)
    private boolean isGranted;

    @JsonView(Views.Public.class)
    private  int id;


    public RolePrivilege() {
    }

    /**
     * Instantiates a new Role privilege.
     *
     * @param id        the id
     * @param role      the role
     * @param privilege the privilege
     * @param isGranted the is granted
     */
    public RolePrivilege(int id, Role role, Privilege privilege, boolean isGranted) {
        this.role = role;
        this.privilege = privilege;
        this.isGranted = isGranted;
        this.id = id;
    }

    /**
     * Gets role.
     *
     * @return the role
     */
    public Role getRole() {
        return role;
    }

    /**
     * Sets role.
     *
     * @param role the role
     */
    public void setRole(Role role) {
        this.role = role;
    }

    /**
     * Gets privilege.
     *
     * @return the privilege
     */
    public Privilege getPrivilege() {
        return privilege;
    }

    /**
     * Sets privilege.
     *
     * @param privilege the privilege
     */
    public void setPrivilege(Privilege privilege) {
        this.privilege = privilege;
    }

    /**
     * Is granted boolean.
     *
     * @return the boolean
     */
    public boolean isGranted() {
        return isGranted;
    }

    /**
     * Sets is granted.
     *
     * @param isGranted the is granted
     */
    public void setIsGranted(boolean isGranted) {
        this.isGranted = isGranted;
    }


    /**
     * Gets id.
     *
     * @return the id
     */
    public int getId() {
        return id;
    }
}
