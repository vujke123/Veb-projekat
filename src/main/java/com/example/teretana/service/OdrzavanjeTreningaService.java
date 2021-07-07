package com.example.teretana.service;

import com.example.teretana.model.Fitnes_Centar;
import com.example.teretana.model.Odrzavanje_treninga;
import com.example.teretana.model.Sala;
import com.example.teretana.model.Trening;
import com.example.teretana.model.dto.OdrzavanjeDTO;
import com.example.teretana.repository.OdrzavanjeTreningaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.Date;
import java.util.List;

@Transactional
@Service
public class OdrzavanjeTreningaService {

    @Autowired
    private OdrzavanjeTreningaRepository odrzavanjeTreningaRepository;

    @Autowired
    private FitnesService fitnesService;

    @Autowired
    private TreningService treningService;

    @Autowired
    private SalaService salaService;

    public Odrzavanje_treninga findOne(Long id) {
        Odrzavanje_treninga odrzavanje_treninga= this.odrzavanjeTreningaRepository.findById(id).get();
        return odrzavanje_treninga;
    }

    public List<Odrzavanje_treninga> findAll() {
        List<Odrzavanje_treninga> odrzavanje_treninga=this.odrzavanjeTreningaRepository.findAll();
        return odrzavanje_treninga;
    }

    public Odrzavanje_treninga save(Odrzavanje_treninga odrzavanje_treninga) {
        return this.odrzavanjeTreningaRepository.save(odrzavanje_treninga);
    }

    public List<Odrzavanje_treninga> findByFitnesId(Long id) {
        return odrzavanjeTreningaRepository.findByFitnesId(id);
    }

    public void addOdrzavanje_treninga(OdrzavanjeDTO odrzavanjeDTO) {
        Odrzavanje_treninga odrzavanje_treninga=new Odrzavanje_treninga();
        Fitnes_Centar fitnes_centar= this.fitnesService.findOne(odrzavanjeDTO.getFitnes_id());
        Trening trening = this.treningService.findOne(odrzavanjeDTO.getTrening_id());
        Sala sala = this.salaService.findOne(odrzavanjeDTO.getSala_id());
        odrzavanje_treninga.setFitnes(fitnes_centar);
        odrzavanje_treninga.setTrening(trening);
        odrzavanje_treninga.getSale().add(sala);
        odrzavanje_treninga.setDan((Date) odrzavanjeDTO.getDan());
        odrzavanje_treninga.setCena_karte(odrzavanjeDTO.getCena());
        odrzavanje_treninga.setVreme(odrzavanjeDTO.getVreme());
        odrzavanje_treninga.setClan(null);
        this.odrzavanjeTreningaRepository.save(odrzavanje_treninga);
        //  fitnes_centar.getSchedule().add(odrzavanje_treninga);
        //  sala.getProjections().add(odrzavanje_treninga);

    }
}
