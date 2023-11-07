package com.example.demotwo.security.manager;

import com.example.demotwo.security.exceptions.AuthenticationNotSupportedException;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class DemoAuthenticationManager implements AuthenticationManager {
    private final AuthenticationProvider authenticationProvider;
    @Override
    public Authentication authenticate(Authentication authRequest) throws AuthenticationException {
        if (authenticationProvider.supports(authRequest.getClass())) {
            return authenticationProvider.authenticate(authRequest);}
        throw new AuthenticationNotSupportedException("OOPS");
    }


}
