package com.example.provinciesciutats2.model.entintats;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity
@Table(name = "authorities")
public class Authority {
    @Id
    public String username;

    public String authority;
}
