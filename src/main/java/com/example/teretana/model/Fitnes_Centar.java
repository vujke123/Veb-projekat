package com.example.teretana.model;
import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

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

    @OneToMany (mappedBy= "Fitnes_Centar",fetch=FetchType.LAZY,cascade=CascadeType.ALL)
    private Set<Korisnik> trener=new HashSet<>();

    @OneToMany (mappedBy= "Fitnes_centar",fetch=FetchType.LAZY,cascade=CascadeType.ALL)
    private Set<Sala> sale=new HashSet<>();

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

}