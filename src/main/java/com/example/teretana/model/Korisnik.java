package com.example.teretana.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Korisnik implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String korisnicko_ime;

    @Column
    private String lozinka;

    @Column
    private String ime;

    @Column
    private String prezime;

    @Column
    private String kontakt_broj;

    @Column
    private String email;

    @Column
    private String datum_rodjenja;

    @Column
    private Uloga uloga;

    @Column
    private Boolean aktivan;

    @JsonIgnore
    @ManyToMany(cascade=CascadeType.ALL)
    @JoinTable(name = "REZERVACIJE",
            joinColumns = @JoinColumn(name = "clan_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "odrzavanje_id", referencedColumnName = "id"))
    Set<Odrzavanje_treninga> prijavljen=new HashSet<>();

    @OneToMany( mappedBy = "Trener", fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private Set <Trening> trening=new HashSet<>();

    @ManyToOne( fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Fitnes_Centar Fitnes_Centar;


    public void setFitnes_Centar(com.example.teretana.model.Fitnes_Centar fitnes_Centar) {
        Fitnes_Centar = fitnes_Centar;
    }

}

