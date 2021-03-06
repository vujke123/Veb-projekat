package com.example.teretana.service;

import com.example.teretana.model.*;
import com.example.teretana.model.dto.KorisnikDTO;
import com.example.teretana.model.dto.SalaDTO;
import com.example.teretana.model.dto.TrenerDTO;
import com.example.teretana.repository.KorisnikRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Set;

@Transactional
@Service
public class KorisnikService {

    @Autowired
    private KorisnikRepository korisnikRepository;

    @Autowired
    private FitnesService fitnesService;

    @Autowired
    private SalaService salaService;

    @Autowired
    private OdrzavanjeTreningaService odrzavanjeTreningaService;


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
    public void addRoom(SalaDTO salaDTO) {
        Fitnes_Centar fitnes_centar=this.fitnesService.findOne(salaDTO.getFitnesId());
        Sala room=new Sala(Math.toIntExact(salaDTO.getKapacitet()),salaDTO.getOznaka(),null,fitnes_centar);
        this.salaService.save(room);
    }

    public void editRoom(Sala sala) {this.salaService.editRoom(sala);}

    public List<Korisnik> getTreneri() {return this.korisnikRepository.findByUloga(Uloga.TRENER);}

    public void deleteUser(Long id) {
        this.korisnikRepository.deleteById(id);
    }

    public void saveTrener(TrenerDTO korisnik) {
        Korisnik newKorisnik = new Korisnik();
        newKorisnik.setEmail(korisnik.getEmail());
        newKorisnik.setIme(korisnik.getIme());
        newKorisnik.setPrezime(korisnik.getPrezime());
        newKorisnik.setDatum_rodjenja(korisnik.getDatum_rodjenja());
        newKorisnik.setKontakt_broj(korisnik.getKontakt_broj());
        newKorisnik.setKorisnicko_ime(korisnik.getKorisnicko_ime());
        newKorisnik.setLozinka(korisnik.getLozinka());
        newKorisnik.setAktivan(true);
        newKorisnik.setUloga(Uloga.TRENER);

        this.korisnikRepository.save(newKorisnik);
    }

    public boolean addReservation (Long korisnik_id, Long trening_id) {
        Korisnik korisnik = this.korisnikRepository.findById(korisnik_id).get();
        Odrzavanje_treninga odrzavanje_treninga = this.odrzavanjeTreningaService.findOne(trening_id);
        if(korisnik.getPrijavljen().contains(odrzavanje_treninga)) {
            return false;
        }
        for(Sala sala: odrzavanje_treninga.getSale()) {
            if(sala.getKapacitet() - odrzavanje_treninga.getClan().size() > 0) {
                korisnik.getPrijavljen().add(odrzavanje_treninga);
                return true;
            }
        }
        return false;
    }

    public void cancelReservation(Long id , Long odrzavanje_id) {
        Korisnik korisnik = this.korisnikRepository.findById(id).get();
        Odrzavanje_treninga odrzavanje_treninga = this.odrzavanjeTreningaService.findOne(odrzavanje_id);
        korisnik.getPrijavljen().remove(odrzavanje_treninga);
        return;
    }
}
