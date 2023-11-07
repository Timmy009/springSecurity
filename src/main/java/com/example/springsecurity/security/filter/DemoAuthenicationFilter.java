package com.example.demotwo.security.filter;

import com.example.demotwo.security.dto.LoginRequest;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

@AllArgsConstructor
@Component
public class DemoAuthenicationFilter implements Filter {

    private final AuthenticationManager authenticationManager;


    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        var httpRequest = (HttpServletRequest) servletRequest;
        if (!httpRequest.getServletPath().equals("/login"));
        InputStream inputStream = servletRequest.getInputStream();
        ObjectMapper mapper = new ObjectMapper();
        LoginRequest loginRequest = mapper.readValue(inputStream, LoginRequest.class);
        String username = loginRequest.getUsername();
        String password = loginRequest.getPassword();
        Authentication authenticationResult = new UsernamePasswordAuthenticationToken(username, password);
authenticationManager.authenticate(authenticationResult);
if (authenticationResult != null) {
   SecurityContext context = SecurityContextHolder.getContext();
   context.setAuthentication(authenticationResult);;
    OutputStream outputStream = servletResponse.getOutputStream();
    Map<String, String> map = new HashMap<>();
    map.put("response", "authentication successful");
    outputStream.write(mapper.writeValueAsBytes(map));
}
filterChain.doFilter(servletRequest, servletResponse);
    }


}
