package com.example.Vebprojekat.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Trening implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String naziv;

    @Column
    private String opis;

    @Column
    private String tip_treninga;

    @Column
    private String trajanje;

    @Column
    private double ocena;

    @OneToMany(mappedBy = "Trening",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Odradjen_trening> odradjen = new HashSet<>();

    @OneToMany(mappedBy = "Trening", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private  Set<Prijavljen_Trening> prijavljen = new HashSet<>();

    @ManyToOne(fetch=FetchType.LAZY,cascade=CascadeType.ALL)
    private Korisnik Trener;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public String getTip_treninga() {
        return tip_treninga;
    }

    public void setTip_treninga(String tip_treninga) {
        this.tip_treninga = tip_treninga;
    }

    public String getTrajanje() {
        return trajanje;
    }

    public void setTrajanje(String trajanje) {
        this.trajanje = trajanje;
    }

    public double getOcena() {
        return ocena;
    }

    public void setOcena(double ocena) {
        this.ocena = ocena;
    }

    public Set<Odradjen_trening> getOdradjen() {
        return odradjen;
    }

    public void setOdradjen(Set<Odradjen_trening> odradjen) {
        this.odradjen = odradjen;
    }

    public Set<Prijavljen_Trening> getPrijavljen() {
        return prijavljen;
    }

    public void setPrijavljen(Set<Prijavljen_Trening> prijavljen) {
        this.prijavljen = prijavljen;
    }

    public Korisnik getTrener() {
        return Trener;
    }

    public void setTrener(Korisnik trener) {
        this.Trener = trener;
    }
}
