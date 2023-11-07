package com.example.demotwo.security.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Collection;
import java.util.Set;

import static jakarta.persistence.EnumType.STRING;
import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table
public class User {
    @Column (unique = true)
    private String username;
    private String password;

    @Id
    @GeneratedValue (strategy =IDENTITY)
    private Long id;
    @Enumerated (STRING)
    @Column (name = "authority")
    private Collection<Authority> authorities;
package com.example.demotwo.security.models;public class User {
}
