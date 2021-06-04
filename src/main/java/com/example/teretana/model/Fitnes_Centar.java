package com.example.teretana.model;
import com.example.teretana.model.dto.FitnesDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
public class Fitnes_Centar implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String naziv;

    @Column
    private String adresa;

    @Column
    private String br_tel_centrale;

    @Column(unique = true)
    private String email;
    @JsonIgnore
    @OneToMany (mappedBy= "Fitnes_Centar",fetch=FetchType.LAZY,cascade=CascadeType.ALL)
    private Set<Korisnik> trener=new HashSet<>();

    @OneToMany (mappedBy= "Fitnes_centar",fetch=FetchType.LAZY,cascade=CascadeType.ALL)
    private Set<Sala> sale=new HashSet<>();

    @OneToMany(mappedBy = "fitnes", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Odrzavanje_treninga> odrzavanje=new HashSet<>();

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

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public String getBr_tel_centrale() {
        return br_tel_centrale;
    }

    public void setBr_tel_centrale(String br_tel_centrale) {
        this.br_tel_centrale = br_tel_centrale;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<Korisnik> getTrener() {
        return trener;
    }

    public void setTrener(Set<Korisnik> trener) {
        this.trener = trener;
    }

    public Set<Sala> getSale() {
        return sale;
    }

    public void setSale(Set<Sala> sale) {
        this.sale = sale;
    }

    public Set<Odrzavanje_treninga> getOdrzavanje() {
        return odrzavanje;
    }

    public void setOdrzavanje(Set<Odrzavanje_treninga> odrzavanje) {
        this.odrzavanje = odrzavanje;
    }

    public Fitnes_Centar(Long id, String naziv, String adresa, String br_tel_centrale, String email, Set<Korisnik> trener,
                         Set<Sala> sale, Set<Odrzavanje_treninga> odrzavanje) {
        this.id = id;
        this.naziv = naziv;
        this.adresa = adresa;
        this.br_tel_centrale = br_tel_centrale;
        this.email = email;
        this.trener = trener;
        this.sale = sale;
        this.odrzavanje = odrzavanje;
    }

    public Fitnes_Centar() {}

    public static Fitnes_Centar getFitnesDTO(FitnesDTO fitnesDTO) {
        Fitnes_Centar fitnes= new Fitnes_Centar();
        fitnes.setAdresa(fitnesDTO.getAdresa());
        fitnes.setEmail(fitnesDTO.getEmail());
        fitnes.setNaziv(fitnesDTO.getNaziv());
        fitnes.setBr_tel_centrale(fitnesDTO.getBr_tel_centrale());
        return fitnes;
    }

    public Fitnes_Centar(String naziv, String adresa, String br_tel_centrale, String email) {
        this.naziv = naziv;
        this.adresa = adresa;
        this.br_tel_centrale = br_tel_centrale;
        this.email = email;
    }

    public Fitnes_Centar(String naziv, String adresa) {
        this.naziv = naziv;
        this.adresa = adresa;
    }
}