package com.example.teretana.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class KorisnikDTO {
    private String email;
    private String lozinka;
    private String ime;
    private String prezime;
    private String korisnicko_ime;
    private String kontakt_broj;
    private String datum_rodjenja;

}
