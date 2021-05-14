package com.example.teretana.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Odradjen_trening implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private double ocena;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Trening Trening;
    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private Korisnik Clan;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Korisnik korisnik;

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

    public Korisnik getKorisnik() {
        return korisnik;
    }

    public void setKorisnik(Korisnik korisnik) {
        this.korisnik = korisnik;
    }
}

