package com.fisiunmsm.ayudadoc.evaluaciones.DTO;

import java.util.List;

public class CompetenciaArbolDTO {
    private Integer competenciaId;
    private String nombre;
    private List<ComponenteArbolDTO> componentes;

    public CompetenciaArbolDTO() {}

    public CompetenciaArbolDTO(Integer competenciaId, String nombre, List<ComponenteArbolDTO> componentes) {
        this.competenciaId = competenciaId;
        this.nombre = nombre;
        this.componentes = componentes;
    }

    public Integer getCompetenciaId() { return competenciaId; }
    public void setCompetenciaId(Integer competenciaId) { this.competenciaId = competenciaId; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public List<ComponenteArbolDTO> getComponentes() { return componentes; }
    public void setComponentes(List<ComponenteArbolDTO> componentes) { this.componentes = componentes; }
}