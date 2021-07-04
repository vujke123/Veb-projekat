package com.example.teretana.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
public class Sala implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private int kapacitet;

    @Column
    private String oznaka_sale;

    @JsonIgnore
    @ManyToMany(cascade=CascadeType.ALL)
    @JoinTable(name = "SOBE_ODRZAVANJE",
            joinColumns = @JoinColumn(name = "soba_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "odrzavanje_id", referencedColumnName = "id"))
    private Set<Odrzavanje_treninga> odrzavanje = new HashSet<>();

    @ManyToOne(fetch=FetchType.EAGER,cascade=CascadeType.ALL)
    private Fitnes_Centar fitnes_centar;

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

    public Fitnes_Centar getCentar() {
        return fitnes_centar;
    }

    public void setCentar(Fitnes_Centar centar) {
        this.fitnes_centar = centar;
    }

    public Set<Odrzavanje_treninga> getOdrzavanje() {
        return odrzavanje;
    }

    public void setOdrzavanje(Set<Odrzavanje_treninga> odrzavanje) {
        this.odrzavanje = odrzavanje;
    }

    public Fitnes_Centar getFitnes_centar() {
        return fitnes_centar;
    }

    public void setFitnes_centar(Fitnes_Centar fitnes_centar) {
        fitnes_centar = fitnes_centar;
    }

    public Sala() {}

    public Sala(int kapacitet, String oznaka_sale, Set<Odrzavanje_treninga> odrzavanje,
                Fitnes_Centar fitnes_centar) {
        super();
        this.kapacitet = kapacitet;
        this.oznaka_sale = oznaka_sale;
        this.odrzavanje = odrzavanje;
        this.fitnes_centar = fitnes_centar;
    }
}

