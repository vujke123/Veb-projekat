package com.example.Vebprojekat.model;


import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

enum Uloga { ADMIN, TRENER, CLAN }

@Entity
public class Korisnik implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String korisnicko_ime;

    @Column
    private String lozinka;

    @Column
    private String ime;

    @Column
    private String prezime;

    @Column
    private String kontakt_broj;

    @Column (unique = true)
    private String email;

    @Column
    private String datum_rodjenja;

    @Column
    private Uloga uloga;

    @Column
    private Boolean aktivan;

    @OneToMany( mappedBy = "Clan", fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private Set <Odradjen_trening> odradjen_trening=new HashSet<>();

    @OneToMany( mappedBy = "Clan", fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private Set <Prijavljen_Trening> prijavljen_trening=new HashSet<>();

    @OneToMany( mappedBy = "Trener", fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private Set <Trening> trening=new HashSet<>();

    @ManyToOne( fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Fitnes_Centar Fitnes_Centar;



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getKorisnicko_ime() {
        return korisnicko_ime;
    }

    public void setKorisnicko_ime(String korisnicko_ime) {
        this.korisnicko_ime = korisnicko_ime;
    }

    public String getLozinka() {
        return lozinka;
    }

    public void setLozinka(String lozinka) {
        this.lozinka = lozinka;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getKontakt_broj() {
        return kontakt_broj;
    }

    public void setKontakt_broj(String kontakt_broj) {
        this.kontakt_broj = kontakt_broj;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.lozinka = email;
    }

    public String getDatum_rodjenja() {
        return datum_rodjenja;
    }

    public void setDatum_rodjenja(String datum_rodjenja) {
        this.datum_rodjenja = datum_rodjenja;
    }

    public Uloga getUloga() {
        return uloga;
    }

    public void setUloga(Uloga uloga) {
        this.uloga = uloga;
    }

    public Boolean getAktivan() {
        return aktivan;
    }

    public void setAktivan(Boolean aktivan) {
        this.aktivan = aktivan;
    }

    public Set<Odradjen_trening> getOdradjen_trening() {
        return odradjen_trening;
    }

    public void setOdradjen_trening(Set<Odradjen_trening> odradjen_trening) {
        this.odradjen_trening = odradjen_trening;
    }

    public Set<Prijavljen_Trening> getPrijavljen_trening() {
        return prijavljen_trening;
    }

    public void setPrijavljen_trening(Set<Prijavljen_Trening> prijavljen_trening) {
        this.prijavljen_trening = prijavljen_trening;
    }

    public Set<Trening> getTrening() {
        return trening;
    }

    public void setTrening(Set<Trening> trening) {
        this.trening = trening;
    }
}
