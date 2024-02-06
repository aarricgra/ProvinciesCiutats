package com.example.provinciesciutats2.model.entintats;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "users")
public class User {
    @Id
    public String username;
    @Column(nullable = false)
    public String password;
    @Column(nullable = false)
    public boolean enabled;

    @OneToMany(mappedBy = "username")
    public Set<Authority> authorities;
}
