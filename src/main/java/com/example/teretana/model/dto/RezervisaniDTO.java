package com.example.teretana.model.dto;

public class RezervisaniDTO {

    private Long clan_id;

    private Long odrzavanje_id;

    public  RezervisaniDTO() {}

    public RezervisaniDTO(Long clan_id, Long odrzavanje_id) {
        this.clan_id = clan_id;
        this.odrzavanje_id = odrzavanje_id;
    }

    public Long getClan_id() {
        return clan_id;
    }

    public void setClan_id(Long clan_id) {
        this.clan_id = clan_id;
    }

    public Long getOdrzavanje_id() {
        return odrzavanje_id;
    }

    public void setOdrzavanje_id(Long odrzavanje_id) {
        this.odrzavanje_id = odrzavanje_id;
    }
}
