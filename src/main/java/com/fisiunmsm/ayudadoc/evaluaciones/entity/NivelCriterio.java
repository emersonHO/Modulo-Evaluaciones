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
    private int puntajemax;
    private int criterioid;
    private String titulo;
}
