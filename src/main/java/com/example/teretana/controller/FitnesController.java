package com.example.teretana.controller;

import com.example.teretana.model.Korisnik;
import com.example.teretana.service.KorisnikService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import com.example.teretana.service.FitnesService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.example.teretana.model.Fitnes_Centar;
import com.example.teretana.service.FitnesService;
import com.example.teretana.model.dto.FitnesDTO;


import java.util.List;


@Controller
public class FitnesController {

    @Autowired
    private FitnesService fitnesService;

    @Autowired
    private KorisnikService korisnikService;

    @GetMapping("/fitnesi")
    public String wel(Model model) {
        List<Fitnes_Centar> fitnesi = this.fitnesService.findAll();
        model.addAttribute("fitnesi", fitnesi);
        return "fitnesi";
    }


    @PostMapping( "/dodaj-fitnes")
    public ResponseEntity<?> add(@RequestBody FitnesDTO fitnesDTO){
        Fitnes_Centar fitnes_centar=fitnesService.save(Fitnes_Centar.getFitnesDTO(fitnesDTO));
        if (fitnes_centar == null)
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        return new ResponseEntity<Fitnes_Centar>(fitnes_centar, HttpStatus.OK);
    }

    @GetMapping("/fitnes/{id}")
    public String fitnes(@PathVariable(name="id") Long id, Model model) {
        Fitnes_Centar fitnes=this.fitnesService.findOne(id);
        model.addAttribute("fitnes", fitnes);
        return "fitnes";
    }

    @DeleteMapping("/ukloni-fitnes/{id}")
    public ResponseEntity<?> delete(@PathVariable(name = "id") Long id) {
        try{
            this.fitnesService.deleteFitnes(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e ) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/uredi_fitnes")
    public ResponseEntity<?> edit_fitnes(@RequestBody Fitnes_Centar fitnes) {
        try {
            this.fitnesService.editFitnes(fitnes);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }



}
