package com.example.provinciesciutats2.model.entintats;

import jakarta.persistence.*;

import java.util.List;
import java.util.Set;

@Entity
@Table
public class Franquicies {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String nom;

    @Column(nullable = false)
    private String img;
    @Column(nullable = false)
    private String desc;

    @OneToMany(mappedBy = "id")
    private List<Ciutats> franquiciesCiutats;

    public Franquicies() {
    }

    public Franquicies(Long id, String nom, String img, String desc) {
        this.id = id;
        this.nom = nom;
        this.img = img;
        this.desc = desc;
    }

    public List<Ciutats> getFranquiciesCiutats() {
        return franquiciesCiutats;
    }

    public void setFranquiciesCiutats(List<Ciutats> franquiciesCiutats) {
        this.franquiciesCiutats = franquiciesCiutats;
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

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public String toString() {
        return "Franquicies{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", img='" + img + '\'' +
                ", desc='" + desc + '\'' +
                '}';
    }
}
