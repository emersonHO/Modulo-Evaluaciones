package com.fisiunmsm.ayudadoc.evaluaciones.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table("criteriorubrica")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CriterioRubrica {
    @Id
    private int id;
    private String descripcion;
    private String estado;
    private int rubricaid;
}