package com.example.teretana.model;
import com.example.teretana.model.dto.FitnesDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Data
@AllArgsConstructor
@NoArgsConstructor
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