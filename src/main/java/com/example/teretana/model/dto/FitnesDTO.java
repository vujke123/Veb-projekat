package com.example.teretana.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FitnesDTO {

    private String naziv;

    private String adresa;

    private String br_tel_centrale;

    private String email;

    private String ocena;

    public String getOcena() {
        return ocena;
    }

    public void setOcena(String ocena) {
        this.ocena = ocena;
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

    public FitnesDTO(String naziv, String adresa, String br_tel_centrale, String email) {
        this.naziv = naziv;
        this.adresa = adresa;
        this.br_tel_centrale = br_tel_centrale;
        this.email = email;
    }

}
