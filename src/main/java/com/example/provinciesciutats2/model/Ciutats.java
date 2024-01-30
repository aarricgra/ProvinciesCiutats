package com.example.provinciesciutats2.model;

import jakarta.persistence.*;

@Entity
@Table
public class Ciutats {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String nom;
    private int poblacio;
    private String descripcio;
    private String image;
    @ManyToOne
    @JoinColumn(name = "id_provincia")
    private Provincies provincia;

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

    public int getPoblacio() {
        return poblacio;
    }

    public void setPoblacio(int poblacio) {
        this.poblacio = poblacio;
    }

    public String getDescripcio() {
        return descripcio;
    }

    public void setDescripcio(String descripcio) {
        this.descripcio = descripcio;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String imatge) {
        this.image = imatge;
    }

    public Provincies getProvincia() {
        return provincia;
    }

    public void setProvincia(Provincies provincia) {
        this.provincia = provincia;
    }

    public Ciutats(Long id, String nom, int poblacio, String descripcio, String imatge, Provincies provincia) {
        this.id = id;
        this.nom = nom;
        this.poblacio = poblacio;
        this.descripcio = descripcio;
        this.image = imatge;
        this.provincia = provincia;
    }

    public Ciutats() {
    }

    @Override
    public String toString() {
        return "Ciutats{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", poblacio=" + poblacio +
                ", descripcio='" + descripcio + '\'' +
                ", imatge='" + image + '\'' +
                ", provincia=" + provincia +
                '}';
    }
}
