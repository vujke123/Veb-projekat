package com.example.teretana.controller;

import com.example.teretana.model.Fitnes_Centar;
import com.example.teretana.model.Korisnik;
import com.example.teretana.model.Sala;
import com.example.teretana.model.Trening;
import com.example.teretana.model.dto.*;
import com.example.teretana.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.jws.WebParam;
import java.util.List;

@Controller
public class KorisnikController {
    @Autowired
    private KorisnikService korisnikService;

    @Autowired
    private SalaService salaService;

    @Autowired
    private FitnesService fitnesService;

    @Autowired
    private TreningService treningService;

    @Autowired
    private OdrzavanjeTreningaService odrzavanjeTreningaService;

    @GetMapping("/registracija")
    public String registracija() {
        return "register";
    }

    @PostMapping("/registracija-korisnika")
    public ResponseEntity<?> registracija(@RequestBody KorisnikDTO korisnik) {
        Korisnik korisnik1;
        try {
            korisnik1 = korisnikService.save(korisnik);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        return new ResponseEntity<Korisnik>(korisnik1, HttpStatus.OK);
    }

    @GetMapping("/profil/{id}")
    public String account(@PathVariable(name = "id") Long id, Model model) {
        Korisnik korisnik = this.korisnikService.findOne(id);
        model.addAttribute("korisnik", korisnik);
        return "profil";
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody KorisnikDTO korisnikDTO) {
        Korisnik korisnik;
        try {
            korisnik = this.korisnikService.checkEmail(korisnikDTO);
        } catch (Exception e) {
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_ACCEPTABLE);
        }
        if (korisnik == null || !korisnik.getLozinka().equals(korisnikDTO.getLozinka())) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<Korisnik>(korisnik, HttpStatus.OK);
    }

    @DeleteMapping("/delete_room/{fitnes_id}/sala/{sala_id}")
    public ResponseEntity<?> delete_room(@PathVariable(name = "fitnes_id") Long fitnes_id, @PathVariable(name = "soba_id") Long soba_id) {
        try {
            if (this.salaService.deleteById(fitnes_id, soba_id))
                return new ResponseEntity<>(HttpStatus.OK);
            else
                return new ResponseEntity<>(HttpStatus.CONFLICT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/profil/{id}/fitnes/sala/{sala_id}")
    public String room_editing(@PathVariable(name = "id") Long id, @PathVariable(name = "sala_id") Long sala_id, Model model){
    Sala sala = this.salaService.findOne(sala_id);
    model.addAttribute("sala",sala);
    return "room";
}

    @PostMapping("/dodaj_sobu")
    public ResponseEntity<?> add_room(@RequestBody SalaDTO sala) {
        try {
            korisnikService.addRoom(sala);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
    }
    @PutMapping("/edit_room")
    public ResponseEntity<?> edit_room(@RequestBody Sala sala){
        try{
            this.korisnikService.editRoom(sala);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }

    @GetMapping("/profil/{id}/treneri")
    public String treneri(@PathVariable(name = "id") Long id, Model model) {
        List<Korisnik> korisnici = this.korisnikService.getTreneri();
        Korisnik korisnik = this.korisnikService.findOne(id);
        model.addAttribute("treneri",korisnici);
        model.addAttribute("korisnik",korisnik);
        return "trener.html";
    }

    @GetMapping("/sala/{id}")
    public String sala(@PathVariable(name="id") Long id, Model model) {
        Sala sala=this.salaService.findOne(id);
        model.addAttribute("sala", sala);
        return "izmena-sale.html";
    }

    @PutMapping("/uredi_salu")
    public ResponseEntity<?> edit_sala(@RequestBody Sala sala) {
        try {
            this.salaService.editSala(sala);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }


    @GetMapping("/profil/{id}/sale")
    public String sale(@PathVariable(name = "id") Long id, Model model) {
        List<Sala> sale = this.salaService.findAll();
        Korisnik korisnik = this.korisnikService.findOne(id);
        model.addAttribute("sale", sale);
        model.addAttribute("korisnik",korisnik);
        return "sala.html";
    }
    @GetMapping("/profil/{id}/registracija-trenera")
    public String registracija_trenera(@PathVariable(name = "id") Long id, Model model) {
        List <Fitnes_Centar> fitnesi = this.fitnesService.findAll();
        Korisnik korisnik = this.korisnikService.findOne(id);
        model.addAttribute("fitnesi",fitnesi);
        model.addAttribute("korisnik", korisnik);
        return "registracija-trenera.html";
    }

    @GetMapping("/profil/{id}/registracija-sale")
    public String registracija_sale(@PathVariable(name = "id") Long id, Model model) {
        List <Sala> sale = this.salaService.findAll();
        Korisnik korisnik = this.korisnikService.findOne(id);
        model.addAttribute("sale",sale);
        model.addAttribute("korisnik", korisnik);
        return "registracija-sale.html";
    }

    @PostMapping("/registracija-tren")
    public ResponseEntity<?> create_trenera(@RequestBody TrenerDTO trenerDTO) {
        try {
            this.korisnikService.saveTrener(trenerDTO);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
            return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/registracija-sal")
    public ResponseEntity<?> create_sale(@RequestBody Sala salaDTO) {
        try {
            this.salaService.saveSala(salaDTO);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping ("/ukloni-trenera/{id}")
    public ResponseEntity<?> obrisi_tren(@PathVariable(name = "id") Long id) {
        try{
            this.korisnikService.deleteUser(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping ("/ukloni-salu/{id}")
    public ResponseEntity<?> obrisi_salu(@PathVariable(name = "id") Long id) {
        try {
            this.salaService.deleteSala(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping ("/profil/{id}/odradjeni_treninzi")
    public String odradjen_trening(@PathVariable(name = "id") Long id , Model model) {
        Korisnik korisnik = this.korisnikService.findOne(id);
        model.addAttribute("korisnik",korisnik);
        return "odradjeni_treninzi.html";
    }

    @PostMapping ("/prijavljen")
    public ResponseEntity<?> prijavljen_trening(@RequestBody RezervisaniDTO rezervisaniDTO) {
        boolean flag = false;
        try {
            flag= this.korisnikService.addReservation(rezervisaniDTO.getClan_id(),rezervisaniDTO.getOdrzavanje_id());
            if(flag)
                return new ResponseEntity<>(HttpStatus.OK);
            else
                return new ResponseEntity<>(HttpStatus.CONFLICT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/profil/{id}/prijavljen")
    public String prijavljen(@PathVariable(name = "id") Long id , Model model) {
        Korisnik korisnik = this.korisnikService.findOne(id);
        model.addAttribute("korisnik" , korisnik);
        return "prijavljen.html";

    }

    @GetMapping("/profil/{id}/addTrening")
    public String addTrening(@PathVariable(name = "id") Long id , Model model){
        Korisnik korisnik = this.korisnikService.findOne(id);
        Fitnes_Centar fitnes_centar = korisnik.getFitnes_Centar();
        List<Trening> treninzi = this.treningService.findAll();
        model.addAttribute("korisnik" , korisnik);
        model.addAttribute("fitnes" , fitnes_centar);
        model.addAttribute("treninzi", treninzi);
        return "addTrening";

    }

    @PostMapping("/addTrening")
    public ResponseEntity<?> add_trening(@RequestBody OdrzavanjeDTO odrzavanjeDTO) {
        try {
            this.odrzavanjeTreningaService.addOdrzavanje_treninga(odrzavanjeDTO);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }

    }

    @GetMapping ("/profil/{id}/fitnes")
    public String tre_fitnes(@PathVariable(name = "id") Long id, Model model) {
        Korisnik korisnik = this.korisnikService.findOne(id);
        Fitnes_Centar fitnes_centar = korisnik.getFitnes_Centar();
        model.addAttribute("fitnes" , fitnes_centar);
        model.addAttribute("korisnik" , korisnik);
        return "tre_fitnes";
    }

    @DeleteMapping ("/cancel_reservation")
    public ResponseEntity<?> cancel(@RequestBody RezervisaniDTO rezervisaniDTO) {
        try{
            this.korisnikService.cancelReservation(rezervisaniDTO.getClan_id(),rezervisaniDTO.getOdrzavanje_id());
            return new ResponseEntity<>(HttpStatus.OK);
        }   catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
