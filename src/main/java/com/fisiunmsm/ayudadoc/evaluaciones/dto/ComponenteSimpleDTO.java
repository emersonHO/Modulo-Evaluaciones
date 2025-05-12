package com.fisiunmsm.ayudadoc.evaluaciones.dto;

public class ComponenteSimpleDTO {
    private Integer id;
    private String descripcion;
    private Double peso;

    public ComponenteSimpleDTO() {
    }

    public ComponenteSimpleDTO(Integer id, String descripcion, Double peso) {
        this.id = id;
        this.descripcion = descripcion;
        this.peso = peso;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }
}