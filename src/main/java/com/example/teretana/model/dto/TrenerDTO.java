package com.example.teretana.model.dto;


import com.example.teretana.model.Uloga;

public class TrenerDTO {

    private Long fitnes_id;

    private String korisnicko_ime;

    private String lozinka;

    private String ime;

    private String prezime;

    private String kontakt_broj;

    private String email;

    private Uloga uloga;

    private String datum_rodjenja;

    private Boolean aktivan;

    public Long getFitnes_id() {
        return fitnes_id;
    }

    public void setFitnes_id(Long fitnes_id) {
        this.fitnes_id = fitnes_id;
    }

    public String getKorisnicko_ime() {
        return korisnicko_ime;
    }

    public void setKorisnicko_ime(String korisnicko_ime) {
        this.korisnicko_ime = korisnicko_ime;
    }

    public String getLozinka() {
        return lozinka;
    }

    public void setLozinka(String lozinka) {
        this.lozinka = lozinka;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getKontakt_broj() {
        return kontakt_broj;
    }

    public void setKontakt_broj(String kontakt_broj) {
        this.kontakt_broj = kontakt_broj;
    }

    public String getEmail() {
        return email;
    }


    public void setEmail(String email) {
        this.email = email;
    }

    public Uloga getUloga() {
        return uloga;
    }

    public void setUloga(Uloga uloga) {
        this.uloga = uloga;
    }

    public String getDatum_rodjenja() {
        return datum_rodjenja;
    }

    public void setDatum_rodjenja(String datum_rodjenja) {
        this.datum_rodjenja = datum_rodjenja;
    }

    public Boolean getAktivan() {
        return aktivan;
    }

    public void setAktivan(Boolean aktivan) {
        this.aktivan = aktivan;
    }

    public TrenerDTO() {}
}
