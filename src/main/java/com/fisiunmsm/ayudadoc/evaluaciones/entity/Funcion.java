package com.fisiunmsm.ayudadoc.evaluaciones.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table ("funcion")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Funcion {

    @Id
    private int id;

    private String nombre;
    private String estado;
    private String funsql;
    private String descripcion;


    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id=id;
    }
    public String getNombre(){
        return nombre;
    }
    public void setNombre(String nombre){
        this.nombre=nombre;
    }
    public String getEstado(){
        return estado;
    }
    public void setEstado(String estado){
        this.estado=estado;
    }
    public String getFunsql(){
        return funsql;
    }
    public void setFunsql(String funsql){
        this.funsql=funsql;
    }
    public String getDescripcion(){
        return descripcion;
    }
    public void setDescripcion(String descripcion){
        this.descripcion=descripcion;
    }
}
