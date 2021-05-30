package com.example.teretana.controller;

import com.example.teretana.model.Trening;
import com.example.teretana.model.dto.TreninziDTO;
import com.example.teretana.service.TreningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

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

    @GetMapping("/trening/{id}")
    public String getTrening(@PathVariable(name = "id") Long id, Model model) {
        Trening trening=this.treningService.findOne(id);
        model.addAttribute("trening", trening);
        return "trening";
    }


}
