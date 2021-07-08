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

    public void deleteFitnes(Long id) {
        this.fitnesRepository.deleteById(id);
    }

    public void editFitnes(Fitnes_Centar fitnes) {
      // this.fitnesRepository.updateFitnes(fitnes.getId(),fitnes.getNaziv(),fitnes.getAdresa(),fitnes.getBr_tel_centrale(),fitnes.getEmail());
    }
}
