package com.example.teretana.controller;

import com.example.teretana.model.Trening;
import com.example.teretana.model.dto.PretragaDTO;
import com.example.teretana.model.dto.TreninziDTO;
import com.example.teretana.service.TreningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class TreningController {
    @Autowired
    private TreningService treningService;

    @GetMapping("/treninzi")
    public String treninzi(Model model) {
        TreninziDTO treninziDTO= this.treningService.getData();
        model.addAttribute("treninziDTO", treninziDTO);
        return "treninzi";
    }

    @PostMapping("/pretraga")
    public String pretraga(Model model, @RequestBody PretragaDTO pretragaDTO) {
        TreninziDTO treninziDTO= this.treningService.treningSearch(pretragaDTO);
        model.addAttribute("treninziDTO", treninziDTO);
        return "treninzi1";
    }

    @GetMapping("/trening/{id}")
    public String getTrening(@PathVariable(name = "id") Long id, Model model) {
        Trening trening=this.treningService.findOne(id);
        model.addAttribute("trening", trening);
        return "trening";
    }


}
