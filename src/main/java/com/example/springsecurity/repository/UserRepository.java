package com.example.demotwo.repository;

import com.example.demotwo.security.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    @Query ("SELECT u from User u where u.username = :username")
    Optional<User> findByUsername (String username);

}