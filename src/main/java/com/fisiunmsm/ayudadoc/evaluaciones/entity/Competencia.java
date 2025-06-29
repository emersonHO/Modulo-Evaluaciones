package com.fisiunmsm.ayudadoc.evaluaciones.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table("competencia")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Competencia {
    @Id
    private int id;

    private String codigo;
    private String nombre;
    private String descripcion;
    private int planid;
    private int institucionid;
    private int departamentoid;
    private String tipo;
}