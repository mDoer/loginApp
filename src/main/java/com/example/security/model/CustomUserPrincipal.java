package com.example.security.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.Entity;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


/**
 * The type Custom user principal.
 */
public class CustomUserPrincipal implements UserDetails {
    private User user;

    /**
     * Instantiates a new Custom user principal.
     *
     * @param user the user
     */
    public CustomUserPrincipal(User user) {
        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        this.user.getRoles()
                .forEach(roleIterator -> roleIterator.getPrivileges()
                        .forEach(privilegeIterator -> authorities.add(new SimpleGrantedAuthority(privilegeIterator.getPrivilege()))
                        )
                );
        return authorities;
    }

    @Override
    public String getPassword() {
        System.out.println("was here");
        return this.user.getPassword();
    }

    @Override
    public String getUsername() {
        return this.user.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    /**
     * Gets user.
     *
     * @return the user
     */
    public User getUser() {
        return user;
    }
}
