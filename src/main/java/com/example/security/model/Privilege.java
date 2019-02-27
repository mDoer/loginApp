package com.example.security.model;

import com.example.jsonview.Views;
import com.fasterxml.jackson.annotation.JsonView;

import javax.persistence.*;

/**
 * The type Privilege.
 */
@Entity
@Table(name = "privilege")
public class Privilege {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    @JsonView(Views.Public.class)
    private int id;

    @Column(name="privilege")
    @JsonView(Views.Public.class)
    private String privilege;


    /**
     * Gets id.
     *
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gets privilege.
     *
     * @return the privilege
     */
    public String getPrivilege() {
        return privilege;
    }

    /**
     * Sets privilege.
     *
     * @param privilege the privilege
     */
    public void setPrivilege(String privilege) {
        this.privilege = privilege;
    }
}
