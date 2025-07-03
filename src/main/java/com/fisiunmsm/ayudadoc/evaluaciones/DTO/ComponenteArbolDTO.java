package com.fisiunmsm.ayudadoc.evaluaciones.DTO;

import java.util.List;

public class ComponenteArbolDTO {
    private Integer id;
    private String descripcion;
    private Double peso;
    private List<ComponenteArbolDTO> hijos;

    public ComponenteArbolDTO() {}

    public ComponenteArbolDTO(Integer id, String descripcion, Double peso, List<ComponenteArbolDTO> hijos) {
        this.id = id;
        this.descripcion = descripcion;
        this.peso = peso;
        this.hijos = hijos;
    }

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public Double getPeso() { return peso; }
    public void setPeso(Double peso) { this.peso = peso; }

    public List<ComponenteArbolDTO> getHijos() { return hijos; }
    public void setHijos(List<ComponenteArbolDTO> hijos) { this.hijos = hijos; }
}
