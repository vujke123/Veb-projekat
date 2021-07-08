package com.example.teretana.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
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

    @JsonIgnore
    @OneToMany(mappedBy = "Trening",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Odradjen_trening> odradjen = new HashSet<>();

   // @OneToMany (mappedBy = "trening", fetch = FetchType.LAZY,orphanRemoval = true)
    //private Set<Odrzavanje_treninga> odrzavanje = new HashSet<>();


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

    public Korisnik getTrener() {
        return Trener;
    }

    public void setOdradjen(Set<Odradjen_trening> odradjen) {
        this.odradjen = odradjen;
    }

   /* public Set<Odrzavanje_treninga> getOdrzavanje() {return odrzavanje;}

    public void setOdrzavanje(Set<Odrzavanje_treninga> odrzavanje) {this.odrzavanje = odrzavanje;}*/

    public void setTrener(Korisnik trener) {
        Trener = trener;
    }

    public Trening(Long id, String naziv, String opis, String tip_treninga,
                   String trajanje, double ocena, Set<Odradjen_trening> odradjen, Set<Odrzavanje_treninga> odrzavanje, Korisnik trener) {
        this.id = id;
        this.naziv = naziv;
        this.opis = opis;
        this.tip_treninga = tip_treninga;
        this.trajanje = trajanje;
        this.ocena = ocena;
        this.odradjen = odradjen;
       // this.odrzavanje = odrzavanje;
        Trener = trener;
    }

    public Trening() {ocena=0;}
}

