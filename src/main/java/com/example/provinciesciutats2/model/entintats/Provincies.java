package com.example.provinciesciutats2.model.entintats;

import com.example.provinciesciutats2.model.entintats.Ciutats;
import com.example.provinciesciutats2.model.entintats.Paisos;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table
public class Provincies {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String nom;

    @OneToMany(mappedBy = "provincia", cascade = CascadeType.ALL)
    private List<Ciutats> ciutats;

    @ManyToOne
    @JoinColumn(name = "id_pais")
    private Paisos pais;

    public Provincies() {
    }

    public Provincies(Long id, String nom, List<Ciutats> ciutats, Paisos pais) {
        this.id = id;
        this.nom = nom;
        this.ciutats = ciutats;
        this.pais = pais;
    }

    @Override
    public String toString() {
        return "Provincies{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", ciutats=" + ciutats +
                ", pais=" + pais +
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

    public List<Ciutats> getCiutats() {
        return ciutats;
    }

    public void setCiutats(List<Ciutats> ciutats) {
        this.ciutats = ciutats;
    }

    public Paisos getPais() {
        return pais;
    }

    public void setPais(Paisos pais) {
        this.pais = pais;
    }
}
