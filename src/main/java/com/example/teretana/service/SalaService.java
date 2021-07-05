package com.example.teretana.service;

import com.example.teretana.model.Fitnes_Centar;
import com.example.teretana.model.Sala;
import com.example.teretana.repository.SalaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service
public class SalaService {

    @Autowired
    private SalaRepository salaRepository;

    @Autowired
    private FitnesService fitnesService;

    public Sala findOne(Long id) {
    Sala sala = this.salaRepository.findById(id).get();
    return sala;
    }

    public List<Sala> findAll() {
        List<Sala> sale = this.salaRepository.findAll();
        return sale;
    }

    public Sala save(Sala sala) {
        return this.salaRepository.save(sala);
    }

    public  void editRoom(Sala sala) { this.salaRepository.updateRoom(sala.getId(),sala.getKapacitet(),sala.getOznaka_sale());}

    public boolean deleteById(Long fitnes_id , Long sala_id) {
        try{
            Fitnes_Centar fitnes = this.fitnesService.findOne(fitnes_id);
            Sala sala = this.salaRepository.findById(sala_id).get();
            fitnes.getSale().remove(sala);
            sala.getOdrzavanje().clear();
            this.salaRepository.deleteById(sala_id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
