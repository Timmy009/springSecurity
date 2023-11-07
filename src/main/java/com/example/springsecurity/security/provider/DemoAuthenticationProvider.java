package com.example.demotwo.security.provider;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
@AllArgsConstructor
public class DemoAuthenticationProvider implements AuthenticationProvider {
    private final UserDetailsService userDetailsService;
    private final PasswordEncoder passwordEncoder;
    @Override
    public Authentication authenticate(Authentication authRequest) throws AuthenticationException {
        String username = authRequest.getPrincipal().toString();
        String password = authRequest.getCredentials().toString();
       UserDetails userDetails = userDetailsService.loadUserByUsername(username);
       if (passwordEncoder.matches(password, userDetails.getPassword())) {
           Collection<? extends GrantedAuthority> authorities = userDetails.getAuthorities();
           Authentication authenticationResult = UsernamePasswordAuthenticationToken.authenticated(username, password, authorities);
           return authenticationResult;
       }
      throw new BadCredentialsException("Invalid Credentials");
    }


    @Override
    public boolean supports(Class<?> authenticationType) {
        Class <UsernamePasswordAuthenticationToken> authenticationTokenClass = UsernamePasswordAuthenticationToken.class;
        return authenticationType.equals(authenticationTokenClass);
    }

}
