package com.fisiunmsm.ayudadoc.evaluaciones.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table("cursocompetencia")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class CursoCompetencia {
    @Id
    private int id;
    private int cursoid;
    private int competenciaid;
}
