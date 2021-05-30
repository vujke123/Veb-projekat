package com.example.teretana.service;

import com.example.teretana.model.Trening;
import com.example.teretana.model.dto.TreninziDTO;
import com.example.teretana.repository.TreningRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;


@Service
public class TreningService {
    @Autowired
    private TreningRepository treningRepository;

    public Trening findOne(Long id) {
        Trening trening= this.treningRepository.findById(id).get();
        return trening;
    }

    public List<Trening> findAll() {
        List<Trening> treninzi= this.treningRepository.findAll();
        return treninzi;
    }

    public Trening save(Trening trening){
        return this.treningRepository.save(trening);
    }

    public TreninziDTO getData() {
        List<Trening> treninzi = findAll();
        List<String> tip = new ArrayList<String>();
        for(int i=0; i<treninzi.size();i++){
            if(!tip.contains(treninzi.get(i).getTip_treninga())) {
                tip.add(treninzi.get(i).getTip_treninga());
            }
        }
        return new TreninziDTO(treninzi,tip);
    }

   // public void setRating(Long id, double ocena ) {this.treningRepository.setRating(id,ocena);}

}
