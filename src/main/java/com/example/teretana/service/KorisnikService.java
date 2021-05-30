package com.example.teretana.service;

import com.example.teretana.model.Korisnik;
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

    public Korisnik save(Korisnik korisnik) { return this.korisnikRepository.save(korisnik);}

    public Korisnik checkEmail(KorisnikDTO korisnikDTO) {
        Korisnik korisnik = this.korisnikRepository.findByEmail(korisnikDTO.getEmail());
        if (korisnik == null)
            return null;
        return korisnik;
    }


}
