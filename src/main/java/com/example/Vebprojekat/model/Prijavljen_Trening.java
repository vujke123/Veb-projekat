package com.example.Vebprojekat.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Prijavljen_Trening implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Odrzavanje_treninga odrzavanje_treninga;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Korisnik korisnik;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Odrzavanje_treninga getOdrzavanje_treninga() {
        return odrzavanje_treninga;
    }

    public void setOdrzavanje_treninga(Odrzavanje_treninga odrzavanje_treninga) {
        this.odrzavanje_treninga = odrzavanje_treninga;
    }

    public Korisnik getKorisnik() {
        return korisnik;
    }

    public void setKorisnik(Korisnik korisnik) {
        this.korisnik = korisnik;
    }
}

