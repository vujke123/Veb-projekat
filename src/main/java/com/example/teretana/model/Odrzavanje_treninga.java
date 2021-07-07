package com.example.teretana.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
public class Odrzavanje_treninga implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Date Dan;

    @Column
    private String Vreme;

    @Column
    private String cena_karte;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Trening trening;

    @ManyToMany(mappedBy = "odrzavanje", cascade = CascadeType.ALL)
    private Set<Sala> sale = new HashSet<>();

    @ManyToOne(fetch = FetchType.EAGER)
    private Fitnes_Centar fitnes;

    @ManyToMany(mappedBy = "prijavljen")
    private Set<Korisnik> clan = new HashSet<>();


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDan() {
        return Dan;
    }

    public void setDan(Date dan) {
        Dan = dan;
    }

    public String getCena_karte() {
        return cena_karte;
    }

    public void setCena_karte( String cena_karte) {
        this.cena_karte = cena_karte;
    }

    public String getVreme() {
        return Vreme;
    }

    public void setVreme(String vreme) {
        Vreme = vreme;
    }

    public Trening getTrening() {
        return trening;
    }

    public void setTrening(Trening trening) {
        this.trening = trening;
    }

    public Set<Sala> getSale() {
        return sale;
    }

    public void setSale(Set<Sala> sale) {
        this.sale = sale;
    }

    public Fitnes_Centar getFitnes() {
        return fitnes;
    }

    public void setFitnes(Fitnes_Centar fitnes) {
        this.fitnes = fitnes;
    }

    public Set<Korisnik> getClan() {
        return clan;
    }

    public void setClan(Set<Korisnik> clan) {
        this.clan = clan;
    }

    public Odrzavanje_treninga(Long id, Date dan, String vreme,
                               String cena_karte, Trening trening, Set<Sala> sale, Fitnes_Centar fitnes, Set<Korisnik> clan) {
        this.id = id;
        Dan = dan;
        Vreme = vreme;
        this.cena_karte = cena_karte;
        this.trening = trening;
        this.sale = sale;
        this.fitnes = fitnes;
        this.clan = clan;
    }

    public Odrzavanje_treninga() {
    }

}