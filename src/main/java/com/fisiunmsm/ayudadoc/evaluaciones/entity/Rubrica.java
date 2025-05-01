package com.fisiunmsm.ayudadoc.evaluaciones.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "rubrica")
public class Rubrica {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id;
    private String nombre;
    private String descripcion;
    private int cursocomponenteid;
    private String estado;
}
