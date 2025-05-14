package com.fisiunmsm.ayudadoc.evaluaciones.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table("nivelcriterio")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class NivelCriterio {
    @Id
    private int id;

    private String descripcion;
    private int nivel;
    private double puntaje;
    private int criterioid;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public int getNivel() {
        return nivel;
    }
    public void setNivel(int nivel) {
        this.nivel = nivel;
    }
    public double getPuntaje() {
        return puntaje;
    }
    public void setPuntaje(double puntaje) {
        this.puntaje = puntaje;
    }
    public int getCriterioid() {
        return criterioid;
    }
    public void setCriterioid(int criterioid) {
        this.criterioid = criterioid;
    }
}
