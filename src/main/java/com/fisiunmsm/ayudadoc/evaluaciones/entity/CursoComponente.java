package com.fisiunmsm.ayudadoc.evaluaciones.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table("cursocomponente")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class CursoComponente {
    @Id
    private Long id;

    private String codigo;
    private String descripcion;
    private int evaluacionid;
    private float peso;
    private String estado;
    private int cursoid;
    private int orden;
    private Long padreid;
    private int nivel;
    private int institucionalid;
    private String calculado;
    private Long departamentoid;
    private Long formulaid;
    private Long curso_id;
}
