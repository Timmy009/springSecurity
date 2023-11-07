package com.example.demotwo.security;

import com.example.demotwo.security.models.Authority;
import com.example.demotwo.security.models.User;
import lombok.AllArgsConstructor;
import lombok.var;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;


@AllArgsConstructor
public class SecureUser implements UserDetails {
    private final User user;
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<Authority> userAuthorities = user.getAuthorities();
        Collection<GrantedAuthority> authorities = new ArrayList<>();
        for (Authority authority: userAuthorities) {
            var auth = new SimpleGrantedAuthority(authority.name());
            authorities.add(auth);
        }

        return authorities;
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
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

}
