package com.example.teretana.controller;

import com.example.teretana.model.Korisnik;
import com.example.teretana.model.dto.KorisnikDTO;
import com.example.teretana.service.KorisnikService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class KorisnikController {
    @Autowired
    private KorisnikService korisnikService;

    @GetMapping("/registracija")
    public String registracija() {
        return "register";
    }

    @PostMapping ( "/registracija-korisnika")
    public ResponseEntity<?> registracija(@RequestBody KorisnikDTO korisnik){
        Korisnik korisnik1;
        try {
            korisnik1=korisnikService.save(korisnik);
        }   catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        return new ResponseEntity<Korisnik>(korisnik1, HttpStatus.OK);
    }

    @GetMapping("/profil/{id}")
    public String account(@PathVariable(name = "id") Long id, Model model) {
        Korisnik korisnik= this.korisnikService.findOne(id);
        model.addAttribute("korisnik", korisnik);
        return "profil.html";
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody KorisnikDTO korisnikDTO) {
        Korisnik korisnik;
        try {
            korisnik =this.korisnikService.checkEmail(korisnikDTO);
        } catch (Exception e) {
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_ACCEPTABLE);
        }
        if(korisnik==null || !korisnik.getLozinka().equals(korisnikDTO.getLozinka())) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<Korisnik>(korisnik, HttpStatus.OK);
    }
}
