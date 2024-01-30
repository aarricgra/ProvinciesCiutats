package com.example.provinciesciutats2.model.entintats;

import jakarta.persistence.*;

@Entity
@Table
public class CiutatsFranquicies {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "ciutats_id")
    private Ciutats id_ciutat;
    @ManyToOne
    @JoinColumn(name = "franquicies_id")
    private Franquicies id_franquicia;

    public CiutatsFranquicies() {
    }

    public CiutatsFranquicies(Long id, Ciutats id_ciutat, Franquicies id_franquicia) {
        this.id = id;
        this.id_ciutat = id_ciutat;
        this.id_franquicia = id_franquicia;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Ciutats getId_ciutat() {
        return id_ciutat;
    }

    public void setId_ciutat(Ciutats id_ciutat) {
        this.id_ciutat = id_ciutat;
    }

    public Franquicies getId_franquicia() {
        return id_franquicia;
    }

    public void setId_franquicia(Franquicies id_franquicia) {
        this.id_franquicia = id_franquicia;
    }
}
