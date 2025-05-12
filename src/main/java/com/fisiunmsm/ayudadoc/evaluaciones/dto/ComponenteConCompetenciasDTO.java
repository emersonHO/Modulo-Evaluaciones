package com.fisiunmsm.ayudadoc.evaluaciones.dto;

import java.util.List;

public class ComponenteConCompetenciasDTO {
    private Integer idComponente;
    private String descripcionComponente;
    private List<String> competencias; // Descripciones de competencias asociadas

    public Integer getIdComponente() {
        return idComponente;
    }

    public void setIdComponente(Integer idComponente) {
        this.idComponente = idComponente;
    }

    public String getDescripcionComponente() {
        return descripcionComponente;
    }

    public void setDescripcionComponente(String descripcionComponente) {
        this.descripcionComponente = descripcionComponente;
    }

    public List<String> getCompetencias() {
        return competencias;
    }

    public void setCompetencias(List<String> competencias) {
        this.competencias = competencias;
    }
}