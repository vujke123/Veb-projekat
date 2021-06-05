package com.example.teretana.service;

import com.example.teretana.model.Korisnik;
import com.example.teretana.model.Uloga;
import com.example.teretana.model.dto.KorisnikDTO;
import com.example.teretana.repository.KorisnikRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service
public class KorisnikService {

    @Autowired
    private KorisnikRepository korisnikRepository;


    public Korisnik findOne(Long id){
        Korisnik korisnik = this.korisnikRepository.findById(id).get();
        return korisnik;
    }

    public List<Korisnik> findAll() {
        List<Korisnik> korisnici = this.korisnikRepository.findAll();
        return korisnici;
    }

    public Korisnik save(KorisnikDTO korisnik) {
        Korisnik newKorisnik = new Korisnik();
        newKorisnik.setEmail(korisnik.getEmail());
        newKorisnik.setIme(korisnik.getIme());
        newKorisnik.setPrezime(korisnik.getPrezime());
        newKorisnik.setDatum_rodjenja(korisnik.getDatum_rodjenja());
        newKorisnik.setKontakt_broj(korisnik.getKontakt_broj());
        newKorisnik.setKorisnicko_ime(korisnik.getKorisnicko_ime());
        newKorisnik.setLozinka(korisnik.getLozinka());
        newKorisnik.setAktivan(true);
        newKorisnik.setUloga(Uloga.CLAN);

        return this.korisnikRepository.save(newKorisnik);
    }

    public Korisnik checkEmail(KorisnikDTO korisnikDTO) {
        Korisnik korisnik = this.korisnikRepository.findByEmail(korisnikDTO.getEmail());
        if (korisnik == null)
            return null;
        return korisnik;
    }


}
