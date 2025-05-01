package com.fisiunmsm.ayudadoc.evaluaciones.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "cursocomponente")
public class CursoComponente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String codigo;
    private String descripcion;
    private int evaluacionid;
    private float peso;
    private String estado;
    private int cursoid;
    private int orden;
    private int padreid;
    private int nivel;
    private int institucionid;
    private String calculado;
    private int departamentoid;
    private int formulaid;
    private int curso_id;
}
