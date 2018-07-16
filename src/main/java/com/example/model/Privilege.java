package com.example.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.example.jsonview.Views;
import com.fasterxml.jackson.annotation.JsonView;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.annotation.Transient;

import java.util.Collection;

/**
 * The type Privilege.
 */
@Entity
@Table(name = "privilege")
public class Privilege {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="privilege_id")
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
