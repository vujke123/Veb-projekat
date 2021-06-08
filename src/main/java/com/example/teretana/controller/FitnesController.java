package com.example.teretana.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import com.example.teretana.service.FitnesService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.example.teretana.model.Fitnes_Centar;
import com.example.teretana.service.FitnesService;
import com.example.teretana.model.dto.FitnesDTO;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


import java.util.List;


@Controller
public class FitnesController {

    @Autowired
    private FitnesService fitnesService;

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
}
