package com.fisiunmsm.ayudadoc.evaluaciones.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "criteriorubrica")
public class CriterioRubrica {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int rubricaid;
    private String descripcion;
    private int nivel;
    private double puntaje;
    private String estado;
}
