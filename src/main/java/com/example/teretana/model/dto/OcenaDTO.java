package com.example.teretana.model.dto;

public class OcenaDTO {

    private Long trening_id;

    private Long odradjen_id;

    private Long ocena;

    public Long getTrening_id() {
        return trening_id;
    }

    public void setTrening_id(Long trening_id) {
        this.trening_id = trening_id;
    }

    public Long getOdradjen_id() {
        return odradjen_id;
    }

    public void setOdradjen_id(Long odradjen_id) {
        this.odradjen_id = odradjen_id;
    }

    public Long getOcena() {
        return ocena;
    }

    public void setOcena(Long ocena) {
        this.ocena = ocena;
    }

    public OcenaDTO(Long trening_id , Long odradjen_id, Long ocena ) {
        super();
        this.trening_id = trening_id;
        this.odradjen_id = odradjen_id;
        this.ocena = ocena;
    }

    public OcenaDTO() {}

}
