package com.fisiunmsm.ayudadoc.evaluaciones.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table("curso")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Curso {
    @Id
    private Integer id;
    private String codigo;
    private String nombre;
    private String estado;
    private Integer institucionId;
    private Integer departamentoId;
    private Integer periodoId;
}