package com.example.teretana.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
public class Odradjen_trening implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private double ocena;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    public Trening Trening;
    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    public Korisnik Clan;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getOcena() {
        return ocena;
    }

    public void setOcena(double ocena) {
        this.ocena = ocena;
    }

    public Trening getTrening() {
        return Trening;
    }

    public void setTrening(Trening trening) {
        this.Trening = trening;
    }

    public Odradjen_trening(Long id, double ocena, com.example.teretana.model.Trening trening, Korisnik clan) {
        this.id = id;
        this.ocena = ocena;
        this.Trening = trening;
        this.Clan = clan;
    }
    public Odradjen_trening() {

    }
}

