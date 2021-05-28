package com.example.teretana.model.dto;

import com.example.teretana.model.Trening;

import java.util.List;

public class TreninziDTO {

    private List<Trening> treninzi;

    private List<String> tip_treninga;

    public List<Trening> getTreninzi() {
        return treninzi;
    }

    public void setTreninzi(List<Trening> treninzi) {
        this.treninzi = treninzi;
    }

    public List<String> getTip_treninga() {
        return tip_treninga;
    }

    public void setTip_treninga(List<String> tip_treninga) {
        this.tip_treninga = tip_treninga;
    }

    public TreninziDTO(List<Trening> treninzi, List<String> tip_treninga) {
        this.treninzi = treninzi;
        this.tip_treninga = tip_treninga;
    }
}
