package com.example.teretana.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.teretana.model.Fitnes_Centar;
import com.example.teretana.repository.FitnesRepository;
import com.example.teretana.model.Korisnik;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service
public class FitnesService {

    @Autowired
    private FitnesRepository fitnesRepository;

    public List<Fitnes_Centar> findAll() {
        List<Fitnes_Centar> fitnesi = this.fitnesRepository.findAll();
        return fitnesi;
    }

    public Fitnes_Centar findOne(Long id){
        Fitnes_Centar fitnes_centar = this.fitnesRepository.findById(id).get();
        return fitnes_centar;
    }

    public Fitnes_Centar save(Fitnes_Centar fitnes_Centar) {
        return  this.fitnesRepository.save(fitnes_Centar);
    }

    public void deleteFitnes(Long id){
       this.fitnesRepository.deleteByNaziv("OLP");

    }

    public void editFitnes(Fitnes_Centar fitnes) {
        Fitnes_Centar fitnes_centar = this.fitnesRepository.findById(fitnes.getId()).orElse(null);
        fitnes_centar.setNaziv(fitnes.getNaziv());
        fitnes_centar.setAdresa(fitnes.getAdresa());
        fitnes_centar.setBr_tel_centrale(fitnes.getBr_tel_centrale());
        fitnes_centar.setEmail(fitnes.getEmail());
        this.fitnesRepository.save(fitnes_centar);
       // this.fitnesRepository.updateFitnes(fitnes.getId(),fitnes.getNaziv(),fitnes.getAdresa(),fitnes.getBr_tel_centrale(),fitnes.getEmail());
    }

    public void rateFitnes(Fitnes_Centar fitnes) {
        Fitnes_Centar fitnes_centar = this.fitnesRepository.findById(fitnes.getId()).orElse(null);
        fitnes_centar.setNaziv(fitnes.getNaziv());
        fitnes_centar.setAdresa(fitnes.getAdresa());
        fitnes_centar.setBr_tel_centrale(fitnes.getBr_tel_centrale());
        fitnes_centar.setEmail(fitnes.getEmail());
        fitnes_centar.setOcena(fitnes.getOcena());
        this.fitnesRepository.save(fitnes_centar);
    }
}
