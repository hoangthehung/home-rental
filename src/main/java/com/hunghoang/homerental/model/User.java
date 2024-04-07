package com.hunghoang.homerental.model;

import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

public class User implements UserDetails {
    @Setter
    String username;
    @Setter
    String password;

    @Setter
    UserStatus status;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return !UserStatus.DEACTIVATED.equals(status);
    }

    @Override
    public boolean isAccountNonLocked() {
        return !UserStatus.DEACTIVATED.equals(status);
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return !UserStatus.DEACTIVATED.equals(status);
    }

    @Override
    public boolean isEnabled() {
        return !UserStatus.DEACTIVATED.equals(status);
    }
}
