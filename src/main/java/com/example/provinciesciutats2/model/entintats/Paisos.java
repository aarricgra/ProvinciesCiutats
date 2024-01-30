package com.example.provinciesciutats2.model.entintats;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table
public class Paisos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String nom;

    @OneToMany(mappedBy = "pais", cascade = CascadeType.ALL)
    private List<Provincies> provincies;

    public Paisos() {
    }

    public Paisos(Long id, String nom, List<Provincies> provincies) {
        this.id = id;
        this.nom = nom;
        this.provincies = provincies;
    }

    @Override
    public String toString() {
        return "Paisos{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", provincies=" + provincies +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public List<Provincies> getProvincies() {
        return provincies;
    }

    public void setProvincies(List<Provincies> provincies) {
        this.provincies = provincies;
    }
}
