package com.example.converter;

import com.example.model.Privilege;
import com.example.model.User;
import com.example.model.UserDetailsImpl;
import org.springframework.core.convert.converter.Converter;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


@Component
public class UserToUserDetailsConverter implements Converter<User, UserDetails> {

    @Override
    public UserDetails convert(User user) {
        UserDetailsImpl userDetails = new UserDetailsImpl();

        userDetails.setUsername(user.getUsername());
        userDetails.setPassword(user.getPassword());
        userDetails.setEnabled(true); //FIXME always enabled
        userDetails.setAuthorities(this.getUserAuthorities(user));

        return userDetails;
    }

    private Collection<SimpleGrantedAuthority> getUserAuthorities(User user) {
        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        user.getRoles().forEach(role-> role.getPrivileges().forEach(privilege -> authorities.add(new SimpleGrantedAuthority(privilege.getPrivilege()) )));
        System.out.println("was here");
        return authorities;
    }
}