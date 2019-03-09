package com.example.model.forms;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UserForm {

    @Email (message = "Email should be valid")
    private String email;

    @NotNull (message = "Name cannot be null")
    @Size(min=2, max=30, message = "Length between 2 and 30")
    private String username;
    @NotNull (message = "Name cannot be null")
    @Size(min=2, max=30, message = "Length between 2 and 30")
    private String name;
    @NotNull (message = "Name cannot be null")
    @Size(min=2, max=30, message = "Length between 2 and 30")
    private String lastName;


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
