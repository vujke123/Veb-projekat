package com.example.teretana.model.dto;

public class PrijavljanDTO {

    private Long clanId;

    private Long treningId;

    public PrijavljanDTO() {}

    public PrijavljanDTO(Long clanId, Long treningId) {
        this.clanId = clanId;
        this.treningId = treningId;
    }

    public Long getClanId() {
        return clanId;
    }

    public void setClanId(Long clanId) {
        this.clanId = clanId;
    }

    public Long getTreningId() {
        return treningId;
    }

    public void setTreningId(Long treningId) {
        this.treningId = treningId;
    }
}
