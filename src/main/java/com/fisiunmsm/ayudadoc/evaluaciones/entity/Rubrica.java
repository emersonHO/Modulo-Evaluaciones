package com.fisiunmsm.ayudadoc.evaluaciones.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table("rubrica")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Rubrica {
    @Id
    private int id;

    private String descripcion;
    private String estado;
    private String nombre;
    private int cursocomponenteid;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCursocomponenteid() {
        return cursocomponenteid;
    }

    public void setCursocomponenteid(int cursocomponenteid) {
        this.cursocomponenteid = cursocomponenteid;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}