package com.example.security;

import com.example.security.model.CustomUserPrincipal;
import com.example.security.model.User;
import org.springframework.security.access.PermissionEvaluator;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Objects;

@Component
public class CustomPermissionEvaluator implements PermissionEvaluator {


    @Override
    public boolean hasPermission(Authentication auth, Object targetDomainObject, Object permission) {
        if ((auth == null) || (targetDomainObject == null) || !(permission instanceof String)) {
            return false;
        }
        String targetType = targetDomainObject.getClass().getSimpleName().toUpperCase();

        return hasPrivilege(auth, targetType, permission.toString().toUpperCase());
    }

    @Override
    public boolean hasPermission(Authentication auth, Serializable targetId, String targetType, Object permission) {
        if ((auth == null) || (targetType == null) || !(permission instanceof String)) {
            return false;
        }
        return hasPrivilege(auth, targetType.toUpperCase(),
                permission.toString().toUpperCase());
    }


    private boolean hasPrivilege(Authentication auth, String permission) {
        for (GrantedAuthority grantedAuth : auth.getAuthorities()) {
            if (grantedAuth.getAuthority().contains(permission)) {
                return true;
            }
        }
        return false;
    }


    private boolean hasPrivilege(Authentication auth, String targetType, String permission) {

        // deny anonymous access always
        if (auth instanceof AnonymousAuthenticationToken) return false;

        // always allow superadmin
        CustomUserPrincipal userPrincipal = (CustomUserPrincipal) auth.getPrincipal();
        if (userPrincipal.getUser().getIsSuperAdmin() == 1) return true;

        // and the rest
        for (GrantedAuthority grantedAuth : auth.getAuthorities()) {
            if (Objects.equals(grantedAuth.getAuthority(), permission)) {
                return true;
            }
        }
        return false;
    }
}