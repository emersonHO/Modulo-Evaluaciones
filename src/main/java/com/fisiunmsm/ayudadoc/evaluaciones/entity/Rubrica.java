package com.fisiunmsm.ayudadoc.evaluaciones.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table ("rubrica")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Rubrica {
    @Id
    private int id;

    private String descripcion;
    private String estado;
    private String nombre;
}