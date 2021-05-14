package com.example.teretana.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Sala implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private int kapacitet;

    @Column
    private String oznaka_sale;

    @ManyToMany(mappedBy = "Sale" , fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Odrzavanje_treninga> odrzavanje_treninga = new HashSet<>();

    @ManyToOne(fetch=FetchType.EAGER,cascade=CascadeType.ALL)
    private Fitnes_Centar Fitnes_centar;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getKapacitet() {
        return kapacitet;
    }

    public void setKapacitet(int kapacitet) {
        this.kapacitet = kapacitet;
    }

    public String getOznaka_sale() {
        return oznaka_sale;
    }

    public void setOznaka_sale(String oznaka_sale) {
        this.oznaka_sale = oznaka_sale;
    }

    public Set<Odrzavanje_treninga> getOdrzavanje_treninga() {
        return odrzavanje_treninga;
    }

    public void setOdrzavanje_treninga(Set<Odrzavanje_treninga> odrzavanje_treninga) {
        this.odrzavanje_treninga = odrzavanje_treninga;
    }

    public Fitnes_Centar getCentar() {
        return Fitnes_centar;
    }

    public void setCentar(Fitnes_Centar centar) {
        this.Fitnes_centar = centar;
    }
}

