package com.example.Vebprojekat.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Odrzavanje_treninga implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String Dan;

    @Column
    private String cena_karte;

    @ManyToOne(fetch=FetchType.EAGER,cascade=CascadeType.ALL)
    private Sala sala;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDan() {
        return Dan;
    }

    public void setDan(String dan) {
        Dan = dan;
    }

    public String getCena_karte() {
        return cena_karte;
    }

    public void setCena_karte(String cena_karte) {
        this.cena_karte = cena_karte;
    }

    public Sala getSala() {
        return sala;
    }

    public void setSala(Sala sala) {
        this.sala = sala;
    }

}
