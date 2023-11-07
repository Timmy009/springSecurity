package com.example.springsecurity.repository;

import com.example.demotwo.security.models.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UserRepositoryTest {
    @Autowired
    private UserRepository userRepository;

    @Test
    void findByUsername() {
        User u1 = new User();
        User u2 = new User();
        User u3 = new User();
       u1.setUsername("john");
        u2.setUsername("timmy");
        u3.setUsername("esther");
u1.setPassword("password");
        userRepository.save(u1);
        userRepository.save(u2);
        userRepository.save(u3);
        var foundUser = userRepository.findByUsername("john").orElse(null);
        assertThat(foundUser).isInstanceOf(User.class);


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class UserRepositoryTest {

    @Test
    void findByUsername() {
    }
}