package com.example.teretana.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OdrzavanjeDTO {
    private Date dan;
    private String vreme;
    private String cena;
    private Long trening_id;
    private Long sala_id;
    private Long fitnes_id;

    public Date getDan() {
        return dan;
    }

    public void setDan(Date dan) {
        this.dan = dan;
    }

    public String getNaziv() {
        return vreme;
    }

    public void setNaziv(String naziv) {
        this.vreme = naziv;
    }

    public String getCena() {
        return cena;
    }

    public void setCena(String cena) {
        this.cena = cena;
    }

    public Long getTrening_id() {
        return trening_id;
    }

    public void setTrening_id(Long trening_id) {
        this.trening_id = trening_id;
    }

    public Long getSala_id() {
        return sala_id;
    }

    public void setSala_id(Long sala_id) {
        this.sala_id = sala_id;
    }

    public Long getFitnes_id() {
        return fitnes_id;
    }

    public void setFitnes_id(Long fitnes_id) {
        this.fitnes_id = fitnes_id;
    }
}
