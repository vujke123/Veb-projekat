package com.example.teretana.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
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

    @ManyToMany(cascade=CascadeType.ALL)
    @JoinTable(name = "REZERVACIJE",
            joinColumns = @JoinColumn(name = "clan_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "odrzavanje_id", referencedColumnName = "id"))
    Set<Odrzavanje_treninga> prijavljen=new HashSet<>();

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


    public Set<Trening> getTrening() {
        return trening;
    }

    public void setTrening(Set<Trening> trening) {
        this.trening = trening;
    }

    public Set<Odrzavanje_treninga> getPrijavljen() {
        return prijavljen;
    }

    public void setPrijavljen(Set<Odrzavanje_treninga> prijavljen) {
        this.prijavljen = prijavljen;
    }

    public com.example.teretana.model.Fitnes_Centar getFitnes_Centar() {
        return Fitnes_Centar;
    }

    public void setFitnes_Centar(com.example.teretana.model.Fitnes_Centar fitnes_Centar) {
        Fitnes_Centar = fitnes_Centar;
    }

    public Korisnik() {}

    public Korisnik(Long id, String korisnicko_ime, String lozinka, String ime, String prezime, String kontakt_broj, String email, String datum_rodjenja,
                    Uloga uloga, Boolean aktivan, Set<Odrzavanje_treninga> prijavljen, Set<Trening> trening, com.example.teretana.model.Fitnes_Centar fitnes_Centar) {
        this.id = id;
        this.korisnicko_ime = korisnicko_ime;
        this.lozinka = lozinka;
        this.ime = ime;
        this.prezime = prezime;
        this.kontakt_broj = kontakt_broj;
        this.email = email;
        this.datum_rodjenja = datum_rodjenja;
        this.uloga = uloga;
        this.aktivan = aktivan;
        this.prijavljen = prijavljen;
        this.trening = trening;
        this.Fitnes_Centar = fitnes_Centar;
    }
}

